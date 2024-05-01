package br.org.unifacisa.booksapi.controller;

import br.org.unifacisa.booksapi.domain.library.Library;
import br.org.unifacisa.booksapi.domain.library.LibraryRequestDto;
import br.org.unifacisa.booksapi.exceptions.NotFoundException;
import br.org.unifacisa.booksapi.repositories.LibraryRepository;
import br.org.unifacisa.booksapi.sevice.LibrariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibrariesController {
	
	@Autowired
	private final LibrariesService librariesService;
	
	public LibrariesController(LibrariesService librariesService) {
		this.librariesService = librariesService;
		
	}
	
	@GetMapping
	public ResponseEntity<List<Library>> getLibraries() {
		return librariesService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Library> getLibrary(@PathVariable String id) {
		return librariesService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Library> createLibrary(@RequestBody LibraryRequestDto libraryRequestDto) {
		return librariesService.save(libraryRequestDto);
	}
}
