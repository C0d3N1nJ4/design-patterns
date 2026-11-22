package com.design.patterns.creational.abstractfactory;

/** Creates a consistent family of UI components. */
public interface WidgetFactory {
    Button createButton();

    Checkbox createCheckbox();
}
