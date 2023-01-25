package br.com.rodolfo.api.transaction.repositories;

import br.com.rodolfo.api.transaction.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


}
