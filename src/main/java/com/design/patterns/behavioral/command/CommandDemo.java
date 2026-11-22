package com.design.patterns.behavioral.command;

public final class CommandDemo {
    private CommandDemo() {
    }

    public static void main(String[] args) {
        var light = new CommandExample.Light();
        var remote = new CommandExample.Remote();
        remote.submit(new CommandExample.SetLight(light, true));
        System.out.println("Light on: " + light.isOn());
        remote.undoLast();
        System.out.println("After undo: " + light.isOn());
    }
}
