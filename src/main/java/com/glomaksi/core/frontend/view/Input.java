package com.glomaksi.core.frontend.view;

import com.glomaksi.core.utils.Close;

import java.io.IOException;

public interface Input extends Close {
    String getLine() throws IOException;

    int getNumber() throws IOException;
}
