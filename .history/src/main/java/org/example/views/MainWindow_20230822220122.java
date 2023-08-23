package org.example.views;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

    public MainWindow() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        this.setBackground(Color.blue);
        this.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void initComponents() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }
    
}
