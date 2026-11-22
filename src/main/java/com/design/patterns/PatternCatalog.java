package com.design.patterns;

import java.util.List;

/**
 * Roadmap catalog for the 23 classic GoF patterns.
 * Entries describe planned lessons; they do not claim implementations exist yet.
 */
public final class PatternCatalog {
    private static final List<PatternDefinition> PATTERNS = List.of(
            new PatternDefinition("Abstract Factory", PatternCategory.CREATIONAL),
            new PatternDefinition("Builder", PatternCategory.CREATIONAL),
            new PatternDefinition("Factory Method", PatternCategory.CREATIONAL),
            new PatternDefinition("Prototype", PatternCategory.CREATIONAL),
            new PatternDefinition("Singleton", PatternCategory.CREATIONAL),
            new PatternDefinition("Adapter", PatternCategory.STRUCTURAL),
            new PatternDefinition("Bridge", PatternCategory.STRUCTURAL),
            new PatternDefinition("Composite", PatternCategory.STRUCTURAL),
            new PatternDefinition("Decorator", PatternCategory.STRUCTURAL),
            new PatternDefinition("Facade", PatternCategory.STRUCTURAL),
            new PatternDefinition("Flyweight", PatternCategory.STRUCTURAL),
            new PatternDefinition("Proxy", PatternCategory.STRUCTURAL),
            new PatternDefinition("Chain of Responsibility", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Command", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Interpreter", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Iterator", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Mediator", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Memento", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Observer", PatternCategory.BEHAVIORAL),
            new PatternDefinition("State", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Strategy", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Template Method", PatternCategory.BEHAVIORAL),
            new PatternDefinition("Visitor", PatternCategory.BEHAVIORAL)
    );

    private PatternCatalog() {
    }

    public static List<PatternDefinition> all() {
        return PATTERNS;
    }

    public static List<PatternDefinition> byCategory(PatternCategory category) {
        return PATTERNS.stream().filter(pattern -> pattern.category() == category).toList();
    }
}
