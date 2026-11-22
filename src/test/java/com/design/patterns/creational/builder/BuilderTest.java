package com.design.patterns.creational.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BuilderTest {
    @Test
    void requiredPropertiesAreKeptAndOptionsDefaultToFalse() {
        var car = new Car.Builder("Electric", "Automatic").build();
        assertEquals("Electric", car.engine());
        assertEquals("Automatic", car.transmission());
        assertFalse(car.airConditioning());
        assertFalse(car.sunroof());
    }

    @Test
    void fluentBuilderEnablesSelectedOptions() {
        var car = new Car.Builder("V8", "Manual").airConditioning(true).sunroof(true).build();
        assertTrue(car.airConditioning());
        assertTrue(car.sunroof());
    }

    @Test
    void rejectsMissingRequiredProperties() {
        assertThrows(NullPointerException.class, () -> new Car.Builder(null, "Manual"));
        assertThrows(NullPointerException.class, () -> new Car.Builder("V8", null));
        assertThrows(IllegalArgumentException.class, () -> new Car.Builder(" ", "Manual"));
        assertThrows(IllegalArgumentException.class, () -> new Car.Builder("V8", ""));
    }

    @Test
    void finishedCarsDoNotChangeWhenBuilderIsReused() {
        var builder = new Car.Builder("V8", "Manual");
        var initial = builder.build();
        var upgraded = builder.sunroof(true).build();
        assertFalse(initial.sunroof());
        assertTrue(upgraded.sunroof());
    }
}
