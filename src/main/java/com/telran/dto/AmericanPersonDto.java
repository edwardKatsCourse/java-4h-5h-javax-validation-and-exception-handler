package com.telran.dto;

import com.telran.validation.Age;
import com.telran.validation.AmericanPersonValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@AmericanPersonValidation
public class AmericanPersonDto {

    @NotBlank
    @Length(min = 3, max = 10) //this annotation for STRING only!
    private String name;

    @Email(message = "Email format is incorrect") //"" - false | null = true
    @NotBlank //""
    @Length(min = 10, max = 20)
    //abcdefg
    private String email;

    @Age(isUSA = false)
    private Integer age;

    //private PersonDetails personDetails;
    //personDetails.getPersonCountry().getCountryName();
    //country code, country name, country currency
}
