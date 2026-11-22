package com.design.patterns.creational.abstractfactory;

import java.util.Objects;

/** Client depends on an entire factory family, not individual concrete widgets. */
public final class SettingsScreen {
    private final Button button;
    private final Checkbox checkbox;

    public SettingsScreen(WidgetFactory factory) {
        Objects.requireNonNull(factory, "factory");
        button = Objects.requireNonNull(factory.createButton(), "button");
        checkbox = Objects.requireNonNull(factory.createCheckbox(), "checkbox");
    }

    public String render() {
        return button.render() + " + " + checkbox.render();
    }
}
