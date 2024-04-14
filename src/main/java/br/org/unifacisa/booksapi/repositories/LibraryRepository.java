package br.org.unifacisa.booksapi.repositories;

import br.org.unifacisa.booksapi.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, String> {
}
