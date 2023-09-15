package org.example;

import org.example.controller.Controller;

public class App {

    public static void main(String[] args) {

        Controller c = new Controller();
        c.generateWithCongruent(83, 151, 251, 11, 15, 'm', 5);
        c.invokePokerTest(95).getParametersMap();
        String[][] tableData = c.invokePokerTest(95).getpokerTableData();

        for(int i = 0; i < tableData.length; i++) {
            for(int j = 0; j < tableData[0].length; j++) {
                System.out.print(tableData[i][j] + ' ');
            }
            System.out.println();
        }
    }
}
