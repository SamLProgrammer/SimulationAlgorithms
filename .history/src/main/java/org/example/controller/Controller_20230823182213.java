package org.example.controller;

import java.util.ArrayList;

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

    public void generateWithMiddleSquare(int iterations, String seed, int columns) {
        ArrayList<Double> randomsList = randomAlgorithms.generateWithMiddleSquare(iterations, seed);
        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        System.out.println(rowsNumber);
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = String.valueOf(randomsList.get(i));
        }
        mainWindow.updateRiTableRows(tableData);
    }

    public void generateWithCongruent(int x0, int k, int c, int g, int iterations, char type, int columns) {
        ArrayList<Double> randomsList = randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        System.out.println(rowsNumber);
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = String.valueOf(randomsList.get(i));
        }
        mainWindow.updateRiTableRows(tableData);
    }

}
