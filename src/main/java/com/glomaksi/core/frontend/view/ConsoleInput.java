package com.glomaksi.core.frontend.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private final BufferedReader bufferedReader;

    public ConsoleInput() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getLine() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public int getNumber() throws IOException {
        return Integer.parseInt(getLine());
    }

    @Override
    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
