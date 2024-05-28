package br.com.jcode.booksApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	@Serial
	private static final long serialVersionUID = -6045065325890722061L;
	
	public NotFoundException() {
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
