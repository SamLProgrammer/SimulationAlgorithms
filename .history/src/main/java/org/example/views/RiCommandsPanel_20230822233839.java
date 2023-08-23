package org.example.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RiCommandsPanel extends JPanel{

    private JButton submitGenerationButton;

    public RiCommandsPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setLayout(new GridLayout(6, 6));
    }

    private void initComponents() {
        submitGenerationButton = new JButton("Generate");
        add(submitGenerationButton);
    }
    
}
