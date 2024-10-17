package com.springApp.service.attractionService;

import com.springApp.dao.attractionRepo.AttractionDao;
import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.dto.attractionDto.AttractionDtoToShow;
import com.springApp.mapper.AttractionMapper;
import com.springApp.model.Attraction;
import com.springApp.model.ServiceOption;
import com.springApp.model.Settlement;
import com.springApp.service.serviceOptionService.ServiceOptionService;
import com.springApp.service.settlementService.SettlementService;
import com.springApp.util.AttractionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionServiceImp implements AttractionService {

    private final AttractionDao attractionDao;
    private final AttractionMapper attractionMapper;
    private final SettlementService settlementService;
    private final ServiceOptionService serviceOptionService;

    @Override
    @Transactional
    public void add(AttractionDtoToGet attractionDto) {

        String settlementName = attractionDto.getSettlement();
        Settlement settlement = settlementService.getByName(settlementName);

        ServiceOption serviceOption = serviceOptionService.getByType(attractionDto.getServiceOption());

        Attraction attraction = attractionMapper.fromDto(attractionDto);
        attraction.setSettlement(settlement);
        attraction.setServiceOption(serviceOption);

        attractionDao.add(attraction);
    }

    @Override
    @Transactional
    public void update(int id, String description) {
        attractionDao.update(id, description);
    }

    @Override
    @Transactional
    public List<AttractionDtoToShow> findByTypeSortByName(String type) {
        AttractionType attractionType = AttractionType.valueOf(type.toUpperCase());

        List<Attraction> allAttractions = attractionDao.findByTypeSortByName(attractionType);

        List<AttractionDtoToShow> attractionsDto = allAttractions.stream()
                .filter(Objects::nonNull)
                .map(attractionMapper::toDto)
                .toList();

        return attractionsDto;
    }

    @Override
    @Transactional
    public List<AttractionDtoToShow> findBySettlementName(String settlementName) {
        List<Attraction> allAttractions = attractionDao.findBySettlementName(settlementName);

        List<AttractionDtoToShow> attractionsDto = allAttractions.stream()
                .filter(Objects::nonNull)
                .map(attractionMapper::toDto)
                .toList();

        return attractionsDto;
    }

    @Override
    @Transactional
    public void remove(int id) {
        attractionDao.remove(id);
    }
}
