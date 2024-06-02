package br.com.jcode.booksApi.sevice;

import br.com.jcode.booksApi.domain.security.AccountCredentials;
import br.com.jcode.booksApi.domain.security.TokenDTO;
import br.com.jcode.booksApi.repositories.UserRepository;
import br.com.jcode.booksApi.security.Jwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthService {
	
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	
	public AuthService(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, UserRepository userRepository) {
		this.jwtTokenProvider = jwtTokenProvider;
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
	}
	
	public ResponseEntity signin(AccountCredentials data) {
		try {
			var username = data.getLogin();
			var password = data.getPassword();
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
			
			var user = userRepository.findByLogin(username);
			
			var tokenResponse = new TokenDTO();
			if (user != null) {
				tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username " + username + " not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid username/password supplied!");
		}
	}
	
}
