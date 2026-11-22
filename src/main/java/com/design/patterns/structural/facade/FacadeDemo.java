package com.design.patterns.structural.facade;

public final class FacadeDemo {
    private FacadeDemo() {
    }

    public static void main(String[] args) {
        var orders = new OrderFacade(new OrderFacade.Inventory(10),
                new OrderFacade.ReceiptService());
        System.out.println(orders.placeOrder("BOOK-1", 2));
    }
}
