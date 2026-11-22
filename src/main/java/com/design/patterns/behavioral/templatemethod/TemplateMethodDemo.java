package com.design.patterns.behavioral.templatemethod;

public final class TemplateMethodDemo {
    private TemplateMethodDemo() {
    }

    public static void main(String[] args) {
        var exporter = new TemplateMethodExample.HtmlExporter();
        System.out.println(exporter.export("Revenue < 100"));
    }
}
