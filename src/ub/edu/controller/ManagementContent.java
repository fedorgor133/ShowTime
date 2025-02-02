package ub.edu.controller;

import ub.edu.model.*;
import ub.edu.model.exceptions.NotAvailableGroupsException;
import ub.edu.model.exceptions.NotAvailableMoviesException;
import ub.edu.model.exceptions.NotAvailableShowsException;
import ub.edu.resources.dao.Duo;
import ub.edu.resources.service.DataService;
import java.util.*;

public class ManagementContent {
    private DataService dataService;
    private Map<String, Movie> moviesList;
    private Map<String, Series> seriesList;
    private Map<String, Theme> themesList;
    private Map<String, GrupInterest> interestGroupList;
    private Map<String, Question> questionsList;

    public ManagementContent(DataService dataService, Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, Theme> themesList, Map<String, GrupInterest> interestGroupList, Map<String, Question> questionsList) {
        this.dataService = dataService;
        this.moviesList = moviesList;
        this.seriesList = seriesList;
        this.themesList = themesList;
        this.interestGroupList = interestGroupList;
        this.questionsList = questionsList;
    }

    public void loadData() {
        loadPelicules();
        loadSeries();
        loadTematiques();
        loadGrupsInteres();
        loadPreguntes();
        relacionsPeliculesTematiques();
        relacionsGrupInteresSerie();
        relacionsGrupInteresPelicula();
        relacionsGrupInteresTrivia();
    }

    public void resetData() {
        moviesList.clear();
        seriesList.clear();
        themesList.clear();
        interestGroupList.clear();
        questionsList.clear();
    }

    private boolean loadPelicules() {
        List<Movie> pelicules;
        try {
            pelicules = dataService.getAllPelicules();
        } catch (Exception e) {
            return false;
        }

        if (pelicules != null) {
            for (Movie movie : pelicules) {
                moviesList.put(movie.getTitle(), movie);
            }
            return true;
        }
        return false;
    }

    private boolean loadSeries() {
        List<Series> series;
        try {
            series = dataService.getAllSeries();
        } catch (Exception e) {
            return false;
        }

        if (series != null) {
            for (Series serie : series) {
                seriesList.put(serie.getTitle(), serie);
            }
            return true;
        }
        return false;
    }

    private boolean loadPreguntes() {
        List<Question> preguntes;
        try{
            preguntes = dataService.getAllPreguntes();
        } catch (Exception e) {
            return false;
        }

        if (preguntes != null) {
            for (Question question : preguntes) {
                questionsList.put(question.getStatement(), question);
            }
            return true;
        }
        return false;
    }

    private boolean loadTematiques() {
        List<Theme> tematiques;
        try {
            tematiques = dataService.getAllTematiques();
        } catch (Exception e) {
            return false;
        }

        if (tematiques != null) {
            for (Theme theme : tematiques) {
                themesList.put(theme.getThemeName(), theme);
            }
            return true;
        }
        return false;
    }

    private Boolean loadGrupsInteres() {
        List<GrupInterest> grupsInteres;
        try {
            grupsInteres = dataService.getAllGrupsInteres();
        } catch (Exception e) {
            return false;
        }

        if (grupsInteres != null) {
            for (GrupInterest grupInterest : grupsInteres) {
                interestGroupList.put(grupInterest.getGroupName(), grupInterest);
            }
            return true;
        }
        return false;
    }

    private void relacionsPeliculesTematiques() {
        List<Duo<String, String>> relacionsPT;
        try {
            relacionsPT = dataService.getAllRelacionsPeliculesTematiques();
            for (Duo relacio : relacionsPT) {
                Theme theme = themesList.get(relacio.getElement1());
                Movie movie = moviesList.get(relacio.getElement2());
                movie.addTematica(theme);
            }
        } catch (Exception e) {
        }
    }

    private void relacionsGrupInteresSerie() {
        List<Duo<String, String>> relacionsGS;
        try {
            relacionsGS = dataService.getAllRelacionsGrupInteresSerie();
            for (Duo relacio : relacionsGS) {
                GrupInterest grupInterest = interestGroupList.get(relacio.getElement1());
                Series series = seriesList.get(relacio.getElement2());
                grupInterest.addContent(series);
            }
        } catch (Exception e) {
        }
    }

