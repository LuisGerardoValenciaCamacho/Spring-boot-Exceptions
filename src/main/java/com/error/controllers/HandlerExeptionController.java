package com.error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.error.exceptions.UserNotFoundException;
import com.error.models.Error;

@ControllerAdvice
public class HandlerExeptionController {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Error> divisionByZero(Exception ex) {
		Error error = new Error(ex.getMessage(), "Error dividr por cero!", HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
		return ResponseEntity.internalServerError().body(error);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> notFoundApiException(Exception ex) {
		Error error = new Error(ex.getMessage(), "API rest no encontrado", HttpStatus.NOT_FOUND.value(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Error> numberFormatException(Exception ex) {
		Error error = new Error(ex.getMessage(), "Formato incorrecto", HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
	}
	
	@ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
	public ResponseEntity<Error> nullPointerException(Exception ex) {
		Error error = new Error(ex.getMessage(), "Usuario o rol no existe", HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
	}
}
