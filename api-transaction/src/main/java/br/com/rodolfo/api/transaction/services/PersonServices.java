package br.com.rodolfo.api.transaction.services;

import br.com.rodolfo.api.transaction.exception.NotFoundOperationException;
import br.com.rodolfo.api.transaction.model.Person;
import br.com.rodolfo.api.transaction.repositories.PersonRepository;
import br.com.rodolfo.api.transaction.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rodolfo.api.transaction.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

   private final PersonRepository personRepository;

   private final TaskRepository taskRepository;

    public PersonServices(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Person findById(Long id) {


        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");

        return personRepository.findById(id).orElseThrow(
                () -> new NotFoundOperationException("Nenhum recurso encontrado"));

    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {


      var entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new NotFoundOperationException("Nenhum recurso encontrado"));

        entity.setId(counter.incrementAndGet());
        entity.setFirstName("Leandro");
        entity.setLastName("Costa");
        entity.setAddress("Uberlândia - Minas Gerais - Brasil");
        entity.setGender("Male");

        return personRepository.save(entity);
    }

    public void delete(Long id) {

        var entity = personRepository.findById(id).orElseThrow(
                () -> new NotFoundOperationException("Nenhum recurso encontrado"));

        personRepository.delete(entity);
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }


    public Task updateTask(Task task, Long id) {

        var entity = taskRepository.findById(id).orElseThrow(
                () -> new NotFoundOperationException("Nenhum recurso encontrado"));

        entity.setId(entity.getId());
        entity.setDescription( task.getDescription());
        entity.setPriority(task.getPriority());


        return taskRepository.save(entity);
    }


}
