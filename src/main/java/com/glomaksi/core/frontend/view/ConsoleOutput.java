package com.glomaksi.core.frontend.view;

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
