package br.org.unifacisa.booksapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true, nullable = false)
	private String id;
	
	@Column(name = "login",unique = true, nullable = false)
	private String login;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "account_non_expired")
	private String accountNonExpired;
	
	@Column(name = "account_non_locked")
	private String accountNonLocked;
	
	@Column(name = "credentials_non_expired")
	private String credentialsNonExpired;
	
	@Column(name = "enabled")
	private String enabled;
	
}
