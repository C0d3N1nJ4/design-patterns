package com.design.patterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/** Guards guide completeness and known-invalid class relationships. */
class MermaidDocumentationTest {
    @Test
    void allPatternGuidesContainClassDiagramsWithoutInvalidRelationOperators() throws IOException {
        var directory = Path.of("docs", "guides");
        try (Stream<Path> files = Files.list(directory)) {
            var guides = files.filter(p -> p.toString().endsWith(".md")).toList();
            assertEquals(23, guides.size(), "There should be one guide for each GoF pattern");
            for (var guide : guides) {
                var markdown = Files.readString(guide);
                assertTrue(markdown.contains("```mermaid\nclassDiagram\n"),
                        () -> guide + " must contain a Mermaid class diagram");
                assertFalse(markdown.contains(" +-- "),
                        () -> guide + " uses invalid Mermaid +-- relation syntax");
                assertFalse(markdown.contains(" o--> "),
                        () -> guide + " uses nonstandard Mermaid o--> syntax");
                assertTrue(markdown.indexOf("```", markdown.indexOf("```mermaid") + 3) > 0,
                        () -> guide + " has an unclosed Mermaid diagram");
            }
        }
    }
}
