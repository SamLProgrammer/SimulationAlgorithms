package org.example.controller;

import java.util.ArrayList;
import org.example.models.ChiSquaredResult;
import org.example.models.MeansTestResult;
import org.example.models.PokerResult;
import org.example.models.RandomAlgorithms;
import org.example.models.StatisticFunctions;
import org.example.models.Tests;
import org.example.models.VarianceTestResult;
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
        mainWindow.switchTestTabs(true);
        randomAlgorithms.generateWithMiddleSquare(iterations, seed);
        mainWindow.updateRiTableRows(createRandomsTableData(randomAlgorithms.getCurrentRandomList(), columns));
    }

    public void generateWithCongruent(int x0, int k, int c, int g, int iterations, char type, int columns) {
        mainWindow.switchTestTabs(true);
        randomAlgorithms.generateWithCongruent(x0, k, c, g, iterations, type);
        mainWindow.updateRiTableRows(createRandomsTableData(randomAlgorithms.getCurrentRandomList(), columns));
    }

    private String[][] createRandomsTableData(ArrayList<Double> randomsList, int columns) {

        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = String.valueOf(randomsList.get(i));
        }
        return tableData;
    }

    private String[][] createRandomsTableDataFromStringArray(ArrayList<String> randomsList, int columns) {

        int rowsNumber = randomsList.size() / columns;
        rowsNumber = (randomsList.size() % columns == 0) ? rowsNumber : rowsNumber + 1;
        String[][] tableData = new String[rowsNumber][columns];

        for(int i = 0; i < randomsList.size(); i++) {
            tableData[i/columns][i % columns] = randomsList.get(i);
        }
        return tableData;
    }

    public VarianceTestResult invokeVarianceTest(double acceptanceRate) {
        return new VarianceTestResult(tests.invokeVarianceTest(acceptanceRate, randomAlgorithms.getCurrentRandomList()), createRandomsTableData(randomAlgorithms.getCurrentRandomList(), 5));
    }

    public MeansTestResult invokeMeansTest(double acceptanceRate) {
        return new MeansTestResult(tests.invokeMeansTest(acceptanceRate, randomAlgorithms.getCurrentRandomList()), createRandomsTableData(randomAlgorithms.getCurrentRandomList(), 5));
    }

    public ChiSquaredResult invokeChiSquaredTest(double acceptanceRate, int intervalsAmount) {
        return tests.invokeChiSquaredTest(acceptanceRate, randomAlgorithms.getCurrentRandomList(), intervalsAmount);
    }

    public PokerResult invokePokerTest(double acceptanceRate) {
        PokerResult pokerResult = tests.invokePokerTest(acceptanceRate, randomAlgorithms.getCurrentRandomList());
        pokerResult.setLabeledPokerTableData(createRandomsTableDataFromStringArray(pokerResult.getLabeledData(), 5));
        return pokerResult;
    }

}
