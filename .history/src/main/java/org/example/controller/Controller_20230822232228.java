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
        String[][] testTableDataMatrix = new String[3][3];
        String[] words = {
                "apple", "banana", "cherry", "grape", "orange",
                "pear", "pineapple", "strawberry", "watermelon"
        };

        // Create a Random object
        Random random = new Random();

        // Fill the matrix with random words
        for (int i = 0; i < testTableDataMatrix.length; i++) {
            for (int j = 0; j < testTableDataMatrix[i].length; j++) {
                int index = random.nextInt(words.length);
                testTableDataMatrix[i][j] = words[index];
            }
        }
        mainWindow.updateRiTableRows(testTableDataMatrix);
    }

    private ArrayList<Double> generateWithMiddleSquare(int iterations, String seed) {
        return randomAlgorithms.generateWithMiddleSquare(iterations, seed);
    }

    private ArrayList<Double> generateWithCongruent(int x0, int k, int c, int g, int iterations, char type) {
        return randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
    }

}
