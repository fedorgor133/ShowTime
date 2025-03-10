package controller;

import model.*;
import java.util.*;

public class ShowTVTime implements DataManagerInterface {

    private PortfolioPeople portfolioPeople;
    private Map<String, Series> llistaSeries;
    private Map<String, Movie> llistaPelicules;
    private Map<String, Theme> llistaTemes;
    private Map<String, InterestGroup> llistaGrupInteres;
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

    public void addMovie(String name, int releaseYear, int duration) {
        managementContent.addMovie(name, releaseYear, duration);
    }

    public Iterable<String> viewSeriesByName() {
        return managementContent.viewSeriesByName();
    }

    public void addSeries(String seriesName, int releaseYear) {
        managementContent.addSeries(seriesName, releaseYear);
    }

    public void addSeries(String seriesName, String language, int releaseYear) {
        managementContent.addSeries(seriesName, language, releaseYear);
    }

    public void addSeries(String seriesName, String description, String url, int releaseYear,
                          String language, int duration) {
        managementContent.addSeries(seriesName, description, url, releaseYear, language, duration);
    }

    public void addSeason(String seriesName, int seasonNumber) {
        managementContent.addSeason(seriesName, seasonNumber);
    }

    public Iterable<String> viewSeasonsSeries(String seriesName) {
        return managementContent.viewSeasonsSeries(seriesName);
    }

    public void addEpisode(String seriesName, int seasonNumber, int episodeNumber, String episodeTitle, int duration) {
        managementContent.addEpisode(seriesName, seasonNumber, episodeNumber, episodeTitle, duration);
    }

    public Iterable<String> viewEpisodesSeasonSeries(String seriesName, int seasonNumber) {
        return managementContent.viewEpisodesSeasonSeries(seriesName, seasonNumber);
    }

    public void addTheme(String theme) {
        managementContent.addTheme(theme);
    }

    public void addMovie(String title, String description, String url, int releaseYear, String language, int duration, float rating) {
        managementContent.addMovie(title, description, url, releaseYear, language, duration, rating);
    }

    public void addThemeToMovie(String title, String theme) {
        managementContent.addThemeToMovie(title, theme);
    }

    public Iterable<String> viewMoviesByTheme(String themeName) {
        return managementContent.viewMoviesByTheme(themeName);
    }

    public void removeSeason(String seriesName, int seasonNumber) {
        managementContent.removeSeason(seriesName, seasonNumber);
    }

    public void addGroup(String name, String description, String code) {
        managementContent.addGroup(name, description, code);
    }

    public Iterable<String> viewGroupsByName() {
        return managementContent.viewGroupsByName();
    }

    public void addContentToGroup(String group, String series) {
        managementContent.addContentToGroup(group, series);
    }

    public Iterable<String> getSeriesGroup(String group) {
        return managementContent.getSeriesGroup(group);
    }

    public Iterable<String> getMoviesGroup(String group) {
        return managementContent.getMoviesGroup(group);
    }

    public Iterable<String> getContentGroup(String group) {
        return managementContent.getContentGroup(group);
    }

    public void addContentWatchedHistory(String username, String title) {
        managementLists.addContentWatchedHistory(username, title);
    }

    public void deleteContentWatchedHistory(String username, String title) {
        managementLists.deleteContentWatchedHistory(username, title);
    }

    public List<String> viewWatchedHistory(String username) {
        return managementLists.viewWatchedHistory(username);
    }

    public void emptyWatchedHistory(String username) {
        managementLists.emptyWatchedHistory(username);
    }

    public void emptyWatchNext(String username) {
        managementLists.emptyWatchNext(username);
    }

    public void addContentWatchNext(String username, String title) {
        managementLists.addContentWatchNext(username, title);
    }

    public void deleteContentWatchNext(String username, String title) {
        managementLists.deleteContentWatchNext(username, title);
    }

    public List<String> viewWatchNext(String username) {
        return managementLists.viewWatchNext(username);
    }

    public String followGroup(String groupName, String user) {
        return managementLists.followGroup(groupName, user);
    }

    public String unfollowGroup(String groupName, String user) {
        return managementLists.unfollowGroup(groupName, user);
    }

    public String becomeMember(String groupName, String user, String game, Params params) {
        return managementLists.becomeMember(groupName, user, game, params);
    }

    public String getAccessCode(String group) {
        return managementLists.getAccessCode(group);
    }

    public int getUserPoints(String groupName, String user) {
        return managementLists.getUserPoints(groupName, user);
    }

    public Question getQuestion(String groupName, String question) {
        return managementContent.getQuestion(groupName, question);
    }

}