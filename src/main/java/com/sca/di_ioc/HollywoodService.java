package com.sca.di_ioc;

import java.util.ArrayList;
import java.util.List;

public class HollywoodService {
    public static List<Agent> getFriendlyAgents() {
        AgentFinder finder = new SpreadsheetAgentFinder();
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<Agent>();
        for (Agent agent : agents) {
            if (agent.getType().equals("Java Developers")) {
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }
}
