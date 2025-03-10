package steps;

import controller.Controller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.exceptions.NotAvailableMoviesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class MoviesVisualizationSteps {

    private Controller controlador = Controller.getInstance();
    private Iterable<String> movies;

    // Scenario for adding movies to the system
    @Given("the movies available in the system are")
    public void givenExistingMoviesInTheSystem(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> row : rows.subList(1, rows.size())) {
            String title = row.get(0);
            int releaseYear = Integer.parseInt(row.get(1));
            int duration = Integer.parseInt(row.get(2));
            controlador.addMovie(title, releaseYear, duration);
        }
    }

    @Given("the movies available in the database")
    public void givenExistingMoviesInTheDatabase() {
        controlador.loadData();
    }

    // When statement for listing movies by name
    @When("the user requests the list of movies by name")
    public void requestMovieListByName() {
        movies = controlador.viewMoviesByName();
    }

    // Scenario for listing movies by name
    @Then("the system will list the movies ordered by name")
    public void thenSystemListsMoviesOrderedByName(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        movies.forEach(actualList::add);

        assertEquals(expectedList, actualList);
    }

    // When statement for listing movies by release year
    @When("the user requests the list of movies by release year")
    public void requestMovieListByReleaseYear() throws NotAvailableMoviesException {
        movies = controlador.viewMoviesBYRelease();
    }

    // Scenario for listing movies by release year
    @Then("the system will list the movies ordered by release year")
    public void thenSystemListsMoviesOrderedByReleaseYear(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        movies.forEach(actualList::add);

        assertEquals(expectedList, actualList);
    }

    // Scenario for listing movies by genre
    // Given step to define the genres available in the system
    @Given("^the genres available in the system$")
    public void givenExistingGenresInTheSystem(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asList().forEach(genre -> controlador.addTheme(genre));
    }

    // And step to add movies with their respective genres
    @Given("^the movies with genres in the system$")
    public void givenMoviesWithGenreInTheSystem(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            controlador.addMovie(row.get("Movie"),
                    row.get("Description"),
                    row.get("URL"),
                    Integer.parseInt(row.get("Release Year")),
                    row.get("Language"),
                    Integer.parseInt(row.get("Duration")),
                    Float.parseFloat(row.get("Rating")));
            controlador.addThemeToMovie(row.get("Movie"), row.get("Genre"));
        }
    }

    // When step to request the list of movies by genre
    @When("^the user requests the list of movies for the genre \"([^\"]*)\"$")
    public void whenUserRequestsListOfMoviesByGenre(String genre) throws NotAvailableMoviesException {
        // Filter the movies by the requested genre
        movies = controlador.viewMoviesByTheme(genre);
    }

    // Then step to verify that the system lists the movies correctly
    @Then("^the system will list the movies for the genre \"([^\"]*)\"$")
    public void thenSystemListsMoviesByGenre(String expectedGenre, io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedMovies = expectedTable.asList(String.class);
        List<String> actualList = new ArrayList<>();
        movies.forEach(actualList::add);
        // Verify that the filtered list matches the expected one
        assertEquals(expectedMovies, actualList);
    }
}
