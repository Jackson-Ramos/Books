package br.com.jcode.booksApi.sevice;

import br.com.jcode.booksApi.domain.library.Library;
import br.com.jcode.booksApi.domain.library.LibraryRequestDto;
import br.com.jcode.booksApi.repositories.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

public class LibrariesService {
	private final LibraryRepository librariesRepositori;
	
	public LibrariesService(LibraryRepository librariesRepositori) {
		this.librariesRepositori = librariesRepositori;
	}
	
	public ResponseEntity<List<Library>> findAll() {
		return ResponseEntity.ok(librariesRepositori.findAll());
	}
	
	
	public ResponseEntity<Library> findById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(librariesRepositori.findById(id).orElse(null));
	}
	
	public ResponseEntity<Library> save(@RequestBody LibraryRequestDto libraryRequestDto) {
		
		Library library = new Library(
				null,
				libraryRequestDto.getName(),
				Collections.EMPTY_LIST
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(librariesRepositori.save(library));
	}
}
