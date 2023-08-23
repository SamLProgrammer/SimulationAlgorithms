package org.example.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RiCommandsPanel extends JPanel{

    private JButton submitGenerationButton;
    private JButton button1;
    private JButton button2;

    public RiCommandsPanel() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents() {
        submitGenerationButton = new JButton("Generate");
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.wei

        
        add(submitGenerationButton,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;

        add(button1,constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;

        add(button2,constraints);

    }
    
}
