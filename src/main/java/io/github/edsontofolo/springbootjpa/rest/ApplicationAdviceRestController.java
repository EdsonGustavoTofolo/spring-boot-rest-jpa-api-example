package io.github.edsontofolo.springbootjpa.rest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationAdviceRestController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleConstraintViolation(ConstraintViolationException ex) {
        String sqlExceptionMessage = ex.getSQLException().getMessage().toLowerCase();
        if (sqlExceptionMessage.contains("unique index or primary key violation")) {
            return new ApiErrors("Record must be unique");
        } else if (sqlExceptionMessage.contains("referential integrity constraint violation")) {
            return new ApiErrors("Record does reference to another table");
        }
        return new ApiErrors(ex.getCause().getMessage());
    }

}
