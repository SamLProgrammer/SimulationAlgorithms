package org.example.models;

import java.util.ArrayList;

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
    }
}
