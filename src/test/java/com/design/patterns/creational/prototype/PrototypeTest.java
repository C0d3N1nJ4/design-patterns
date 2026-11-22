package com.design.patterns.creational.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrototypeTest {
    @Test
    void copyCanBeCustomizedWithoutMutatingOriginal() {
        var original = new ReportTemplate("Base", List.of("Summary"));
        var copy = original.copyFor("Weekly");
        copy.addSection("Metrics");
        assertNotSame(original, copy);
        assertEquals(List.of("Summary"), original.sections());
        assertEquals(List.of("Summary", "Metrics"), copy.sections());
        assertEquals("Weekly", copy.title());
    }

    @Test
    void constructorCopiesInputAndExposesUnmodifiableSnapshot() {
        var input = new ArrayList<>(List.of("Summary"));
        var report = new ReportTemplate("Base", input);
        input.add("Changed");
        assertEquals(List.of("Summary"), report.sections());
        assertThrows(UnsupportedOperationException.class, () -> report.sections().add("Changed"));
    }

    @Test
    void rejectsInvalidTitlesAndSections() {
        assertThrows(IllegalArgumentException.class, () -> new ReportTemplate("", List.of()));
        assertThrows(IllegalArgumentException.class,
                () -> new ReportTemplate("Base", List.of(" ")));
        assertThrows(NullPointerException.class, () -> new ReportTemplate("Base", null));
        var report = new ReportTemplate("Base", List.of());
        assertThrows(IllegalArgumentException.class, () -> report.addSection(" "));
        assertThrows(IllegalArgumentException.class, () -> report.copyFor(""));
    }
}
