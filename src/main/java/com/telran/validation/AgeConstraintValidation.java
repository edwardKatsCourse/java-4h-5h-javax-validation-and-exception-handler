package com.telran.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidation implements ConstraintValidator<Age, Integer> {

    private Age ageAnnotation;

    //default constructor

    @Override
    public void initialize(Age constraintAnnotation) {
        this.ageAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }


        if (value > 100) {
            return false;
        }

        //US driver
        if (ageAnnotation.isUSA() && value >= 16) {
            return true;
        }

        //EU driver
        if (!ageAnnotation.isUSA() && value >= 18) {
            return true;
        }
        return false;
    }
}
