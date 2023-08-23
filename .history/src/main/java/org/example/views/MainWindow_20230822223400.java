package org.example.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

    public MainWindow() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.blue);
    }

    private void initComponents() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }
    
}
