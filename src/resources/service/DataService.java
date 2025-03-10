package resources.service;

import model.*;
import resources.dao.Duo;
import resources.dao.entities.*;
import resources.dao.relationships.DAORelationInterestGroupMovie;
import resources.dao.relationships.DAORelationInterestGroupSeries;
import resources.dao.relationships.DAORelationInterestGroupTrivia;
import resources.dao.relationships.DAORelationThemeMovie;

import java.util.List;

public class DataService {

    // Entitats
    private DAOPerson daoPerson;
    private DAOMovie daoMovie;
    private DAOSeries daoSeries;
    private DAOSeason daoSeason;
    private DAOEpisode daoEpisode;
    private DAOTheme daoTheme;
    private DAOInterestGroup daoInterestGroup;
    private DAOQuestion daoQuestion;

    // Relacions
    private DAORelationThemeMovie daoRelationThemeMovie;
    private DAORelationInterestGroupSeries daoRelationInterestGroupSeries;
    private DAORelationInterestGroupMovie daoRelationInterestGroupMovie;
    private DAORelationInterestGroupTrivia daoRelationInterestGroupTrivia;

    public DataService(AbstractFactoryData factory) {

        // Entitats
        daoPerson = factory.createDAOPersona();
        daoMovie = factory.createDAOPelicula();
        daoSeries = factory.createDAOSerie();
        daoSeason = factory.createDAOTemporada();
        daoEpisode = factory.createDAOEpisodi();
        daoTheme = factory.createDAOTematica();
        daoInterestGroup = factory.createDAOGrupInteres();
        daoQuestion = factory.createDAOPregunta();

        // Relacions
        daoRelationThemeMovie = factory.createDAORelacioTematicaPelicula();
        daoRelationInterestGroupSeries = factory.createDAORelacioGrupInteresSerie();

        // TO DO: Crear els altres DAO de les altres estructures
        daoRelationInterestGroupMovie = factory.createDAORelacioGrupInteresPelicula();
        daoRelationInterestGroupTrivia = factory.createDAORelacioGrupInteresTrivia();
    }

    public List<Person> getAllPersones() throws Exception {
        return daoPerson.getAll();
    }

    public List<Movie> getAllPelicules() throws Exception {
        return daoMovie.getAll();
    }

    public List<Series> getAllSeries() throws Exception {
        List<Series> series = daoSeries.getAll();
        List<Season> seasons = daoSeason.getAll();
        List<Episode> episodes = daoEpisode.getAll();
        for (Season season : seasons) {
            for (Episode episode : episodes) {
                if (season.getSeriesName().equals(episode.getSeriesName()) && episode.getNumSeason() == (season.getNumSeason())) {
                    season.addEpisode(episode);
                }
            }
            for (Series serie: series) {
                if (serie.getTitle().equals(season.getSeriesName())) {
                    serie.addSeason(season);
                }
            }
        }
        return series;
    }

    public List<Theme> getAllTematiques() throws Exception {
        return daoTheme.getAll();
    }

    public List<InterestGroup> getAllGrupsInteres() throws Exception {
        return daoInterestGroup.getAll();
    }

    public List<Duo<String, String>> getAllRelacionsPeliculesTematiques() throws Exception {
        return daoRelationThemeMovie.getAll();
    }

    public List<Duo<String, String>> getAllRelacionsGrupInteresSerie() throws Exception {
        return daoRelationInterestGroupSeries.getAll();
    }

    public List<Duo<String, String>> getAllRelacionsGrupInteresPelicula() throws Exception {
        return daoRelationInterestGroupMovie.getAll();
    }

    public List<Duo<String, String>> getllRelacionsGrupInteresTrivia() throws Exception {
        return daoRelationInterestGroupTrivia.getAll();
    }

    public List<Question> getAllPreguntes() throws Exception {
        return daoQuestion.getAll();
    }
}
