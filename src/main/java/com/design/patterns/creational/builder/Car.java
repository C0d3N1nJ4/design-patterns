package com.design.patterns.creational.builder;

import java.util.Objects;

/** Immutable car configured through a nested Builder. */
public final class Car {
    private final String engine;
    private final String transmission;
    private final boolean airConditioning;
    private final boolean sunroof;

    private Car(Builder builder) {
        engine = builder.engine;
        transmission = builder.transmission;
        airConditioning = builder.airConditioning;
        sunroof = builder.sunroof;
    }

    public String engine() {
        return engine;
    }

    public String transmission() {
        return transmission;
    }

    public boolean airConditioning() {
        return airConditioning;
    }

    public boolean sunroof() {
        return sunroof;
    }

    @Override
    public String toString() {
        return "Car[engine=" + engine + ", transmission=" + transmission
                + ", airConditioning=" + airConditioning + ", sunroof=" + sunroof + "]";
    }

    public static final class Builder {
        private final String engine;
        private final String transmission;
        private boolean airConditioning;
        private boolean sunroof;

        public Builder(String engine, String transmission) {
            this.engine = requireText(engine, "engine");
            this.transmission = requireText(transmission, "transmission");
        }

        public Builder airConditioning(boolean enabled) {
            airConditioning = enabled;
            return this;
        }

        public Builder sunroof(boolean enabled) {
            sunroof = enabled;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

        private static String requireText(String text, String name) {
            Objects.requireNonNull(text, name);
            if (text.isBlank()) {
                throw new IllegalArgumentException(name + " must not be blank");
            }
            return text;
        }
    }
}
