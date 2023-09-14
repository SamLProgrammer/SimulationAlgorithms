package org.example.models;

public class ChiInterval {

    private int index;
    private double start;
    private double end;
    private double ocurrences;
    private double expected;
    private double err;

    public String[] getTableRow() {

        String[] tableRow = {String.valueOf(index),
            String.valueOf(start),
            String.valueOf(end),
            String.valueOf(ocurrences),
            String.valueOf(expected),
            String.valueOf(err)};
            return tableRow;
    }
}
