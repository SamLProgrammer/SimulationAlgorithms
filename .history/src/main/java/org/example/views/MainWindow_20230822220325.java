package org.example.views;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

    public MainWindow() {
        initProperties();
        initComponents();
    }

    private void initProperties() {
        // this.setExtendedState(MAXIMIZED_BOTH);
        // this.setVisible(true);
        // this.setBackground(Color.blue);
        EventQueue.invokeLater(() -> {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);

            // Create a JPanel with blue background
            Color blueColor = new Color(0, 0, 255);
            this.getContentPane().setBackground(blueColor);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        });
    }

    private void initComponents() {
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setSize((int)width, (int)height);
    }
    
}
