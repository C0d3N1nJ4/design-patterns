package com.design.patterns.creational.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AbstractFactoryTest {
    @Test
    void createsConsistentLightAndDarkProductFamilies() {
        assertEquals("Light button + Light checkbox",
                new SettingsScreen(new LightWidgetFactory()).render());
        assertEquals("Dark button + Dark checkbox",
                new SettingsScreen(new DarkWidgetFactory()).render());
    }

    @Test
    void acceptsAThirdFamilyWithoutChangingClient() {
        WidgetFactory highContrast = new WidgetFactory() {
            @Override
            public Button createButton() {
                return () -> "Contrast button";
            }

            @Override
            public Checkbox createCheckbox() {
                return () -> "Contrast checkbox";
            }
        };
        assertEquals("Contrast button + Contrast checkbox", new SettingsScreen(highContrast).render());
    }

    @Test
    void rejectsMissingFactoryOrProducts() {
        assertThrows(NullPointerException.class, () -> new SettingsScreen(null));
        WidgetFactory invalid = new WidgetFactory() {
            @Override
            public Button createButton() {
                return null;
            }

            @Override
            public Checkbox createCheckbox() {
                return () -> "ok";
            }
        };
        assertThrows(NullPointerException.class, () -> new SettingsScreen(invalid));
    }
}
