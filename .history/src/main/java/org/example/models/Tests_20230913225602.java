package org.example.models;

import java.util.ArrayList;
import java.util.Map;

public class Tests {
    private MeansTest meansTest;
    private VarianceTest varianceTest;
    private ChiSquaredTest chiSquaredTest;

    public Tests(StatisticFunctions statisticFunctions) {
        initProperties(); 
        initComponents(statisticFunctions);
    }

    private void initProperties() {

    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        meansTest = new MeansTest(statisticFunctions);
        varianceTest = new VarianceTest(statisticFunctions);
        chiSquaredTest = new ChiSquaredTest(statisticFunctions);
    }

    public Map<String, Double> invokeMeansTest(double acceptanceRate, ArrayList<Double> randomsList) {
        return meansTest.executeTest(acceptanceRate,randomsList);
    }

    public Map<String, Double> invokeVarianceTest(double acceptanceRate, ArrayList<Double> randomsList) {
        return varianceTest.executeTest(acceptanceRate, randomsList);
    }
}
