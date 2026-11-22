package com.design.patterns.structural.flyweight;

public final class FlyweightDemo {
    private FlyweightDemo() {
    }

    public static void main(String[] args) {
        var factory = new TextStyleFactory();
        var first = factory.style("Mono", 12);
        var second = factory.style("Mono", 12);
        System.out.println("Shared style: " + (first == second));
        System.out.println(first.render('A', 0));
        System.out.println("Cached styles: " + factory.cachedStyles());
    }
}
