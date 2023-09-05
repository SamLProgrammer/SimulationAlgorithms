package org.example.models;

import java.util.ArrayList;

public class VarianceTest {

    private StatisticFunctions statisticFunctions;
    private double variance;
    private double alpha;
    private double halfAlpha;
    private double inverseHalfAlpha;
    private double halfAlphaX;
    private double inverseHalfAlphaX;
    private double rightLimit;
    private double leftLimit;
    private double acceptanceRate;

    public VarianceTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    private void calculateVariables(double variance) {
        alpha = 100 - acceptanceRate;
        halfAlpha = alpha / 200;
        inverseHalfAlpha = 1 - halfAlpha;
    }

    private double calculateMean(ArrayList<Double> numbersList) {
        double sum = 0;
        for (Double number : numbersList) {
            sum += number;
        }
        return sum / numbersList.size();
    }

    private double calculateVariance(ArrayList<Double> numbersList) {
        double sqrdsum = 0;
        double mean = calculateMean(numbersList);
        for (Double number : numbersList) {
            sqrdsum += (number - mean) * (number - mean);
        }
        return sqrdsum/numbersList.size();
    }

}
