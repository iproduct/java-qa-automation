package dao;

import model.Person;

import java.util.Arrays;

public class PersonRepository {
    public static final int MAX_PERSONS = 100;
    private long nextId = 0;

    private Person[] persons = new Person[MAX_PERSONS];
    private int length = 0;

    public Person create(Person p) {
        p.setId(++ nextId);
        persons[length++] = p;
        return p;
    }

    public Person[] findAll() {
        return Arrays.copyOfRange(persons, 0, length);
    }
}
