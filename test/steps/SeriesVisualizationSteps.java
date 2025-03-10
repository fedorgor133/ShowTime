package steps;

import controller.Controller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SeriesVisualizationSteps {

    private Controller controller = Controller.getInstance();
    private Iterable<String> series;

    // Given step to add the series available in the system using a Cucumber DataTable
    @Given("^the series available in the system are$")
    public void the_series_available_in_the_system_are(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            controller.addSeries(
                    row.get("Series"),
                    row.get("Description"),
                    row.get("URL"),
                    Integer.parseInt(row.get("Release Year")),
                    row.get("Language"),
                    Integer.parseInt(row.get("Duration"))
            );
        }
    }

    // When step to list series by name
    @When("the user requests the list of series by name")
    public void request_series_list_by_name() {
        series = controller.viewSeriesByName();  // Retrieve series ordered by name
    }

    // Then step to verify the series ordered by name
    @Then("the system will list the series ordered by name")
    public void the_system_will_list_the_series_ordered_by_name(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        series.forEach(actualList::add);

        assertEquals(expectedList, actualList);
    }
}
