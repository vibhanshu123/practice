package java8;

/*
 * Let's see how the :: keyword works for constructors.
 *  First we define an example bean with different constructors:
 */
class Person1 {
    String firstName;
    String lastName;

    Person1() {}

    Person1(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}