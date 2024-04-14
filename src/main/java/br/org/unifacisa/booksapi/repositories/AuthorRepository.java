package br.org.unifacisa.booksapi.repositories;

import br.org.unifacisa.booksapi.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}