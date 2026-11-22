package com.design.patterns.behavioral.strategy;

import java.util.Objects;

/** Context: delegates sharing to a strategy selected at runtime. */
public final class CameraApp {
    private SharingStrategy sharingStrategy;

    public CameraApp(SharingStrategy sharingStrategy) {
        setSharingStrategy(sharingStrategy);
    }

    public void setSharingStrategy(SharingStrategy sharingStrategy) {
        this.sharingStrategy = Objects.requireNonNull(sharingStrategy, "sharingStrategy");
    }

    public String sharePhoto(String photoId) {
        if (photoId == null || photoId.isBlank()) {
            throw new IllegalArgumentException("photoId must not be blank");
        }
        return sharingStrategy.share(photoId);
    }
}
