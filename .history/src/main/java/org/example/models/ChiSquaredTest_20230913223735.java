package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class ChiSquaredTest {
    
    private ArrayList<ChiInterval> intervals;
    private int intervalsNumber;
    private double acceptanceError;
    private boolean result;
    private double min;
    private double max;


    public boolean executeTest(ArrayList<Double> randomNumbersList, int intervalsAmount) {
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

        quickSort(randomNumbersList, 0, randomNumbersList.size());

        for (ChiInterval interval : intervals) {

        }
    }

    public void quickSort(List<Double> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);
            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    private int partition(List<Double> list, int low, int high) {
        double pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Double> list, int i, int j) {
        double temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
