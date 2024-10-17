package com.springApp.validators.serviceOptionValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsServiceExist.class)
public @interface CheckServiceEntity {

    public String message() default "There is no such service";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
