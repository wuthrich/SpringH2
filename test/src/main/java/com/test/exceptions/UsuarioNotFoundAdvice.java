package com.test.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class UsuarioNotFoundAdvice {

	@ResponseBody
	  @ExceptionHandler(UsuarioNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String usuarioNotFoundHandler(UsuarioNotFoundException ex) {
	    return ex.getMessage();
	  }
	
}
