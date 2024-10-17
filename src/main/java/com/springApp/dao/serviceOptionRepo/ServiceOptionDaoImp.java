package com.springApp.dao.serviceOptionRepo;

import com.springApp.dao.UniversalImp;
import com.springApp.model.ServiceOption;
import com.springApp.util.ServiceOptionType;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ServiceOptionDaoImp extends UniversalImp<ServiceOption> implements ServiceOptionDao {

    private final SessionFactory sessionFactory;

    @Override
    public ServiceOption getByType(String type) {
        ServiceOptionType serviceOptionType = ServiceOptionType.valueOf(type.toUpperCase());
        return sessionFactory.getCurrentSession()
                .createQuery("from ServiceOption where name = :serviceOptionType", ServiceOption.class)
                .setParameter("serviceOptionType", serviceOptionType)
                .uniqueResult();
    }
}
