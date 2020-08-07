package com.example.criminalintent.controller.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.criminalintent.R;
import com.example.criminalintent.controller.activity.CrimeDetailActivity;
import com.example.criminalintent.model.Crime;

import java.util.UUID;

import static android.content.ContentValues.TAG;


public class CrimeDetailFragment extends Fragment {
    private Crime mCrime;
    EditText mEditTextCriminalTitle;
    CheckBox mCheckBoxCriminalSolved;
    Button mButtonCriminalDate;


    public final String FRAGMENT_CRIME_SAVE = "com.example.criminalintent.model.Crime.mcrime_save";
    public static final String CRIM_ID = "com.example.criminalintent.model.Crime.crimId";

    /**
     *
     * @param source source that start detail activity
     * @param crimeId id of Crime repository
     * @return
     */
    public static Intent newIntent(Context source, UUID crimeId) {
        Intent intent = new Intent(source, CrimeDetailActivity.class);
        intent.putExtra(CRIM_ID, crimeId);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mCrime = new Crime("modur", false);
        } else {
            mCrime = (Crime) savedInstanceState.getSerializable(FRAGMENT_CRIME_SAVE);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(FRAGMENT_CRIME_SAVE, mCrime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crime_detail, container, false);
        findViewsById(view);
        initViews();
        setListeners();
        return view;
    }

    private void setListeners() {
        // edit text change
        mEditTextCriminalTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
                Log.d(TAG, mCrime.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        // checkbox set cheched
        mCheckBoxCriminalSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setSolved(b);
                Log.d(TAG, mCrime.toString());
            }
        });
    }

    private void initViews() {
        mButtonCriminalDate.setText(mCrime.getDate().toString());
        mButtonCriminalDate.setEnabled(false);
    }

    private void findViewsById(View view) {
        mButtonCriminalDate = view.findViewById(R.id.criminal_date);
        mCheckBoxCriminalSolved = view.findViewById(R.id.criminal_solved);
        mEditTextCriminalTitle = view.findViewById(R.id.criminal_title);
    }
}