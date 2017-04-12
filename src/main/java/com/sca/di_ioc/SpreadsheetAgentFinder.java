package com.sca.di_ioc;

import java.util.ArrayList;
import java.util.List;

public class SpreadsheetAgentFinder implements AgentFinder {

    @Override
    public List<Agent> findAllAgents() {
        List<Agent> lstAgents = new ArrayList<Agent>();
        generateAgentsList(lstAgents);
        return lstAgents;
    }

    private void generateAgentsList(List<Agent> lst) {
        for (int x = 1; x <= 3; x++) {
            lst.add(new Agent("SpreadAgent-" + x));
        }
    }
}
