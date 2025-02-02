package ub.edu.resources.dao.MOCK.entities;

import ub.edu.model.Person;
import ub.edu.resources.dao.entities.DAOPerson;

import java.util.*;

public class DAOPersonMOCK implements DAOPerson {

    private Map<String, Person> xarxaPersones = new HashMap<>();

    public DAOPersonMOCK() {
        addPersona("ajaleo@gmail.com", "ajaleoPassw7");
        addPersona("dtomacal@yahoo.cat", "Qwertyft5");
        addPersona("heisenberg@gmail.com", "the1whoknocks");
        addPersona("rick@gmail.com", "wabalabadapdap22");
        addPersona("nietolopez10@gmail.com", "pekFD91m2a");
        addPersona("nancyarg10@yahoo.com", "contra10LOadc");
        addPersona("CapitaCC@gmail.com", "Alistar10");
        addPersona("nauin2@gmail.com", "kaynJGL20");
        addPersona("juancarlos999@gmail.com", "staIamsA12");
        addPersona("judit121@gmail.com", "Ordinador1");
    }

    private void addPersona(String nom, String pwd){
        xarxaPersones.put(nom, new Person(nom, pwd));
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(xarxaPersones.values());
    }

    @Override
    public Optional<Person> getById(String[] id) {
        return Optional.ofNullable(xarxaPersones.get(Objects.requireNonNull(id[0], "Name cannot be null")));
    }

    @Override
    public boolean add(final Person person) {
        if (xarxaPersones.containsKey(person.getName())) {
            return false;
        }
        xarxaPersones.put(person.getName(), person);
        return true;
    }

    @Override
    public boolean update(final Person person, String[] params) {
        person.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        person.setPwd(Objects.requireNonNull(
                params[1], "Password cannot be null"));
        return xarxaPersones.replace(person.getName(), person) != null;
    }

    @Override
    public boolean delete(final Person person) {
        return xarxaPersones.remove(person.getName()) != null;
    }
}
