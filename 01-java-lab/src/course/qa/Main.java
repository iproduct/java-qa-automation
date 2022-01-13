package course.qa;

import course.qa.dao.PersonRepository;
import course.qa.dao.PersonRepositoryMemoryImpl;
import course.qa.dao.UserRepository;
import course.qa.dao.UserRepositoryMemoryImpl;
import course.qa.model.Person;
import course.qa.model.Role;
import course.qa.model.User;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepositoryMemoryImpl();
        repo.create(new User("Trayan", 45, "trayan", "trayan123"));
        User georgi = repo.create(new User("Georgi", 35, "george", "george123"));
        repo.create(new User("Maria", 25, "mary", "mary123",
                new Role[]{Role.CLIENT, Role.ISSUER, Role.ADMIN}));

        repo.deleteById(georgi.getId() );

        for(User p: repo.findAll()) {
            System.out.println(p);
        }
    }
}
