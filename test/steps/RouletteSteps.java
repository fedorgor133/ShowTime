package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import resources.WorldState;
import controller.Controller;
import model.Params;

public class RouletteSteps {

    private final Controller controller;
    private final WorldState state;
    private String user;
    private String groupName;
    private String result;

    public RouletteSteps(WorldState state) {
        this.controller = Controller.getInstance();
        this.state = state;
    }

    @Given("the user email {string} is a follower of the interest group {string}")
    public void userEmailIsFollowerOfGroup(String user, String groupName) {
        this.user = user;
        this.groupName = groupName;
        result = controller.followGroup(groupName, user);
        state.message = result;
    }

    @When("they select the game type {string} and the result is {int}")
    public void selectGameTypeAndResultIs(String gameType, int num) {
        Params params = new Params(num);
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }
}
