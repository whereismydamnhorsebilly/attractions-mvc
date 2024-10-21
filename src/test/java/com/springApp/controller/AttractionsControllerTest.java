package com.springApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springApp.dto.attractionDto.AboutAttractionDto;
import com.springApp.dto.attractionDto.AttractionDtoToGet;
import com.springApp.dto.attractionDto.AttractionDtoToShow;
import com.springApp.model.Settlement;
import com.springApp.service.BindingResultHandler;
import com.springApp.service.attractionService.AttractionService;
import com.springApp.util.AttractionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
class AttractionsControllerTest {

    @InjectMocks
    private AttractionsController controller;

    @Mock
    private AttractionService attractionService;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private BindingResultHandler bindingResultHandler;

    @Mock
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    AttractionDtoToShow testAttractionDtoToShow = new AttractionDtoToShow();
    List<AttractionDtoToShow> testAttractionDtoList = new ArrayList<>();
    Settlement testSettlement = new Settlement();
    String settlementName = "TestSettlement";

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();

        testSettlement.setName(settlementName);
        testAttractionDtoToShow.setAttractionType(AttractionType.MUSEUM);
        testAttractionDtoToShow.setSettlement(testSettlement);
        testAttractionDtoList.add(testAttractionDtoToShow);
    }

    /**
     * Тестирование метода getAllAttractionsByType (получаем все достопримечательности по типу)
     * @throws Exception
     */
    @Test
    void getAllAttractionsByTypeTest() throws Exception {
        String type = "MUSEUM";

        when(attractionService.findByTypeSortByName(type)).thenReturn(testAttractionDtoList);

        mockMvc.perform(get("/api/attractions/byType")
                .param("type", type))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(testAttractionDtoToShow.getName()))
                .andExpect(jsonPath("$[0].attractionType").value(type));
    }

    /**
     * Тестирование метода getAllAttractionsBySettlement (получаем все достопримечательности по городу)
     * @throws Exception
     */
    @Test
    void getAllAttractionsBySettlementTest() throws Exception {
        when(attractionService.findBySettlementName(settlementName)).thenReturn(testAttractionDtoList);

        mockMvc.perform(get("/api/attractions/bySettlement")
                        .param("settlementName", settlementName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(testAttractionDtoToShow.getName()))
                .andExpect(jsonPath("$[0].settlement").exists());
    }

    /**
     * Тестирование метода add (добавляем достопримечательность)
     * @throws Exception
     */
    @Test
    void addAttractionTest() throws Exception {
        AttractionDtoToGet testAttractionDtoToGet = new AttractionDtoToGet();
        String attractionJson = objectMapper.writeValueAsString(testAttractionDtoToGet);

        mockMvc.perform(post("/api/attractions/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(attractionJson))
                .andExpect(status().isCreated());
    }

    /**
     * Тестирование метода update (обновляем описание достопримечательности)
     * @throws Exception
     */
    @Test
    void updateAttractionTest() throws Exception {
        AboutAttractionDto aboutAttractionDto = new AboutAttractionDto();
        Integer attractionId = 1;

        String attractionJson = objectMapper.writeValueAsString(aboutAttractionDto);

        mockMvc.perform(patch("/api/attractions/{id}/aboutAttraction", attractionId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(attractionJson))
                .andExpect(status().isOk());
    }

    /**
     * Тестирование метода delete (удаляем достопримечательность)
     * @throws Exception
     */
    @Test
    void deleteAttractionTest() throws Exception {
        Integer attractionId = 1;

        mockMvc.perform(delete("/api/attractions/{id}/remove", attractionId)
                        .param("id", String.valueOf(attractionId)))
                .andExpect(status().isNoContent());
    }
}
