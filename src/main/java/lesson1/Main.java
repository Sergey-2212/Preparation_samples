package lesson1;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String[] args) {


        Person person = Person.builder()
                .withAddress("Moscow")
                .withAge(39)
                .withCountry("Russia")
                .withFirstName("Mark")
                .withGender("Male")
                .withLastName("Kriukoff")
                .withMiddleName("Jerk")
                .build();

        System.out.println(person);

    }
}
