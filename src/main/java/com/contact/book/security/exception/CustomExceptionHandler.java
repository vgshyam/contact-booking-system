package com.contact.book.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.contact.book.util.response.ResponseUtil;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = GeneralException.class)
	public ResponseEntity<?> generalException(GeneralException generalException){
		return ResponseUtil.failure(generalException.getMessage(),HttpStatus.NOT_FOUND.value());		
	}
}
