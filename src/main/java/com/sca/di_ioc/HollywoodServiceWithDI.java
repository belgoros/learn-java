package com.sca.di_ioc;

import java.util.ArrayList;
import java.util.List;

public class HollywoodServiceWithDI {

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<Agent>();
        for (Agent agent : agents) {
            if (agent.getType().equals("Java Developers")) {
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }

    public List<Agent> getFriendlyAgents(AgentFinder finder) {
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developers");
        return friendlyAgents;
    }
}
