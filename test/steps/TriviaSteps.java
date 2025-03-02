package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import resources.WorldState;
import controller.Controller;
import model.Params;

public class TriviaSteps {

    private WorldState state;
    private Controller controller;
    private String user;
    private String groupName;
    private String result;
    private String answer;
    private String category;
    private String gameType;
    private String question;

    public TriviaSteps(WorldState state) {
        this.controller = Controller.getInstance();
        this.state = state;
    }

    @Given("the user with email {string} is a follower of the {string} group")
    public void userIsFollowerOfGroup(String user, String groupName) {
        this.user = user;
        this.groupName = groupName;
        result = controller.followGroup(groupName, user);
        state.message = result;
    }

    @Given("the system displays the question {string} from the {string} group")
    public void systemDisplaysQuestion(String question, String groupName) {
        this.question = question;
        this.groupName = groupName;
    }

    @When("the user plays the {string} game and the category {string} appears")
    public void userPlaysGameAndCategoryAppears(String game, String category) {
        this.category = category;
        this.gameType = game;
        Params params = new Params(category);
        controller.becomeMember(groupName, user, game, params);
        state.message = result;
    }

    @Then("the system will display the question {string}")
    public void systemWillDisplayQuestion(String question) {
        this.question = question;
        String obtainedQuestion = controller.getQuestion(groupName, question).getStatement();
        Assert.assertEquals(obtainedQuestion, question);
    }

    @When("the user with email {string} enters the answer {string} in {string}")
    public void userEntersAnswer(String user, String answer, String gameType) {
        this.user = user;
        this.gameType = gameType;
        Params params = new Params(question, answer);
        result = controller.becomeMember(groupName, user, gameType, params);
        state.message = result;
    }

    @Then("the user will earn {int} points")
    public void systemWillAwardPoints(int expectedPoints) {
        int actualPoints = controller.getUserPoints(groupName, user);
        Assert.assertEquals(expectedPoints, actualPoints);
    }
}