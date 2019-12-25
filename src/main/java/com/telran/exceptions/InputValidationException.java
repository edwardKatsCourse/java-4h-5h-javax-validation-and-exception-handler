package com.telran.exceptions;

import com.telran.dto.ErrorDto;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class InputValidationException extends RuntimeException {
    private BindingResult result;


    public ErrorDto getErrorDto() {
        //  email, {"length annotation message", "email annotation message"}
        List<ErrorBundleMap> fieldErrors = result.getFieldErrors().stream()
                .map(x -> ErrorBundleMap.builder()
                        .name(x.getField())
                        .message(x.getDefaultMessage())
                        .build()
                )
                .collect(Collectors.toList());

        List<ErrorBundleMap> objectErrors = result.getGlobalErrors().stream()
                .map(x -> ErrorBundleMap.builder()
                        .name(x.getObjectName())
                        .message(x.getDefaultMessage())
                        .build()
                )
                .collect(Collectors.toList());

        Map<String, List<String>> errors = Stream.of(objectErrors, fieldErrors)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        x -> x.getName(),
                        Collectors.mapping(x -> x.getMessage(), Collectors.toList())
                ));

        return ErrorDto.builder()
                .message("Input validation error")
                .errors(errors)
                .build();
    }
}


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
class ErrorBundleMap {
    private String name;
    private String message;
}
