package org.example.DAO;

import org.example.Person;
import org.example.DAO.sequencers.PersonIdSequencer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {
    private final List<Person> persons;

    public PersonDAOCollection() {
        this.persons = new ArrayList<>();
    }

    @Override
    public Person persist(Person person) {
        person.setId(PersonIdSequencer.nextId());
        persons.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Person findByEmail(String email) {
        return persons.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
