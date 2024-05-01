package br.org.unifacisa.booksapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -6045065325890722061L;
	
	public NotFoundException() {
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
