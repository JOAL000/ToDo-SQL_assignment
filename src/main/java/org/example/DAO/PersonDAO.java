package org.example.DAO;

import org.example.Model.Person;

import java.util.Collection;

public interface PersonDAO {
    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person person);
    boolean deleteById(int id);
}
