package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.WorldState;
import controller.Controller;

public class PersonRegisterSteps {

    private Controller controller = Controller.getInstance();
    private String personaName;
    private String password;
    private String result;
    private WorldState state;

    public PersonRegisterSteps(WorldState state) {
        this.state = state;
    }

    // Step to set up an existing person in the system
    @Given("the existing person with email {string}")
    public void the_existing_person_with_email(String email) {
        this.personaName = email;
        result = controller.findPersona(email);  // Find person in the system
        state.message = result;
    }

    // Step to ensure no user exists with the specified email
    @Given("there is no registered user with the email {string}")
    public void no_registered_user_with_email(String email) {
        result = controller.findPersona(email);
        if (result.equals("Nonexistent mail")) {
            state.message = result;  // Confirm the user does not exist
        }
    }

    // When step to attempt registration with a given email
    @When("I try to register with the email {string}")
    public void i_try_to_register_with_email(String email) {
        this.personaName = email;
        result = controller.findPersona(email);  // Attempt to register a new person
        state.message = result;  // Store result in the shared state
    }

    // When step to attempt registration with a given email and password
    @When("I try to register with the email {string} and a password {string}")
    public void i_try_to_register_with_email_and_password(String personaName, String password) {
        result = controller.validatePersonRegistration(personaName, password);  // Validate registration process
        state.message = result;
    }

    // When step to validate a secure password
    @When("I want to set a password {string}")
    public void i_want_to_set_a_password(String password) {
        result = controller.validatePassword(password);  // Validate password
        state.message = result;
    }

    // And step to set up an already existing user in the system
    @And("the user {string} already exists in the system")
    public void user_already_exists_in_the_system(String email) {
        this.personaName = email;
        result = controller.findPersona(email);  // Find person in the system
        state.message = result;
    }
}
