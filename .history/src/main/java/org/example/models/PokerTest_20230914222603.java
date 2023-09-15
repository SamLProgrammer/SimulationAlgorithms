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
    private String[][] tableData;

    public PokerTest() {
        initComponents();
    }

    private void initComponents() {
        initPokerRows();
    }

    private void initPokerRows() {
        tableData = new String[7][5];
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
        PokerRow allDifferentRow = new PokerRow("Different", allDifferent, 0.3024, 0.3024*n);
        tableData[0] = allDifferentRow.getTableRow();

        PokerRow onePairRow = new PokerRow("One Pair", onePair, 0.504, 0.504*n);
        tableData[1] = onePairRow.getTableRow();

        PokerRow twoPairRow = new PokerRow("Two Pairs", twoPair, 0.108, 0.108*n);
        tableData[2] = twoPairRow.getTableRow();

        PokerRow threeOfAKindRow = new PokerRow("Three Of A Kind", threeOfAKind, 0.072, 0.072*n);
        tableData[3] = threeOfAKindRow.getTableRow();

        PokerRow fullHouseRow = new PokerRow("Full House", fullHouse, 0.009, 0.009*n);
        tableData[4] = fullHouseRow.getTableRow();

        PokerRow pokerRow = new PokerRow("Poker", poker, 0.0045, 0.0045*n);
        tableData[5] = pokerRow.getTableRow();

        PokerRow quintetRow = new PokerRow("Quintet", quintet, 0.0001, 0.0001*n);
        tableData[6] = quintetRow.getTableRow();
    }

    private double calculateTotalError() {
        double totalError = 0;
        for (String[] strings : tableData) {
            totalError += Double.valueOf(strings[strings.length-1]);
        }
        return totalError;
    }

    private String takeDecimalPart(double number) {
        return String.valueOf(number).split(".")[1];
    }
}
