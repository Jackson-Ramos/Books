package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.author.Author;
import br.org.unifacisa.booksapi.domain.author.AuthorRequestDto;
import br.org.unifacisa.booksapi.domain.book.Book;
import br.org.unifacisa.booksapi.exceptions.NotFoundException;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import br.org.unifacisa.booksapi.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("")));
	}
	
	@PostMapping
	public ResponseEntity<Author> create(@RequestBody AuthorRequestDto authorRecord) {
		List<Book> books = bookRepository.findAllById(authorRecord.getBookIds());
		Author author = new Author(
				null,
				authorRecord.getName(),
				books
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(author));
	}
}
