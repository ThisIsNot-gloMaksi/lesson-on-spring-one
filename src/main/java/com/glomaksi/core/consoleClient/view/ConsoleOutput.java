package com.glomaksi.core.consoleClient.view;

public class ConsoleOutput implements Output {

    @Override
    public void output(String... str) {
        for (String i : str) {
            System.out.print(i);
        }
    }

    @Override
    public void close() {
    }
}
