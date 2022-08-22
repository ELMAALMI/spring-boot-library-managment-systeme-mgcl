package com.elmaalmi.billal.library.service;

import com.elmaalmi.billal.library.model.Adherent;

import java.util.List;

public interface CrudService <T>{
    void save(T o);
    void update(T o);
    void delete(long id);
    T findById(long id);
    List<T> findAll();
}
