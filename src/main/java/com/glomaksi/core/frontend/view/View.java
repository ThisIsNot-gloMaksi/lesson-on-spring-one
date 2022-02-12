package com.glomaksi.core.frontend.view;

import com.glomaksi.core.event.Event;
import com.glomaksi.core.event.Observer;
import com.glomaksi.core.exception.NoSuchOperationException;

import java.io.IOException;

public class View implements Observer {
    private final Input input;
    private final Output output;
    private final Event event;

    public View(Input input, Output output, Event event) {
        this.input = input;
        this.output = output;
        this.event = event;
        event.subscribe(this);
    }

    private void promptToEnter(String text) throws IOException {
        output.output(text + "\n>>");
    }

    public int getOperation(int countOperation) throws IOException {
        promptToEnter("Введите операцию");
        int operation = input.getNumber();
        if (operation > countOperation || operation < 0) {
            throw new NoSuchOperationException("illegal operation");
        }
        return operation;
    }

    public String getLine(String text) throws IOException {
        promptToEnter(text);
        return input.getLine();
    }

    public int getNumber(String text) throws IOException {
        promptToEnter(text);
        return input.getNumber();
    }

    public void println(String str) throws IOException {
        output.output(str + "\n");
    }

    public void print(String str) throws IOException {
        output.output(str);
    }

    @Override
    public void updateState() {
        close();
    }

    private void close() {
        input.close();
        output.close();
        event.unsubscribe(this);
    }
}
