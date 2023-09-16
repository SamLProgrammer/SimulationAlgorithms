package org.example.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.example.controller.Controller;


public class RiCommandsPanel extends JPanel {

    private JButton submitGenerationButton;
    private JComboBox<String> algorithmChooserBox;
    private JComboBox<String> congruentialTypeBox;
    private JButton button2;
    private Controller controller;
    private JTextField x0TextField;
    private JTextField kTextField;
    private JTextField cTextField;
    private JTextField gTextField;
    private JTextField iTextField;
    private JTextField seedTextField;
    private JTextField nTextField;
    private JTextField typeTextField;
    private JPanel submitButtonPanel;
    private JPanel statsContainer;
    private JPanel statsContainerCongruential;
    private JPanel statsContainerMiddleSquares;

    public RiCommandsPanel(Controller controller) {
        initProperties();
        initComponents(controller);
        setComponentListener();
    }

    private void initProperties() {
        setLayout(new GridBagLayout());
    }

    private void initComponents(Controller controller) {
        this.controller = controller;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitButtonPanel = new JPanel(new BorderLayout());
        submitGenerationButton = new JButton("Generate");
        submitGenerationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitGenerationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandomNumbersList();
            }
        });

        submitButtonPanel.add(submitGenerationButton);

        congruentialTypeBox = new JComboBox<String>(new String[] { "Linear", "Multiplicative", "Additive" });

        algorithmChooserBox = new JComboBox<String>(new String[] { "Middle Squares", "Congruential" });
        algorithmChooserBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (algorithmChooserBox.getSelectedItem().toString()) {
                    case "Congruential":
                        statsContainer.removeAll();
                        statsContainer.add(statsContainerCongruential);
                        statsContainer.updateUI();
                        resetFontRecursively();
                        break;
                    case "Middle Squares":
                        statsContainer.removeAll();
                        statsContainer.add(statsContainerMiddleSquares);
                        statsContainer.updateUI();
                        resetFontRecursively();
                        break;
                }
            }
        });

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        statsContainer = new JPanel(new BorderLayout());
        statsContainerCongruential = new JPanel(new GridLayout(1, 5, 10, 10));
        statsContainerMiddleSquares = new JPanel(new GridLayout(1, 2, 20, 20));

        fillStatsPanelForCongruential();
        fillStatsPanelForMiddleSquares();
        statsContainer.add(statsContainerMiddleSquares);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.1;
        add(algorithmChooserBox, constraints);

        constraints.weightx = 0.8;
        add(statsContainer, constraints);

        constraints.weightx = 0.1;
        add(submitButtonPanel, constraints);

        resetFontRecursively();
    }

    private void resetFontRecursively() {
        setFontRecursively(myInstance(), new Font("Oswald", Font.BOLD, 20));
    }

    private void fillStatsPanelForCongruential() {
        JPanel x0Container = new JPanel(new BorderLayout());
        JLabel x0Label = new JLabel("X0:");
        x0TextField = new JTextField();
        x0Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        x0Container.add(x0Label, BorderLayout.WEST);
        x0Container.add(x0TextField);
        statsContainerCongruential.add(x0Container);

        JPanel cContainer = new JPanel(new BorderLayout());
        JLabel cLabel = new JLabel("c:");
        cLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        cTextField = new JTextField();
        cContainer.add(cLabel, BorderLayout.WEST);
        cContainer.add(cTextField);
        statsContainerCongruential.add(cContainer);

        JPanel kContainer = new JPanel(new BorderLayout());
        JLabel kLabel = new JLabel("k:");
        kLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        kTextField = new JTextField();
        kContainer.add(kLabel, BorderLayout.WEST);
        kContainer.add(kTextField);
        statsContainerCongruential.add(kContainer);

        JPanel gContainer = new JPanel(new BorderLayout());
        JLabel gLabel = new JLabel("g:");
        gLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        gTextField = new JTextField();
        gContainer.add(gLabel, BorderLayout.WEST);
        gContainer.add(gTextField);
        statsContainerCongruential.add(gContainer);

        JPanel iContainer = new JPanel(new BorderLayout());
        JLabel iLabel = new JLabel("n:");
        iLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        iTextField = new JTextField();
        iContainer.add(iLabel, BorderLayout.WEST);
        iContainer.add(iTextField);
        statsContainerCongruential.add(iContainer);

        JPanel typeContainer = new JPanel(new BorderLayout());
        JLabel typeLabel = new JLabel("type");
        typeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        typeContainer.add(typeLabel, BorderLayout.WEST);
        typeContainer.add(congruentialTypeBox);
        statsContainerCongruential.add(typeContainer);
    }

    private void fillStatsPanelForMiddleSquares() {
        JPanel seedContainer = new JPanel(new BorderLayout());
        JLabel seedLabel = new JLabel("seed:");
        seedLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        seedTextField = new JTextField();
        seedContainer.add(seedLabel, BorderLayout.WEST);
        seedContainer.add(seedTextField);
        statsContainerMiddleSquares.add(seedContainer);

        JPanel nContainer = new JPanel(new BorderLayout());
        JLabel nLabel = new JLabel("n:");
        nLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        nTextField = new JTextField();
        nContainer.add(nLabel, BorderLayout.WEST);
        nContainer.add(nTextField);
        statsContainerMiddleSquares.add(nContainer);
    }

    public static void setFontRecursively(Component component, Font font) {
        if (component instanceof JComponent) {
            ((JComponent) component).setFont(font);
        }

        if (component instanceof Container) {
            Component[] children = ((Container) component).getComponents();
            for (Component child : children) {
                setFontRecursively(child, font);
            }
        }
    }

    private RiCommandsPanel myInstance() {
        return this;
    }

    private void generateRandomNumbersList() {
        switch (algorithmChooserBox.getSelectedItem().toString()) {
            case "Middle Squares":
                controller.generateWithMiddleSquare(Integer.valueOf(nTextField.getText()), seedTextField.getText(), 10);
                break;
            case "Congruential":
            char type = 'l';
            switch (congruentialTypeBox.getSelectedItem().toString()) {
                case "Multiplicative": 
                type = 'm';
                case "Additive":
                type = 'a';
                }
                controller.generateWithCongruent(Integer.valueOf(x0TextField.getText()),
                        Integer.valueOf(kTextField.getText()),
                        Integer.valueOf(cTextField.getText()),
                        Integer.valueOf(gTextField.getText()),
                        Integer.valueOf(iTextField.getText()),
                        type, 10);
                break;
        }
    }

    private void setComponentListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int margin = (int) (getWidth() * 0.02);
                int outterMargin = (int) (getWidth() * 0.01);
                statsContainer.setBorder(BorderFactory.createEmptyBorder(0, margin, 0, margin));
                algorithmChooserBox.setBorder(BorderFactory.createEmptyBorder(0, outterMargin, 0, outterMargin));
                submitButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, outterMargin, 0, outterMargin));
            }
        });
    }
}
