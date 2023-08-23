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
        return randomAlgorithms.generateWithMiddleSquare(iterations, seed);
    }

    private ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        return randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
    }

}
