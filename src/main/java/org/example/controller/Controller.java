package org.example.controller;

import org.example.models.RandomAlgorithms;

public class Controller {
    private RandomAlgorithms randomAlgorithms;

    public Controller() {
        initComponents();
    }

    private void initComponents()  {
        randomAlgorithms = new RandomAlgorithms();
    }

}
