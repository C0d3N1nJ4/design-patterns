package com.design.patterns;

/** Local, dependency-free entry point for the design-pattern learning catalog. */
public final class DesignPatternsApplication {
    private DesignPatternsApplication() {
    }

    public static void main(String[] args) {
        System.out.println("Java Design Patterns | 23 GoF patterns planned");
        for (PatternCategory category : PatternCategory.values()) {
            var patterns = PatternCatalog.byCategory(category);
            System.out.printf("%n%s (%d)%n", category, patterns.size());
            patterns.forEach(pattern -> System.out.println(" - " + pattern.name()));
        }
        System.out.println("\nPattern implementations will be added in subsequent PRs.");
    }
}
