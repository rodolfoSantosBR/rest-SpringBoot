package br.com.rodolfo.api.transaction.repositories;

import br.com.rodolfo.api.transaction.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}