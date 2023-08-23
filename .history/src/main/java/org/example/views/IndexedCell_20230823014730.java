package org.example.views;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class IndexedCell extends JComponent{

    private JLabel indexLabel;
    private JLabel valueLabel;
    private int index;
    private String value;
    
    public IndexedCell(int index, String value) {
        initProperties();
        initComponents(index, value);
        turnOn();
    }

    public IndexedCell() {
        
    }

    private void initProperties() {
        setLayout(new BorderLayout());
    }

    private void initComponents(int index, String value) {
        this.index = index;
        this.value = value;
        indexLabel = new JLabel(String.valueOf(index));
        valueLabel = new JLabel(value);

        add(indexLabel, BorderLayout.WEST);
        add(valueLabel);
    }

    private void turnOn() {
        setVisible(true);
    }
}
