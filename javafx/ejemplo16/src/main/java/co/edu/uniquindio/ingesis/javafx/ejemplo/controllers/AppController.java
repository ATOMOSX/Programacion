package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Diplomado;

public enum AppController {
    INSTANCE;
    private final Diplomado diplomado;

    AppController() {
        diplomado = new Diplomado("Programación",10);
    }

    public Diplomado getDiplomado() {
        return diplomado;
    }
}
