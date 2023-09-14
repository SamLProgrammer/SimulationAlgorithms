package org.example.models;

public class ChiInterval {

    private int index;
    private double start;
    private double end;
    private double ocurrences;
    private double expected;
    private double err;

    public ChiInterval(int index, double start, double end, double expected) {
        this.index = index;
        this.start = start;
        this.end = end;
        this.expected = expected;
    }

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
