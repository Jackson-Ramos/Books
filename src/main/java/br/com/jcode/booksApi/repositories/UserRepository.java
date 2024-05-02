package br.com.jcode.booksApi.repositories;

import br.com.jcode.booksApi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
	UserDetails findByLogin(String login);
}