package br.com.jcode.booksApi.sevice;

import br.com.jcode.booksApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private final UserRepository userRepository;
	
	public UserService(final UserService userService) {
		this.userRepository = userService.userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var login = userRepository.findByLogin(username);
		if (login == null) {
			throw new UsernameNotFoundException("User login: " + username + "not found");
		}
		return login;
	}
}
