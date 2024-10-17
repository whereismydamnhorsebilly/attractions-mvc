package com.springApp.service.settlementService;

import com.springApp.dao.settlementRepo.SettlementDao;
import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.mapper.SettlementMapper;
import com.springApp.model.Settlement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SettlementServiceImp implements SettlementService {

    private final SettlementDao settlementDao;
    private final SettlementMapper settlementMapper;

    @Override
    @Transactional
    public void add(SettlementDto settlementDto) {
        Settlement settlement = settlementMapper.fromDto(settlementDto);

        settlementDao.add(settlement);
    }

    @Override
    @Transactional
    public void update(int id, Integer newPopulation) {
        settlementDao.update(id, newPopulation);
    }

    @Override
    @Transactional
    public void updateMetro(int id, boolean metroUpd) {
        settlementDao.updateMetro(id, metroUpd);
    }

    @Override
    @Transactional
    public Settlement getByName(String name) {
        return settlementDao.getByName(name);
    }
}
