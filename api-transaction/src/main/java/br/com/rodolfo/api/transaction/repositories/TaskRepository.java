package br.com.rodolfo.api.transaction.repositories;

import br.com.rodolfo.api.transaction.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {



}
