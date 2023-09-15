package org.example.models;

import java.util.ArrayList;

public class PokerTest {

    private int onePair;
    private int twoPair;
    private int threeOfAKind;
    private int fullHouse;
    private int poker;
    private int quintet;

    // 89724
    public boolean executeTest(ArrayList<Double> randomNumbersList, double acceptanceRate) {
        int[] scoresArray = new int[10];

        for (Double currentNumber : randomNumbersList) {
            String stringDecimal = takeDecimalPart(currentNumber);
            for (int i = 0; i < stringDecimal.length(); i++) {
                scoresArray[stringDecimal.charAt(i)]++;
            }

            boolean onePair;
            boolean twoPair;
            boolean threeOfAKind;
            boolean fullHouse;
            boolean poker;
            boolean quintet;
            
            for (int i : scoresArray) {
                switch (i) {
                    case 2:
                        if (onePair) {
                            twoPair = true;
                            onePair = false;
                        } else if (threeOfAKind) {
                            fullHouse = true;
                            onePair = false;
                        } else {
                            onePair = true;
                        }
                        break;
                    case 3:
                        if (onePair) {
                            fullHouse = true;
                            onePair = false;
                        } else {
                            threeOfAKind = true;
                        }
                        break;
                    case 4:
                        poker = true;
                        break;
                    case 5:
                        quintet = true;
                        break;
                }
            }
            // scoresArray = new int[10];
        }

        return true;
    }

    private String takeDecimalPart(double number) {
        return String.valueOf(number).split(".")[1];
    }
}
