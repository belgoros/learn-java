package com.sca.jcommander;

import com.beust.jcommander.Parameter;

/**
 * Created by serguei_cambour on 18/12/2015.
 * <p/>
 * See the test class for the use cases
 */
public class RunWithJCommander {


    @Parameter(names = "-u", description = "User name")
    private String userName;

    @Parameter(names = "-keep", description = "Keep notified")
    private boolean keep;

    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug;

    @Parameter(names = "--es-host", description = "elastic search host")
    private String esHost;

    @Parameter(names = "--period", description = "some period description")
    private int period;


    public String getUserName() {
        return userName;
    }

    public boolean isKeep() {
        return keep;
    }

    public boolean isDebug() {
        return debug;
    }

    public String getEsHost() {
        return esHost;
    }

    public int getPeriod() {
        return period;
    }
}
