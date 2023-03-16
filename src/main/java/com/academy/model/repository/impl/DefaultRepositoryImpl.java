package com.academy.model.repository.impl;

import com.academy.model.repository.DefaultRepository;

import java.util.List;

public class DefaultRepositoryImpl<T,I> implements DefaultRepository<T,I> {
    @Override
    public void create(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(I id) {
        return null;
    }
}
