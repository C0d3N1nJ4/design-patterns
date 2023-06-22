package com.design.patterns.strategy;

public class ShareViaEmail implements ShareBehaviour {

    public void share() {
        System.out.println("I'm emailing the photo");
    }
}
