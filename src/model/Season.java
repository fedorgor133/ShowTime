package model;

import java.util.ArrayList;
import java.util.List;

public class Season {

    private int numSeason;
    private String seriesName;
    private ArrayList<Episode> episodes;

    public Season(String seriesName, int numSeason) {
        this.seriesName = seriesName;
        this.numSeason = numSeason;
        episodes = new ArrayList<>();
    }

    public int getNumSeason() {
        return numSeason;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getNumEpisodes() {
        return episodes.size();
    }

    public List<Episode> getEpisodes() {
        return new ArrayList<>(episodes);
    }

    public void setSeriesName(String nouNomSerie) {
        seriesName = nouNomSerie;
    }

    public void addEpisode(Episode episode){
        episodes.add(episode);
    }

    public boolean containsEpisode(int numEpisode) {
        for (Episode e: episodes) {
            if (e.getNumEpisode() == numEpisode) {
                return true;
            }
        }
        return false;
    }

    public void removeEpisode(int numEpisode) {
        episodes.removeIf(episodi -> episodi.getNumEpisode() == numEpisode);
    }
}
