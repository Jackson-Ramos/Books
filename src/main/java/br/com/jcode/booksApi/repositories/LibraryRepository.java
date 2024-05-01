package br.com.jcode.booksApi.repositories;

import br.com.jcode.booksApi.domain.library.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}
