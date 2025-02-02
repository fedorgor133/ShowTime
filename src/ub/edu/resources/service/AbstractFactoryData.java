package ub.edu.resources.service;

import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.DAORelationInterestGroupMovie;
import ub.edu.resources.dao.relationships.DAORelationInterestGroupSeries;
import ub.edu.resources.dao.relationships.DAORelationInterestGroupTrivia;
import ub.edu.resources.dao.relationships.DAORelationThemeMovie;

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
