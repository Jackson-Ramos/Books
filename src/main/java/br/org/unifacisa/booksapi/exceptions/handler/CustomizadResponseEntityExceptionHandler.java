package br.org.unifacisa.booksapi.exceptions.handler;

import br.org.unifacisa.booksapi.exceptions.ExceptionResponse;
import br.org.unifacisa.booksapi.exceptions.NotFoundException;
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
	public ResponseEntity<ExceptionResponse> notFoundException(Exception exception, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				exception.getMessage(),
				webRequest.getDescription(false)
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
}
