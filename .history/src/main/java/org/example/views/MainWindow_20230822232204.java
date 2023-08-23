package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

    private MainTabbedPanel mainTabbedPanel;

    public MainWindow() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.blue);
        initSize();
    }

    private void initSize() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }

    private void initComponents() {
        mainTabbedPanel = new MainTabbedPanel();
        add(mainTabbedPanel,BorderLayout.CENTER);
    }
    
    public void updateRiTableRows(String[][] tableData) {
        mainTabbedPanel.updateRiTableRows(tableData);
    }
}
