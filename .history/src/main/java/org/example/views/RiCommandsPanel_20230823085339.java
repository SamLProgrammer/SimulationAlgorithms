package org.example.views;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.example.controller.Controller;


public class RiCommandsPanel extends JPanel{

    private JButton submitGenerationButton;
    private JComboBox algorithmChooserBox;
    private JButton button2;
    private Controller controller;

    public RiCommandsPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;


        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitGenerationButton = new JButton("Generate");
        submitGenerationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitGenerationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandomNumbersList();
            }
        });

        algorithmChooserBox = new JComboBox<String>(new String[]{"Middle Squares", "Congruential"});

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 10;
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.weightx = 1;

        
        add(algorithmChooserBox,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;

        add(button2,constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);

        add(submitGenerationButton,constraints);

    }

    private RiCommandsPanel myInstance() {
        return this;
    }
    
    private void generateRandomNumbersList() {
        controller.generateWithMiddleSquare(198, "314157", 10);
    }
}
