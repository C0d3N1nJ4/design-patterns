package com.design.patterns.behavioral.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MementoTest {
    @Test
    void restoresSnapshotsInReverseOrder() {
        var editor = new MementoExample.Editor();
        var history = new MementoExample.History();
        editor.write("A");
        history.remember(editor);
        editor.write("B");
        history.remember(editor);
        editor.write("C");
        history.undo(editor);
        assertEquals("B", editor.text());
        history.undo(editor);
        assertEquals("A", editor.text());
    }

    @Test
    void rejectsInvalidRestoreAndEmptyHistory() {
        var editor = new MementoExample.Editor();
        assertThrows(NullPointerException.class, () -> editor.restore(null));
        assertThrows(NullPointerException.class, () -> editor.write(null));
        assertThrows(IllegalStateException.class, () -> new MementoExample.History().undo(editor));
    }
}
