package com.design.patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

class PatternCatalogTest {
    @Test
    void catalogContainsAllTwentyThreeUniquePatterns() {
        var patterns = PatternCatalog.all();
        assertEquals(23, patterns.size());
        assertEquals(23, new HashSet<>(patterns.stream().map(PatternDefinition::name).toList()).size());
    }

    @Test
    void catalogHasExpectedCategoryCounts() {
        assertEquals(5, PatternCatalog.byCategory(PatternCategory.CREATIONAL).size());
        assertEquals(7, PatternCatalog.byCategory(PatternCategory.STRUCTURAL).size());
        assertEquals(11, PatternCatalog.byCategory(PatternCategory.BEHAVIORAL).size());
    }

    @Test
    void catalogCannotBeModifiedByCallers() {
        assertThrows(UnsupportedOperationException.class, () -> PatternCatalog.all().clear());
    }

    @Test
    void patternMetadataRejectsInvalidNamesAndCategories() {
        assertThrows(IllegalArgumentException.class,
                () -> new PatternDefinition(" ", PatternCategory.CREATIONAL));
        assertThrows(NullPointerException.class,
                () -> new PatternDefinition("Example", null));
    }

    @Test
    void strategyExistsInRoadmap() {
        assertTrue(PatternCatalog.byCategory(PatternCategory.BEHAVIORAL)
                .stream().anyMatch(p -> p.name().equals("Strategy")));
    }
}
