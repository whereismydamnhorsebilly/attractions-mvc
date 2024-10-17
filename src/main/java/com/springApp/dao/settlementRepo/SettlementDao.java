package com.springApp.dao.settlementRepo;

import com.springApp.dao.UniversalAdd;
import com.springApp.dao.UniversalUpdate;
import com.springApp.model.Settlement;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementDao extends UniversalAdd<Settlement>, UniversalUpdate<Integer> {

    void updateMetro(int id, boolean metro);

    Settlement getByName(String name);
}