    private void relacionsGrupInteresTrivia() {
        List<Duo<String, String>> relacionsGS;
        try {
            relacionsGS = dataService.getllRelacionsGrupInteresTrivia();
            for (Duo relacio : relacionsGS) {
                GrupInterest grupInterest = interestGroupList.get(relacio.getElement1());
                Question question = questionsList.get(relacio.getElement2());
                grupInterest.addQuestionTrivia(question);
            }
        } catch (Exception e) {
        }
    }

    // Mètode per carregar Pel·lícules als grups d'interès
    private void relacionsGrupInteresPelicula() {
        List<Duo<String, String>> relacionsGS;
        try {
            relacionsGS = dataService.getAllRelacionsGrupInteresPelicula();
            for (Duo relacio : relacionsGS) {
                GrupInterest grupInterest = interestGroupList.get(relacio.getElement1());
                Movie movie = moviesList.get(relacio.getElement2());
                grupInterest.addContent(movie);
            }
        } catch (Exception e) {
        }
    }

    public Iterable<String> viewMoviesByName() {
        SortedSet<String> pelisDisponibles = new TreeSet<>();
        try {
            List<Movie> sortedList = getPelisList();
            sortedList.sort(new Comparator<Movie>() {
                public int compare(Movie a1, Movie a2) {
                    return (a1.getTitle().compareTo(a2.getTitle()));
                }
            });

            for (Movie p : sortedList) {
                pelisDisponibles.add(p.getTitle());
            }
            return pelisDisponibles;
        } catch (NotAvailableMoviesException e) {
            pelisDisponibles.add(Messages.translate(e));
            return pelisDisponibles;
        }
    }

    public Iterable<String> viewMoviesBYRelease() {
        List<java.lang.String> pelisDisponibles = new ArrayList<>();
        try {
            List<Movie> sortedList = getPelisList();
            sortedList.sort(new Comparator<Movie>() {
                public int compare(Movie a1, Movie a2) {
                    return (Integer.compare(a2.getYearFirstRelease(), a1.getYearFirstRelease()));
                }
            });

            for (Movie p : sortedList) {
                pelisDisponibles.add(p.getTitle());
            }
            return pelisDisponibles;
        } catch (NotAvailableMoviesException e) {
            pelisDisponibles.add(Messages.translate(e));
            return pelisDisponibles;
        }
    }


    public void addMovie(String nom, int estrena, int durada) {
        Movie p = new Movie(nom, estrena, durada);
        moviesList.put(nom, p);
    }

    public Iterable<String> viewSeriesByName() {
        SortedSet<String> seriesDisponibles = new TreeSet<>();
        for (Series r : seriesList.values()) {
            seriesDisponibles.add(r.getTitle());
        }
        return seriesDisponibles;
    }

    public void addSeries(String nomSerie, int anyEstrena) {
        Series s = new Series(nomSerie, anyEstrena);
        seriesList.put(nomSerie, s);
    }

    public void addSeries(String nomSerie, String idioma, int anyEstrena) {
        Series s = new Series(nomSerie, anyEstrena);
        seriesList.put(nomSerie, s);
    }

    public void addSeries(String nomSerie, String descripcio, String url, int anyEstrena,
                            String idioma, int durada) {
        Series s = new Series(nomSerie, descripcio, url, anyEstrena, idioma, durada);
        seriesList.put(nomSerie, s);
    }

    public void addSeason(String nomSerie, int numTemporada) {
        Series series = seriesList.get(nomSerie);
        if (series == null) {
            System.out.println(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> temporades = series.getSeasons();
            if (temporades == null) {
                System.out.println(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean trobat = false;
                while (i < temporades.size() && !trobat) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == numTemporada) {
                        trobat = true;
                    } else i++;
                }
                if (trobat) {
                    System.out.println(Messages.DuplicateSeason.getMessage());
                } else {
                    Season season = new Season(nomSerie, numTemporada);
                    series.addSeason(season);
                }
            }
        }
    }

