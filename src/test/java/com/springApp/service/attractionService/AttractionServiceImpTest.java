package com.springApp.service.attractionService;

import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.mapper.AttractionMapper;
import com.springApp.model.Attraction;
import com.springApp.model.ServiceOption;
import com.springApp.model.Settlement;
import com.springApp.dao.attractionRepo.AttractionDao;
import com.springApp.service.serviceOptionService.ServiceOptionService;
import com.springApp.service.settlementService.SettlementService;
import com.springApp.util.AttractionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AttractionServiceImpTest {

    @InjectMocks
    private AttractionServiceImp attractionService;

    @Mock
    private AttractionDao attractionDao;

    @Mock
    private AttractionMapper attractionMapper;

    @Mock
    private SettlementService settlementService;

    @Mock
    private ServiceOptionService serviceOptionService;

    AttractionDtoToGet attractionDtoToGet = new AttractionDtoToGet();
    Settlement testSettlement = new Settlement();
    ServiceOption testServiceOption = new ServiceOption();
    Attraction testAttraction = new Attraction();

    @BeforeEach
    public void setUp() {
        attractionDtoToGet.setName("TestName");
        attractionDtoToGet.setAboutAttraction("TestDescription");
        attractionDtoToGet.setAttractionType("PARK");
        attractionDtoToGet.setCreationDate(LocalDate.now());
        attractionDtoToGet.setSettlement("TestSettlement");
        attractionDtoToGet.setServiceOption("GUIDED_TOUR");
    }

    /**
     * Тестирование метода add (добавление достопримечательности: поступает dto -> маппится -> добавляется объект)
     */
    @Test
    public void addAttractionTest() {
        // Arrange
        when(settlementService.getByName("TestSettlement")).thenReturn(testSettlement);
        when(serviceOptionService.getByType("GUIDED_TOUR")).thenReturn(testServiceOption);
        when(attractionMapper.fromDto(attractionDtoToGet)).thenReturn(testAttraction);

        // Act
        attractionService.add(attractionDtoToGet);

        // Assert
        verify(attractionDao).add(testAttraction);
        assertEquals(testSettlement, testAttraction.getSettlement());
        assertEquals(testServiceOption, testAttraction.getServiceOption());
    }

    /**
     * Тестирование метода update (обновление описания достопримечательности)
     */
    @Test
    public void updateDescriptionTest() {
        // Arrange
        int id = 1;
        String newDescription = "NewTestDescription";

        // Act
        attractionService.update(id, newDescription);

        // Assert
        verify(attractionDao).update(id, newDescription);
    }

    /**
     * Тестирование метода findByTypeSortByName (поиск по типу)
     */
    @Test
    public void findByTypeSortByNameTest() {
        // Arrange
        List<Attraction> testListOfAttractions = new ArrayList<>();
        testListOfAttractions.add(testAttraction);

        // Act
        attractionService.findByTypeSortByName("PARK");

        // Assert
        verify(attractionDao).findByTypeSortByName(AttractionType.PARK);
    }

    /**
     * Тестирование метода findBySettlement (поиск по городу)
     */
    @Test
    public void findBySettlementTest() {
        // Arrange
        List<Attraction> testListOfAttractions = new ArrayList<>();
        testListOfAttractions.add(testAttraction);

        // Act
        attractionService.findBySettlementName("TestSettlement");

        // Assert
        verify(attractionDao).findBySettlementName("TestSettlement");
    }

    /**
     * Тестирование метода remove (удаление достопримечательности)
     */
    @Test
    public void removeTest() {
        // Arrange
        int id = 1;

        // Act
        attractionService.remove(id);

        // Assert
        verify(attractionDao).remove(id);
    }
}
