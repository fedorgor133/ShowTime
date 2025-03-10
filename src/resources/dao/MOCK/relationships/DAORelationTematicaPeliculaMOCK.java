package resources.dao.MOCK.relationships;

import resources.dao.Duo;
import resources.dao.relationships.DAORelationThemeMovie;

public class DAORelationTematicaPeliculaMOCK extends DAORelationMOCK<Duo<String, String>> implements DAORelationThemeMovie {

    public DAORelationTematicaPeliculaMOCK() {
        addThemeMovie("Sci-Fi", "Avatar");
        addThemeMovie("Action", "Inception");
        addThemeMovie("Sci-Fi", "Inception");
        addThemeMovie("Adventure", "Inception");
        addThemeMovie("Adventure", "Interstellar");
        addThemeMovie("Drama", "Interstellar");
        addThemeMovie("Sci-Fi", "Interstellar");
        addThemeMovie("Sci-Fi", "The Matrix");
        addThemeMovie("Action", "The Matrix");
        addThemeMovie("Drama", "Shawshank Redemption");
    }

    private boolean addThemeMovie(String nameTheme, String nameMovie) {
        return relations.add(new Duo<>(nameTheme, nameMovie));
    }
}
