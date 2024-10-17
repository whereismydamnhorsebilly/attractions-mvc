package com.springApp.service.serviceOptionService;

import com.springApp.dao.UniversalImp;
import com.springApp.dao.serviceOptionRepo.ServiceOptionDao;
import com.springApp.dto.serviceoptionDto.ServiceOptionDtoToGet;
import com.springApp.mapper.ServiceOptionMapper;
import com.springApp.model.Attraction;
import com.springApp.model.ServiceOption;
import com.springApp.util.ServiceOptionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceOptionServiceImpTest {

    @InjectMocks
    private ServiceOptionServiceImp serviceOptionService;

    @Mock
    private ServiceOptionDao serviceOptionDao;

    @Mock
    private ServiceOptionMapper serviceOptionMapper;

    /**
     * Тестирование метода getByType (получение объекта ServiceOption по типу)
     */
    @Test
    public void getByTypeTest() {
        // Arrange
        ServiceOptionDtoToGet testServiceOptionDto = new ServiceOptionDtoToGet();
        ServiceOption testServiceOption = new ServiceOption();
        testServiceOptionDto.setName(ServiceOptionType.AUDIO_GUIDE);

        when(serviceOptionMapper.fromDto(testServiceOptionDto)).thenReturn(testServiceOption);
        when(serviceOptionService.getByType("AUDIO_GUIDE")).thenReturn(testServiceOption);

        // Act
        serviceOptionService.add(testServiceOptionDto);
        serviceOptionService.getByType("AUDIO_GUIDE");

        // Assert
        verify(serviceOptionDao).getByType("AUDIO_GUIDE");
        assertEquals(testServiceOption, serviceOptionService.getByType("AUDIO_GUIDE"));
    }
}
