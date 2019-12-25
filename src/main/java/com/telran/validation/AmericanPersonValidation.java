package com.telran.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmericanPersonValidationConstraint.class)
public @interface AmericanPersonValidation {

    String message() default "AmericanPerson validation message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
