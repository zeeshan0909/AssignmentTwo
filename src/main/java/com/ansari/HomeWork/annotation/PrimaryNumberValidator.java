package com.ansari.HomeWork.annotation;

import com.ansari.HomeWork.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimaryNumberValidator implements ConstraintValidator<PrimaryNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
        if (num == null) {
            throw new ResourceNotFoundException("Null value is not allowed");
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
