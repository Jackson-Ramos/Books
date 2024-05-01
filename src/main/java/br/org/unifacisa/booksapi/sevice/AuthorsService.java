package br.org.unifacisa.booksapi.sevice;

import br.org.unifacisa.booksapi.domain.author.Author;
import br.org.unifacisa.booksapi.domain.author.AuthorRequestDto;
import br.org.unifacisa.booksapi.domain.book.Book;
import br.org.unifacisa.booksapi.exceptions.NotFoundException;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import br.org.unifacisa.booksapi.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AuthorsService {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public AuthorsService(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAll());
	}
	
	public ResponseEntity<Author> findById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id: " + id + " not found")));
	}
	
	public ResponseEntity<Author> save(@RequestBody AuthorRequestDto authorRecord) {
		List<Book> books = bookRepository.findAllById(authorRecord.getBookIds());
		Author author = new Author(
				null,
				authorRecord.getName(),
				books
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(author));
	}
}