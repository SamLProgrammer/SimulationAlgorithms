package org.example.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
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
    private JTextField iTextField;
    private JTextField seedTextField;
    private JPanel statsContainer;
    private JPanel statsContainerCongruential;
    private JPanel statsContainerMiddleSquares;

    public RiCommandsPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {
        setLayout(new GridLayout(1, 3, 10, 10));
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
                switch (algorithmChooserBox.getSelectedItem().toString()) {
                    case "Congruential":
                        statsContainer.removeAll();
                        statsContainer.add(statsContainerCongruential);
                        System.out.println(statsContainerCongruential.getLayout().getClass());
                        statsContainer.updateUI();
                        break;
                        case "Middle Squares":
                        statsContainer.removeAll();
                        statsContainer.add(statsContainerMiddleSquares);
                        statsContainer.updateUI();
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

        add(algorithmChooserBox);

        add(statsContainer);

        add(submitGenerationButton);

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
    }

    private void fillStatsPanelForMiddleSquares() {
        JPanel seedContainer = new JPanel(new BorderLayout());
        JLabel seedLabel = new JLabel("seed:");
        seedLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        seedTextField = new JTextField();
        seedContainer.add(seedLabel, BorderLayout.WEST);
        seedContainer.add(gTextField);
        statsContainerMiddleSquares.add(seedContainer);

        JPanel iContainer = new JPanel(new BorderLayout());
        JLabel iLabel = new JLabel("n:");
        iLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        iTextField = new JTextField();
        iContainer.add(iLabel, BorderLayout.WEST);
        iContainer.add(iTextField);
        statsContainerMiddleSquares.add(iContainer);

    }

    private RiCommandsPanel myInstance() {
        return this;
    }

    private void generateRandomNumbersList() {
        controller.generateWithMiddleSquare(198, "314157", 10);
    }


}
