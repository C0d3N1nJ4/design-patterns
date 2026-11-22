package com.design.patterns.behavioral.strategy;

/** A replaceable algorithm for sharing a photo. */
@FunctionalInterface
public interface SharingStrategy {
    String share(String photoId);
}
