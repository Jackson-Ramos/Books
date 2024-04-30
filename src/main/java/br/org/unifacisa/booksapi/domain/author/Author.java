package br.org.unifacisa.booksapi.domain.author;

import br.org.unifacisa.booksapi.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true, nullable = false)
	private String id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties(value = "author")
	private List<Book> books;
}
