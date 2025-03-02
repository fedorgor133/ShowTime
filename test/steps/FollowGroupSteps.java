package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.WorldState;
import controller.Controller;
import model.InterestGroup;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FollowGroupSteps {

    private Controller controller = Controller.getInstance();
    private String user;
    private String result;
    private InterestGroup group;
    private WorldState state;
    private String groupName;
    private Iterable<String> contents;

    public FollowGroupSteps(WorldState state) {
        this.state = state;
    }

    @Given("the user with email {string} wants to follow the interest group {string}")
    public void theUserWantsToFollowTheInterestGroup(String userEmail, String groupName) {
        this.user = userEmail;
        this.groupName = groupName;
    }

    @Given("the user with email {string} follows the interest group {string}")
    public void theUserFollowsTheInterestGroup(String userEmail, String groupName) {
        this.user = userEmail;
        this.groupName = groupName;
        result = controller.followGroup(groupName, userEmail);
        state.message = result;
    }

    // Step to simulate when the user clicks the button to follow or unfollow a group
    @When("the user starts following the interest group")
    public void theUserStartsFollowingTheInterestGroup() {
        result = controller.followGroup(groupName, user);
        state.message = result;
    }

    @When("the user wants to see the list of series of the interest group")
    public void theUserWantsToSeeTheListOfSeriesOfTheInterestGroup() {
        contents = controller.getSeriesGroup(groupName);
    }

    @When("the user wants to see the list of movies of the interest group")
    public void theUserWantsToSeeTheListOfMoviesOfTheInterestGroup() {
        contents = controller.getMoviesGroup(groupName);
    }

    @When("the user wants to see the list of content of the interest group")
    public void theUserWantsToSeeTheListOfContentOfTheInterestGroup() {
        contents = controller.getContentGroup(groupName);
    }

    @Then("the system will display the list of the interest group")
    public void willDisplayTheListOfInterestGroup(io.cucumber.datatable.DataTable expectedTable) {
        List<String> expectedList = expectedTable.asList();
        List<String> actualList = new ArrayList<>();
        contents.forEach(actualList::add);
        assertEquals(expectedList, actualList);
    }
}
