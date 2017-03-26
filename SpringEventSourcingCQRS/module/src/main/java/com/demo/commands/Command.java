package com.demo.commands;

public abstract class Command {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
