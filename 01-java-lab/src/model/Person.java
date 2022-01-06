package model;

public class Person {  // extends Object by default
//    // static (class) attributes
//    private static long nextId = 0;
//
//    // static helper method
//    public static long printNumPersons(){
//        System.out.println("Number of persons: " + nextId);
//        return nextId;
//    }

    // instance attributes
    private long id;
    private String name = "Anonymous"; // default initialization
    private int age;
    private String cv; // null by default

    public Person() {
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
//            System.out.println("Lazy initializin CV ...");
            cv = "Curriculum Vitae\nMy name is " + name + " and  I am " + age + " years old.\n...";
        }
        return cv;
    }

    @Override
    public String toString(){
        return "\nID: " + id + "\nName: " + name + "\nAge: " + age + "\n" + getCv() + "\n";
    }

    public String sayHello(){
        return "Hello, " + this.name + "!";
    }

    public String sayHello(String prefix){ // overloading
        return prefix + name + "!";
    }

    public static void main(String[] args) {
        Person p1 = new Person("Trayan", 45);
//        System.out.println("Name: " + hello.name);
//        System.out.println("Age: " + hello.age);
        System.out.println(p1.sayHello());
        System.out.println(p1.sayHello("Hi, ")); // overloaded method
//        System.out.println(p1);
        Person p2 = new Person("Georgi", 35);
        Person p3 = new Person("Maria", 25);
//        Person[] persons = {p1, p2, p3};
        long count = 0;
        Person[] persons = new Person[10];
        persons[0] = p1;
        count++;
        persons[1] = p2;
        count++;
        persons[2] = p3;
        count++;
//        for(Person p: persons) {
//            System.out.println(p);
//        }

        for(int i = 0; i < count; i++) {
            System.out.println(persons[i]);
        }
//        printNumPersons(); // Person.printNumPersons();
    }
}
