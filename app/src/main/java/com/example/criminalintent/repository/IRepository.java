package com.example.criminalintent.repository;

import android.widget.LinearLayout;

import com.example.criminalintent.model.Crime;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    List<E> getLists();
    E get(UUID uuid);
    void update(E e);
    void delete(E e);
    void insert(E e);
    void insertList(List<E> list);
    void setList(List<E> list);
    UUID getUUIDByPosition(int position);

}
