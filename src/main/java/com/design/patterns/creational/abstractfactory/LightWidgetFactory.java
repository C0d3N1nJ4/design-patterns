package com.design.patterns.creational.abstractfactory;

public final class LightWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton() {
        return () -> "Light button";
    }

    @Override
    public Checkbox createCheckbox() {
        return () -> "Light checkbox";
    }
}
