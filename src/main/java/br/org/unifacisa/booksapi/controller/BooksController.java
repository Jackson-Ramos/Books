package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.Author;
import br.org.unifacisa.booksapi.domain.Book;
import br.org.unifacisa.booksapi.domain.Library;
import br.org.unifacisa.booksapi.domain.dtos.BookRequestDto;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import br.org.unifacisa.booksapi.repositories.BookRepository;
import br.org.unifacisa.booksapi.repositories.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private final BookRepository booksRepository;
	private final AuthorRepository authorRepository;
	private final LibraryRepository libraryRepository;
	
	public BooksController
			(
					final BookRepository booksRepository,
					final AuthorRepository authorRepository,
					final LibraryRepository libraryRepository
			) {
		this.booksRepository = booksRepository;
		this.authorRepository = authorRepository;
		this.libraryRepository = libraryRepository;
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
		
		List<Library> libraries = libraryRepository.findAllById(request.getLibrariesIds());
		Book book = new Book(
				null,
				request.getTitle(),
				request.getDescription(),
				existingAuthor.get(),
				libraries
				);
		
		libraries.forEach(library -> {
			library.addBook(book);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
	}
}
