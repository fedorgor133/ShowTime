package controller;

import model.*;
import model.exceptions.NotAvailableGroupsException;
import model.exceptions.NotAvailableMoviesException;
import model.exceptions.NotAvailableShowsException;
import resources.dao.Duo;
import resources.service.DataService;
import java.util.*;

public class ManagementContent {
    private DataService dataService;
    private Map<String, Movie> moviesList;
    private Map<String, Series> seriesList;
    private Map<String, Theme> themesList;
    private Map<String, InterestGroup> interestGroupList;
    private Map<String, Question> questionsList;

    public ManagementContent(DataService dataService, Map<String, Movie> moviesList, Map<String, Series> seriesList, Map<String, Theme> themesList, Map<String, InterestGroup> interestGroupList, Map<String, Question> questionsList) {
        this.dataService = dataService;
        this.moviesList = moviesList;
        this.seriesList = seriesList;
        this.themesList = themesList;
        this.interestGroupList = interestGroupList;
        this.questionsList = questionsList;
    }

    public void loadData() {
        loadMovies();
        loadSeries();
        loadThemes();
        loadIteresetGroups();
        loadQuestions();
        relationsMoviesThemes();
        relationsInterestGroupsSeries();
        relationsInterestGroupMovie();
        relationsInterestGroupTrivia();
    }

    public void resetData() {
        moviesList.clear();
        seriesList.clear();
        themesList.clear();
        interestGroupList.clear();
        questionsList.clear();
    }

