package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.WorldState;
import controller.Controller;
import controller.Messages;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeasonsVisualizationSteps {

    private Controller controller = Controller.getInstance();
    private Iterable<String> seasons;  // Local handling of the seasons list
    private WorldState state;          // Shared state for message validation

    private String seriesName;         // Store the series name for the test

    // Constructor to inject the shared WorldState object
    public SeasonsVisualizationSteps(WorldState state) {
        this.state = state;  // Inject the shared state
    }

    // Step definition for "The series does not exist in the system"
    @Given("the series {string} does not exist in the system")
    public void the_series_does_not_exist_in_the_system(String seriesName) {
        seasons = controller.viewSeasonsSeries(seriesName);
        if (seasons.iterator().hasNext()) {
            String message = seasons.iterator().next();
            if (message.equals(Messages.NotAvailableShow.getMessage())) {
                state.message = message;
            }
        }
    }

    // Step definition for adding a series without any seasons
    @Given("the series {string} exists in the system without seasons")
    public void the_series_exists_in_the_system_without_seasons(String seriesName) {
        controller.addSeries(seriesName, 2020);
        seasons = controller.viewSeasonsSeries(seriesName);
        if (seasons.iterator().hasNext()) {
            String message = seasons.iterator().next();
            if (message.equals(Messages.ShowWithoutSeasons.getMessage())) {
                state.message = message;
            }
        }
    }

    // Step definition for adding a series with predefined seasons
    @Given("the series {string} with its corresponding seasons exists")
    public void add_series_with_corresponding_seasons(String seriesName) {
        controller.addSeries(seriesName, "English", 2016);
        controller.addSeason(seriesName, 1);
        controller.addSeason(seriesName, 2);
        controller.addSeason(seriesName, 3);
        controller.addSeason(seriesName, 4);
        controller.addSeason(seriesName, 5);
        this.seriesName = seriesName;
    }

    // When step for requesting the list of seasons of a series
    @When("the user requests the list of seasons of the series")
    public void request_list_of_seasons_of_the_series() {
        // No additional logic needed; the Given steps already set the seriesName and seasons variable.
        // The When step here ensures the flow between Given and Then.
        seasons = controller.viewSeasonsSeries(this.seriesName);
    }

    // Step definition to verify the ordered list of seasons for a series
    @Then("the system will display the list of seasons ordered by season number")
    public void the_system_will_display_the_ordered_list_of_seasons(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        seasons.forEach(actualList::add);
        assertEquals(expectedList, actualList);
    }
}
