package com.example.jaz_s29467_nbp.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;


@ControllerAdvice
public class NbpControllerAdvice {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> NotFoundException(HttpClientErrorException.NotFound ex) {
        return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> BadRequestException(HttpClientErrorException.BadRequest ex) {
        String message = ex.getMessage();
        if (message != null && message.contains("Przekroczono limit")) {
            return new ResponseEntity<>("Przekroczono limit", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> GenericExceptionException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
