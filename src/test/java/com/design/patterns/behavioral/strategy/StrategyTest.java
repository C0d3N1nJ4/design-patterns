package com.design.patterns.behavioral.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StrategyTest {
    @Test
    void selectsEmailAlgorithmAndCanSwitchToSocialAtRuntime() {
        var camera = new CameraApp(new EmailSharing());
        assertEquals("Email sent for photo trip", camera.sharePhoto("trip"));
        camera.setSharingStrategy(new SocialSharing());
        assertEquals("Social post created for photo trip", camera.sharePhoto("trip"));
    }

    @Test
    void supportsTextAndLambdaImplementations() {
        var camera = new CameraApp(new TextSharing());
        assertEquals("Text sent for photo trip", camera.sharePhoto("trip"));
        camera.setSharingStrategy(photo -> "Saved " + photo);
        assertEquals("Saved trip", camera.sharePhoto("trip"));
    }

    @Test
    void preventsMissingStrategiesAndInvalidPhotos() {
        assertThrows(NullPointerException.class, () -> new CameraApp(null));
        var camera = new CameraApp(new EmailSharing());
        assertThrows(NullPointerException.class, () -> camera.setSharingStrategy(null));
        assertThrows(IllegalArgumentException.class, () -> camera.sharePhoto(" "));
        assertThrows(IllegalArgumentException.class, () -> camera.sharePhoto(null));
    }
}
