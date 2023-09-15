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
    private PokerRow[] pokerRows;

    public PokerTest() {
        initComponents();
    }

    private void initComponents() {
        initPokerRows();
    }

    private void initPokerRows() {
        pokerRows = new PokerRow[7];
    }

    public boolean executeTest(ArrayList<Double> randomNumbersList, double acceptanceRate) {
        initPokerRows();
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
        fillPokerRows(randomNumbersList.size());
        return true;
    }

    private void fillPokerRows(int n) {
        pokerRows[0] = new PokerRow("Different", allDifferent, 0.3024, 0.3024*n);
        pokerRows[1] = new PokerRow("One Pair", onePair, 0.504, 0.3024*n);
        pokerRows[2] = new PokerRow("Two Pairs", twoPair, 0.108, 0.3024*n);
        pokerRows[3] = new PokerRow("Three Of A Kind", threeOfAKind, 0.072, 0.3024*n);
        pokerRows[4] = new PokerRow("Full House", fullHouse, 0.009, 0.3024*n);
        pokerRows[5] = new PokerRow("Poker", poker, 0.0045, 0.3024*n);
        pokerRows[6] = new PokerRow("Quintet", quintet, 0.0001, 0.3024*n);
    }

    private String takeDecimalPart(double number) {
        return String.valueOf(number).split(".")[1];
    }
}
