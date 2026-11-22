package com.design.patterns.behavioral.strategy;

public final class TextSharing implements SharingStrategy {
    @Override
    public String share(String photoId) {
        return "Text sent for photo " + photoId;
    }
}
