package ub.edu.resources.dao.MOCK.entities;

import ub.edu.model.Season;
import ub.edu.resources.dao.Duo;
import ub.edu.resources.dao.entities.DAOSeason;

import java.util.*;

public class DAOSeasonMOCK implements DAOSeason {

    // Utilitzem nomSerie, numTemporada per identificar una temporada
    private Map<Duo<String, Integer>, Season> temporades = new HashMap<>();

    public DAOSeasonMOCK(){
        addTemporada("Stranger Things", 1);
        addTemporada("Stranger Things", 2);
        addTemporada("Stranger Things", 3);
        addTemporada("Stranger Things", 4);
        addTemporada("Stranger Things", 5);
    }

    private void addTemporada(String nomSerie, int numTemporada){
        temporades.put(new Duo<>(nomSerie,numTemporada), new Season(nomSerie, numTemporada));
    }

    @Override
    public Optional<Season> getById(String[] id) throws Exception {
        int numTemporada = Integer.parseInt(Objects.requireNonNull(id[1], "Temporada number cannot be null"));
        return Optional.ofNullable(temporades.get(new Duo<>(Objects.requireNonNull(id[0], "Serie name cannot be null"), numTemporada)));
    }

    public Optional<Season> getById(String nomSerie, int numTemporada) throws Exception {
        return getById(new String[]{nomSerie, Integer.toString(numTemporada)});
    }

    @Override
    public List<Season> getAll() throws Exception {
        return new ArrayList<>(temporades.values());
    }

    @Override
    public boolean add(final Season season) throws Exception {
        if (getById(season.getSeriesName(), season.getNumSeason()).isPresent()) {
            return false;
        }
        temporades.put(new Duo<>(season.getSeriesName(), season.getNumSeason()), season);
        return true;
    }

    @Override
    public boolean update(Season season, String[] params) throws Exception {
        season.setSeriesName(Objects.requireNonNull(
                params[0], "Serie name cannot be null"));
        return temporades.replace(new Duo<>(season.getSeriesName(), season.getNumSeason()), season) != null;
    }

    @Override
    public boolean delete(Season season) throws Exception {
        return temporades.remove(new Duo<>(season.getSeriesName(), Integer.toString(season.getNumSeason()))) != null;
    }
}
