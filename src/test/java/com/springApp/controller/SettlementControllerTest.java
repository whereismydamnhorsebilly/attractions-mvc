package com.springApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.springApp.dto.settlementDto.SettlementDto;
import com.springApp.dto.settlementDto.SettlementHasMetroDto;
import com.springApp.dto.settlementDto.SettlementPopulationDto;
import com.springApp.service.BindingResultHandler;
import com.springApp.service.settlementService.SettlementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SettlementControllerTest {

    @InjectMocks
    private SettlementsController controller;

    @Mock
    private SettlementService service;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private BindingResultHandler bindingResultHandler;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Тестирование метода add (добавляем населенный пункт)
     * @throws Exception
     */
    @Test
    void addSettlementTest() throws Exception {
        SettlementDto testSettlementDto = new SettlementDto();
        String settlementJson = objectMapper.writeValueAsString(testSettlementDto);

        mockMvc.perform(post("/api/settlements/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(settlementJson))
                .andExpect(status().isCreated());
    }

    /**
     * Тестирование метода update (обновляем информацию о численности населения)
     * @throws Exception
     */
    @Test
    void updatePopulationTest() throws Exception {
        SettlementPopulationDto testSettlementPopulationDto = new SettlementPopulationDto();

        String populationJson = objectMapper.writeValueAsString(testSettlementPopulationDto);

        mockMvc.perform(patch("/api/settlements/{id}/population", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(populationJson))
                .andExpect(status().isOk());
    }

    /**
     * Тестирование метода updateMetro (обновляем информацию о наличии метро, boolean)
     * @throws Exception
     */
    @Test
    void updateMetroTest() throws Exception {
        SettlementHasMetroDto testSettlementMetroDto = new SettlementHasMetroDto();

        String populationJson = objectMapper.writeValueAsString(testSettlementMetroDto);

        mockMvc.perform(patch("/api/settlements/{id}/metro", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(populationJson))
                .andExpect(status().isOk());
    }
}
