package com.Zweb.backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalMinValidator.class)
public @interface OptionalMin {
    String message() default "Field can be null but negative or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
