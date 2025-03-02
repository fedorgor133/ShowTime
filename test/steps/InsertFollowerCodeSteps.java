package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import resources.WorldState;
import controller.Controller;
import model.Params;

public class InsertFollowerCodeSteps {

    private final Controller controller;
    private final WorldState state;
    private String user;
    private String groupName;
    private String result;

    public InsertFollowerCodeSteps(WorldState state) {
        this.controller = Controller.getInstance();
        this.state = state;
    }

    @Given("the user with email {string} is a follower of the interest group {string}")
    public void userWithEmailIsFollowerOfGroup(String user, String groupName) {
        this.user = user;
        this.groupName = groupName;
        result = controller.followGroup(groupName, user);
        state.message = result;
    }

    @When("they select the game type {string} and the user enters the code {string}")
    public void selectGameTypeAndUserEntersCode(String gameType, String code) {
        Params params = new Params(code);
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }

    @When("the user has played the {string} game and entered the correct code")
    public void userHasPlayedGameAndEnteredCorrectCode(String gameType) {
        Params params = new Params(controller.getAccessCode(groupName));
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }

    @Then("the system will grant {int} points to the user")
    public void systemGrantsPointsToUser(int expectedPoints) {
        int actualPoints = controller.getUserPoints(groupName, user);
        Assert.assertEquals(expectedPoints, actualPoints);
    }
}
