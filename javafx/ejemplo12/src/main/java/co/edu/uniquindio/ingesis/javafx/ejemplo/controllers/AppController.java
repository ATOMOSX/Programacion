package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Bus;

public enum AppController {
    INSTANCE;
    private final Bus bus;

    AppController() {
        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }
}
