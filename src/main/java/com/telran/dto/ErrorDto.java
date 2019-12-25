package com.telran.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NotBlank
@Builder
@Data
public class ErrorDto {

    private String message;
    private Map<String, List<String>> errors;
}
