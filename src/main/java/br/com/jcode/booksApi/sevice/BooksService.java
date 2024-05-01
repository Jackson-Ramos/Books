package br.com.jcode.booksApi.sevice;

import br.com.jcode.booksApi.exceptions.NotFoundException;
import br.com.jcode.booksApi.repositories.AuthorRepository;
import br.com.jcode.booksApi.domain.author.Author;
import br.com.jcode.booksApi.domain.book.Book;
import br.com.jcode.booksApi.domain.book.BookRequestDto;
import br.com.jcode.booksApi.domain.library.Library;
import br.com.jcode.booksApi.repositories.BookRepository;
import br.com.jcode.booksApi.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class BooksService {
	
	@Autowired
	private final BookRepository booksRepository;
	@Autowired
	private final AuthorRepository authorRepository;
	@Autowired
	private final LibraryRepository libraryRepository;
	
	public BooksService
			(
					final BookRepository booksRepository,
					final AuthorRepository authorRepository,
					final LibraryRepository libraryRepository
			) {
		this.booksRepository = booksRepository;
		this.authorRepository = authorRepository;
		this.libraryRepository = libraryRepository;
	}
	
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findAll());
	}
	
	public ResponseEntity<Book> findById(@PathVariable final String id) {
		var book = booksRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Id: " + id + " not found"));
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	public ResponseEntity<Book> save(@RequestBody BookRequestDto request) {
		Author existingAuthor = authorRepository.findById(request.getAuthorId())
				.orElseThrow(()-> new NotFoundException("Author not found"));
		
		List<Library> libraries = libraryRepository.findAllById(request.getLibrariesIds());
		Book book = new Book(
				null,
				request.getTitle(),
				request.getDescription(),
				existingAuthor,
				libraries
		);
		
		libraries.forEach(library -> {
			library.addBook(book);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(book));
	}
}
