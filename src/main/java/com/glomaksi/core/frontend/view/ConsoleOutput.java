package com.glomaksi.core.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ConsoleOutput implements Output{

    @Override
    public void output(String... str) throws IOException {
        for (String i: str) {
            System.out.print(i);
        }
    }
}
