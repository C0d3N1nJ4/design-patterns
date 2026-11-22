package com.design.patterns;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class DesignPatternsApplicationTests {
    @Test
    void cliListsAllImplementedPatternFamilies() {
        var output = new ByteArrayOutputStream();
        var original = System.out;
        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));
            DesignPatternsApplication.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        var text = output.toString(StandardCharsets.UTF_8);
        assertTrue(text.contains("All 23 GoF patterns implemented"));
        assertTrue(text.contains("CREATIONAL (5)"));
        assertTrue(text.contains("STRUCTURAL (7)"));
        assertTrue(text.contains("BEHAVIORAL (11)"));
        assertTrue(text.contains("docs/USER_GUIDE.md"));
    }
}
