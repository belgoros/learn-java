package com.sca.steps;

import com.sca.basic.Developer;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serguei_cambour on 11/12/2015.
 */
public class DeveloperSteps {

    private List<Developer> developers = new ArrayList<>();

    @Given("^the following developers:$")
    public void theFollowingDevelopers(final DataTable dataTable) {
        developers = dataTable.asList(Developer.class);
        for (Developer developer : developers) {
            System.out.println(developer.getFirstName() + " " + developer.getLastName());
        }
    }
}
