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
    private double leftLimit;
    private double rightLimit;
    private final double MEAN = 0.5;

    public MeansTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    public Map<String, Double> executeTest(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
        calculateVariables();
        Map<String, Double> statsMap = new HashMap<String, Double>();
        statsMap.put("alphaRate", alphaRate);
        statsMap.put("halfAlphaRate", halfAlphaRate);
        statsMap.put("relativeAlphaRate", relativeAlphaRate);
        statsMap.put("zet", zet);
        statsMap.put("leftLimit", leftLimit);
        statsMap.put("rightLimit", rightLimit);
        return statsMap;
    }

    private void calculateVariables() {
        alphaRate = 100 - acceptanceRate;
        halfAlphaRate = alphaRate/200;
        relativeAlphaRate = 1.0 - halfAlphaRate;
        zet = Double.parseDouble(statisticFunctions.getNormSINV(relativeAlphaRate).replace(',', '.'));
        leftLimit = (MEAN - zet) * (1/Math.sqrt(12*100));
        rightLimit = (MEAN - zet) + (1/Math.sqrt(12*100));
    }

}
