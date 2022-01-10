package course.qa.model;

public class Person implements Comparable<Person> {  // extends Object by default
//    // static (class) attributes
//    private static long nextId = 0;
//
//    // static helper method
//    public static long printNumPersons(){
//        System.out.println("Number of persons: " + nextId);
//        return nextId;
//    }

    // instance attributes
    private Long id;
    private String name = "Anonymous"; // default initialization
    private int age;
    private String cv; // null by default

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Person(String name, int anAge){ // constructor initialization
        this.name = name;
        age = anAge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCv() { // lazy initialization
        if(cv == null) {
            cv = "Curriculum Vitae\nMy name is " + name + " and  I am " + age + " years old.\n...";
        }
        return cv;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\n" + getCv();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id != null ? id.equals(person.id) : person.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public int compareTo(Person other) {
        return id.compareTo(other.id);
    }
}
