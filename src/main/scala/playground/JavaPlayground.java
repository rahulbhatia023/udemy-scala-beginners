package playground;

public class JavaPlayground {
    public static void main(String[] args) {
        /**
         * We would access N_EYES from class Person but not from instance of class Person
         */
        System.out.println(Person.N_EYES);
    }
}

/**
 * Class Level Functionality - Functionality that does not depend on instance of a class
 * Universal constants or universal methods that we should be able to access without creating the instance of class
 */
class Person {
    public static final int N_EYES = 2;
}