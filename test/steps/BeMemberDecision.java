package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import controller.Controller;
import model.Params;
import resources.WorldState;

public class BeMemberDecision {
    private Controller controller;
    private WorldState state;
    private String result;
    String user;
    String groupName;

    public BeMemberDecision(WorldState state) {
        this.controller = Controller.getInstance();
        this.state = state;
    }

    @Given("the user {string} is a follower of the {string} interest group")
    public void userIsFollowerOfGroup(String user, String groupName) {
        this.user = user;
        this.groupName = groupName;
        result = controller.followGroup(groupName, user);
        state.message = result;
    }

    @When("the user goes to the option to become a member")
    public void userGoesToBecomeMemberOption() {
        System.out.println("The user is reviewing the options to become a member.");
    }

    @Then("the system will display the options to become a member")
    public void systemDisplaysOptions() {
        System.out.println("Available options: [AccessCode, Roulette]");
    }

    @When("the user plays the {string} game and the result is {int}")
    public void userPlaysGameAndResultIs(String gameType, int resultValue) {
        Params params = new Params(resultValue);
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }

    @When("the user selects the game type {string} and enters the code {string}")
    public void userSelectsGameAndEntersCode(String gameType, String code) {
        Params params = new Params(controller.getAccessCode(groupName));
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }
}
