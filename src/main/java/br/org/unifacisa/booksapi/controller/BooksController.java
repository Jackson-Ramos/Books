package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.Author;
import br.org.unifacisa.booksapi.domain.Book;
import br.org.unifacisa.booksapi.domain.dtos.BookRequestDto;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import br.org.unifacisa.booksapi.repositories.BooksRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private final BooksRepository booksRepository;
	private final AuthorRepository authorRepository;
	
	public BooksController(final BooksRepository booksRepository, final AuthorRepository authorRepository) {
		this.booksRepository = booksRepository;
		this.authorRepository = authorRepository;
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return booksRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable final String id) {
		return booksRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Object> createBook(@RequestBody BookRequestDto request) {
		Optional<Author> existingAuthor = authorRepository.findById(request.getAuthorId());
		
		if (existingAuthor.isEmpty()) {
			return ResponseEntity.badRequest().body("Author not found");
		}
		
		Book book = new Book(
				null,
				request.getTitle(),
				request.getDescription(),
				existingAuthor.get()
		);
		
		return ResponseEntity.ok(booksRepository.save(book));
	}
}
