package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiSquaredTest {

    private ArrayList<ChiInterval> intervals;
    private StatisticFunctions sf;
    private double chiInvTest;
    private double halfAlpha;

    public ChiSquaredTest(StatisticFunctions sf) {
        this.sf = sf;
        initComponents();
    }

    private void initComponents() {
        intervals = new ArrayList<>();
    }

    public ChiSquaredResult executeTest(ArrayList<Double> randomNumbersList, int intervalsAmount,
            double acceptanceError) {
        initComponents();
        halfAlpha = (100 - acceptanceError) / 200;
        ArrayList<Double> copyRandomNumbersList = new ArrayList<>(randomNumbersList);
        double min = 1;
        double max = 0;

        for (Double currentNumber : copyRandomNumbersList) {
            if (currentNumber < min) {
                min = currentNumber;
            }
            if (currentNumber > max) {
                max = currentNumber;
            }
        }
        double intervalWidth = (max - min) / intervalsAmount;
        double currentMin = min;
        for (int i = 0; i < intervalsAmount; i++) {
            intervals.add(new ChiInterval(i + 1, currentMin, min + intervalWidth * (i + 1),
                    (double)copyRandomNumbersList.size() / (double)intervalsAmount));
            currentMin = currentMin + intervalWidth;
        }
        
        quickSort(copyRandomNumbersList, 0, copyRandomNumbersList.size() - 1);

        int ocurrences = 0;
        int index = 0;
        double totalError = 0;
        for (ChiInterval interval : intervals) {
            while (index < copyRandomNumbersList.size() && copyRandomNumbersList.get(index) < interval.getEnd()) {
                ocurrences++;
                index++;
            }
            interval.setOcurrences(ocurrences);
            totalError += interval.calculateError();
            ocurrences = 0;
        }

        chiInvTest = Double.valueOf(sf.getCHIInv(halfAlpha, intervalsAmount - 1));

        Map<String, Double> statsMap = new HashMap<String, Double>();

        statsMap.put("max", formatDouble(max));
        statsMap.put("min", formatDouble(min));
        statsMap.put("chiInvTest", formatDouble(chiInvTest));
        statsMap.put("totalError", formatDouble(totalError));
        statsMap.put("result", totalError < chiInvTest ? 1.0 : 0.0);

        ChiSquaredResult chiSquaredResult = new ChiSquaredResult(statsMap, setupTableData(), intervalsAmount);
        return chiSquaredResult;
    }

    public String[][] setupTableData() {
        String[][] tableData = new String[intervals.size()][6];
        int index = 0;
        for (ChiInterval chiInterval : intervals) {
            tableData[index] = chiInterval.getTableRow();
            index++;
        }
        return tableData;
    }

    public static void quickSort(List<Double> list, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end);

            quickSort(list, begin, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, end);
        }
    }

    private static int partition(List<Double> list, int begin, int end) {
        double pivot = list.get(end);
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (list.get(j) <= pivot) {
                i++;
                double swapTemp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swapTemp);
            }
        }

        double swapTemp = list.get(i + 1);
        list.set(i + 1, list.get(end));
        list.set(end, swapTemp);

        return i + 1;
    }

    private Double formatDouble(double value) {
        String valueString = String.valueOf(value);
        String decimalSide = valueString.split("\\.")[1];
        int remainingDecimals = 0;
        if(decimalSide.length() > 5) {
            remainingDecimals = decimalSide.length() - 5;
        }
        return Double.parseDouble(valueString.substring(0, valueString.length()-remainingDecimals));
    }
}
