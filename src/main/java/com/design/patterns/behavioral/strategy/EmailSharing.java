package com.design.patterns.behavioral.strategy;

public final class EmailSharing implements SharingStrategy {
    @Override
    public String share(String photoId) {
        return "Email sent for photo " + photoId;
    }
}
