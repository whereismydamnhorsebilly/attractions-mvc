package com.springApp.dao.settlementRepo;

import com.springApp.dao.UniversalImp;
import com.springApp.model.Settlement;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class SettlementDaoImp extends UniversalImp<Settlement> implements SettlementDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void update(int id, Integer newPopulation) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("update Settlement set population = :newPopulation where id = :id")
                .setParameter("newPopulation", newPopulation)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateMetro(int id, boolean hasMetroUpd) {
        Session session = sessionFactory.getCurrentSession();

        session.createQuery("update Settlement set hasMetro = :hasMetroUpd where id = :id")
                .setParameter("hasMetroUpd", hasMetroUpd)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Settlement getByName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        Session session = sessionFactory.getCurrentSession();

        Settlement settlement = (Settlement) session
                .createQuery("from Settlement where name = :name")
                .setParameter("name", name)
                .uniqueResult();

        return settlement;
    }
}
