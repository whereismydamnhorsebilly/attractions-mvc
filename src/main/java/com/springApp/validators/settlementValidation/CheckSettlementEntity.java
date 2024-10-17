package com.springApp.validators.settlementValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsSettlementExist.class)
public @interface CheckSettlementEntity {

    String message() default "Settlement should exist in database";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
