package java8;

//Next we specify a person factory interface to be used for creating new persons:
interface PersonFactory<P extends Person1> {
    P create(String firstName, String lastName);
}