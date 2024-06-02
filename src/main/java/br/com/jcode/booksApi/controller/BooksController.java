package br.com.jcode.booksApi.controller;

import br.com.jcode.booksApi.domain.book.Book;
import br.com.jcode.booksApi.domain.book.BookRequestDto;
import br.com.jcode.booksApi.sevice.BooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	
	private final BooksService booksService;
	
	public BooksController(BooksService booksService) {
		this.booksService = booksService;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		return booksService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable final String id) {
		return booksService.findById(id);
		
	}
	
	@PostMapping
	public ResponseEntity<Book> save(@RequestBody @Valid BookRequestDto request) {
		return booksService.save(request);
	}
}
