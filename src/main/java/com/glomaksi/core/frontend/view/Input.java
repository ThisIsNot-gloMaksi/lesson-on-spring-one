package com.glomaksi.core.view;

import java.io.IOException;

public interface Input {
    String getLine() throws IOException;
    int getNumber() throws IOException;
}
