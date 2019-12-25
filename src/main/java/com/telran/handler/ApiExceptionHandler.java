package com.telran.handler;

import com.telran.dto.ErrorDto;
import com.telran.exceptions.InputValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Aspect Oriented Programming (AOP)     YourAspect -> new Person()
public class ApiExceptionHandler {

    //response entity = JSON response + status code
    //@RestController + @ResponseStatus = response entity

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> commonErrorResponse(Exception e) {
        ResponseEntity<ErrorDto> response = new ResponseEntity<>(
                ErrorDto.builder().message(e.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        //Http status codes

        return response;
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ErrorDto> getInputValidationResponse(InputValidationException e) {
        return new ResponseEntity<>(e.getErrorDto(), HttpStatus.BAD_REQUEST); //400
    }


}

