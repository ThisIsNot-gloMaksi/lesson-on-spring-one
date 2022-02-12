package com.glomaksi.core.event;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private final List<Observer> observers = new ArrayList<>();
    private final List<Observer> unsubscribes = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        unsubscribes.add(observer);
    }

    public void update() {
        realUnsubscribe();
        for (Observer observer : observers) {
            observer.updateState();
        }
        realUnsubscribe();
    }

    private void realUnsubscribe() {
        unsubscribes.forEach(observers::remove);
        unsubscribes.clear();
    }

}
