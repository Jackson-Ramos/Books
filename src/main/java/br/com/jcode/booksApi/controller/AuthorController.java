package br.com.jcode.booksApi.controller;

import br.com.jcode.booksApi.domain.author.AuthorRequestDto;
import br.com.jcode.booksApi.domain.author.Author;
import br.com.jcode.booksApi.sevice.AuthorsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	private final AuthorsService authorsService;
	
	public AuthorController(AuthorsService authorsService) {
		this.authorsService = authorsService;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		return authorsService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable String id) {
		return authorsService.findById(id);
		
	}
	
	@PostMapping
	public ResponseEntity<Author> create(@RequestBody @Valid AuthorRequestDto authorRecord) {
		return authorsService.save(authorRecord);
	}
}
