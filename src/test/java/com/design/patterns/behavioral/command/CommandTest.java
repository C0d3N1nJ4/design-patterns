package com.design.patterns.behavioral.command;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CommandTest {
    @Test
    void executesAndUndoesTheLightCommand() {
        var light = new CommandExample.Light();
        var remote = new CommandExample.Remote();
        remote.submit(new CommandExample.SetLight(light, true));
        assertTrue(light.isOn());
        remote.undoLast();
        assertFalse(light.isOn());
    }

    @Test
    void guardsAgainstInvalidLifecycle() {
        var light = new CommandExample.Light();
        var command = new CommandExample.SetLight(light, true);
        assertThrows(IllegalStateException.class, command::undo);
        command.execute();
        assertThrows(IllegalStateException.class, command::execute);
        command.undo();
        assertThrows(IllegalStateException.class, new CommandExample.Remote()::undoLast);
        assertThrows(NullPointerException.class, () -> new CommandExample.SetLight(null, true));
        assertThrows(NullPointerException.class, () -> new CommandExample.Remote().submit(null));
    }
}
