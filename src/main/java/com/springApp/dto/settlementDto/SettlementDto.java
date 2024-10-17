package com.springApp.dto.settlementDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
public class SettlementDto {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "Enter an existing settlement name")
    private String name;

    @Min(value = 1)
    private int population;

    private boolean hasMetro;

}
