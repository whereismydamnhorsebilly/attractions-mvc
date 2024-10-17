package com.springApp.dao.serviceOptionRepo;

import com.springApp.dao.UniversalAdd;
import com.springApp.model.ServiceOption;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOptionDao extends UniversalAdd<ServiceOption> {

    ServiceOption getByType(String type);
}
