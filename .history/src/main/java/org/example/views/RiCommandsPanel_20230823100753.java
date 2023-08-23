package org.example.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.controller.Controller;

public class RiCommandsPanel extends JPanel {

    private JButton submitGenerationButton;
    private JComboBox<String> algorithmChooserBox;
    private JButton button2;
    private Controller controller;
    private JTextField x0TextField;
    private JTextField kTextField;
    private JTextField cTextField;
    private JTextField gTextField;
    private JPanel statsContainer;
    private JPanel statsContainerCongruential;
    private JPanel statsContainerMiddleSquares;

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

        algorithmChooserBox = new JComboBox<String>(new String[] { "Middle Squares", "Congruential" });
        algorithmChooserBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.toString());
                System.out.println("==============================");
                switch (algorithmChooserBox.getSelectedItem().toString()) {
                    case "Congruential":
                        statsContainer.removeAll();
                        fillStatsPanelForCongruential();
                        statsContainer.updateUI();
                        break;
                        case "Middle Squares":
                        statsContainer.removeAll();
                        fillStatsPanelForMiddleSquares();
                        statsContainer.updateUI();
                        break;
                }
            }
        });

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        statsContainer = new JPanel();
        statsContainerCongruential = new JPanel(new GridLayout(1, 4, 10, 10));
        statsContainerMiddleSquares = new JPanel(new BorderLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 10;
        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.weightx = 1;

        add(algorithmChooserBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;

        add(statsContainer, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);

        add(submitGenerationButton, constraints);

    }

    private void fillStatsPanelForCongruential() {
        // JPanel x0Container = new JPanel(new BorderLayout());
        // JLabel x0Label = new JLabel("X0:");
        // x0TextField = new JTextField();
        // x0Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // x0Container.add(x0Label, BorderLayout.WEST);
        // x0Container.add(x0TextField);
        // statsContainerCongruential.add(x0Container);

        // JPanel cContainer = new JPanel(new BorderLayout());
        // JLabel cLabel = new JLabel("c:");
        // cLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // cTextField = new JTextField();
        // cContainer.add(cLabel, BorderLayout.WEST);
        // cContainer.add(cTextField);
        // statsContainerCongruential.add(cContainer);

        // JPanel kContainer = new JPanel(new BorderLayout());
        // JLabel kLabel = new JLabel("k:");
        // kLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // kTextField = new JTextField();
        // kContainer.add(kLabel, BorderLayout.WEST);
        // kContainer.add(kTextField);
        // statsContainerCongruential.add(kContainer);

        // JPanel gContainer = new JPanel(new BorderLayout());
        // JLabel gLabel = new JLabel("g:");
        // gLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        // gTextField = new JTextField();
        // gContainer.add(gLabel, BorderLayout.WEST);
        // gContainer.add(gTextField);
        // statsContainerCongruential.add(gContainer);
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        statsContainer.add(panel);
        statsContainer.add(statsContainerCongruential);
    }

    private void fillStatsPanelForMiddleSquares() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.green);
        statsContainer.add(panel);
        statsContainer.add(statsContainerMiddleSquares);
    }

    private RiCommandsPanel myInstance() {
        return this;
    }

    private void generateRandomNumbersList() {
        controller.generateWithMiddleSquare(198, "314157", 10);
    }


}
