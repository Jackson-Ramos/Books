package br.org.unifacisa.booksapi.domain.book;

import br.org.unifacisa.booksapi.domain.library.Library;
import br.org.unifacisa.booksapi.domain.author.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book implements Serializable {
	private static final long serialVersionUID = -9100469024047177455L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(unique = true, nullable = false)
	private String id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	@JsonIgnoreProperties("books")
	private Author author;
	
	@ManyToMany(mappedBy = "books")
	@JsonIgnoreProperties("books")
	private List<Library> libraries;
	
	public void setAuthor(Author author) {
	}
}
