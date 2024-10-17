package com.springApp.mapper;

import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.dto.attractionDto.AttractionDtoToShow;
import com.springApp.model.Attraction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttractionMapper {

    AttractionDtoToShow toDto(Attraction attraction);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "aboutAttraction", target = "aboutAttraction")
    @Mapping(source = "attractionType", target = "attractionType")
    @Mapping(target = "settlement", ignore = true)
    @Mapping(target = "serviceOption", ignore = true)
    Attraction fromDto(AttractionDtoToGet attractionDtoToGet);
}
