package com.springApp.mapper;

import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.model.Settlement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SettlementMapper {

    SettlementDto toDto(Settlement settlement);

    @Mapping(target = "id", ignore = true)
    Settlement fromDto(SettlementDto settlementDto);

}
