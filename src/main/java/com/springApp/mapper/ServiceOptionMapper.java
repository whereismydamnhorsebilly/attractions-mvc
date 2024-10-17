package com.springApp.mapper;

import com.springApp.dto.serviceoptionDto.ServiceOptionDto;
import com.springApp.dto.serviceoptionDto.ServiceOptionDtoToGet;
import com.springApp.model.ServiceOption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceOptionMapper {

    ServiceOptionDto toDto(ServiceOption serviceOption);

    ServiceOption fromDto(ServiceOptionDtoToGet serviceOptionDtoToGet);
}
