package com.test.exceptions;

public class UsuarioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1965628989533553484L;

	public UsuarioNotFoundException(Long id) {
	    super("No se encontro Usuario " + id);
	  }
}
