package com.springApp.service.settlementService;

import com.springApp.dao.settlementRepo.SettlementDao;
import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.mapper.SettlementMapper;
import com.springApp.model.Settlement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SettlementServiceImpTest {

    @InjectMocks
    private SettlementServiceImp settlementService;

    @Mock
    private SettlementDao settlementDao;

    @Mock
    private SettlementMapper settlementMapper;

    /**
     * Тестирование метода add (добавление города: поступает dto -> маппится на сущность -> добавляется новый объект)
     */
    @Test
    public void addSettlementTest() {
        // Arrange
        SettlementDto settlementDto = new SettlementDto();
        settlementDto.setName("TestSettlement");
        settlementDto.setId(1);
        settlementDto.setPopulation(10);
        settlementDto.setHasMetro(true);

        Settlement testSettlement = new Settlement();
        when(settlementMapper.fromDto(settlementDto)).thenReturn(testSettlement);

        // Act
        settlementService.add(settlementDto);

        // Assert
        verify(settlementDao).add(testSettlement);
    }

    /**
     * Тестирование метода update (обновление информации о населении города)
     */
    @Test
    public void updatePopulationTest() {
        int id = 1;
        int testPopulationUpdate = 100;

        settlementService.update(id,testPopulationUpdate);

        verify(settlementDao).update(id, testPopulationUpdate);
    }

    /**
     * Тестирование метода updateMetro (обновление информации о наличии метро, boolean)
     */
    @Test
    public void updateMetroTest() {
        int id = 1;
        boolean testMetroUpdate = false;

        settlementService.updateMetro(id,testMetroUpdate);

        verify(settlementDao).updateMetro(id, testMetroUpdate);
    }

    /**
     * Тестирование метода getByName (поиск по городу по названию)
     */
    @Test
    public void getByNameTest() {
        List<Settlement> testSettlementList = new ArrayList<>();
        Settlement testSettlement = new Settlement();
        testSettlement.setName("TestSettlement");
        testSettlementList.add(testSettlement);

        settlementService.getByName("TestSettlement");

        verify(settlementDao).getByName(testSettlement.getName());
    }
}
