package com.example.criminalintent.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Crime implements Serializable {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mIsSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mIsSolved;
    }

    public void setSolved(boolean solved) {
        mIsSolved = solved;
    }

    public Crime() {
        mId=UUID.randomUUID();
        mDate=new Date();
    }

    public Crime(String title, boolean isSolved) {
        this();
        mTitle = title;
        mIsSolved = isSolved;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mDate=" + mDate +
                ", mIsSolved=" + mIsSolved +
                '}';
    }
}
