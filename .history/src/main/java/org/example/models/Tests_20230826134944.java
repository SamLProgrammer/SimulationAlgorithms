package org.example.models;

public class Tests {
    private MeansTest meansTest;
    private StatisticFunctions statisticFunctions;

    public Tests(StatisticFunctions statisticFunctions) {
        initProperties(); 
        initComponents(statisticFunctions);
    }

    private void initProperties() {

    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        meansTest = new MeansTest(statisticFunctions);
    }

    public void invokeMeansTest(double acceptanceRate) {
        meansTest.executeTest(acceptanceRate);
    }
}
