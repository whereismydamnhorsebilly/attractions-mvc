package com.springApp.service.settlementService;

import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.model.Settlement;
import org.springframework.stereotype.Service;

@Service
public interface SettlementService {

    void add(SettlementDto settlementDto);

    void update(int id, Integer newPopulation);

    void updateMetro(int id, boolean metroUpd);

    Settlement getByName(String settlementName);
}
