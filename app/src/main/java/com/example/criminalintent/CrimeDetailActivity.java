package com.example.criminalintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CrimeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_detail);
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,new CrimeDetailFragment())
                .commit();

    }
}