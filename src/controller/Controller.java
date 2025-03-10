package controller;

import model.Params;
import model.Question;

import java.util.List;

public class Controller {
    private ShowTVTime showTV;
    private static Controller uniqueInstance;

    private Controller(){
        this.showTV = new ShowTVTime();
    }

    public void loadData() {
        showTV.loadData();
    }

    public void resetData() {
        showTV.resetData();
    }

    public static Controller getInstance() {
        if(uniqueInstance == null) {
            //Thread safe
            synchronized (Controller.class) {
                if (uniqueInstance == null) uniqueInstance = new Controller();
            }
        }
        return uniqueInstance;
    }

    public String validatePersonRegistration(String username, String password) {
        return showTV.validatePersonRegistration(username, password);
    }

    public String validatePassword(String b) {
        return showTV.validatePassword(b);
    }

    public String validateUsername(String b)  {
        return showTV.validateUsername(b);
    }

    public String loginPerson(String username, String password) {
        return showTV.loginPerson(username, password);
    }

    public String recoverPassword(String username) {
        return showTV.recoverPassword(username);
    }

    public String findPersona(String username) {
        return showTV.findPersona(username);
    }

    public Iterable<String> viewMoviesByName() {
        return showTV.viewMoviesByName();
    }

    public Iterable<String> viewMoviesBYRelease(){
        return showTV.viewMoviesBYRelease();
    }

    public void addMovie(String name, int release, int duration) {
        showTV.addMovie(name, release, duration);
    }

    public Iterable<String> viewSeriesByName() {
        return showTV.viewSeriesByName();
    }

    public void addSeries(String nomSerie, int anyEstrena) {
        showTV.addSeries(nomSerie, anyEstrena);
    }

    public void addSeries(String nomSerie, String idioma, int anyEstrena) {
        showTV.addSeries(nomSerie, idioma, anyEstrena);
    }

    public void addSeries(String nomSerie, String descripcio, String url, int anyEstrena,
                          String idioma, int durada) {
        showTV.addSeries(nomSerie, descripcio, url, anyEstrena, idioma, durada);
    }

    public void addSeason(String nomSerie, int numTemporada) {
        showTV.addSeason(nomSerie, numTemporada);
    }

    public Iterable<String> viewSeasonsSeries(String nomSerie) {
        return showTV.viewSeasonsSeries(nomSerie);
    }

    public void addEpisode(String nomSerie, int numTemporada, int numEpisodi, String títolEpisodi, int durada) {
        showTV.addEpisode(nomSerie, numTemporada, numEpisodi, títolEpisodi, durada);
    }

    public Iterable<String> viewEpisodesSeasonSeries(String nomSerie, int numTemporada) {
        return showTV.viewEpisodesSeasonSeries(nomSerie, numTemporada);
    }

    public void addTheme(String tematica) {
        showTV.addTheme(tematica);
    }

    public void addMovie(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        showTV.addMovie(titol, descripcio, url, estrena, idioma, durada, valoracio);
    }

    public void addThemeToMovie(String titol, String tematica) {
        showTV.addThemeToMovie(titol, tematica);
    }

    public Iterable<String> viewMoviesByTheme(String nomTematica){
        return showTV.viewMoviesByTheme(nomTematica);
    }

    public void removeSeason(String nomSerie, int numTemporada) {
        showTV.removeSeason(nomSerie, numTemporada);
    }

    public void addGroup(String s, String descripcio, String codi) {
        showTV.addGroup(s, descripcio, codi);
    }


    public Iterable<String> viewGroupsByName(){
        return showTV.viewGroupsByName();
    }

    public void addContentToGroup(String grup, String serie) {
        showTV.addContentToGroup(grup, serie);
    }

    public Iterable<String> getSeriesGroup(String grup) {
        return showTV.getSeriesGroup(grup);
    }

    public Iterable<String> getMoviesGroup(String grup) {
        return showTV.getMoviesGroup(grup);
    }

    public Iterable<String> getContentGroup(String grup) {
        return showTV.getContentGroup(grup);
    }

    public void addContentWatchedHistory(String nomUsuari, String titol) {
        showTV.addContentWatchedHistory(nomUsuari, titol);
    }

    public void deleteContentWatchedHistory(String nomUsuari, String titol) {
        showTV.deleteContentWatchedHistory(nomUsuari, titol);
    }

    public List<String> viewWatchedHistory(String nomUsuari) {
        return showTV.viewWatchedHistory(nomUsuari);
    }

    public void emptyWatchedHistory(String nomUsuari) {
        showTV.emptyWatchedHistory(nomUsuari);
    }

    public void emptyWatchNext(String nomUsuari) {
        showTV.emptyWatchNext(nomUsuari);
    }

    public void addContentWatchNext(String nomUsuari, String titol) {
        showTV.addContentWatchNext(nomUsuari, titol);
    }

    public void deleteContentWatchNext(String nomUsuari, String titol) {
        showTV.deleteContentWatchNext(nomUsuari, titol);
    }

    public List<String> viewWatchNext(String nomUsuari) {
        return showTV.viewWatchNext(nomUsuari);
    }

    public String followGroup(String nomGrup, String usuari) {
        return showTV.followGroup(nomGrup, usuari);
    }

    public String unfollowGroup(String nomGrup, String usuari) {
        return showTV.unfollowGroup(nomGrup, usuari);
    }

    public String becomeMember(String nomGrup, String usuari, String tipusJoc, Params params) {
        return showTV.becomeMember(nomGrup, usuari, tipusJoc, params);
    }

    public String getAccessCode(String grup) {
        return showTV.getAccessCode(grup);
    }

    public int getUserPoints(String nomGrup, String usuari) {
        return showTV.getUserPoints(nomGrup, usuari);
    }

    public Question getQuestion(String nomGrup, String pregunta) {
        return showTV.getQuestion(nomGrup, pregunta);
    }
}
