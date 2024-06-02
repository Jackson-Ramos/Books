package br.com.jcode.booksApi.sevice;

import br.com.jcode.booksApi.domain.library.Library;
import br.com.jcode.booksApi.domain.library.LibraryRequestDto;
import br.com.jcode.booksApi.repositories.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@Service
public class LibrariesService {
	private final LibraryRepository librariesRepository;
	
	public LibrariesService(LibraryRepository librariesRepository) {
		this.librariesRepository = librariesRepository;
	}
	
	public ResponseEntity<List<Library>> findAll() {
		return ResponseEntity.ok(librariesRepository.findAll());
	}
	
	
	public ResponseEntity<Library> findById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(librariesRepository.findById(id).orElse(null));
	}
	
	public ResponseEntity<Library> save(@RequestBody LibraryRequestDto libraryRequestDto) {
		
		Library library = new Library(
				null,
				libraryRequestDto.getName(),
				Collections.EMPTY_LIST
		);
		return ResponseEntity.status(HttpStatus.CREATED).body(librariesRepository.save(library));
	}
}
