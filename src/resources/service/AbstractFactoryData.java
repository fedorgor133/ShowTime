package resources.service;

import resources.dao.entities.*;
import resources.dao.relationships.DAORelationInterestGroupMovie;
import resources.dao.relationships.DAORelationInterestGroupSeries;
import resources.dao.relationships.DAORelationInterestGroupTrivia;
import resources.dao.relationships.DAORelationThemeMovie;

public interface AbstractFactoryData {

    // Entitats
    DAOPerson createDAOPersona();
    DAOEpisode createDAOEpisodi();
    DAOSeason createDAOTemporada();
    DAOMovie createDAOPelicula();
    DAOSeries createDAOSerie();
    DAOTheme createDAOTematica();
    DAOInterestGroup createDAOGrupInteres();
    DAOQuestion createDAOPregunta();

    // Relacions
    DAORelationThemeMovie createDAORelacioTematicaPelicula();
    DAORelationInterestGroupSeries createDAORelacioGrupInteresSerie();

    //Cal afegir les creacions de les altres classes DAO que es necessitin
    DAORelationInterestGroupMovie createDAORelacioGrupInteresPelicula();
    DAORelationInterestGroupTrivia createDAORelacioGrupInteresTrivia();
}
