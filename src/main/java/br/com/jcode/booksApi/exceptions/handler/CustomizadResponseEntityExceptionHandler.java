package br.com.jcode.booksApi.exceptions.handler;

import br.com.jcode.booksApi.exceptions.ExceptionResponse;
import br.com.jcode.booksApi.exceptions.InvalidJwtAuthenticationException;
import br.com.jcode.booksApi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizadResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception exception, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> notFoundException(Exception exception, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> InvalidJwtAuthenticationException(Exception exception, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
	}
}
