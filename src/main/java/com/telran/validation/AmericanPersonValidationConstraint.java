package com.telran.validation;

import com.telran.dto.AmericanPersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AmericanPersonValidationConstraint implements ConstraintValidator<AmericanPersonValidation, AmericanPersonDto> {

    @Override
    public boolean isValid(AmericanPersonDto value, ConstraintValidatorContext context) {
        System.out.println(value);
        return false;
    }
}
