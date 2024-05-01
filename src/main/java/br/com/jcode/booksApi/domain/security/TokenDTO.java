package br.com.jcode.booksApi.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class TokenDTO implements Serializable {
	
	private static final long serialVersionUID = 1685846123444814146L;
	
	private String login;
	private Boolean authenticated;
	private Date created;
	private Date expiration;
	private String accessToken;
	private String refreshToken;
}
