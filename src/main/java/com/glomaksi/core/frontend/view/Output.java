package com.glomaksi.core.frontend.view;

import java.io.IOException;

public interface Output extends Close {
    void output(String... str) throws IOException;
}
