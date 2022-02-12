package com.glomaksi.core.view;

import com.glomaksi.core.exception.NoSuchOperationException;

import java.io.IOException;

public class View {
    private final Input input;
    private final Output output;

    public View(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    private void promptToEnter(String text) throws IOException {
        output.output(text + "\n>>");
    }

    public int getOperation(int countOperation) throws IOException {
        promptToEnter("Введите операцию");
        int operation = input.getNumber();
        if (operation > countOperation  || operation < 0) {
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
        output.output(str+"\n");
    }



    public void print(String str) throws IOException {
        output.output(str);
    }
}
