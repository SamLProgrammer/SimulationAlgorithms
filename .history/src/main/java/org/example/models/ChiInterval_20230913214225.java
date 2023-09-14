package org.example.models;

public class ChiInterval {
    private int index;
    private double start;
    private double end;
    private int ocurrences;
    private int expected;
    private double err;


    public String[] getTableRowValues() {
        String[] tableRow = {String.valueOf(index),
            String.valueOf(start),
            String.valueOf(end),
            String.valueOf(ocurrences),
            String.valueOf(expected),
            String.valueOf(err)};
            return tableRow;
    }


}
