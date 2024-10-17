package com.springApp.dto.serviceoptionDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
@NoArgsConstructor
public class ServiceOptionDto {

    @Enumerated(EnumType.STRING)
    private String name;

    private String aboutService;

}
