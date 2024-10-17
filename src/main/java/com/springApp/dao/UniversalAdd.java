package com.springApp.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UniversalAdd<E> {

    void add(E entity);
}
