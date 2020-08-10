package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements IRepository<Crime> {


    public static CrimeRepository sCrimeRepository;
    public static final int NUMBER_OF_CRIMES = 100;

    public static CrimeRepository getInstance() {

        if (sCrimeRepository == null)
            sCrimeRepository = new CrimeRepository();
        return sCrimeRepository;
    }

    private List<Crime> mCrimes;

    @Override
    public void setList(List<Crime> crimes) {
        mCrimes = crimes;
    }

    @Override
    public UUID getUUIDByPosition(int position) {
        return mCrimes.get(position).getId();
    }

    @Override
    public int getPositionByUUID(UUID uuid) {
        for (int i=0;i<mCrimes.size();i++){
            if (mCrimes.get(i).getId().equals(uuid)){
                return i;
            }
        }
        return -1;
    }

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i <= NUMBER_OF_CRIMES; i++) {
            Crime crime = new Crime("Crime " + (i + 1), i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    @Override
    public Crime get(UUID uuid) {
        for (Crime crime :
                mCrimes) {
            if (crime.getId().equals(uuid))
                return crime;
        }
        return null;
    }

    @Override
    public void update(Crime newCrime) {
        Crime updateCrime = get(newCrime.getId());
        updateCrime.setSolved(newCrime.isSolved());
        updateCrime.setTitle(newCrime.getTitle());
        updateCrime.setDate(newCrime.getDate());
    }

    @Override
    public List<Crime> getLists() {
        return mCrimes;
    }

    public void delete(Crime crime) {
        for (Crime obj :
                mCrimes) {
            if (obj.getId().equals(crime.getId())) {
                mCrimes.remove(mCrimes);
                return;
            }
        }
    }

    @Override
    public void insert(Crime crime) {
        mCrimes.add(crime);
    }

    @Override
    public void insertList(List<Crime> crimes) {
        mCrimes.addAll(crimes);
    }
}

