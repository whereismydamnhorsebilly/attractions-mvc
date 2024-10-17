package com.springApp.validators.settlementValidation;

import com.springApp.service.settlementService.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsSettlementExist implements ConstraintValidator<CheckSettlementEntity, String> {

    @Autowired
    private SettlementService settlementService;

    @Override
    public void initialize(CheckSettlementEntity constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String settlementName, ConstraintValidatorContext constraintValidatorContext) {
        if (settlementService.getByName(settlementName) == null || settlementName == null) {
            return false;
        }
        return settlementService.getByName(settlementName) != null;
    }
}
