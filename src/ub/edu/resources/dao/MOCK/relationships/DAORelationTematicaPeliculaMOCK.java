package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.resources.dao.Duo;
import ub.edu.resources.dao.relationships.DAORelationThemeMovie;

public class DAORelationTematicaPeliculaMOCK extends DAORelationMOCK<Duo<String, String>> implements DAORelationThemeMovie {

    public DAORelationTematicaPeliculaMOCK() {
        addTematicaPelicula("Sci-Fi", "Avatar");
        addTematicaPelicula("Action", "Inception");
        addTematicaPelicula("Sci-Fi", "Inception");
        addTematicaPelicula("Adventure", "Inception");
        addTematicaPelicula("Adventure", "Interstellar");
        addTematicaPelicula("Drama", "Interstellar");
        addTematicaPelicula("Sci-Fi", "Interstellar");
        addTematicaPelicula("Sci-Fi", "The Matrix");
        addTematicaPelicula("Action", "The Matrix");
        addTematicaPelicula("Drama", "Shawshank Redemption");
    }

    private boolean addTematicaPelicula(String nomTematica, String nomPelicula) {
        return relacions.add(new Duo<>(nomTematica, nomPelicula));
    }
}
