package org.example.views;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import org.example.controller.Controller;

public class MainWindow extends JFrame{

    private MainTabbedPanel mainTabbedPanel;

    public MainWindow(Controller controller) {
        initProperties();
        initComponents(controller);
        turnOn();
    }

    private void initProperties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        initSize();
    }

    private void initSize() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setSize((int)width, (int)height);
    }

    private void initComponents(Controller controller) {
        mainTabbedPanel = new MainTabbedPanel(controller);
        add(mainTabbedPanel,BorderLayout.CENTER);
    }
    
    public void updateRiTableRows(String[][] tableData) {
        mainTabbedPanel.updateRiTableRows(tableData);
    }

    private void turnOn() {
        setVisible(true);
        printComponentClassNames(this);
    }

    private MainWindow myInstance() {
        return this;
    }

    private void printComponentClassNames(Component component) {
        if (component instanceof Container) {
            Component[] components = ((Container) component).getComponents();
            for (Component child : components) {
                // System.out.println(child.getClass().getSimpleName());
                if (child instanceof Container) {
                    printComponentClassNames(child);
                }
            }
        }
    }
}

