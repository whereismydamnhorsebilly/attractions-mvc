package com.springApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UniversalImp<E> implements UniversalAdd<E> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
    }
}
