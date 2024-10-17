package com.springApp.dao.attractionRepo;

import com.springApp.dao.UniversalImp;
import com.springApp.model.Attraction;
import com.springApp.util.AttractionType;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class AttractionDaoImp extends UniversalImp<Attraction> implements AttractionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Attraction> findByTypeSortByName(AttractionType type) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Attraction a join fetch a.settlement where a.attractionType = :type order by a.name", Attraction.class)
                .setParameter("type", type)
                .list();
    }

    @Override
    public List<Attraction> findBySettlementName(String settlementName) {
        settlementName = settlementName.substring(0, 1).toUpperCase() + settlementName.substring(1);

        return sessionFactory.getCurrentSession()
                .createQuery("from Attraction where settlement.name = :settlementName", Attraction.class)
                .setParameter("settlementName", settlementName)
                .list();
    }

    @Override
    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Attraction where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void update(int id, String description) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("update Attraction set aboutAttraction = :description where id = :id")
                .setParameter("description", description)
                .setParameter("id", id)
                .executeUpdate();
    }
}