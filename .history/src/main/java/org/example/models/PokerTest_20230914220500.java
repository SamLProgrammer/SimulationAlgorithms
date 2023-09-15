package org.example.models;

import java.util.ArrayList;

public class PokerTest {

    private int onePair;
    private int twoPair;
    private int threeOfAKind;
    private int fullHouse;
    private int poker;
    private int quintet;
    private int allDifferent;
    private ArrayList<PokerRow> pokerRows;

    // 89724
    public boolean executeTest(ArrayList<Double> randomNumbersList, double acceptanceRate) {
        pokerRows = new ArrayList<>();
        int[] scoresArray = new int[10];

        for (Double currentNumber : randomNumbersList) {
            String stringDecimal = takeDecimalPart(currentNumber);
            for (int i = 0; i < stringDecimal.length(); i++) {
                scoresArray[stringDecimal.charAt(i)]++;
            }

            boolean onePair = false;
            boolean twoPair = false;
            boolean threeOfAKind = false;
            boolean fullHouse = false;
            boolean poker = false;
            boolean quintet = false;

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

            if (onePair) {
                this.onePair++;
            } else if (twoPair) {
                this.twoPair++;
            } else if (threeOfAKind) {
                this.threeOfAKind++;
            } else if (fullHouse) {
                this.fullHouse++;
            } else if (poker) {
                this.poker++;
            } else if (quintet) {
                this.quintet++;
            } else {
                this.allDifferent++;
            }
            scoresArray = new int[10];
        }
        
        return true;
    }

    private String takeDecimalPart(double number) {
        return String.valueOf(number).split(".")[1];
    }
}
