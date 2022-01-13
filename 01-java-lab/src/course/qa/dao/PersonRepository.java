package course.qa.dao;

import course.qa.model.Person;

import java.util.Collection;

public interface PersonRepository {
    Person create(Person p);
    Person update(Person p);
    Person deleteById(Long id);
    Collection<Person> findAll();
    Person findById(Long id);
    long getCount();
}
