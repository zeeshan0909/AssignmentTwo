package com.ansari.HomeWork.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordValidation {
    String messag() default "{Password should be contain a. contain one uppercase letter\n" +
                                "b. contain one lowercase letter\n" +
            "c. contain one specialcase letter\n" +
            "d. minimum length is 10 character}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
