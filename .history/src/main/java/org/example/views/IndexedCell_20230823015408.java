package org.example.views;

import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IndexedCell extends DefaultCellEditor{

    private JLabel indexLabel;
    private JLabel valueLabel;
    private int index;
    private String value;
    
    public IndexedCell(JTextField textField, int Index, String value) {
        super(textField);
        initProperties();
        initComponents(index, value);
        turnOn();
    }

    private void initProperties() {
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
