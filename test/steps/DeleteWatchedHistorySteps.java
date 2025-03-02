package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

public class DeleteWatchedHistorySteps {

    private Controller controller = Controller.getInstance();
    private String user;
    private List<String> history;

    // Step for when the user has content saved in their WatchedHistory
    @Given("the user {string} has content saved in their WatchedHistory")
    public void the_user_has_content_saved_in_their_WatchedHistory(String userName) {
        this.user = userName;
        // Add initial content to the user's WatchedHistory
        controller.addContentWatchedHistory(user, "The Witcher");
        controller.addContentWatchedHistory(user, "The Matrix");
        controller.addContentWatchedHistory(user, "Inception");
        controller.addContentWatchedHistory(user, "Interstellar");
    }

    // Step for when the user selects content to delete
    @When("the user selects {string} to delete")
    public void the_user_selects_content_to_delete(String title) {
        controller.deleteContentWatchedHistory(user, title);
    }

    // Step to verify that the system displays the updated list without the deleted content
    @Then("the system will display the updated list")
    public void the_system_will_display_the_updated_list(DataTable table) {
        List<String> expectedContents = new ArrayList<>(table.asList());
        history = controller.viewWatchedHistory(user);
        Assert.assertEquals(expectedContents, history);
    }
}
