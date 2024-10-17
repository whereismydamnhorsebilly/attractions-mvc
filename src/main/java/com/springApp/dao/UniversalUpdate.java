package com.springApp.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UniversalUpdate<T> {

    void update(int id, T t);
}
