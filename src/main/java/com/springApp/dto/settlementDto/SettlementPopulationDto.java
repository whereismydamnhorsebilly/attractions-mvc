package com.springApp.dto.settlementDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettlementPopulationDto {

    @Min(value = 1)
    private int population;
}
