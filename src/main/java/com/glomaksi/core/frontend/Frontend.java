package com.glomaksi.core.frontend;

import com.glomaksi.core.bean.Operation;
import com.glomaksi.core.event.Event;
import com.glomaksi.core.event.Observer;
import com.glomaksi.core.exception.NoSuchOperationException;
import com.glomaksi.core.frontend.view.View;
import com.glomaksi.core.service.OperationService;
import com.glomaksi.core.utils.MenuRender;

import java.io.IOException;
import java.util.List;

public class Frontend implements Observer {
    private final View view;
    private final OperationService operationService;
    private final Event event;
    private boolean isStart;

    public Frontend(View view, OperationService operationService, Event event) {
        this.view = view;
        this.operationService = operationService;
        this.event = event;
        event.subscribe(this);
        isStart = true;
    }

    public void run() {
        try {
            List<Operation> s = operationService.getOperation();
            while (isStart) {
                try {
                    view.println(MenuRender.getMenu(s));
                    int operation = view.getOperation(s.size());
                    s.get(operation - 1).execute();
                } catch (NoSuchOperationException e) {
                    view.println("Неверная операция");
                } catch (NumberFormatException e) {
                    view.println("Некорректная операция");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateState() {
        close();
    }

    private void close() {
        isStart = false;
        event.unsubscribe(this);
    }
}
