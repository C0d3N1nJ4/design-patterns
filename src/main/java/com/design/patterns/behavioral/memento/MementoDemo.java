package com.design.patterns.behavioral.memento;

public final class MementoDemo {
    private MementoDemo() {
    }

    public static void main(String[] args) {
        var editor = new MementoExample.Editor();
        var history = new MementoExample.History();
        editor.write("Version one");
        history.remember(editor);
        editor.write("Version two");
        history.undo(editor);
        System.out.println("Restored: " + editor.text());
    }
}
