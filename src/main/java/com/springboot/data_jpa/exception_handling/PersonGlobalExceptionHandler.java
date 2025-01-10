package com.springboot.data_jpa.exception_handling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class PersonGlobalExceptionHandler{
    @ExceptionHandler
    public ResponseEntity<PersonIncorrectData> handleException(PersonException exception) {
        PersonIncorrectData data = new PersonIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonIncorrectData> handleException(Exception exception) {
        PersonIncorrectData data = new PersonIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constrainViolationException(ConstraintViolationException ex, WebRequest request){
        List<String> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));
        Map<String, List<String>> result = new HashMap<>();

        result.put("errors: ", errors);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
