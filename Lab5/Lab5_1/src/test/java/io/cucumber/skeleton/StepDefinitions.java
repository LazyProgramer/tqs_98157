package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    Belly belly = new Belly();
    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        belly.eat(cukes);
    }
    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
        belly.setBellyFull(-int1);
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        assertTrue(belly.getBellyFull()<0);
    }

}
