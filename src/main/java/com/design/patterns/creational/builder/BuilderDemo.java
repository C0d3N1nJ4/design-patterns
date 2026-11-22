package com.design.patterns.creational.builder;

/** Run with: java -cp target/classes com.design.patterns.creational.builder.BuilderDemo */
public final class BuilderDemo {
    private BuilderDemo() {
    }

    public static void main(String[] args) {
        var car = new Car.Builder("Electric", "Automatic")
                .airConditioning(true)
                .sunroof(true)
                .build();
        System.out.println(car);
    }
}
