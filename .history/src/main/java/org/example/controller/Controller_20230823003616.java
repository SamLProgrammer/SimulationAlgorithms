package org.example.controller;

import java.util.ArrayList;
import java.util.Random;

import org.example.models.RandomAlgorithms;
import org.example.views.MainWindow;

public class Controller {

    private RandomAlgorithms randomAlgorithms;
    private MainWindow mainWindow;

    public Controller() {
        initComponents();
    }

    private void initComponents()  {
        randomAlgorithms = new RandomAlgorithms();
        mainWindow = new MainWindow();
    }



    public ArrayList<Double> generateWithMiddleSquare(int iterations, String seed) {
        return randomAlgorithms.generateWithMiddleSquare(iterations, seed);
    }

    public ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        return randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
    }

}
