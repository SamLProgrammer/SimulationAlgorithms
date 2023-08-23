package org.example.views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

public class IndexedCellEditor extends DefaultCellEditor {

	protected IndexedCell indexedCell;
	private String lbl;
	private boolean clicked;
	
	public IndexedCellEditor(JTextField textField, int index, String value) {
		super(textField);
		indexedCell = new IndexedCell();
		indexedCell.setBackground(Color.black);

	}
	public IndexedCell getindexedCell() {
		return indexedCell;
	}
	public void setindexedCell(IndexedCell indexedCell) {
		this.indexedCell = indexedCell;
	}
        
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		lbl = (value == null) ? "" : value.toString();
		// indexedCell.setText(lbl);
		clicked = true;
		return indexedCell;
	}

	@Override
	public Object getCellEditorValue() {
		clicked = false;
		return new String(lbl);
	}

	@Override
	public boolean stopCellEditing() {
		clicked = false;

		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
	
	public boolean isClicked() {
		return clicked;
	}
}
