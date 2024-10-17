package com.springApp.validators.serviceOptionValidation;

import com.springApp.service.serviceOptionService.ServiceOptionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsServiceExist implements ConstraintValidator<CheckServiceEntity, String> {

    @Autowired
    private ServiceOptionService serviceOptionService;

    @Override
    public void initialize(CheckServiceEntity constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String serviceOptionType, ConstraintValidatorContext constraintValidatorContext) {
        if (serviceOptionService.getByType(serviceOptionType) == null || serviceOptionType == null) {
            return false;
        }
        return serviceOptionService.getByType(serviceOptionType) != null;
    }
}
