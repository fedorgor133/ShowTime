package ub.edu.resources.dao.MOCK.entities;

import ub.edu.model.Theme;
import ub.edu.resources.dao.entities.DAOTheme;

import java.util.*;

public class DAOThemeMOCK implements DAOTheme {

    private Map<String, Theme> tematiques = new HashMap<>();

    public DAOThemeMOCK(){
        addTematica("Sci-Fi");
        addTematica("Drama");
        addTematica("Comedy");
        addTematica("Action");
        addTematica("Horror");
        addTematica("Thriller");
        addTematica("Romance");
        addTematica("Mystery");
        addTematica("Crime");
        addTematica("Animation");
        addTematica("Adventure");
        addTematica("Fantasy");
        addTematica("Superhero");
        addTematica("Family");
        addTematica("War");
        addTematica("History");
        addTematica("Documentary");
        addTematica("Western");
        addTematica("Music");
        addTematica("Sport");
        addTematica("Biography");
        addTematica("Musical");
        addTematica("Short");
    }

    private void addTematica(String nomTematica){
        tematiques.put(nomTematica, new Theme(nomTematica));
    }

    @Override
    public Optional<Theme> getById(String[] id) throws Exception {
        return Optional.ofNullable(tematiques.get(Objects.requireNonNull(id[0], "Tematica name cannot be null")));
    }

    @Override
    public List<Theme> getAll() throws Exception {
        return new ArrayList<>(tematiques.values());
    }

    @Override
    public boolean add(Theme Theme) throws Exception {
        if (getById(new String[]{Theme.getThemeName()}).isPresent()) {
            return false;
        }
        tematiques.put(Theme.getThemeName(), Theme);
        return true;
    }

    @Override
    public boolean update(Theme Theme, String[] params) throws Exception {
        Theme.setThemeName(Objects.requireNonNull(
                params[0], "Tematica name cannot be null"));
        return tematiques.replace(Theme.getThemeName(), Theme) != null;
    }

    @Override
    public boolean delete(Theme Theme) throws Exception {
        return tematiques.remove(Theme.getThemeName()) != null;
    }
}
