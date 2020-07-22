package com.example.criminalintent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CrimeDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrimeDetailFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    EditText mEditTextCriminalTitle;
    CheckBox mCheckBoxCriminalSolved;
    Button mButtonCriminalDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_crime_detail, container, false);
        findViewsById(view);
        return view;
    }

    private void findViewsById(View view) {
        mButtonCriminalDate=view.findViewById(R.id.criminal_date);
        mCheckBoxCriminalSolved=view.findViewById(R.id.criminal_solved);
        mEditTextCriminalTitle=view.findViewById(R.id.criminal_title);
    }
}