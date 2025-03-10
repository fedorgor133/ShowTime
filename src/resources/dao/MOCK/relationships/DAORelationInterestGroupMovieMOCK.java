package resources.dao.MOCK.relationships;

import resources.dao.Duo;
import resources.dao.relationships.DAORelationInterestGroupMovie;

public class DAORelationInterestGroupMovieMOCK extends DAORelationMOCK<Duo<String, String>> implements DAORelationInterestGroupMovie {

    public DAORelationInterestGroupMovieMOCK() {
        addInterestGroupMovie("Anime", "Avatar");
        addInterestGroupMovie("Anime", "Shawshank Redemption");
        addInterestGroupMovie("Anime", "The Dark Knight");

        addInterestGroupMovie("Reality TV", "Avengers: Endgame");
        addInterestGroupMovie("Reality TV", "Inception");
        addInterestGroupMovie("Reality TV", "Shawshank Redemption");

        addInterestGroupMovie("Superheroes", "Avengers: Endgame");
        addInterestGroupMovie("Superheroes", "Interstellar");

        addInterestGroupMovie("Children’s TVs", "Avatar");
        addInterestGroupMovie("Children’s TVs", "Parasite");
    }

    private boolean addInterestGroupMovie(String groupName, String movieName) {
        return relations.add(new Duo<>(groupName, movieName));
    }
}
