package br.org.unifacisa.booksapi.repositories;

import br.org.unifacisa.booksapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}








