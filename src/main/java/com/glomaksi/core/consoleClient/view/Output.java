package com.glomaksi.core.consoleClient.view;

import com.glomaksi.core.utils.Close;

import java.io.IOException;

public interface Output extends Close {
    void output(String... str) throws IOException;
}
