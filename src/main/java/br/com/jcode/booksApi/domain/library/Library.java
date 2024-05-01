package br.com.jcode.booksApi.domain.library;

import br.com.jcode.booksApi.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "libraries")
@NoArgsConstructor
@AllArgsConstructor
public class Library implements Serializable {
	private static final long serialVersionUID = -8106984482890458068L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "library_book",
			joinColumns = @JoinColumn(name = "library_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	@JsonIgnoreProperties("libraries")
	private List<Book> books;
	
	public void addBook(Book book) {
		this.books.add(book);
	}
}
