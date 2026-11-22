package com.design.patterns.behavioral.strategy;

public final class SocialSharing implements SharingStrategy {
    @Override
    public String share(String photoId) {
        return "Social post created for photo " + photoId;
    }
}
