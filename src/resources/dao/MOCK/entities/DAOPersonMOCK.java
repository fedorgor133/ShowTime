package resources.dao.MOCK.entities;

import model.Person;
import resources.dao.entities.DAOPerson;

import java.util.*;

public class DAOPersonMOCK implements DAOPerson {

    private Map<String, Person> peopleNet = new HashMap<>();

    public DAOPersonMOCK() {
        addPerson("ajaleo@gmail.com", "ajaleoPassw7");
        addPerson("dtomacal@yahoo.cat", "Qwertyft5");
        addPerson("heisenberg@gmail.com", "the1whoknocks");
        addPerson("rick@gmail.com", "wabalabadapdap22");
        addPerson("nietolopez10@gmail.com", "pekFD91m2a");
        addPerson("nancyarg10@yahoo.com", "contra10LOadc");
        addPerson("CapitaCC@gmail.com", "Alistar10");
        addPerson("nauin2@gmail.com", "kaynJGL20");
        addPerson("juancarlos999@gmail.com", "staIamsA12");
        addPerson("judit121@gmail.com", "Ordinador1");
    }

    private void addPerson(String name, String pwd){
        peopleNet.put(name, new Person(name, pwd));
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(peopleNet.values());
    }

    @Override
    public Optional<Person> getById(String[] id) {
        return Optional.ofNullable(peopleNet.get(Objects.requireNonNull(id[0], "Name cannot be null")));
    }

    @Override
    public boolean add(final Person person) {
        if (peopleNet.containsKey(person.getName())) {
            return false;
        }
        peopleNet.put(person.getName(), person);
        return true;
    }

    @Override
    public boolean update(final Person person, String[] params) {
        person.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        person.setPwd(Objects.requireNonNull(
                params[1], "Password cannot be null"));
        return peopleNet.replace(person.getName(), person) != null;
    }

    @Override
    public boolean delete(final Person person) {
        return peopleNet.remove(person.getName()) != null;
    }
}
