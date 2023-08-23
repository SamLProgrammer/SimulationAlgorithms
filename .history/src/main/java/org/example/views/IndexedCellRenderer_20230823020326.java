package org.example.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class IndexedCellRenderer extends IndexedCell implements TableCellRenderer{
    /**
     *
     * @param color
     */
    public IndexedCellRenderer() {
        super(UNDEFINED_CONDITION, TOOL_TIP_TEXT_KEY);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
                setValue("I dont know");
		return this;
	}
}