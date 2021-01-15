package com.company.Commands;

import com.company.Control;

public abstract class Command {
    protected Control control;

    public abstract void execute();
}

