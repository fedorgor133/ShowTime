package model;

import java.util.ArrayList;

public class Series extends AudiovisualContent {
    private ArrayList<Season> seasons;

    public Series(String titol, int yearFirstRelease) {
        super(titol, yearFirstRelease, 0); // Durada puede calcularse en base a episodios
        this.seasons = new ArrayList<>();
    }

    public Series(String title, String description, String imatgeUrl, int yearFirstRelease, String language, int duration) {
        super(title, description, imatgeUrl, yearFirstRelease, language, duration);
        this.seasons = new ArrayList<>();
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public void removeSeason(int numSeason) {
        Season season = seasons.stream()
                .filter(t -> t.getNumSeason() == numSeason)
                .findFirst()
                .orElse(null);
        if (season != null) {
            seasons.remove(season);
        }
    }
}
