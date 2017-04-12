package com.sca.di_ioc;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

public class HollywoodServiceClient {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AgentFinderModule());
        HollywoodServiceGuice hollywoodService = injector.getInstance(HollywoodServiceGuice.class);
        List<Agent> agents = hollywoodService.getFriendlyAgents();
        System.out.println("Here is my favorite agents:");
        for (Agent agent : agents) {
            System.out.println(agent);
        }
    }
}
