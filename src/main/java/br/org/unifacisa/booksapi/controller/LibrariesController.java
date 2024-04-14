package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.Library;
import br.org.unifacisa.booksapi.domain.dtos.LibraryRequestDto;
import br.org.unifacisa.booksapi.repositories.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibrariesController {
	
	private final LibraryRepository librariesRepositori;
	
	public LibrariesController(LibraryRepository librariesRepositori) {
		this.librariesRepositori = librariesRepositori;
	}
	
	@GetMapping
	public ResponseEntity<List<Library>> getLibraries() {
		return ResponseEntity.ok(librariesRepositori.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Library> getLibrary(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(librariesRepositori.findById(id).orElse(null));
	}
	
	@PostMapping
	public ResponseEntity<Library> createLibrary(@RequestBody LibraryRequestDto libraryRequestDto) {
		
		Library library = new Library(
				null,
				libraryRequestDto.getName(),
				Collections.EMPTY_LIST
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(librariesRepositori.save(library));
	}
}
