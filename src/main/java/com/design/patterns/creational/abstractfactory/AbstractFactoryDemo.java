package com.design.patterns.creational.abstractfactory;

public final class AbstractFactoryDemo {
    private AbstractFactoryDemo() {
    }

    public static void main(String[] args) {
        System.out.println(new SettingsScreen(new LightWidgetFactory()).render());
        System.out.println(new SettingsScreen(new DarkWidgetFactory()).render());
    }
}