    private boolean loadMovies() {
        List<Movie> movies;
        try {
            movies = dataService.getAllPelicules();
        } catch (Exception e) {
            return false;
        }

        if (movies != null) {
            for (Movie movie : movies) {
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

    private boolean loadQuestions() {
        List<Question> questions;
        try{
            questions = dataService.getAllPreguntes();
        } catch (Exception e) {
            return false;
        }

        if (questions != null) {
            for (Question question : questions) {
                questionsList.put(question.getStatement(), question);
            }
            return true;
        }
        return false;
    }

    private boolean loadThemes() {
        List<Theme> themes;
        try {
            themes = dataService.getAllTematiques();
        } catch (Exception e) {
            return false;
        }

        if (themes != null) {
            for (Theme theme : themes) {
                themesList.put(theme.getThemeName(), theme);
            }
            return true;
        }
        return false;
    }

    private Boolean loadIteresetGroups() {
        List<InterestGroup> interestGroups;
        try {
            interestGroups = dataService.getAllGrupsInteres();
        } catch (Exception e) {
            return false;
        }

        if (interestGroups != null) {
            for (InterestGroup interestGroup : interestGroups) {
                interestGroupList.put(interestGroup.getGroupName(), interestGroup);
            }
            return true;
        }
        return false;
    }

    private void relationsMoviesThemes() {
        List<Duo<String, String>> relationsMT;
        try {
            relationsMT = dataService.getAllRelacionsPeliculesTematiques();
            for (Duo relacio : relationsMT) {
                Theme theme = themesList.get(relacio.getElement1());
                Movie movie = moviesList.get(relacio.getElement2());
                movie.addTematica(theme);
            }
        } catch (Exception e) {
        }
    }

    private void relationsInterestGroupsSeries() {
        List<Duo<String, String>> relationsGS;
        try {
            relationsGS = dataService.getAllRelacionsGrupInteresSerie();
            for (Duo relacio : relationsGS) {
                InterestGroup interestGroup = interestGroupList.get(relacio.getElement1());
                Series series = seriesList.get(relacio.getElement2());
                interestGroup.addContent(series);
            }
        } catch (Exception e) {
        }
    }

    private void relationsInterestGroupTrivia() {
        List<Duo<String, String>> relationsGS;
        try {
            relationsGS = dataService.getllRelacionsGrupInteresTrivia();
            for (Duo relacio : relationsGS) {
                InterestGroup interestGroup = interestGroupList.get(relacio.getElement1());
                Question question = questionsList.get(relacio.getElement2());
                interestGroup.addQuestionTrivia(question);
            }
        } catch (Exception e) {
        }
    }

    // Mètode per carregar Pel·lícules als grups d'interès
    private void relationsInterestGroupMovie() {
        List<Duo<String, String>> relationsGS;
        try {
            relationsGS = dataService.getAllRelacionsGrupInteresPelicula();
            for (Duo relacio : relationsGS) {
                InterestGroup interestGroup = interestGroupList.get(relacio.getElement1());
                Movie movie = moviesList.get(relacio.getElement2());
                interestGroup.addContent(movie);
            }
        } catch (Exception e) {
        }
    }

    public Iterable<String> viewMoviesByName() {
        SortedSet<String> availableMovies = new TreeSet<>();
        try {
            List<Movie> sortedList = getPelisList();
            sortedList.sort(new Comparator<Movie>() {
                public int compare(Movie a1, Movie a2) {
                    return (a1.getTitle().compareTo(a2.getTitle()));
                }
            });

            for (Movie p : sortedList) {
                availableMovies.add(p.getTitle());
            }
            return availableMovies;
        } catch (NotAvailableMoviesException e) {
            availableMovies.add(Messages.translate(e));
            return availableMovies;
        }
    }

    public Iterable<String> viewMoviesBYRelease() {
        List<java.lang.String> availableMovies = new ArrayList<>();
        try {
            List<Movie> sortedList = getPelisList();
            sortedList.sort(new Comparator<Movie>() {
                public int compare(Movie a1, Movie a2) {
                    return (Integer.compare(a2.getYearFirstRelease(), a1.getYearFirstRelease()));
                }
            });

            for (Movie p : sortedList) {
                availableMovies.add(p.getTitle());
            }
            return availableMovies;
        } catch (NotAvailableMoviesException e) {
            availableMovies.add(Messages.translate(e));
            return availableMovies;
        }
    }


    public void addMovie(String nom, int estrena, int durada) {
        Movie p = new Movie(nom, estrena, durada);
        moviesList.put(nom, p);
    }

    public Iterable<String> viewSeriesByName() {
        SortedSet<String> availableSeries = new TreeSet<>();
        for (Series r : seriesList.values()) {
            availableSeries.add(r.getTitle());
        }
        return availableSeries;
    }

    public void addSeries(String seriesName, int releaseYear) {
        Series s = new Series(seriesName, releaseYear);
        seriesList.put(seriesName, s);
    }

    public void addSeries(String seriesName, String language, int releaseYear) {
        Series s = new Series(seriesName, releaseYear);
        seriesList.put(seriesName, s);
    }

    public void addSeries(String seriesName, String description, String url, int releaseYear,
                          String language, int duration) {
        Series s = new Series(seriesName, description, url, releaseYear, language, duration);
        seriesList.put(seriesName, s);
    }

    public void addSeason(String seriesName, int seasonNumber) {
        Series series = seriesList.get(seriesName);
        if (series == null) {
            System.out.println(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> seasons = series.getSeasons();
            if (seasons == null) {
                System.out.println(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean found = false;
                while (i < seasons.size() && !found) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == seasonNumber) {
                        found = true;
                    } else i++;
                }
                if (found) {
                    System.out.println(Messages.DuplicateSeason.getMessage());
                } else {
                    Season season = new Season(seriesName, seasonNumber);
                    series.addSeason(season);
                }
            }
        }
    }

    public Iterable<String> viewSeasonsSeries(String seriesName) {
        SortedSet<String> availableSeasons = new TreeSet<>();
        Series series = seriesList.get(seriesName);
        if (series == null) {
            availableSeasons.add(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> seasons = series.getSeasons();
            if (seasons.isEmpty()) {
                availableSeasons.add(Messages.ShowWithoutSeasons.getMessage());
            } else {
                for (Season t : series.getSeasons()) {
                    availableSeasons.add(String.valueOf(t.getNumSeason()));
                }
            }
        }
        return availableSeasons;
    }

    public void addEpisode(String seriesName, int seasonNumber, int episodeNumber, String episodeTitle, int duration) {
        Series series = seriesList.get(seriesName);
        if (series == null) {
            System.out.println(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> seasons = series.getSeasons();
            if (seasons == null) {
                System.out.println(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean found = false;
                while (i < seasons.size() && !found) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == seasonNumber) {
                        found = true;
                    } else {
                        i++;
                    }
                }
                if (found) {
                    Season season = series.getSeasons().get(i);
                    if (season.containsEpisode(episodeNumber)) {
                        System.out.println(Messages.DuplicateEpisode.getMessage());
                    } else {
                        Episode episode = new Episode(seriesName, seasonNumber, episodeNumber, episodeTitle, duration);
                        season.addEpisode(episode);
                    }
                } else {
                    System.out.println(Messages.ShowWithoutSeason.getMessage());
                }
            }
        }
    }

    public Iterable<String> viewEpisodesSeasonSeries(String seriesName, int seasonNumber) {
        List<String> availableEpisodes = new ArrayList<>();
        Series series = seriesList.get(seriesName);
        if (series == null) {
            availableEpisodes.add(Messages.NotAvailableShow.getMessage());
        } else {
            List<Season> seasons = series.getSeasons();
            if (seasons == null) {
                availableEpisodes.add(Messages.ShowWithoutSeasons.getMessage());
            } else {
                int i = 0;
                boolean found = false;
                while (i < seasons.size() && !found) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == seasonNumber) {
                        found = true;
                    } else i++;
                }
                if (found) {
                    Season season = series.getSeasons().get(i);
                    List<Episode> sortedList = season.getEpisodes();
                    sortedList.sort(new Comparator<Episode>() {
                        public int compare(Episode a1, Episode a2) {
                            return (Integer.compare(a1.getNumEpisode(), a2.getNumEpisode()));
                        }
                    });

                    for (Episode e : sortedList) {
                        availableEpisodes.add(e.getEpisodeTitle());
                    }
                } else {
                    availableEpisodes.add(Messages.ShowWithoutSeason.getMessage());
                }
            }
        }
        return availableEpisodes;
    }

    public void addTheme(String theme) {
        Theme t = new Theme(theme);
        themesList.put(theme, t);
    }

    public void addMovie(String title, String description, String url, int releaseYear, String language, int duration, float rating) {
        Movie p = new Movie(title, description, url, releaseYear, language, duration, rating);
        moviesList.put(title, p);
    }

    public void addThemeToMovie(String title, String theme) {
        if (moviesList.containsKey(title)) {
            Movie p = moviesList.get(title);
            if (themesList.containsKey(theme)) {
                Theme t = themesList.get(theme);
                p.addTematica(t);
            } else {
                Theme t = new Theme(theme);
                p.addTematica(t);
            }
        } else {
            System.out.println(Messages.NotAvailableMovie.getMessage());
        }
    }

    public Iterable<String> viewMoviesByTheme(String themeName) {
        ArrayList<String> availableMovies = new ArrayList<>();

        try {
            ArrayList<String> sortedList = new ArrayList<>();
            for (Movie p : getPelisList()) {
                ArrayList<Theme> themes = p.getTematiques();

                for (Theme t : themes) {
                    if (t.getThemeName().equals(themeName)) {
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
                availableMovies.add(s);
            }
            return availableMovies;
        } catch (NotAvailableMoviesException e) {
            availableMovies.add(Messages.translate(e));
            return availableMovies;
        }
    }

    public void removeSeason(String seriesName, int seasonNumber) {
        Series series = seriesList.get(seriesName);
        if (series != null) {
            List<Season> seasons = series.getSeasons();
            if (seasons != null) {
                int i = 0;
                boolean found = false;
                while (i < seasons.size() && !found) {
                    Season season = series.getSeasons().get(i);
                    if (season.getNumSeason() == seasonNumber) {
                        found = true;
                    } else {
                        i++;
                    }
                }
                if (found) {
                    series.removeSeason(seasonNumber);
                }
            }
        }
    }

    public void addGroup(String name, String description, String code) {
        InterestGroup g = new InterestGroup(name, description, code);
        interestGroupList.put(name, g);
    }

    public Iterable<String> viewGroupsByName() {
        ArrayList<String> availableGroups = new ArrayList<>();
        try {
            for (InterestGroup group : getGrupsList()) {
                availableGroups.add(group.getGroupName());
            }
            Collections.sort(availableGroups);

            return availableGroups;
        } catch (NotAvailableGroupsException e) {
            availableGroups.add(Messages.translate(e));
            return availableGroups;
        }
    }

    public void addContentToGroup(String group, String content) {
        InterestGroup gr = interestGroupList.get(group);
        AudiovisualContent c = seriesList.get(content);
        if (c == null) {
            c = moviesList.get(content);
        }
        gr.addContent(seriesList.get(content));
    }

    public Iterable<String> getSeriesGroup(String group) {
        InterestGroup gr = interestGroupList.get(group);
        TreeSet<String> seriesGroup = new TreeSet<>();

        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();
            for (AudiovisualContent a : list) {
                if (a instanceof Series) {
                    seriesGroup.add(((Series) a).getTitle());
                }
            }
        }

        return seriesGroup;
    }

    public Iterable<String> getMoviesGroup(String group) {
        InterestGroup gr = interestGroupList.get(group);
        ArrayList<String> moviesGroup = new ArrayList<>();

        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();
            for (AudiovisualContent a : list) {
                if (a != null && a instanceof Movie) {
                    moviesGroup.add(((Movie) a).getTitle());
                }
            }
        }

        Collections.sort(moviesGroup);
        return moviesGroup;
    }

    public Iterable<String> getContentGroup(String group) {
        InterestGroup gr = interestGroupList.get(group);
        ArrayList<String> groupContent = new ArrayList<>();
        if (gr != null) {
            List<AudiovisualContent> list = gr.getContent();
            for (AudiovisualContent a : list) {
                if (a != null) {
                    groupContent.add(a.getTitle());
                }
            }
        }
        Collections.sort(groupContent);
        return groupContent;
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

    private List<InterestGroup> getGrupsList() throws NotAvailableGroupsException {
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


    public Map<String, InterestGroup> getInterestGroupList() {
        return interestGroupList;
    }

    public Question getQuestion(String grupName, String p) {
        InterestGroup group = interestGroupList.get(grupName);
        if (group != null) {
            Question question = group.getQuestion(p);
            if (p != null) {
                return question;
            }
        }
        return null;
    }
}
