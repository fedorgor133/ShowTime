package resources.dao.MOCK.entities;

import model.Movie;
import resources.dao.entities.DAOMovie;
import java.util.*;

public class DAOMovieMOCK implements DAOMovie {

    private Map<String, Movie> pelicules = new HashMap<>();

    public DAOMovieMOCK(){
        addMovie("Inception", "A thief who enters the subconscious of his targets", "URL-inception", 2010, "English", 148, 10);
        addMovie("Interstellar", "A team of explorers travel through a wormhole in space", "URL-interstellar", 2014, "English", 169, 9.5f);
        addMovie("The Matrix", "A computer hacker learns about the nature of reality", "URL-matrix", 1999, "English", 136, 9);
        addMovie("Shawshank Redemption", "A man is sentenced to life in Shawshank State Penitentiary", "URL-shawshank", 1994, "English", 144, 7.5f);
        addMovie("The Godfather", "The story of a mafia family",	"URL_godfather",	1972, "English", 215, 10);
        addMovie("The Dark Knight",	"Batman faces a new adversary, the Joker","URL_darkknight",	2008,	"English",	126, 10);
        addMovie( "Avengers: Endgame", "The Avengers take a final stand against Thanos","URL_endgame",	2019,	"English",	181, 9	);
        addMovie("Avatar","An epic science fiction film set in the mid-22nd century","URL_avatar",	2009,	"English",	162, 8	);
        addMovie("Parasite","The members of a poor family scheme to become employed by a wealthy family","URL_parasite",	2019,	"Korean", 132,	10);
    }

    private void addMovie(String title, String description, String url, int releaseYear, String language, int duration, float rating) {
        pelicules.put(title, new Movie(title, description, url, releaseYear, language, duration, rating));
    }

    @Override
    public Optional<Movie> getById(String[] id) throws Exception {
        return Optional.ofNullable(pelicules.get(Objects.requireNonNull(id[0], "Movie name cannot be null")));
    }

    @Override
    public List<Movie> getAll() throws Exception {
        return new ArrayList<>(pelicules.values());
    }

    @Override
    public boolean add(Movie movie) throws Exception {
        if (getById(new String[]{movie.getTitle()}).isPresent()) {
            return false;
        }
        pelicules.put(movie.getTitle(), movie);
        return true;
    }

    @Override
    public boolean update(Movie movie, String[] params) throws Exception {
        movie.setTitle(Objects.requireNonNull(
                params[0], "Movie name cannot be null"));
        return pelicules.replace(movie.getTitle(), movie) != null;
    }

    @Override
    public boolean delete(Movie movie) throws Exception {
        return pelicules.remove(movie.getTitle()) != null;
    }

}
