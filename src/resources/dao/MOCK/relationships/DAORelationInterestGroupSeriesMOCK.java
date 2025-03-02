package resources.dao.MOCK.relationships;

import resources.dao.Duo;
import resources.dao.relationships.DAORelationInterestGroupSeries;

public class DAORelationInterestGroupSeriesMOCK extends DAORelationMOCK<Duo<String, String>> implements DAORelationInterestGroupSeries {

    public DAORelationInterestGroupSeriesMOCK() {
        addInterestGroupSeries("Anime", "Stranger Things");
        addInterestGroupSeries("Anime", "Game of Thrones");
        addInterestGroupSeries("Anime", "The Witcher");
        addInterestGroupSeries("Anime", "Peaky Blinders");
        addInterestGroupSeries("Anime", "Breaking Bad");

        addInterestGroupSeries("Reality TV", "Game of Thrones");
        addInterestGroupSeries("Reality TV", "The Crown");
        addInterestGroupSeries("Reality TV", "The Office");
        addInterestGroupSeries("Reality TV", "Friends");
        addInterestGroupSeries("Reality TV", "The Big Bang Theory");

        addInterestGroupSeries("Superheroes", "The Mandalorian");
        addInterestGroupSeries("Superheroes", "The Witcher");

        addInterestGroupSeries("Children’s TVs", "The Office");
        addInterestGroupSeries("Children’s TVs", "The Mandalorian");
        addInterestGroupSeries("Children’s TVs", "The Office");
    }

    private boolean addInterestGroupSeries(String groupName, String seriesName) {
        return relations.add(new Duo<>(groupName, seriesName));
    }
}
