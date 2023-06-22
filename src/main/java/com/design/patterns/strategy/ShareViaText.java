package com.design.patterns.strategy;

public class ShareViaText implements ShareBehaviour{

    public void share() {
        System.out.println("I'm sharing the photo via text");
    }
}
