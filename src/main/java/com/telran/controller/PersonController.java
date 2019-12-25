package com.telran.controller;

import com.telran.dto.AmericanPersonDto;
import com.telran.exceptions.InputValidationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    @PostMapping("/persons")
    public void savePerson(@RequestBody @Valid AmericanPersonDto americanPersonDto, BindingResult result) {
//        if (/*validation failed*/) {
//            //record to database, that error occurred
//        }

        if (result.hasErrors()) {
            //List<FieldError> fieldErrors = result.getFieldErrors(); //email
            throw new InputValidationException(result);
        }
    }

}
