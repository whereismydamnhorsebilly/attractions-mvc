package com.springApp.dao.attractionRepo;

import com.springApp.dao.UniversalAdd;
import com.springApp.dao.UniversalUpdate;
import com.springApp.model.Attraction;
import com.springApp.util.AttractionType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionDao extends UniversalAdd<Attraction>, UniversalUpdate<String> {

    List<Attraction> findByTypeSortByName(AttractionType type);

    List<Attraction> findBySettlementName(String settlementName);

    void remove(int id);
}
