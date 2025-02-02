package ub.edu.resources.dao.MOCK.relationships;

import ub.edu.resources.dao.Duo;
import ub.edu.resources.dao.relationships.DAORelationInterestGroupMovie;

public class DAORelationInterestGroupMovieMOCK extends DAORelationMOCK<Duo<String, String>> implements DAORelationInterestGroupMovie {

    public DAORelationInterestGroupMovieMOCK() {
        addGrupInteresPelicula("Anime", "Avatar");
        addGrupInteresPelicula("Anime", "Shawshank Redemption");
        addGrupInteresPelicula("Anime", "The Dark Knight");

        addGrupInteresPelicula("Reality TV", "Avengers: Endgame");
        addGrupInteresPelicula("Reality TV", "Inception");
        addGrupInteresPelicula("Reality TV", "Shawshank Redemption");

        addGrupInteresPelicula("Superheroes", "Avengers: Endgame");
        addGrupInteresPelicula("Superheroes", "Interstellar");

        addGrupInteresPelicula("Children’s TVs", "Avatar");
        addGrupInteresPelicula("Children’s TVs", "Parasite");
    }

    private boolean addGrupInteresPelicula(String nomGrup, String nomPelicula) {
        return relacions.add(new Duo<>(nomGrup, nomPelicula));
    }
}
