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
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    private void initComponents() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }
    
}
