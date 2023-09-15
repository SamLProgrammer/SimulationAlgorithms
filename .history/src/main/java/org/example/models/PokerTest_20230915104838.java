package org.example.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PokerTest {

    private int onePair;
    private int twoPair;
    private int threeOfAKind;
    private int fullHouse;
    private int poker;
    private int quintet;
    private int allDifferent;
    private String[][] tableData;
    private StatisticFunctions sf;

    public PokerTest(StatisticFunctions statisticFunctions) {
        initComponents(statisticFunctions);
    }

    private void initComponents(StatisticFunctions statisticFunctions) {
        this.sf = statisticFunctions;
        initPokerRows();
        initCounters();
    }

    private void initPokerRows() {
        tableData = new String[7][5];
    }

    private void initCounters() {
    this.onePair = 0;
    this.twoPair = 0;
    this.threeOfAKind = 0;
    this.fullHouse = 0;
    this.poker = 0;
    this.quintet = 0;
    this.allDifferent = 0;
    }

    public PokerResult executeTest(ArrayList<Double> randomNumbersList, double acceptanceRate) {
        initPokerRows();
        initCounters();
        ArrayList<String> labeledData = new ArrayList<>();
        
        for (Double currentNumber : randomNumbersList) {
            int[] scoresArray = new int[10];
            String stringDecimal = takeDecimalPart(formatDouble(currentNumber));
            String currentLabeledData = (stringDecimal.length() < 5) ? String.valueOf(currentNumber) + "0" : String.valueOf(currentNumber);

            for (int i = 0; i < stringDecimal.length(); i++) {
                scoresArray[stringDecimal.charAt(i) - 48]++;
            }
            scoresArray[0] += stringDecimal.length() < 5 ? 1 : 0;

            boolean onePair = false;
            boolean twoPair = false;
            boolean threeOfAKind = false;
            boolean fullHouse = false;
            boolean poker = false;
            boolean quintet = false;

            for (int i : scoresArray) {
                System.out.print(i);
            }
            
            for (int i : scoresArray) {
                switch (i) {
                    case 2:
                        if (onePair) {
                            twoPair = true;
                            onePair = false;
                            System.out.println("Two Pair");
                        } else if (threeOfAKind) {
                            fullHouse = true;
                            onePair = false;
                            System.out.println("Full House 1");
                        } else {
                            onePair = true;
                            System.out.println("One Pair");
                        }
                        break;
                    case 3:
                        if (onePair) {
                            fullHouse = true;
                            onePair = false;
                            System.out.println("Full House 2");
                        } else {
                            threeOfAKind = true;
                            System.out.println("Three of A Kind");
                        }
                        break;
                    case 4:
                        threeOfAKind = false;
                        poker = true;
                        System.out.println("poker");
                        break;
                    case 5:
                        poker = false;
                        quintet = true;
                        System.out.println("penta");
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
            System.out.println();
        }

        fillPokerRows(randomNumbersList.size());
        double totalError = calculateTotalError();
        double maxError = Double.valueOf(sf.getCHIInv2(((100 - acceptanceRate) / 200), tableData.length-1));

        Map<String, Double> parametersMap = new HashMap<String, Double>();
        parametersMap.put("totalError", totalError);
        parametersMap.put("chiInv", maxError);
        parametersMap.put("result", totalError < maxError ? 1.0 : 0.0);

        return new PokerResult(parametersMap, tableData, labeledData);
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
        return String.valueOf(number).split("\\.")[1];
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
