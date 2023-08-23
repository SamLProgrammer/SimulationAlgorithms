package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

import org.example.controller.Controller;

public class MainWindow extends JFrame{

    private MainTabbedPanel mainTabbedPanel;

    public MainWindow(Controller controller) {
        initProperties();
        initComponents();
        turnOn();
    }

    private void initProperties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.blue);
        initSize();
    }

    private void initSize() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize((int)width, (int)height);
    }

    private void initComponents() {
        mainTabbedPanel = new MainTabbedPanel();
        add(mainTabbedPanel,BorderLayout.CENTER);
    }
    
    public void updateRiTableRows(String[][] tableData) {
        mainTabbedPanel.updateRiTableRows(tableData);
    }

    private void turnOn() {
        setVisible(true);
    }
}

