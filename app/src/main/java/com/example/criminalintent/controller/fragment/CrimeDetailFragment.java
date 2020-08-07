package com.example.criminalintent.controller.fragment;


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
import com.example.criminalintent.repository.CrimeRepository;
import com.example.criminalintent.repository.RepositoryInterface;

import java.util.UUID;

import static android.content.ContentValues.TAG;


public class CrimeDetailFragment extends Fragment {
    public static final String ARG_CRIME_ID = "com.example.criminalintent.controller.activity.CrimeDetailActivity.CrimId";
    private Crime mCrime;
    EditText mEditTextCriminalTitle;
    CheckBox mCheckBoxCriminalSolved;
    Button mButtonCriminalDate;
    private RepositoryInterface<Crime> mRepository;

    public final String FRAGMENT_CRIME_SAVE = "com.example.criminalintent.model.Crime.mcrime_save";

    public static CrimeDetailFragment newInstance(UUID uuid) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID,uuid);

        CrimeDetailFragment fragment = new CrimeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRepository=CrimeRepository.getInstance();
        UUID crimeId=(UUID)getArguments().getSerializable(ARG_CRIME_ID);
        mCrime=mRepository.get(crimeId);
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
        mEditTextCriminalTitle.setText(mCrime.getTitle());
        mCheckBoxCriminalSolved.setChecked(mCrime.isSolved());
        mButtonCriminalDate.setEnabled(false);
    }

    private void findViewsById(View view) {
        mButtonCriminalDate = view.findViewById(R.id.criminal_date);
        mCheckBoxCriminalSolved = view.findViewById(R.id.criminal_solved);
        mEditTextCriminalTitle = view.findViewById(R.id.criminal_title);
    }
}