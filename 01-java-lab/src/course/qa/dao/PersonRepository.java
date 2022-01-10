package course.qa.dao;

import course.qa.model.Person;

public interface PersonRepository {
    Person create(Person p);
    Person update(Person p);
    Person deleteById(Long id);
    Person[] findAll();
    Person findById(Long id);
    long getCount();
}
