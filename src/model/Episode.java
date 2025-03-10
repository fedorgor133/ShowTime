package model;

public class Episode {

    private String seriesName;
    private int numSeason;
    private int numEpisode;
    private String episodeTitle;
    private int duration;

    public Episode(String seriesName, int numSeason, int numEpisode, String episodeTitle, int duration) {
        this.seriesName = seriesName;
        this.numSeason = numSeason;
        this.numEpisode = numEpisode;
        this.episodeTitle = episodeTitle;
        this.duration = duration;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getNumSeason() {
        return numSeason;
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public int getDuration() {
        return duration;
    }

    public void setEpisodeTitle(String nom) {
        this.episodeTitle = nom;
    }
}
