package br.com.nicolas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

	public UnsupportedMathOperationException() {
		super("favor enviar um parametro do tipo numérico");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
