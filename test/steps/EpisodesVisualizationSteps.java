package steps;

import resources.WorldState;
import controller.Controller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import controller.Messages;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EpisodesVisualizationSteps {

    private Controller controller = Controller.getInstance();
    private Iterable<String> episodes;  // Local handling of the episodes list
    private WorldState state;           // Shared state for message validation
    private String seriesName;          // Store the series name for the test

    public EpisodesVisualizationSteps(WorldState state) {
        this.state = state;  // Inject the shared state
    }

    @Given("the series {string} is not present in the system")
    public void the_series_is_not_present_in_the_system(String seriesName) {
        this.seriesName = seriesName;
    }

    @Given("the season {string} is not found because the series does not exist")
    public void the_season_is_not_found_because_the_series_does_not_exist(String season) {
        // Placeholder for readability. No action needed.
    }

    @Given("that the series {string} has its seasons added but not season {string}")
    public void that_the_series_has_its_seasons_added_but_not_season(String seriesName, String season) {
        controller.addSeries(seriesName, "English", 2016);  // Add the series (with seasons)
        controller.removeSeason(seriesName, Integer.parseInt(season));  // Remove the specified season
        this.seriesName = seriesName;
    }

    @Given("we add the series {string} with its corresponding seasons and episodes")
    public void we_add_the_series_with_its_corresponding_seasons_and_episodes(String seriesName) {
        controller.addSeries(seriesName, "English", 2016);
        controller.addSeason(seriesName, 1);
        controller.addEpisode(seriesName, 1, 1, "Chapter One: The Vanishing of Will Byers", 55);
        controller.addEpisode(seriesName, 1, 2, "Chapter Two: The Weirdo on Maple Street", 55);
        controller.addEpisode(seriesName, 1, 3, "Chapter Three: Holly, Jolly", 55);
        controller.addEpisode(seriesName, 1, 4, "Chapter Four: The Body", 55);
        controller.addEpisode(seriesName, 1, 5, "Chapter Five: The Flea and the Acrobat", 55);
        controller.addEpisode(seriesName, 1, 6, "Chapter Six: The Monster", 55);
        controller.addEpisode(seriesName, 1, 7, "Chapter Seven: The Bathtub", 55);
        controller.addEpisode(seriesName, 1, 8, "Chapter Eight: The Upside Down", 55);
        this.seriesName = seriesName;
    }

    @When("the user requests the list of episodes of the series for season {string}")
    public void the_user_requests_the_list_of_episodes_of_the_series_for_season(String season) {
        episodes = controller.viewEpisodesSeasonSeries(this.seriesName, Integer.parseInt(season));

        if (episodes.iterator().hasNext()) {
            String message = episodes.iterator().next();
            if (message.equals(Messages.NotAvailableShow.getMessage()) ||
                    message.equals(Messages.ShowWithoutSeason.getMessage()) ||
                    message.equals(Messages.ShowWithoutSeasons.getMessage())) {
                state.message = message;
            }
        }
    }

    @Then("the system will display the list of episodes of season {string} ordered by episode number")
    public void the_system_will_display_the_list_of_episodes_ordered(String season, io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        episodes.forEach(actualList::add);
        assertEquals(expectedList, actualList);
    }
}
