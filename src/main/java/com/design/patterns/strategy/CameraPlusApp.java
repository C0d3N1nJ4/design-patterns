package com.design.patterns.strategy;

public class CameraPlusApp extends PhoneCameraApp{

    public void edit() {
        System.out.println("Extra snazzy photo editing features");
    }

    public void doPhoneCameraAppStuff() {
        System.out.println("I'm doing stuff with the CameraPlusApp");
    }
}
