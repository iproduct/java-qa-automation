package course.qa.dao;

import course.qa.model.Person;

import java.util.Arrays;

public class PersonRepositoryMemoryImpl implements PersonRepository {
    public static final int MAX_PERSONS = 100;
    private long nextId = 0;

    private Person[] persons = new Person[MAX_PERSONS];
    private int length = 0;

    @Override
    public Person create(Person p) {
        p.setId(++ nextId);
        persons[length++] = p;
        return p;
    }

    @Override
    public Person update(Person p) {
        int index =  Arrays.binarySearch(persons, p); // O(log(N)
        persons[index] = p;
        return p;
    }

    @Override
    public Person deleteById(Long id) {
        int index =  Arrays.<Person>binarySearch(persons, 0, length, new Person(id)); // O(log(N)
        if(index < 0) return null;
        Person removed =  persons[index];
        for(int i = index; i < length - 1; i++){
            persons[i] = persons[i + 1]; // O(N)
        }
        length --;
        return removed;
    }

    @Override
    public Person[] findAll() {
        return Arrays.copyOfRange(persons, 0, length);
    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
