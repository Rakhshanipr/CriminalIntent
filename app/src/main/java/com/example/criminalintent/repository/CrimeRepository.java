package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements RepositoryInterface {

    public static CrimeRepository sCrimeRepository;
    public static final int NUMBER_OF_CRIMES = 100;

    public static CrimeRepository getInstance() {
        if (sCrimeRepository == null)
            sCrimeRepository = new CrimeRepository();
        return sCrimeRepository;
    }

    private List<Crime> mCrimes;

    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i <= NUMBER_OF_CRIMES; i++) {
            Crime crime = new Crime("Crime " + (i + 1), i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public Crime getCrime(UUID uuid) {
        for (Crime crime :
                mCrimes) {
            if (crime.getId().equals(uuid))
                return crime;
        }
        return null;
    }

    public void updateCrime(Crime newCrime) {
        Crime updateCrime = getCrime(newCrime.getId());
        updateCrime.setSolved(newCrime.isSolved());
        updateCrime.setTitle(newCrime.getTitle());
        updateCrime.setDate(newCrime.getDate());
    }

    @Override
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void deleteCrime(Crime crime) {
        for (Crime obj :
                mCrimes) {
            if (obj.getId().equals(crime.getId())) {
                mCrimes.remove(mCrimes);
                return;
            }
        }
    }
}

