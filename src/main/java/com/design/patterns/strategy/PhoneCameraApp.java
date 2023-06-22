package com.design.patterns.strategy;


public abstract class PhoneCameraApp {

    ShareBehaviour shareBehaviour;

    public void take() {
        System.out.println("Taking the photo");
    }

    public void save() {
        System.out.println("Saving the photo");
    }

    public void edit() {
        System.out.println("Editing the photo");
    }

    public ShareBehaviour getShareBehaviour() {
        return shareBehaviour;
    }

    public void setShareBehaviour(ShareBehaviour shareBehaviour) {
        this.shareBehaviour = shareBehaviour;
    }

    public void performShare() {
        shareBehaviour.share();
    }
}
