package com.design.patterns.creational.abstractfactory;

public final class DarkWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return () -> "Dark button";
    }

    @Override
    public Checkbox createCheckbox() {
        return () -> "Dark checkbox";
    }
}
