package com.sca.steps;

import com.sca.basic.Developer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.hu.De;

import java.util.ArrayList;
import java.util.List;

public class DeveloperSteps {

    private List<Developer> developers;

    @Before
    public void setUp() {
        developers = new ArrayList<>();
    }

    @Given("^the following developers:$")
    public void theFollowingDevelopers(final DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            developers.add(createDeveloper(columns));
        }
    }

    private Developer createDeveloper(List<String> columns) {
        Developer developer = new Developer();
        developer.setFirstName(columns.get(0));
        developer.setLastName(columns.get(1));
        developer.setEmail(columns.get(2));

        return developer;
    }
}
