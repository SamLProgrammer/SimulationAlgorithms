package org.example.views;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ModuleLayer.Controller;

public class ChiSquareTestPanel extends JPanel {

    private Controller controller;

    public ChiSquareTestPanel(Controller controller) {
        initProperties();
        initComponents(controller);
    }

    private void initProperties() {

    }

    private void initComponents(Controller controller) {
        this.controller = controller;
        JButton testButton = new JButton("Chi Test");
        testButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent aEv) {
                controller.invokeChiSquaredTest(0.05);
            }

        });
        add(testButton);
    }
}
