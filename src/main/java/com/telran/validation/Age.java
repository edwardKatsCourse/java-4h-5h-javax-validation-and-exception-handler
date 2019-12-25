package com.telran.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeConstraintValidation.class)
public @interface Age {

    //Required fields
    String message() default "Age must be greater than 18 (16 for USA) and less than 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    //My own fields
    boolean isUSA() default false;
}
