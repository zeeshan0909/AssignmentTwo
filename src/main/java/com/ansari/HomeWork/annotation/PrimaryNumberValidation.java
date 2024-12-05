package com.ansari.HomeWork.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = PrimaryNumberValidator.class)
public @interface PrimaryNumberValidation  {
    String message() default "{Input is a prime number}";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
