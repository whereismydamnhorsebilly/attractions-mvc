package com.springApp.service.serviceOptionService;

import com.springApp.dto.serviceoptionDto.ServiceOptionDtoToGet;
import com.springApp.model.ServiceOption;
import org.springframework.stereotype.Service;

@Service
public interface ServiceOptionService {

    ServiceOption getByType(String type);

    void add(ServiceOptionDtoToGet serviceOptionDto);
}
