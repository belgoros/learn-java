package com.sca.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

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

    class SergueiCambourPerson extends Person {

        private boolean isCVsent;

        @Override
        boolean areInternationallyFocused() {
            return true;
        }

        @Override
        boolean likesFinancialTechnology() {
            return true;
        }

        @Override
        void apply() {
            this.isCVsent = true;
        }

        @Override
        boolean isTaken() {
            return true;
        }
    }

    abstract class Person {
        abstract boolean areInternationallyFocused();
        abstract boolean likesFinancialTechnology();
        abstract void apply();
        abstract boolean isTaken();
    }
}
