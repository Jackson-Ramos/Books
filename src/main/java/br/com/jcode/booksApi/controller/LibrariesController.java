package br.com.jcode.booksApi.controller;

import br.com.jcode.booksApi.domain.library.Library;
import br.com.jcode.booksApi.domain.library.LibraryRequestDto;
import br.com.jcode.booksApi.sevice.LibrariesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
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
	public ResponseEntity<Library> createLibrary(@RequestBody @Valid LibraryRequestDto libraryRequestDto) {
		return librariesService.save(libraryRequestDto);
	}
}
