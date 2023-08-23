package org.example.controller;

import java.util.ArrayList;

import org.example.models.RandomAlgorithms;

public class Controller {
    private RandomAlgorithms randomAlgorithms;

    public Controller() {
        initComponents();
    }

    private void initComponents()  {
        randomAlgorithms = new RandomAlgorithms();
    }

    private ArrayList<Double> generateWithMiddleSquare(int iterations, String seed) {
        randomAlgorithms.generateWithMiddleSquare(iterations, seed);
    }

}
