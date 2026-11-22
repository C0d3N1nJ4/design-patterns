package com.design.patterns.behavioral.visitor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/** Adds pricing calculations to a stable hierarchy of order line types. */
public final class VisitorExample {
    private VisitorExample() {
    }

    public interface Item {
        <T> T accept(ItemVisitor<T> visitor);
    }

    public interface ItemVisitor<T> {
        T visit(Book book);

        T visit(Subscription subscription);
    }

    public record Book(String title, BigDecimal price) implements Item {
        public Book {
            Objects.requireNonNull(title, "title");
            Objects.requireNonNull(price, "price");
            if (title.isBlank() || price.signum() < 0) {
                throw new IllegalArgumentException("Invalid book");
            }
        }

        @Override
        public <T> T accept(ItemVisitor<T> visitor) {
            return Objects.requireNonNull(visitor, "visitor").visit(this);
        }
    }

    public record Subscription(String plan, BigDecimal monthlyPrice) implements Item {
        public Subscription {
            Objects.requireNonNull(plan, "plan");
            Objects.requireNonNull(monthlyPrice, "monthlyPrice");
            if (plan.isBlank() || monthlyPrice.signum() < 0) {
                throw new IllegalArgumentException("Invalid subscription");
            }
        }

        @Override
        public <T> T accept(ItemVisitor<T> visitor) {
            return Objects.requireNonNull(visitor, "visitor").visit(this);
        }
    }

    public static final class AnnualPriceVisitor implements ItemVisitor<BigDecimal> {
        @Override
        public BigDecimal visit(Book book) {
            return book.price();
        }

        @Override
        public BigDecimal visit(Subscription subscription) {
            return subscription.monthlyPrice().multiply(BigDecimal.valueOf(12));
        }
    }

    public static BigDecimal totalAnnual(List<Item> items) {
        Objects.requireNonNull(items, "items");
        var visitor = new AnnualPriceVisitor();
        return items.stream().map(item -> item.accept(visitor)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
