package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.author.Author;
import br.org.unifacisa.booksapi.domain.book.Book;
import br.org.unifacisa.booksapi.domain.library.Library;
import br.org.unifacisa.booksapi.domain.book.BookRequestDto;
import br.org.unifacisa.booksapi.exceptions.NotFoundException;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import br.org.unifacisa.booksapi.repositories.BookRepository;
import br.org.unifacisa.booksapi.repositories.LibraryRepository;
import br.org.unifacisa.booksapi.sevice.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private final BooksService booksService;
	
	public BooksController(BooksService booksService) {
		this.booksService = booksService;
	}
	
	@GetMapping
	public ResponseEntity<List<Book> >findAll() {
		return booksService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable final String id) {
		return booksService.findById(id);
		
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody BookRequestDto request) {
		return booksService.save(request);
	}
}
