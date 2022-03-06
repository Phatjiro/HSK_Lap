package com.laptrinh;

import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TestJTable extends JFrame{
	private DefaultTableModel tableModel;
	private JTable table;

	public TestJTable() {
		this.setTitle("Test JTable");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pCen = new JPanel();
		
		String[] header = {"Tên","Tuổi","Giới Tính"};
		String[] row = {"Nguyễn Văn Phát","21","Nam"};
		
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		pCen.add(new JScrollPane(table));
		
		DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
		rendar.setHorizontalAlignment(JLabel.RIGHT);
		
		tableModel.addRow(row);
		table.getColumnModel().getColumn(0).setCellRenderer(rendar);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.addItem("Nam");
		cbbGioiTinh.addItem("Nữ");
		
		TableColumn col = table.getColumnModel().getColumn(2);
		col.setCellEditor(new DefaultCellEditor(cbbGioiTinh));
		
		// add panel vao content
		this.add(pCen);
	}
	
	public static void main(String[] args) {
		new TestJTable().setVisible(true);
	}
}
