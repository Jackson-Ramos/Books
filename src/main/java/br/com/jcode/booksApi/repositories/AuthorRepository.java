package br.com.jcode.booksApi.repositories;

import br.com.jcode.booksApi.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
