package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import resources.WorldState;
import controller.Controller;

public class PersonLoginSteps {

    private Controller controller = Controller.getInstance();
    private String result;
    private WorldState state;

    public PersonLoginSteps(WorldState state) {
        this.state = state;
    }

    @Given("a user with email {string} and password {string}")
    public void a_user_with_email_and_password(String user, String pass) {
        state.message = controller.findPersona(user); // Find person in the system
    }

    @Given("a user with email {string}")
    public void a_user_with_email(String user) {
        state.message = controller.findPersona(user); // Find person in the system
    }

    @When("I try to log in with the email {string} and the password {string}")
    public void i_try_to_log_in_with_email_and_password(String user, String pass) {
        result = controller.loginPerson(user, pass);
        state.message = result;
    }

    @When("requesting password recovery for the email {string}")
    public void requesting_password_recovery_for_email(String user) {
        result = controller.recoverPassword(user);
        state.message = result;
    }
}
