package com.design.patterns.strategy;

import java.util.Scanner;

public class TestPhoneAppStrategyPattern {

    public static void main(String[] args) {
        PhoneCameraApp basicCameraApp = new BasicCameraApp();
        String share = getSharing();

        switch (share) {
            case "email":
                basicCameraApp.setShareBehaviour(new ShareViaEmail());
                break;
            case "text":
                basicCameraApp.setShareBehaviour(new ShareViaText());
                break;
            case "social":
                basicCameraApp.setShareBehaviour(new ShareViaSocialMedia());
                break;
            default:
                System.out.println("Invalid share type");
        }

        basicCameraApp.take();
        basicCameraApp.save();
        basicCameraApp.edit();
        basicCameraApp.performShare();
    }

    public static String getSharing() {
        Scanner input = new Scanner(System.in);
        System.out.println("Share via email (email), text (text), or social media (social)?");
        String share = input.next();
        input.close();
        return share;
    }
}

