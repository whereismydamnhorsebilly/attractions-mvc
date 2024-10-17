package com.springApp.dto.serviceoptionDto;

import com.springApp.util.ServiceOptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOptionDtoToGet {

    @Enumerated(EnumType.STRING)
    private ServiceOptionType name;

}