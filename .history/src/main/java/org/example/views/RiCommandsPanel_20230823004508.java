package org.example.views;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
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
        
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitGenerationButton = new JButton("Generate");
        submitGenerationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitGenerationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Button clicked!");
            }
        });

        button1 = new JButton("button 1");
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 10;
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.weightx = 1;

        
        add(submitGenerationButton,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;

        add(button1,constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);

        add(button2,constraints);

    }

    private RiCommandsPanel myInstance() {
        return this;
    }
    
}
