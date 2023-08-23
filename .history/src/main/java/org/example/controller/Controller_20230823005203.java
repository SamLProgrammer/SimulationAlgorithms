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
        mainWindow = new MainWindow(this);
    }

    public String[][] generateWithMiddleSquare(int iterations, String seed, int columns) {
        ArrayList<Double> randomsList = randomAlgorithms.generateWithMiddleSquare(iterations, seed);
        String[][] = new String[][];
    }

    public ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        return randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
    }

}
