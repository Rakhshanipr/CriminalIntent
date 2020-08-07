package com.example.criminalintent.controller.activity;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.criminalintent.controller.fragment.CrimeDetailFragment;

import java.util.UUID;

public class CrimeDetailActivity extends SingleFragmentActivity {
    public static final String EXTRA_CRIM_ID_FROM_CRIME_LIST = "com.example.criminalintent.controller.activity.CrimeDetailActivity.crimId";
    public static final String EXTRA_CRIME_ID_TO_FRAGMET = "CrimeId";

    /**
     * @param source source that start detail activity
     * @param crimeId id of Crime repository
     * @return
     */
    public static Intent newIntent(Context source, UUID crimeId) {
        Intent intent = new Intent(source, CrimeDetailActivity.class);
        intent.putExtra(EXTRA_CRIM_ID_FROM_CRIME_LIST, crimeId);
        return intent;
    }
    @Override
    public Fragment createFragment() {
        return CrimeDetailFragment.newInstance((UUID)getIntent().getSerializableExtra(EXTRA_CRIM_ID_FROM_CRIME_LIST));
    }
}