package com.sca.di_ioc;

public class AgentFinderFactory {
    private static AgentFinderFactory factory;

    private AgentFinderFactory() {
    }

    public static AgentFinderFactory getInstance() {
        if (factory == null) {
            factory = new AgentFinderFactory();
        }
        return factory;
    }

    public AgentFinder getAgentFinder(String agentFinderType) {
        if (agentFinderType.equals("web")) {
            return new WebServiceAgentFinder();
        } else {
            return new SpreadsheetAgentFinder();
        }
    }
}
