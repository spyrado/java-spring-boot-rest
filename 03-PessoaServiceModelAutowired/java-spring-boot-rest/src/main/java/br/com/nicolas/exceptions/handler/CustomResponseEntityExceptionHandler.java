package br.com.nicolas.exceptions.handler;

import java.util.Date;

import br.com.nicolas.exceptions.RequiredIsNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.nicolas.exceptions.ExceptionResponse;
import br.com.nicolas.exceptions.ResourceNotFoundException;

@ControllerAdvice() // é como se fosse o interceptor do angular
@RestController()
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
			new Date(), 
			exception.getMessage(), 
			request.getDescription(false)
		);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
			new Date(), 
			exception.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequiredIsNullException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExeption(Exception exception, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
			new Date(),
			exception.getMessage(),
			request.getDescription(false)
		);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
