package ub.edu.resources.service;

import ub.edu.resources.dao.MOCK.entities.*;
import ub.edu.resources.dao.MOCK.relationships.*;
import ub.edu.resources.dao.entities.*;
import ub.edu.resources.dao.relationships.*;

public class FactoryMOCK implements AbstractFactoryData {

    // Entitats

    @Override
    public DAOPerson createDAOPersona() {
        return new DAOPersonMOCK();
    }

    @Override
    public DAOEpisode createDAOEpisodi() {
        return new DAOEpisodeMOCK();
    }

    @Override
    public DAOSeason createDAOTemporada() {
        return new DAOSeasonMOCK();
    }

    @Override
    public DAOMovie createDAOPelicula() {
        return new DAOMovieMOCK();
    }

    @Override
    public DAOSeries createDAOSerie() {
        return new DAOSeriesMOCK();
    }

    @Override
    public DAOTheme createDAOTematica() {
        return new DAOThemeMOCK();
    }

    @Override
    public DAOInterestGroup createDAOGrupInteres() {
        return new DAOInterestGroupMOCK();
    }

    // Relacions
    @Override
    public DAORelationThemeMovie createDAORelacioTematicaPelicula() {
        return new DAORelationTematicaPeliculaMOCK();
    }

    @Override
    public DAORelationInterestGroupSeries createDAORelacioGrupInteresSerie() {
        return new DAORelationInterestGroupSeriesMOCK();
    }

    // TO DO Pràctica 2:  Crear els altres DAOs de les altres classes
    @Override
    public DAORelationInterestGroupMovie createDAORelacioGrupInteresPelicula() {
        return new DAORelationInterestGroupMovieMOCK();
    }

    @Override
    public DAORelationInterestGroupTrivia createDAORelacioGrupInteresTrivia() {
        return new DAORelationInterestGroupTriviaMOCK();
    }

    @Override
    public DAOQuestion createDAOPregunta() {
        return new DAOQuestionMOCK();
    }
}
