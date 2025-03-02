package steps;

import io.cucumber.java.en.Then;
import resources.WorldState;

import static org.junit.Assert.assertEquals;

public class SystemSteps {

    private WorldState state;

    public SystemSteps(WorldState state) {
        this.state = state;
    }

    @Then("the system will display the message {string}")
    public void el_sistema_mostrara_el_missatge(String expectedMessage) {
        assertEquals(expectedMessage, state.message);
    }
}