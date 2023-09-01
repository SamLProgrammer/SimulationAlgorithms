package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class MeansTest {
    private StatisticFunctions statisticFunctions;
    private double acceptanceRate;
    private double alphaRate;
    private double halfAlphaRate;
    private double relativeAlphaRate;
    private double zet;

    public MeansTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    public double[] executeTest(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
        calculateVariables();
        double[] statsVector = new double[]{alphaRate, halfAlphaRate, relativeAlphaRate, zet};
        Map<String, Double> statsMap = new HashMap<String, Double>();
        statsMap.put("alphaRate", alphaRate);
        statsMap.put("halfAlphaRate", halfAlphaRate);
        statsMap.put("relativeAlphaRate", relativeAlphaRate);
        statsMap.put("zet", zet);
        return statsVector;
    }

    private void calculateVariables() {
        alphaRate = 100 - acceptanceRate;
        halfAlphaRate = alphaRate/200;
        relativeAlphaRate = 1.0 - halfAlphaRate;
        zet = Double.parseDouble(statisticFunctions.getNormSINV(relativeAlphaRate).replace(',', '.'));
    }

}
