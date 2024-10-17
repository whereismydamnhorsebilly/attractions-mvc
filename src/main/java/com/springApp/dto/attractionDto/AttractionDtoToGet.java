package com.springApp.dto.attractionDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springApp.validators.serviceOptionValidation.CheckServiceEntity;
import com.springApp.validators.settlementValidation.CheckSettlementEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class AttractionDtoToGet {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    private String aboutAttraction;

    private String attractionType;

    @NotEmpty(message = "Name should not be empty")
    @CheckSettlementEntity
    private String settlement;

    @CheckServiceEntity
    private String serviceOption;
}
