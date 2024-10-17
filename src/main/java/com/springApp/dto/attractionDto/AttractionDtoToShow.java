package com.springApp.dto.attractionDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springApp.dto.serviceoptionDto.ServiceOptionDto;
import com.springApp.model.Settlement;
import com.springApp.util.AttractionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class AttractionDtoToShow {

    @Id
    @NotEmpty
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    private String aboutAttraction;

    @Enumerated(EnumType.STRING)
    private AttractionType attractionType;

    private Settlement settlement;

    private ServiceOptionDto serviceOption;

}
