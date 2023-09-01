package org.example.models;

import java.util.Map;

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

    public Map<String, Double> invokeMeansTest(double acceptanceRate, int n) {
        return meansTest.executeTest(acceptanceRate, n);
    }
}
