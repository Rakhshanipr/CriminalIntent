package com.example.criminalintent.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.criminalintent.R;
import com.example.criminalintent.model.Crime;
import com.example.criminalintent.repository.CrimeRepository;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CrimeRepository mCrimeRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRepository=CrimeRepository.getInstance();
        findAllViewsById(view);
        initUI();
        return view;
    }

    private void initUI() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CrimeAdapter adapter=new CrimeAdapter(mCrimeRepository.getCrimes());
        mRecyclerView.setAdapter(adapter);
    }

    private void findAllViewsById(View view) {
        mRecyclerView = view.findViewById(R.id.recyclers_view_crimes);
    }



    /*
    adapter responsiblity:
    get item count
    create viewholder
    bind viewholder
     */
    private class CrimeHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        private TextView mTextViewDate;

        public CrimeHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewDate = itemView.findViewById(R.id.textview_row_crime_date);
            mTextViewTitle = itemView.findViewById(R.id.textview_row_crime_title);
        }
        public void bindCrime(Crime crime){
            mTextViewTitle.setText(crime.getTitle());
            mTextViewDate.setText(crime.getDate().toString());
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }


        public List<Crime> getCrimes() {
            return mCrimes;
        }

        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("CLF","onCreateViewHolder");

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.list_row_crime, parent, false);

            CrimeHolder crimeHolder=new CrimeHolder(view);

            return crimeHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Log.d("CLF","onBindViewHolder "+position);
            Crime crime=mCrimes.get(position);
            holder.bindCrime(crime);
        }


    }

}