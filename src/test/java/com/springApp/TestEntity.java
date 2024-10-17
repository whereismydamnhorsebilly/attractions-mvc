package com.springApp;

import com.springApp.model.Attraction;
import com.springApp.model.ServiceOption;
import com.springApp.model.Settlement;
import com.springApp.util.AttractionType;
import com.springApp.util.ServiceOptionType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
public class TestEntity {

    /**
     * Создание суррогатных объектов для тестирования
     */
    private List<Attraction> attractions = new ArrayList<>();
    private Attraction testAttraction = new Attraction();
    private Settlement testSettlement = new Settlement();
    private ServiceOption testServiceOption = new ServiceOption();

    public TestEntity() {
        /**
         * Инициализация суррогатных объектов
         */
        testSettlement.setName("TestSettlement");
        testSettlement.setHasMetro(true);
        testSettlement.setId(10);
        testSettlement.setPopulation(123123123);
        testSettlement.setAttractions(attractions);

        testServiceOption.setName(ServiceOptionType.GUIDED_TOUR);
        testServiceOption.setId(1);
        testServiceOption.setAboutService("TestAboutService");
        testServiceOption.setAttraction(attractions);

        testAttraction.setAboutAttraction("TestDescription");
        testAttraction.setName("TestName");
        testAttraction.setAttractionType(AttractionType.MUSEUM);
        testAttraction.setId(123);
        testAttraction.setCreationDate(LocalDate.of(2020, 10, 10));
        testAttraction.setSettlement(testSettlement);
        testAttraction.setServiceOption(testServiceOption);

        attractions.add(testAttraction);
    }
}
