package ub.edu.controller;

import ub.edu.model.*;
import java.util.*;

public class ShowTVTime implements DataManagerInterface {

    private PortfolioPeople portfolioPeople;
    private Map<String, Series> llistaSeries;
    private Map<String, Movie> llistaPelicules;
    private Map<String, Theme> llistaTemes;
    private Map<String, GrupInterest> llistaGrupInteres;
    private Map<String, Question> llistaPreguntes;

    private ManagementData managementData;
    private ManagementContent managementContent;
    private ManagementLists managementLists;

    public ShowTVTime() {
        initEmptyDataStructures();
        FactoryManagements factoryManagements = new FactoryManagements();
        managementData = factoryManagements.createDataManagement(portfolioPeople);
        managementContent = factoryManagements.createContentManagement(llistaPelicules, llistaSeries, llistaTemes, llistaGrupInteres, llistaPreguntes);
    }

    public void initEmptyDataStructures(){
        portfolioPeople = new PortfolioPeople();
        llistaPelicules = new HashMap<>();
        llistaSeries = new HashMap<>();
        llistaTemes = new HashMap<>();
        llistaGrupInteres = new HashMap<>();
        llistaPreguntes = new HashMap<>();
    }

    public void loadData() {
        managementData.loadData();
        portfolioPeople = managementData.getCarteraPersones();
        managementContent.loadData();
        llistaPelicules = managementContent.getMoviesList();
        llistaSeries = managementContent.getSeriesList();
        llistaGrupInteres = managementContent.getInterestGroupList();
        managementLists = new FactoryManagements().createListManagement(portfolioPeople, llistaPelicules, llistaSeries, llistaGrupInteres);
    }

    public void resetData() {
        managementData.resetData();
        managementContent.resetData();
    }

    // Validem els socis a la capa de persistència
    public String validatePersonRegistration(String username, String password) {
        return managementData.validatePersonRegistration(username, password);
    }

    public String validatePassword(String b) {
        return managementData.validatePassword(b);
    }

    public String validateUsername(String b)  {
        return managementData.validateUsername(b);
    }

    public String loginPerson(String username, String password) {
        return managementData.loginPerson(username, password);
    }

    public String recoverPassword(String username) {
        return managementData.recoverPassword(username);
    }

    public String findPersona(String username) {
        return managementData.findPersona(username);
    }

    public Iterable<String> viewMoviesByName(){
        return managementContent.viewMoviesByName();
    }

    public Iterable<String> viewMoviesBYRelease() {
        return managementContent.viewMoviesBYRelease();
    }

    public void addMovie(String nom, int estrena, int durada) {
       managementContent.addMovie(nom, estrena, durada);
    }

    public Iterable<String> viewSeriesByName() {
        return managementContent.viewSeriesByName();
    }

    public void addSeries(String nomSerie, int anyEstrena) {
        managementContent.addSeries(nomSerie, anyEstrena);
    }

    public void addSeries(String nomSerie, String idioma, int anyEstrena) {
        managementContent.addSeries(nomSerie, idioma, anyEstrena);
    }

    public void addSeries(String nomSerie, String descripcio, String url, int anyEstrena,
                            String idioma, int durada) {
        managementContent.addSeries(nomSerie, descripcio, url, anyEstrena, idioma, durada);
    }

    public void addSeason(String nomSerie, int numTemporada) {
        managementContent.addSeason(nomSerie, numTemporada);
    }

    public Iterable<String> viewSeasonsSeries(String nomSerie) {
        return managementContent.viewSeasonsSeries(nomSerie);
    }

    public void addEpisode(String nomSerie, int numTemporada, int numEpisodi, String títolEpisodi, int durada) {
        managementContent.addEpisode(nomSerie, numTemporada, numEpisodi, títolEpisodi, durada);
    }

    public Iterable<String> viewEpisodesSeasonSeries(String nomSerie, int numTemporada) {
        return managementContent.viewEpisodesSeasonSeries(nomSerie, numTemporada);
    }

    public void addTheme(String tematica) {
        managementContent.addTheme(tematica);
    }

    public void addMovie(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        managementContent.addMovie(titol, descripcio, url, estrena, idioma, durada, valoracio);
    }

    public void addThemeToMovie(String titol, String tematica) {
       managementContent.addThemeToMovie(titol, tematica);
    }

    public Iterable<String> viewMoviesByTheme(String nomTematica){
       return managementContent.viewMoviesByTheme(nomTematica);
    }

    public void removeSeason(String nomSerie, int numTemporada) {
        managementContent.removeSeason(nomSerie, numTemporada);
    }

    public void addGroup(String s, String descripcio, String codi) {
        managementContent.addGroup(s, descripcio, codi);
    }

    public Iterable<String> viewGroupsByName() {
        return managementContent.viewGroupsByName();
    }

    public void addContentToGroup(String grup, String serie) {
        managementContent.addContentToGroup(grup, serie);
    }

    public Iterable<String> getSeriesGroup(String grup){
        return managementContent.getSeriesGroup(grup);
    }

    public Iterable<String> getMoviesGroup(String grup) {
        return managementContent.getMoviesGroup(grup);
    }

    public Iterable<String> getContentGroup(String grup) {
        return managementContent.getContentGroup(grup);
    }

    public void addContentWatchedHistory(String nomUsuari, String titol) {
        managementLists.addContentWatchedHistory(nomUsuari, titol);
    }

    public void deleteContentWatchedHistory(String nomUsuari, String titol) {
        managementLists.deleteContentWatchedHistory(nomUsuari, titol);
    }

    public List<String> viewWatchedHistory(String nomUsuari) {
        return managementLists.viewWatchedHistory(nomUsuari);
    }

    public void emptyWatchedHistory(String nomUsuari) {
        managementLists.emptyWatchedHistory(nomUsuari);
    }

    public void emptyWatchNext(String nomUsuari) {
        managementLists.emptyWatchNext(nomUsuari);
    }

    public void addContentWatchNext(String nomUsuari, String titol) {
       managementLists.addContentWatchNext(nomUsuari, titol);
    }

    public void deleteContentWatchNext(String nomUsuari, String titol) {
       managementLists.deleteContentWatchNext(nomUsuari, titol);
    }

    public List<String> viewWatchNext(String nomUsuari) {
        return managementLists.viewWatchNext(nomUsuari);
    }

    public String followGroup(String nomGrup, String usuari) {
       return managementLists.followGroup(nomGrup, usuari);
    }

    public String unfollowGroup(String nomGrup, String usuari) {
        return managementLists.unfollowGroup(nomGrup, usuari);
    }

    public String becomeMember(String nomGrup, String usuari, String joc, Params params) {
        return managementLists.becomeMember(nomGrup, usuari, joc, params);
    }

    public String getAccessCode(String grup){
        return managementLists.getAccessCode(grup);
    }


    public int getUserPoints(String nomGrup, String usuari) {
        return managementLists.getUserPoints(nomGrup, usuari);
    }

    public Question getQuestion(String nomGrup, String pregunta) {
        return managementContent.getQuestion(nomGrup, pregunta);
    }
}
