package com.design.patterns.structural.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FacadeTest {
    @Test
    void orchestratesOrderAndStock() {
        var stock = new OrderFacade.Inventory(5);
        var facade = new OrderFacade(stock, new OrderFacade.ReceiptService());
        assertEquals("Order placed: 2 x BOOK", facade.placeOrder("BOOK", 2));
        assertEquals(3, stock.available());
    }

    @Test
    void invalidOrdersDoNotReserveStock() {
        var stock = new OrderFacade.Inventory(2);
        var facade = new OrderFacade(stock, new OrderFacade.ReceiptService());
        assertThrows(IllegalArgumentException.class, () -> facade.placeOrder(" ", 1));
        assertThrows(IllegalArgumentException.class, () -> facade.placeOrder("BOOK", 0));
        assertThrows(IllegalStateException.class, () -> facade.placeOrder("BOOK", 3));
        assertEquals(2, stock.available());
        assertThrows(IllegalArgumentException.class, () -> new OrderFacade.Inventory(-1));
        assertThrows(NullPointerException.class, () -> new OrderFacade(null, new OrderFacade.ReceiptService()));
    }
}
