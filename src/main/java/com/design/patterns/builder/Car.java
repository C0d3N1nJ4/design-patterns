package com.design.patterns.builder;

public class Car {

    // required parameters
    private final String engine;
    private final String transmission;

    // optional parameters
    private final boolean airConditioning;
    private final boolean sunroof;

    //Private constructor so that only the Builder can create an instance of a Car
    private Car(Builder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.airConditioning = builder.airConditioning;
        this.sunroof = builder.sunroof;
    }

    //Static nested Builder class
    public static class Builder {
        // required parameters
        private final String engine;
        private final String transmission;

        // optional parameters
        private boolean airConditioning = false;
        private boolean sunroof = false;

        //Constructor to set the required parameters
        public Builder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        //method to set the optional parameter of airConditioning
        public Builder airConditioning(boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        //method to set the optional parameter of sunroof
        public Builder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        //method to build and return a Car instance
        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", airConditioning=" + airConditioning +
                ", sunroof=" + sunroof +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Car.Builder("V8", "Automatic")
                .airConditioning(true)
                .sunroof(true)
                .build();
        System.out.println(car);
    }
}
