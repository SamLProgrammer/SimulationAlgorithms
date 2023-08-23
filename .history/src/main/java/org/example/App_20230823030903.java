package org.example;

// import java.util.ArrayList;

// import org.example.controller.Controller;
// import org.example.models.Congruent;
// import org.example.models.MiddleSquare;
// import org.example.models.StatisticFunctions;

// public class App {

//     public static void main(String[] args) {
//         // StatisticFunctions sf = new StatisticFunctions();
//         // MiddleSquare ms = new MiddleSquare();
//         // Congruent cg = new Congruent();
//         // // ArrayList<Double> uniformNumbersList = ms.fecadeStartSquaresGeneration(20, "7351");
//         // ArrayList<Double> uniformNumbersList = cg.fecadeStartCongruentGeneration(6, 8, 5, 10, 50, 'l');
//         // printArrayList(uniformNumbersList);

//         new Controller();

//     }

//     public static void printArrayList(ArrayList<Double> arrayList) {
//         for (Double double1 : arrayList) {
//             System.out.println(double1);
//         }
//     }

    
// }

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dynamic Custom Panel Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[][] initialData = {
                    {"A", "B", "C"},
                    {"D", "E", "F"},
                    {"G", "H", "I"}
            };

            JTable table = new JTable(new CustomTableModel(initialData));

            // Set custom renderer for the JPanel cell
            table.setDefaultRenderer(JPanel.class, new JPanelCellRenderer());

            JButton updateButton = new JButton("Update Table");
            updateButton.addActionListener(e -> {
                String[][] newData = {
                        {"One", "Two", "Three"},
                        {"Four", "Five", "Six"},
                        {"Seven", "Eight", "Nine"}
                };
                ((CustomTableModel) table.getModel()).updateData(newData);
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(updateButton);

            JPanel mainPanel = new JPanel(new GridLayout(1, 2));
            mainPanel.add(new JScrollPane(table));
            mainPanel.add(buttonPanel);

            frame.add(mainPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

class CustomTableModel extends AbstractTableModel {
    private String[][] data;

    public CustomTableModel(String[][] data) {
        this.data = data;
    }

    public void updateData(String[][] newData) {
        this.data = newData;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return JPanel.class;
    }
}

class JPanelCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JLabel indexLabel = new JLabel((row * table.getColumnCount() + column) + "");
        JLabel valueLabel = new JLabel(value.toString());

        Font largerFont = valueLabel.getFont().deriveFont(Font.BOLD, valueLabel.getFont().getSize());
        indexLabel.setFont(largerFont);
        valueLabel.setFont(largerFont);

        panel.add(indexLabel);
        panel.add(valueLabel);


        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }

        return panel;
    }
}