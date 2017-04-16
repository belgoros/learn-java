package com.sca.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

/**
 * Created by serge-mac on 14/04/2017.
 */
public class ApplyAtIngenicoSteps {

    private Person person;

    @Given("^I am an awesome person$")
    public void iAmAnAwesomePerson() {
        person = new SergueiCambourPerson();
        assertTrue(person instanceof Person);

    }

    @Given("^I am internationally focused$")
    public void iAmInternationallyFocused() {
        assertTrue(person.areInternationallyFocused());

    }

    @Given("^I like financial technology$")
    public void iLikeFinancialTechnology() {
        assertTrue(person.likesFinancialTechnology());
    }

    @When("^I apply at Ingenico$")
    public void iApplyAtIngenico() throws Throwable {
        person.apply();
    }

    @Then("^I should be taken immediately$")
    public void iShouldBeTakenImmediately() throws Throwable {
        assertTrue(person.isTaken());
    }

    class SergueiCambourPerson implements Person {

        private boolean isCVSent;

        @Override
        public boolean areInternationallyFocused() {
            return true;
        }

        @Override
        public boolean likesFinancialTechnology() {
            return true;
        }

        @Override
        public void apply() {
            this.isCVSent = true;
        }

        @Override
        public boolean isTaken() {
            return true;
        }
    }

    interface Person {
        boolean areInternationallyFocused();
        boolean likesFinancialTechnology();
        void apply();
        boolean isTaken();
    }
}
