package com.design.patterns.creational.prototype;

import java.util.List;

public final class PrototypeDemo {
    private PrototypeDemo() {
    }

    public static void main(String[] args) {
        var standard = new ReportTemplate("Standard", List.of("Summary", "Risks"));
        var quarterly = standard.copyFor("Quarterly");
        quarterly.addSection("Forecast");
        System.out.println(standard);
        System.out.println(quarterly);
    }
}
