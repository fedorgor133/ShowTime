package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

public class SaveWatchedHistorySteps {

    private Controller controller = Controller.getInstance();
    private String user;
    private List<String> history;

    // Step for when the user wants to save content to their WatchedHistory
    @Given("the user {string} wants to save content to their WatchedHistory")
    public void the_user_wants_to_save_content_to_their_WatchedHistory(String userName) {
        this.user = userName;
        // Add initial content to the user's WatchedHistory
        controller.addContentWatchedHistory(user, "The Witcher");
        controller.addContentWatchedHistory(user, "The Matrix");
        controller.addContentWatchedHistory(user, "Inception");
        controller.addContentWatchedHistory(user, "Interstellar");
    }

    // Step for when the user selects content to save
    @When("the user selects {string} to save")
    public void the_user_selects_content_to_save(String title) {
        controller.addContentWatchedHistory(user, title);
        history = controller.viewWatchedHistory(user);
    }

    // Step to verify that the system shows the updated WatchedHistory list
    @Then("the system will display the updated WatchedHistory list")
    public void the_system_will_display_the_updated_WatchedHistory_list(DataTable table) {
        List<String> expectedContents = new ArrayList<>(table.asList());
        Assert.assertEquals(expectedContents, history);
    }
}
