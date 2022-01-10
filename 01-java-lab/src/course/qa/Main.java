package course.qa;

import course.qa.dao.PersonRepositoryMemoryImpl;
import course.qa.model.Person;

public class Main {
    public static void main(String[] args) {
        PersonRepositoryMemoryImpl repo = new PersonRepositoryMemoryImpl();
        repo.create(new Person("Trayan", 45));
        Person georgi = repo.create(new Person("Georgi", 35));
        repo.create(new Person("Maria", 25));

        repo.deleteById(georgi.getId());

        for(Person p: repo.findAll()) {
            System.out.println(p);
        }
    }
}
