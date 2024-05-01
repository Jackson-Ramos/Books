package br.com.jcode.booksApi.domain.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountCredentials  implements Serializable {
	
	private static final long serialVersionUID = -4645680816422426344L;
	
	private String login;
	private String password;
	
}
