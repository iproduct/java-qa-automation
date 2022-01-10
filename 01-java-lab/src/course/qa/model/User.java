package course.qa.model;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class User extends Person {
    private String username;
    private String password;
    private Role[] roles = { Role.CLIENT };

    public User() {
        super(); // by default
    }

    public User(Long id) {
        super(id); // mandatory super constructor
    }

    public User(String name, int anAge, String username, String password) { // required args constructor
        super(name, anAge);
        this.username = username;
        this.password = password;
    }

    public User(String name, int anAge, String username, String password, Role[] roles) { //all ars constructor
        super(name, anAge);
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nUsername=" + username +
                "\nPassword=" + password +
                "\nRoles=" + Arrays.toString(roles)+
                "\n";
    }
}