    public Iterable<String> viewSeasonsSeries(String nomSerie) {
        SortedSet<String> temporadesDisponibles = new TreeSet<>();
        Series series = seriesList.get(nomSerie);
        if (series == null) {
            temporadesDisponibles.add(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> temporades = series.getSeasons();
            if (temporades.isEmpty()) {
                temporadesDisponibles.add(Messages.ShowWithoutSeasons.getMessage());
            } else {
                for (Season t : series.getSeasons()) {
                    temporadesDisponibles.add(String.valueOf(t.getNumSeason()));
                }
            }
        }
        return temporadesDisponibles;
    }

    public void addEpisode(String nomSerie, int numTemporada, int numEpisodi, String títolEpisodi, int durada) {
        Series series = seriesList.get(nomSerie);
        if (series == null) {
            System.out.println(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> temporades = series.getSeasons();
            if (temporades == null) {
                System.out.println(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean trobat = false;
                while (i < temporades.size() && !trobat) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == numTemporada) {
                        trobat = true;
                    } else {
                        i++;
                    }
                }
                if (trobat) {
                    Season season = series.getSeasons().get(i);
                    if (season.containsEpisode(numEpisodi)) {
                        System.out.println(Messages.DuplicateEpisode.getMessage());
                    } else {
                        Episode episode = new Episode(nomSerie, numTemporada, numEpisodi, títolEpisodi, durada);
                        season.addEpisode(episode);
                    }
                } else {
                    System.out.println(Messages.ShowWithoutSeason.getMessage());
                }
            }
        }
    }

    public Iterable<String> viewEpisodesSeasonSeries(String nomSerie, int numTemporada) {
        List<String> episodisDisponibles = new ArrayList<>();
        Series series = seriesList.get(nomSerie);
        if (series == null) {
            episodisDisponibles.add(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> temporades = series.getSeasons();
            if (temporades == null) {
                episodisDisponibles.add(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean trobat = false;
                while (i < temporades.size() && !trobat) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == numTemporada) {
                        trobat = true;
                    } else i++;
                }
                if (trobat) {
                    Season season = series.getSeasons().get(i);
                    List<Episode> sortedList = season.getEpisodes();
                    sortedList.sort(new Comparator<Episode>() {
                        public int compare(Episode a1, Episode a2) {
                            return (Integer.compare(a1.getNumEpisode(), a2.getNumEpisode()));
                        }
                    });

                    for (Episode e : sortedList) {
                        episodisDisponibles.add(e.getEpisodeTitle());
                    }
                } else {
                    episodisDisponibles.add(Messages.ShowWithoutSeason.getMessage());
                }
            }
        }
        return episodisDisponibles;
    }

    public void addTheme(String tematica) {
        Theme t = new Theme(tematica);
        themesList.put(tematica, t);
    }

    public void addMovie(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        Movie p = new Movie(titol, descripcio, url, estrena, idioma, durada, valoracio);
        moviesList.put(titol, p);
    }

    public void addThemeToMovie(String titol, String tematica) {
        if (moviesList.containsKey(titol)) {
            Movie p = moviesList.get(titol);
            if (themesList.containsKey(tematica)) {
                Theme t = themesList.get(tematica);
                p.addTematica(t);
            } else {
                Theme t = new Theme(tematica);
                p.addTematica(t);
            }
        } else {
            System.out.println(Messages.NotAvailableMovie.getMessage());
        }
    }

    public Iterable<String> viewMoviesByTheme(String nomTematica) {
        ArrayList<String> pelisDisponibles = new ArrayList<>();

        try {
            ArrayList<String> sortedList = new ArrayList<>();
            for (Movie p : getPelisList()) {
                ArrayList<Theme> tematiques = p.getTematiques();

                for (Theme t : tematiques) {
                    if (t.getThemeName().equals(nomTematica)) {
                        sortedList.add(p.getTitle());
                    }
                }
            }
            sortedList.sort(new Comparator<String>() {
                public int compare(String a1, String a2) {
                    return (a1.compareTo(a2));
                }
            });
            for (String s : sortedList) {
                pelisDisponibles.add(s);
            }
            return pelisDisponibles;
        } catch (NotAvailableMoviesException e) {
            pelisDisponibles.add(Messages.translate(e));
            return pelisDisponibles;
        }
    }

    public void removeSeason(String nomSerie, int numTemporada) {
        Series series = seriesList.get(nomSerie);
        if (series != null) {
            List<Season> temporades = series.getSeasons();
            if (temporades != null) {
                int i = 0;
                boolean trobat = false;
                while (i < temporades.size() && !trobat) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == numTemporada) {
                        trobat = true;
                    } else {
                        i++;
                    }
                }
                if (trobat) {
                    series.removeSeason(numTemporada);
                }
            }
        }
    }

    public void addGroup(String s, String descripcio, String codi) {
        GrupInterest g = new GrupInterest(s, descripcio, codi);
        interestGroupList.put(s, g);
    }

    public Iterable<String> viewGroupsByName() {
        ArrayList<String> grupsDisponibles = new ArrayList<>();
        try {
            for (GrupInterest grup : getGrupsList()) {
                grupsDisponibles.add(grup.getGroupName());
            }
            Collections.sort(grupsDisponibles);

            return grupsDisponibles;
        } catch (NotAvailableGroupsException e) {
            grupsDisponibles.add(Messages.translate(e));
            return grupsDisponibles;
        }
    }

    public void addContentToGroup(String grup, String contingut) {
        GrupInterest gr = interestGroupList.get(grup);
        AudiovisualContent c = seriesList.get(contingut);
        if (c == null) {
            c = moviesList.get(contingut);
        }
        gr.addContent(seriesList.get(contingut));
    }

    // Obtenir només les sèries del grup d'interès
    public Iterable<String> getSeriesGroup(String grup) {
        GrupInterest gr = interestGroupList.get(grup);
        TreeSet<String> seriesGrup = new TreeSet<>(); // TreeSet para ordenar automáticamente

        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();

            for (AudiovisualContent a : list) {
                if (a instanceof Series) {
                    seriesGrup.add(((Series) a).getTitle());
                }
            }
        }

        return seriesGrup; // Ordenado y sin duplicados
    }

    // Obtenir només les pel·lícules del grup d'interès
    public Iterable<String> getMoviesGroup(String grup) {
        GrupInterest gr = interestGroupList.get(grup);
        ArrayList<String> pelisGrup = new ArrayList<>();

        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();
            for (AudiovisualContent a : list) {
                if (a != null && a instanceof Movie) {
                    pelisGrup.add(((Movie) a).getTitle());
                }
            }
        }

        Collections.sort(pelisGrup);
        return pelisGrup;
    }

    // Obtenir tot el contingut del grup d'interès
    public Iterable<String> getContentGroup(String grup) {
        GrupInterest gr = interestGroupList.get(grup);
        ArrayList<String> contingutGrup = new ArrayList<>();
        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();
            for (AudiovisualContent a : list) {
                if (a != null) {
                    contingutGrup.add(a.getTitle());
                }
            }
        }
        Collections.sort(contingutGrup);
        return contingutGrup;
    }

    public List<Series> getAllSeriesList() throws NotAvailableShowsException {
        if (seriesList.isEmpty()) {
            throw new NotAvailableShowsException();
        }
        return new ArrayList<>(seriesList.values());
    }

    private List<Movie> getPelisList() throws NotAvailableMoviesException {
        if (moviesList.isEmpty()) {
            throw new NotAvailableMoviesException();
        }
        return new ArrayList<>(moviesList.values());
    }

    private List<GrupInterest> getGrupsList() throws NotAvailableGroupsException {
        if (interestGroupList.isEmpty()) {
            throw new NotAvailableGroupsException();
        }
        return new ArrayList<>(interestGroupList.values());
    }

    public Map<String, Movie> getMoviesList() {
        return moviesList;
    }

    public Map<String, Series> getSeriesList() {
        return seriesList;
    }


    public Map<String, GrupInterest> getInterestGroupList() {
        return interestGroupList;
    }

    public Question getQuestion(String nomGrup, String p) {
        GrupInterest grup = interestGroupList.get(nomGrup);
        if (grup != null) {
            Question question = grup.getQuestion(p);
            if (p != null) {
                return question;
            }
        }
        return null;
    }
}
