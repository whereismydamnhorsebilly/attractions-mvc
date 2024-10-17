package com.springApp.service.attractionService;

import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.dto.attractionDto.AttractionDtoToShow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttractionService {

    void add(AttractionDtoToGet attraction);

    void update(int id, String description);

    List<AttractionDtoToShow> findByTypeSortByName(String type);

    List<AttractionDtoToShow> findBySettlementName(String settlementName);

    void remove(int id);
}
