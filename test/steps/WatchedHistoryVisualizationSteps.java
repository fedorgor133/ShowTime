package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

public class WatchedHistoryVisualizationSteps {

    private Controller controller = Controller.getInstance();
    private String user;
    private List<String> history;

    // Step for when the user has content saved in WatchedHistory
    @Given("the user with email {string} has content saved in WatchedHistory")
    public void the_user_with_email_has_content_saved_in_WatchedHistory(String userName) {
        this.user = userName;
        // Adds predefined content to the user's WatchedHistory
        controller.addContentWatchedHistory(user, "The Witcher");
        controller.addContentWatchedHistory(user, "The Matrix");
        controller.addContentWatchedHistory(user, "Inception");
        controller.addContentWatchedHistory(user, "Interstellar");
    }

    // Step for when the user has no content saved in WatchedHistory
    @Given("the user with email {string} has no content saved in WatchedHistory")
    public void the_user_with_email_has_no_content_saved_in_WatchedHistory(String userName) {
        this.user = userName;
        // Clears the list of saved content in the user's WatchedHistory
        controller.emptyWatchedHistory(userName);
    }

    // Step that simulates the user accessing their WatchedHistory
    @When("they try to access their WatchedHistory")
    public void the_user_accesses_their_WatchedHistory() {
        history = controller.viewWatchedHistory(user);
    }

    // Step to verify the system displays the content ordered by most recent first
    @Then("the system will display a list of the watched content, ordered by most recent first")
    public void the_system_will_display_a_list_of_watched_content_ordered_by_most_recent_first(DataTable table) {
        List<String> expectedContents = new ArrayList<>(table.asList());
        Assert.assertEquals(expectedContents, history);
    }

    // Step to display the corresponding message
    @Then("the system display the message {string}")
    public void the_system_display_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, history.get(0));
    }
}
