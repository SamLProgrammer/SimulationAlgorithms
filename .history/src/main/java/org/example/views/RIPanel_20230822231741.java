package org.example.views;

import java.util.Random;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class RIPanel extends JPanel {

    private TablePanel tablePanel;

    public RIPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {

    }

    private void initComponents() {
        tablePanel = new TablePanel();
        add(tablePanel);
        String[][] testTableDataMatrix = new String[3][3];
        String[] words = {
                "apple", "banana", "cherry", "grape", "orange",
                "pear", "pineapple", "strawberry", "watermelon"
        };

        // Create a Random object
        Random random = new Random();

        // Fill the matrix with random words
        for (int i = 0; i < testTableDataMatrix.length; i++) {
            for (int j = 0; j < testTableDataMatrix[i].length; j++) {
                int index = random.nextInt(words.length);
                testTableDataMatrix[i][j] = words[index];
            }
        }

        tablePanel.updateRowsTable(testTableDataMatrix);
        repaint();
    }

}
