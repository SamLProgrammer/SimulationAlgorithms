package org.example.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        setLayout(new GridBagLayout());
    }

    private void initComponents() {
        submitGenerationButton = new JButton("Generate");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;

        add(submitGenerationButton,constraints);
    }
    
}
