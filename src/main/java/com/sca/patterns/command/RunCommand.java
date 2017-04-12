package com.sca.patterns.command;

public class RunCommand {

    public static void main(String[] args) {
        Light light = new Light();
        Command switchUp = new TurnOnLightCommand(light);
        Command switchDown = new TurnOffLightCommand(light);
        Switch sw = new Switch(switchUp, switchDown);
        sw.flipUp();
        sw.flipDown();
    }
}
