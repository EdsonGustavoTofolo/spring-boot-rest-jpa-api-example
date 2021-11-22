package io.github.edsontofolo.springbootjpa.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class ApiErrors {
    private List<String> errors;

    public ApiErrors(String message) {
        this.errors = Arrays.asList(message);
    }
}
