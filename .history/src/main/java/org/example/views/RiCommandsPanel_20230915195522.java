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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
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
    private ArrayList<JTextField> toValidateFields;
    private JPanel submitButtonPanel;
    private JPanel statsContainer;
    private JPanel statsContainerCongruential;
    private JPanel statsContainerMiddleSquares;
    private boolean congruentialMode;

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
        congruentialMode = false;

        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        submitButtonPanel = new JPanel(new BorderLayout());
        submitGenerationButton = new JButton("Generate");
        submitGenerationButton.setEnabled(false);
        submitGenerationButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitGenerationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateRandomNumbersList();
            }
        });

        submitButtonPanel.add(submitGenerationButton);

        congruentialTypeBox = new JComboBox<String>(new String[] { "Linear", "Multiplicative", "Additive" });
        congruentialTypeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (congruentialTypeBox.getSelectedItem().toString()) {
                    case "Linear":
                        kTextField.setText(null);
                        kTextField.setEnabled(true);

                        cTextField.setText(null);
                        cTextField.setEnabled(true);
                        break;
                    case "Multiplicative":
                        cTextField.setText("0");
                        cTextField.setEnabled(false);

                        kTextField.setText(null);
                        kTextField.setEnabled(true);
                        break;
                    case "Additive":
                        kTextField.setText("1");
                        kTextField.setEnabled(false);

                        cTextField.setText(null);
                        cTextField.setEnabled(true);
                        break;
                }
            }
        });

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
                        congruentialMode = true;
                        break;
                        case "Middle Squares":
                        statsContainer.removeAll();
                        statsContainer.add(statsContainerMiddleSquares);
                        statsContainer.updateUI();
                        resetFontRecursively();
                        congruentialMode = false;
                        break;
                }
            }
        });

        button2 = new JButton("button 2");
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        statsContainer = new JPanel(new BorderLayout());
        statsContainerCongruential = new JPanel(new GridLayout(1, 5, 10, 10));
        statsContainerMiddleSquares = new JPanel(new GridLayout(1, 2, 20, 20));

        initJTextFields();
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

    private void initJTextFields() {
        toValidateFields = new ArrayList<>();
        x0TextField = new JTextField();
        kTextField = new JTextField();
        cTextField = new JTextField();
        gTextField = new JTextField();
        iTextField = new JTextField();
        seedTextField = new JTextField();
        nTextField = new JTextField();
        toValidateFields.add(x0TextField);
        toValidateFields.add(kTextField);
        toValidateFields.add(cTextField);
        toValidateFields.add(gTextField);
        toValidateFields.add(iTextField);
        toValidateFields.add(seedTextField);
        toValidateFields.add(nTextField);
    }

    private void resetFontRecursively() {
        setFontRecursively(myInstance(), new Font("Oswald", Font.BOLD, 20));
    }

    private void fillStatsPanelForCongruential() {
        JPanel x0Container = new JPanel(new BorderLayout());
        JLabel x0Label = new JLabel("X0:");
        x0Label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        x0Container.add(x0Label, BorderLayout.WEST);
        x0Container.add(x0TextField);
        statsContainerCongruential.add(x0Container);

        JPanel cContainer = new JPanel(new BorderLayout());
        JLabel cLabel = new JLabel("c:");
        cLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        cContainer.add(cLabel, BorderLayout.WEST);
        cContainer.add(cTextField);
        statsContainerCongruential.add(cContainer);

        JPanel kContainer = new JPanel(new BorderLayout());
        JLabel kLabel = new JLabel("k:");
        kLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        kContainer.add(kLabel, BorderLayout.WEST);
        kContainer.add(kTextField);
        statsContainerCongruential.add(kContainer);

        JPanel gContainer = new JPanel(new BorderLayout());
        JLabel gLabel = new JLabel("g:");
        gLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        gContainer.add(gLabel, BorderLayout.WEST);
        gContainer.add(gTextField);
        statsContainerCongruential.add(gContainer);

        JPanel iContainer = new JPanel(new BorderLayout());
        JLabel iLabel = new JLabel("n:");
        iLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
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
        seedContainer.add(seedLabel, BorderLayout.WEST);
        seedContainer.add(seedTextField);
        statsContainerMiddleSquares.add(seedContainer);

        JPanel nContainer = new JPanel(new BorderLayout());
        JLabel nLabel = new JLabel("n:");
        nLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
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
                        break;
                    case "Additive":
                        type = 'a';
                        break;
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
        setupTextFieldsListener();
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

    private void setupTextFieldsListener() {
        for (JTextField jTextField : toValidateFields) {
            jTextField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    this.getClass().getName();
                }
            });
        }
    }

    private boolean validateFieldsSet() {
        boolean valid = true;
        for (JTextField jTextField : toValidateFields) {
            boolean currentValid = isValidInteger(jTextField.getText().toString());
            jTextField.setBorder((currentValid) ? null : BorderFactory.createLineBorder(Color.RED, 2));
            valid = valid && currentValid;
        }
        return validateFieldsSet();
    }

    private boolean isValidInteger(String text) {
        return text.matches("^[+-]?\\d+$");
    }
}
