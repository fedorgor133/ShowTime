package resources.dao.MOCK.entities;

import model.Theme;
import resources.dao.entities.DAOTheme;

import java.util.*;

public class DAOThemeMOCK implements DAOTheme {

    private Map<String, Theme> tematiques = new HashMap<>();

    public DAOThemeMOCK(){
        addTheme("Sci-Fi");
        addTheme("Drama");
        addTheme("Comedy");
        addTheme("Action");
        addTheme("Horror");
        addTheme("Thriller");
        addTheme("Romance");
        addTheme("Mystery");
        addTheme("Crime");
        addTheme("Animation");
        addTheme("Adventure");
        addTheme("Fantasy");
        addTheme("Superhero");
        addTheme("Family");
        addTheme("War");
        addTheme("History");
        addTheme("Documentary");
        addTheme("Western");
        addTheme("Music");
        addTheme("Sport");
        addTheme("Biography");
        addTheme("Musical");
        addTheme("Short");
    }

    private void addTheme(String themeName){
        tematiques.put(themeName, new Theme(themeName));
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
    public boolean update(Theme theme, String[] params) throws Exception {
        theme.setThemeName(Objects.requireNonNull(
                params[0], "Tematica name cannot be null"));
        return tematiques.replace(theme.getThemeName(), theme) != null;
    }

    @Override
    public boolean delete(Theme theme) throws Exception {
        return tematiques.remove(theme.getThemeName()) != null;
    }
}
