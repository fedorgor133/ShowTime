package resources.dao.MOCK.entities;

import model.Episode;
import resources.dao.Trio;
import resources.dao.entities.DAOEpisode;

import java.util.*;

public class DAOEpisodeMOCK implements DAOEpisode {

    // Utilitzem nomSerie, numTemporada, numEpisodi per identificar un episodi
    private Map<Trio<String, Integer, Integer>, Episode> episodis = new HashMap<>();

    public DAOEpisodeMOCK(){
        addEpisode("Stranger Things", 1, 1, "Chapter One: The Vanishing of Will Byers", 55);
        addEpisode("Stranger Things", 1, 2, "Chapter Two: The Weirdo on Maple Street", 55);
        addEpisode("Stranger Things", 1, 3, "Chapter Three: Holly, Jolly", 55);
        addEpisode("Stranger Things", 1, 4, "Chapter Four: The Body", 55);
        addEpisode("Stranger Things", 1, 5, "Chapter Five: The Flea and the Acrobat", 55);
        addEpisode("Stranger Things", 1, 6, "Chapter Six: The Monster", 55);
        addEpisode("Stranger Things", 1, 7, "Chapter Seven: The Bathtub", 55);
        addEpisode("Stranger Things", 1, 8, "Chapter Eight: The Upside Down", 55);
    }

    private void addEpisode(String nameSeries, int numSeason, int numEpisode, String titolEpisode, int duration){
        episodis.put(new Trio<>(nameSeries, numSeason, numEpisode), new Episode(nameSeries, numSeason, numEpisode, titolEpisode, duration));
    }

    @Override
    public Optional<Episode> getById(String[] id) throws Exception {
        String nameSeries = Objects.requireNonNull(id[0], "Serie name cannot be null");
        Integer numSeason = Integer.parseInt(Objects.requireNonNull(id[1], "Temporada number cannot be null"));
        Integer numEpisode = Integer.parseInt(Objects.requireNonNull(id[2], "Episodi number cannot be null"));
        return Optional.ofNullable(episodis.get(new Trio<>(nameSeries, numSeason, numEpisode)));
    }

    @Override
    public List<Episode> getAll() throws Exception {
        return new ArrayList<>(episodis.values());
    }

    @Override
    public boolean add(final Episode episode) throws Exception {
        if (getById(new String[]{episode.getSeriesName(), episode.getEpisodeTitle()}).isPresent()) {
            return false;
        }
        episodis.put(new Trio<>(episode.getSeriesName(), episode.getNumSeason(), episode.getNumEpisode()), episode);
        return true;
    }

    @Override
    public boolean update(Episode episode, String[] params) throws Exception {
        episode.setEpisodeTitle(Objects.requireNonNull(
                params[0], "Episode name cannot be null"));
        return episodis.replace(new Trio<>(episode.getSeriesName(), episode.getNumSeason(), episode.getNumEpisode()), episode) != null;
    }

    @Override
    public boolean delete(Episode episode) throws Exception {
        return episodis.remove(new Trio<>(episode.getSeriesName(), episode.getNumSeason(), episode.getNumEpisode())) != null;
    }
}
