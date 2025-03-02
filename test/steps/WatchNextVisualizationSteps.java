package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

public class WatchNextVisualizationSteps {

    private List<String> watchNext;
    private Controller controller = Controller.getInstance();
    private String user;

    // Step for when the user has content saved in their WatchNext
    @Given("the user with email {string} has content saved in their WatchNext")
    public void the_user_with_email_has_content_saved_in_their_WatchNext(String userName) {
        this.user = userName;
        // Add initial content to the user's WatchNext
        controller.addContentWatchNext(user, "Breaking Bad");
        controller.addContentWatchNext(user, "Chernobyl");
        controller.addContentWatchNext(user, "Friends");
        controller.addContentWatchNext(user, "Game of Thrones");
        controller.addContentWatchNext(user, "Peaky Blinders");
        controller.addContentWatchNext(user, "Stranger Things");
        controller.addContentWatchNext(user, "The Big Bang Theory");
        controller.addContentWatchNext(user, "The Crown");
        controller.addContentWatchNext(user, "The Mandalorian");
    }

    // Step for when the user has no content saved in their WatchNext
    @Given("the user with email {string} has no content in their WatchNext yet")
    public void the_user_with_email_has_no_content_in_their_WatchNext_yet(String userName) {
        this.user = userName;
        controller.emptyWatchNext(user);
    }

    // Step to simulate when the user tries to access their WatchNext
    @When("they try to access their WatchNext")
    public void they_try_to_access_their_WatchNext() {
        watchNext = controller.viewWatchNext(user);
    }

    // Step to verify the system displays the list of content to watch
    @Then("the system will display a list of content to watch")
    public void the_system_will_display_a_list_of_content_to_watch(DataTable table) {
        List<String> expectedContents = new ArrayList<>(table.asList());
        Assert.assertEquals(expectedContents, watchNext);
    }

    // Step to show the corresponding message when the list is empty
    @Then("the system should show the message {string}")
    public void the_system_should_show_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, watchNext.get(0));
    }
}
