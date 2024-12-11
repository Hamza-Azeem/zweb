package com.Zweb.backend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OptionalNotEmptyListValidator.class)
public @interface OptionalNotEmptyList {
    String message() default "List can be null but not Empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
