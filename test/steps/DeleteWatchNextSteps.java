package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import controller.Controller;
import java.util.ArrayList;
import java.util.List;

public class DeleteWatchNextSteps {
    private Controller controller = Controller.getInstance();
    private String user;
    private List<String> watchNext;

    // Step for when the user has content saved in their WatchNext
    @Given("the user {string} has content saved in their WatchNext")
    public void the_user_has_content_saved_in_their_WatchNext(String userName) {
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

    // Step to simulate when the user selects a content to delete
    @When("they want to remove {string} because they are not interested")
    public void the_user_wants_to_remove_content_from_watchNext(String title) {
        controller.deleteContentWatchNext(user, title);
    }

    // Step to verify the system displays the updated list without the deleted content
    @Then("the system display the updated list")
    public void the_system_display_the_updated_list(DataTable table) {
        List<String> expectedContents = new ArrayList<>(table.asList());
        watchNext = controller.viewWatchNext(user);
        Assert.assertEquals(expectedContents, watchNext);
    }
}
