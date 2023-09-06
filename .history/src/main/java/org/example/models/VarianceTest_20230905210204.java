package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VarianceTest {

    private StatisticFunctions statisticFunctions;
    private double alpha;
    private double halfAlpha;
    private double inverseHalfAlpha;
    private double halfAlphaX;
    private double inverseHalfAlphaX;
    private double rightLimit;
    private double leftLimit;
    private double acceptanceRate;
    private double result;

    public VarianceTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.statisticFunctions = statisticFunctions;
    }

    public Map<String, Double> executeTest(double acceptanceRate, ArrayList<Double> numbersList) {
        this.acceptanceRate = acceptanceRate;
        Map<String, Double> statsMap = new HashMap<String, Double>();
        double variance = calculateVariance(numbersList);
        result = calculateVariables(variance, numbersList.size());
        statsMap.put("variance", variance);
        statsMap.put("alpha", alpha);
        statsMap.put("halfAlpha", halfAlpha);
        statsMap.put("inverseHalfAlpha", inverseHalfAlpha);
        statsMap.put("halfAlphaX", halfAlphaX);
        statsMap.put("inverseHalfAlphaX", inverseHalfAlphaX);
        statsMap.put("rightLimit", rightLimit);
        statsMap.put("leftLimit", leftLimit);
        statsMap.put("result", result);
        System.out.println("Variance: " + variance);
        System.out.println("LL: " + leftLimit);
        System.out.println("RL: " + rightLimit);
        System.out.println("Result: " + result);
        System.out.println(leftLimit <= variance);
        System.out.println(rightLimit >= variance);
        return statsMap;
    }

    private Double calculateVariables(double variance, double n) {
        alpha = 100 - acceptanceRate;
        halfAlpha = alpha / 200;
        inverseHalfAlpha = 1 - halfAlpha;
        halfAlphaX = Double.parseDouble(statisticFunctions.getCHISSQInv(halfAlpha, n - 1).replace(',', '.'));
        inverseHalfAlphaX = Double.parseDouble(statisticFunctions.getCHISSQInv(inverseHalfAlpha, n - 1).replace(',', '.'));
        leftLimit = halfAlphaX / (12 * (n - 1));
        rightLimit = inverseHalfAlphaX / (12 * (n - 1));
        return (leftLimit <= variance && rightLimit >= variance) ? 1.0 : 0.0;
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
        return sqrdsum / numbersList.size();
    }

}
