package br.com.jcode.booksApi.domain.author;

import br.com.jcode.booksApi.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -5628343897760408106L;
	
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
