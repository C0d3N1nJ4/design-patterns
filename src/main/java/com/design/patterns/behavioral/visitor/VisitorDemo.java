package com.design.patterns.behavioral.visitor;

import java.math.BigDecimal;
import java.util.List;

public final class VisitorDemo {
    private VisitorDemo() {
    }

    public static void main(String[] args) {
        List<VisitorExample.Item> items = List.of(
                new VisitorExample.Book("Java Handbook", new BigDecimal("30.00")),
                new VisitorExample.Subscription("Basic", new BigDecimal("10.00")));
        System.out.println("Annual total: " + VisitorExample.totalAnnual(items));
    }
}
