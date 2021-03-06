package com.example.criminalintent.controller.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.fragment.CrimeDetailFragment;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.repository.CrimeRepository;
import com.example.criminalintent.repository.IRepository;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {
    private static final String EXTRA_CRIME_ID ="com.example.criminalintent.controller.activity.cirmId" ;
    IRepository mRepositoryCrime;
    ViewPager2 mViewPager;
    int mPosition;


    public static Intent newIntent(Context source,UUID crimeId) {
        Intent intent = new Intent(source, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        findViews();
        setInitialValue();


    }

    private void setInitialValue() {
        mRepositoryCrime = CrimeRepository.getInstance();
        UUID uuid=(UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mPosition=mRepositoryCrime.getPositionByUUID(uuid);
        FragmentStateAdapter fragmentStateAdapter=new MyAdapter(this,mRepositoryCrime.getLists());
        mViewPager.setAdapter(fragmentStateAdapter);
        mViewPager.setCurrentItem(mPosition);
    }

    private void findViews() {
        mViewPager = findViewById(R.id.viewpager_crime);
    }

    private class MyAdapter extends FragmentStateAdapter {
        List<Crime> mCrimeList;

        public MyAdapter(@NonNull FragmentActivity fragmentActivity, List<Crime> crimes) {
            super(fragmentActivity);
            mCrimeList = crimes;
        }


        void setCrimeList(List<Crime> crimes) {
            mCrimeList = crimes;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return CrimeDetailFragment.newInstance(mCrimeList.get(position).getId());
        }

        @Override
        public int getItemCount() {
            return mCrimeList.size();
        }
    }
}