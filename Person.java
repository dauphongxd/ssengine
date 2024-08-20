package search;

public class Person {
    String firstName;
    String lastName;
    String email;

    Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        String result = firstName;
        if (lastName != null) {
            result += " " + lastName;
        }
        if (email != null) {
            result += " " + email;
        }
        return result;
    }


}