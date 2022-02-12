package com.glomaksi.core.bean;

import com.glomaksi.core.event.Event;

public class OperationQuitApp implements Operation {
    private final Event event;

    public OperationQuitApp(Event event) {
        this.event = event;
    }

    @Override
    public void execute() {
        event.update();
    }

    @Override
    public String getName() {
        return "Выйти из приложения";
    }
}
