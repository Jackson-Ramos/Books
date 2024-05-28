package br.com.jcode.booksApi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "permissions")
@Table(name = "permissions")
public class Permission implements GrantedAuthority, Serializable {
	
	@Serial
	private static final long serialVersionUID = 96117122726749201L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "permission_id", unique = true, nullable = false)
	private String id;
	
	@Column(name = "permission", nullable = false)
	private String permission;
	
	@Override
	public String getAuthority() {
		return this.permission;
	}
}
