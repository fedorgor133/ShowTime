package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import controller.Controller;
import model.exceptions.NotAvailableGroupsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GroupsVisualizationSteps {

    private Controller controller = Controller.getInstance();
    private Iterable<String> groups;
    private String groupName;
    private Iterable<String> groupSeries;

    @Given("the following interest groups in the system")
    public void theFollowingInterestGroupsInTheSystem(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            controller.addGroup(row.get("Interest Group"), row.get("Description"), row.get("Code"));
        }
    }

    @When("the user requests the list of interest groups by name")
    public void theUserRequestsTheListOfInterestGroupsByName() throws NotAvailableGroupsException {
        groups = controller.viewGroupsByName();  // Retrieve groups ordered by name
    }

    @Then("the system will list the groups ordered by name")
    public void theSystemWillListTheGroupsOrderedByName(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        groups.forEach(actualList::add);

        assertEquals(expectedList, actualList);
    }

    @Given("the group {string} exists in the system")
    public void theGroupExistsInTheSystem(String existingGroup) {
        groupName = existingGroup;
        controller.addGroup(existingGroup, "Fake Description", "1111");
    }

    @And("the group {string} is interested in the series")
    public void theGroupIsInterestedInTheSeries(String group, io.cucumber.datatable.DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            controller.addSeries(row.get("Series"), 2000);
            controller.addContentToGroup(groupName, row.get("Series"));
        }
    }

    @When("the user requests the series of the group {string}")
    public void theUserRequestsTheSeriesFromTheGroup(String group) {
        groupSeries = controller.getContentGroup(group);
    }

    @Then("the system will list the series of the group ordered by name")
    public void theSystemWillListTheSeriesOfTheGroupOrderedByName(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        groupSeries.forEach(actualList::add);

        assertEquals(expectedList, actualList);
    }
}
