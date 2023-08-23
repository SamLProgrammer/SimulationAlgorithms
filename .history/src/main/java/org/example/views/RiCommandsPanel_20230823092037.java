package org.example.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel statsContainer = new JPanel(new GridLayout(1, 4, 10, 10));

        JPanel x0Container = new JPanel(new BorderLayout());
        JLabel x0Label = new JLabel("X0:");
        x0Label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        x0TextField = new JTextField();
        x0Container.add(x0Label, BorderLayout.WEST);
        x0Container.add(x0TextField);
        statsContainer.add(x0Container);

        JPanel cContainer = new JPanel(new BorderLayout());
        JLabel cLabel = new JLabel("c:");
        cLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        cTextField = new JTextField();
        cContainer.add(cLabel, BorderLayout.WEST);
        cContainer.add(cTextField);
        statsContainer.add(cContainer);

        JPanel kContainer = new JPanel(new BorderLayout());
        JLabel kLabel = new JLabel("k:");
        kLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        kTextField = new JTextField();
        kContainer.add(kLabel, BorderLayout.WEST);
        kContainer.add(kTextField);
        statsContainer.add(kContainer);

        JPanel gContainer = new JPanel(new BorderLayout());
        JLabel gLabel = new JLabel("g:");
        gLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        gTextField = new JTextField();
        gContainer.add(gLabel, BorderLayout.WEST);
        gContainer.add(gTextField);
        statsContainer.add(gContainer);

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

    private RiCommandsPanel myInstance() {
        return this;
    }

    private void generateRandomNumbersList() {
        controller.generateWithMiddleSquare(198, "314157", 10);
    }
}
