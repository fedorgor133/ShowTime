package model;

import model.exceptions.PersonaNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class PortfolioPeople {

    private List<Person> people;

    public PortfolioPeople() {
        people = new ArrayList<>();
    }

    public PortfolioPeople(List<Person> people) {
        this.people = people;
    }

    public Person find(String username) throws PersonaNotFoundException {
        for (Person person : people) {
            if (person.getName().equals(username))
                return person;
        }
        throw new PersonaNotFoundException();
    }

    public void add(Person person) {
        people.add(person);
    }
}
