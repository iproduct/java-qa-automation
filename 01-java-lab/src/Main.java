import dao.PersonRepository;
import model.Person;

public class Main {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        repo.create(new Person("Trayan", 45));
        repo.create(new Person("Georgi", 35));
        repo.create(new Person("Maria", 25));

        for(Person p: repo.findAll()) {
            System.out.println(p);
        }
    }
}
