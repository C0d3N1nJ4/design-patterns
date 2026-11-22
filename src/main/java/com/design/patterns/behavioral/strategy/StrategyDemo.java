package com.design.patterns.behavioral.strategy;

/** Run with: java -cp target/classes com.design.patterns.behavioral.strategy.StrategyDemo */
public final class StrategyDemo {
    private StrategyDemo() {
    }

    public static void main(String[] args) {
        var camera = new CameraApp(new EmailSharing());
        System.out.println(camera.sharePhoto("holiday-001"));
        camera.setSharingStrategy(new SocialSharing());
        System.out.println(camera.sharePhoto("holiday-001"));
    }
}
