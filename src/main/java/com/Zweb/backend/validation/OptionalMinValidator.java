package com.Zweb.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OptionalMinValidator implements ConstraintValidator<OptionalMin, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return value == null || value > 1;
    }
}
