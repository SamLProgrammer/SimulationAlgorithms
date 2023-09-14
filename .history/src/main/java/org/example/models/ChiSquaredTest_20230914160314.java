package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiSquaredTest {
    
    private ArrayList<ChiInterval> intervals;
    private int intervalsNumber;
    private double acceptanceError;
    private boolean result;
    private double min;
    private double max;
    private StatisticFunctions sf;
    private double chiInvTest;

    public ChiSquaredTest(StatisticFunctions sf) {
        this.sf = sf;
        initComponents();
    }

    private void initComponents() {
        intervals = new ArrayList<>();
    }

    public ChiSquaredResult executeTest(ArrayList<Double> randomNumbersList, int intervalsAmount, double acceptanceError) {
        double min = 1;
        double max = 0;

        for (Double currentNumber : randomNumbersList) {
            if(currentNumber < min) {
                min = currentNumber;
            }
            if(currentNumber > max) {
                max = currentNumber;
            }
        }
        double intervalWidth = max - min;
        for(int i = 0; i < intervalsAmount; i++) {
            intervals.add(new ChiInterval(i+1, min, min + intervalWidth * (i+1), randomNumbersList.size()/intervalsAmount));
        }

        quickSort(randomNumbersList, 0, randomNumbersList.size()-1);

        int ocurrences = 0;
        int index = 0;
        double totalError = 0;
        for (ChiInterval interval : intervals) {
            while(index < randomNumbersList.size()) {
                if(randomNumbersList.get(index) < interval.getEnd()) {
                    ocurrences ++;
                }
                index++;
            }
            interval.setOcurrences(ocurrences);
            totalError += interval.calculateError();
            ocurrences = 0;
        }

        chiInvTest = Double.valueOf(sf.getCHIInv(acceptanceError, intervalsAmount-1));

        Map<String, Double> statsMap = new HashMap<String, Double>();

        statsMap.put("max", max);
        statsMap.put("min", min);
        statsMap.put("chiInvTest", chiInvTest);
        statsMap.put("totalError", totalError);
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
}
