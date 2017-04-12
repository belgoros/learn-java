package com.sca.di_ioc;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class HollywoodServiceGuice {
    private AgentFinder finder = null;

    @Inject
    public HollywoodServiceGuice(AgentFinder finder) {
        this.finder = finder;
    }

    private static List<Agent> filterAgents(List<Agent> agents, String agentType) {
        List<Agent> filteredAgents = new ArrayList<Agent>();
        for (Agent agent : agents) {
            if (agent.getType().contains(agentType)) {
                filteredAgents.add(agent);
            }
        }
        return filteredAgents;
    }

    public List<Agent> getFriendlyAgents() {
        List<Agent> agents = finder.findAllAgents();
        List<Agent> friendlyAgents = filterAgents(agents, "Java Developer");
        return friendlyAgents;
    }
}
