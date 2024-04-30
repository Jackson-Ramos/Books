package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.author.Author;
import br.org.unifacisa.booksapi.domain.author.AuthorRequestDto;
import br.org.unifacisa.booksapi.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	private final AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(authorRepository.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Author> create(@RequestBody AuthorRequestDto authorRecord) {
		Author author = new Author(
				null,
				authorRecord.getName(),
				Collections.EMPTY_LIST
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(authorRepository.save(author));
	}
}
