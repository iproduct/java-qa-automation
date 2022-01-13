package course.qa;

import course.qa.dao.*;
import course.qa.model.Person;
import course.qa.model.Role;
import course.qa.model.User;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepositoryHashMap();
        repo.create(new User("Trayan", 45, "trayan", "trayan123"));
        User georgi = repo.create(new User("Georgi", 35, "george", "george123"));
        User maria = repo.create(new User("Maria", 25, "mary", "mary123",
                new Role[]{Role.CLIENT, Role.ISSUER, Role.ADMIN}));

        repo.deleteById(georgi.getId());
        maria.setPassword("newpass789");
        repo.update(maria);

        for(User p: repo.findAll()) {
            System.out.println(p);
        }
    }
}
