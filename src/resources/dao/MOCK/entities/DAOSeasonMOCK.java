package resources.dao.MOCK.entities;

import model.Season;
import resources.dao.Duo;
import resources.dao.entities.DAOSeason;

import java.util.*;

public class DAOSeasonMOCK implements DAOSeason {

    // Utilitzem nomSerie, numTemporada per identificar una temporada
    private Map<Duo<String, Integer>, Season> seasons = new HashMap<>();

    public DAOSeasonMOCK(){
        addSeason("Stranger Things", 1);
        addSeason("Stranger Things", 2);
        addSeason("Stranger Things", 3);
        addSeason("Stranger Things", 4);
        addSeason("Stranger Things", 5);
    }

    private void addSeason(String seriesName, int seasonNumber) {
        seasons.put(new Duo<>(seriesName, seasonNumber), new Season(seriesName, seasonNumber));
    }

    @Override
    public Optional<Season> getById(String[] id) throws Exception {
        int seasonNumber = Integer.parseInt(Objects.requireNonNull(id[1], "Season number cannot be null"));
        return Optional.ofNullable(seasons.get(new Duo<>(Objects.requireNonNull(id[0], "Series name cannot be null"), seasonNumber)));
    }

    public Optional<Season> getById(String seriesName, int seasonNumber) throws Exception {
        return getById(new String[]{seriesName, Integer.toString(seasonNumber)});
    }

    @Override
    public List<Season> getAll() throws Exception {
        return new ArrayList<>(seasons.values());
    }

    @Override
    public boolean add(final Season season) throws Exception {
        if (getById(season.getSeriesName(), season.getNumSeason()).isPresent()) {
            return false;
        }
        seasons.put(new Duo<>(season.getSeriesName(), season.getNumSeason()), season);
        return true;
    }

    @Override
    public boolean update(Season season, String[] params) throws Exception {
        season.setSeriesName(Objects.requireNonNull(
                params[0], "Series name cannot be null"));
        return seasons.replace(new Duo<>(season.getSeriesName(), season.getNumSeason()), season) != null;
    }

    @Override
    public boolean delete(Season season) throws Exception {
        return seasons.remove(new Duo<>(season.getSeriesName(), Integer.toString(season.getNumSeason()))) != null;
    }

}
