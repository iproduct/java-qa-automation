package course.qa.model;

import course.qa.dao.Identifiable;

import java.util.Arrays;

public class User extends Person implements Identifiable<Long> {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
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
