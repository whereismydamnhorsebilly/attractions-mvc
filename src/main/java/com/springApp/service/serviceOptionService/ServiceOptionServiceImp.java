package com.springApp.service.serviceOptionService;

import com.springApp.dao.serviceOptionRepo.ServiceOptionDao;
import com.springApp.dto.serviceoptionDto.ServiceOptionDtoToGet;
import com.springApp.mapper.ServiceOptionMapper;
import com.springApp.model.ServiceOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceOptionServiceImp implements ServiceOptionService {

    private final ServiceOptionDao serviceOptionDao;
    private final ServiceOptionMapper serviceOptionMapper;

    @Override
    public ServiceOption getByType(String type) {
        return serviceOptionDao.getByType(type);
    }

    @Override
    public void add(ServiceOptionDtoToGet serviceOptionDto) {
        ServiceOption serviceOption = serviceOptionMapper.fromDto(serviceOptionDto);

        serviceOptionDao.add(serviceOption);
    }
}
