package com.design.patterns.structural.decorator;

public final class DecoratorDemo {
    private DecoratorDemo() {
    }

    public static void main(String[] args) {
        Report report = new SignedReport(new TimestampedReport(new PlainReport("Risk summary")));
        System.out.println(report.render());
    }
}
