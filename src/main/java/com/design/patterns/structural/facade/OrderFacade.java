package com.design.patterns.structural.facade;

import java.util.Objects;

/** Single entry point orchestrating validation, inventory and receipt creation. */
public final class OrderFacade {
    private final Inventory inventory;
    private final ReceiptService receipts;

    public OrderFacade(Inventory inventory, ReceiptService receipts) {
        this.inventory = Objects.requireNonNull(inventory, "inventory");
        this.receipts = Objects.requireNonNull(receipts, "receipts");
    }

    public String placeOrder(String sku, int quantity) {
        if (sku == null || sku.isBlank() || quantity <= 0) {
            throw new IllegalArgumentException("invalid order");
        }
        inventory.reserve(sku, quantity);
        return receipts.create(sku, quantity);
    }

    /** Simple in-memory collaborators, not external integrations. */
    public static final class Inventory {
        private int available;

        public Inventory(int available) {
            if (available < 0) {
                throw new IllegalArgumentException("negative stock");
            }
            this.available = available;
        }

        public void reserve(String sku, int quantity) {
            if (quantity > available) {
                throw new IllegalStateException("Insufficient stock for " + sku);
            }
            available -= quantity;
        }

        public int available() {
            return available;
        }
    }

    public static final class ReceiptService {
        public String create(String sku, int quantity) {
            return "Order placed: " + quantity + " x " + sku;
        }
    }
}
