package com.design.patterns.behavioral.templatemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TemplateMethodTest {
    @Test
    void keepsWorkflowButVariesFormattingSteps() {
        var csv = new TemplateMethodExample.CsvExporter();
        var html = new TemplateMethodExample.HtmlExporter();
        assertEquals("value\n\"A\"\"B\"\n", csv.export("A\"B"));
        assertEquals("<html><p>A &amp; B</p></html>", html.export("A & B"));
    }

    @Test
    void rejectsBlankInput() {
        assertThrows(IllegalArgumentException.class,
                () -> new TemplateMethodExample.CsvExporter().export(""));
        assertThrows(IllegalArgumentException.class,
                () -> new TemplateMethodExample.HtmlExporter().export(null));
    }
}
