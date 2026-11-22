package com.design.patterns;

/** Local, dependency-free entry point for the design-pattern learning catalog. */
public final class DesignPatternsApplication {
    private DesignPatternsApplication() {
    }

    public static void main(String[] args) {
        System.out.println("Java Design Patterns | All 23 GoF patterns implemented");
        for (PatternCategory category : PatternCategory.values()) {
            var patterns = PatternCatalog.byCategory(category);
            System.out.printf("%n%s (%d)%n", category, patterns.size());
            patterns.forEach(pattern -> System.out.println(" - " + pattern.name()));
        }
        System.out.println("\nFor runnable examples and learning guides, see docs/USER_GUIDE.md.");
    }
}
