package br.org.unifacisa.booksapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true, nullable = false)
	private String id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "description", nullable = false)
	private String description;
}
