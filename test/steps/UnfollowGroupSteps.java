package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.WorldState;
import controller.Controller;

// Step class for the use case of unfollowing an interest group
public class UnfollowGroupSteps {
    private Controller controller = Controller.getInstance();
    private String user;
    private String result;
    private WorldState state;
    private String groupName;

    public UnfollowGroupSteps(WorldState state) {
        this.state = state;
    }

    // Step to indicate the user wants to unfollow an interest group
    @Given("the user {string} wants to unfollow the interest group {string}")
    public void theUserWantsToUnfollowTheInterestGroup(String userEmail, String groupName) {
        this.user = userEmail;
        this.groupName = groupName;
    }

    @When("the user unfollows the interest group")
    public void unfollowsInterestGroup() {
        result = controller.unfollowGroup(groupName, user);
        state.message = result;
    }
}
