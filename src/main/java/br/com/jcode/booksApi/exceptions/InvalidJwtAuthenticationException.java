package br.com.jcode.booksApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;


@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {
	
	@Serial
	private static final long serialVersionUID = 1320377213618761209L;
	
	public InvalidJwtAuthenticationException(String exception) {
		super(exception);
	}
	
}
