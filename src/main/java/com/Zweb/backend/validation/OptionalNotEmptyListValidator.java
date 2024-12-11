package com.Zweb.backend.validation;

import com.Zweb.backend.models.Requirements;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class OptionalNotEmptyListValidator implements ConstraintValidator<OptionalNotEmptyList, List<?>> {
    @Override
    public boolean isValid(List<?> value, ConstraintValidatorContext context) {
        return value == null || !value.isEmpty();
    }
}
