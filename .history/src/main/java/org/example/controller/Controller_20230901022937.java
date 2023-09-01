package org.example.controller;

import java.util.ArrayList;
import java.util.Map;

import org.example.models.RandomAlgorithms;
import org.example.models.StatisticFunctions;
import org.example.models.Tests;
import org.example.views.MainWindow;

public class Controller {

    private RandomAlgorithms randomAlgorithms;
    private MainWindow mainWindow;
    private Tests tests;
    private StatisticFunctions statisticFunctions;

    public Controller() {
        initComponents();
    }

    private void initComponents()  {
        statisticFunctions = new StatisticFunctions();
        randomAlgorithms = new RandomAlgorithms();
        tests = new Tests(statisticFunctions);
        mainWindow = new MainWindow(this);
    }

    public void generateWithMiddleSquare(int iterations, String seed, int columns) {
        randomAlgorithms.generateWithMiddleSquare(iterations, seed);
        ArrayList<Double> randomsList = randomAlgorithms.getCurrentRandomList();
        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = String.valueOf(randomsList.get(i));
        }
        mainWindow.updateRiTableRows(tableData);
    }

    public void generateWithCongruent(int x0, int k, int c, int g, int iterations, char type, int columns) {
        randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
        ArrayList<Double> randomsList = randomAlgorithms.getCurrentRandomList();
        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = String.valueOf(randomsList.get(i));
        }
        mainWindow.updateRiTableRows(tableData);
    }

    public Map<String, Double> invokeMeansTest(double acceptanceRate) {
        return tests.invokeMeansTest(acceptanceRate, randomAlgorithms.getN(), randomAlgorithms.getCurrentRandomList());
    }

}
