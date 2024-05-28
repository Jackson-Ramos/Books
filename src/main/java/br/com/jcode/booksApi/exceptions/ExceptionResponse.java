package br.com.jcode.booksApi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1516489948269048788L;
	
	private Date time;
	private String message;
	private String details;
	
}
