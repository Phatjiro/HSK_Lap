package thuchanh.tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NguyenVanPhat_19483821_50_bai1tuan2 extends JFrame implements ActionListener{
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JRadioButton rdbGioiTinh;
	private JButton btnTim;
	private JButton btnThem;
	private JTextField txtNhapSo;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private DefaultTableModel tableModel;
	private JTable table;

	public NguyenVanPhat_19483821_50_bai1tuan2() {
		this.setTitle("19483821_NguyenVanPhat_50");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// tao panel north
		JPanel pNor = new JPanel();
		
		JLabel lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTieuDe.setFont(new Font(lblTieuDe.getFont().getName(), Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);
		
		pNor.add(lblTieuDe);
		
		// tao panel center
		JPanel pCen = new JPanel();
		pCen.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		JLabel lblHo = new JLabel("Họ:");
		JLabel lblTen = new JLabel("Tên nhân viên:");
		JLabel lblTuoi = new JLabel("Tuổi:");
		JLabel lblGioiTinh = new JLabel("Phái:");
		JLabel lblTienLuong = new JLabel("Tiền lương:");
		
		txtMaNV = new JTextField();
		txtHo = new JTextField();
		txtTen = new JTextField();
		txtTuoi = new JTextField();
		txtTienLuong = new JTextField();
		rdbGioiTinh = new JRadioButton("Nữ");
		
		lblMaNV.setBounds(0,0,80,24);
		lblHo.setBounds(0,40,80,24);
		lblTen.setBounds(360,40,90,24);
		lblTuoi.setBounds(0,80,80,24);
		lblGioiTinh.setBounds(660,80,28,24);
		lblTienLuong.setBounds(0,120,80,24);
		
		txtMaNV.setBounds(90,0,680,24);
		txtHo.setBounds(90,40,260,24);
		txtTen.setBounds(460,40,310,24);
		txtTuoi.setBounds(90,80,560,24);
		txtTienLuong.setBounds(90,120,680,24);
		rdbGioiTinh.setBounds(730,80,70,24);
		
		pCen.add(lblMaNV);
		pCen.add(lblHo);
		pCen.add(lblTen);
		pCen.add(lblTuoi);
		pCen.add(lblGioiTinh);
		pCen.add(lblTienLuong);
		
		pCen.add(txtMaNV);
		pCen.add(txtHo);
		pCen.add(txtTen);
		pCen.add(txtTuoi);
		pCen.add(txtTienLuong);
		pCen.add(rdbGioiTinh);
		
		String[] header = {"Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane scTable = new JScrollPane(table);
		
		JComboBox cbGioiTinh = new JComboBox();
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		
		TableColumn col = table.getColumnModel().getColumn(3);
		col.setCellEditor(new DefaultCellEditor(cbGioiTinh));
		
		scTable.setBounds(0,160,788,300);
		table.setRowHeight(30);
		pCen.add(scTable);
		
		String[] row = {"111", "Nguyễn","Văn Phát", "Nam", "21", "100 triệu/3năm"};
		tableModel.addRow(row);
		
		// tao panel south
		JPanel pSouLeft = new JPanel();
		
		JLabel lblNhapSo = new JLabel("Nhập mã số cần tìm");
		txtNhapSo = new JTextField(14);
		btnTim = new JButton("Tìm");
		pSouLeft.add(lblNhapSo);
		pSouLeft.add(txtNhapSo);
		pSouLeft.add(btnTim);
		
		JPanel pSouRight = new JPanel();
		
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xoá trắng");
		btnXoa = new JButton("Xoá");
		btnLuu = new JButton("Lưu");
		pSouRight.add(btnThem);
		pSouRight.add(btnXoaTrang);
		pSouRight.add(btnXoa);
		pSouRight.add(btnLuu);
		
		JSplitPane pSou = new JSplitPane(SwingConstants.VERTICAL, pSouLeft, pSouRight);
		pSou.setOrientation(SwingConstants.VERTICAL);
		
		// add panel vao content
		this.add(pNor, BorderLayout.NORTH);
		this.add(pCen, BorderLayout.CENTER);
		this.add(pSou, BorderLayout.SOUTH);
		
		// dang ki lang nghe
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		rdbGioiTinh.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NguyenVanPhat_19483821_50_bai1tuan2().setVisible(true);
	}
	
	private String kiemTraGT() {
		if(rdbGioiTinh.isSelected()) {
			return "Nữ";
		}
		else {
			return "Nam";
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String[] row = {txtMaNV.getText(), txtHo.getText(), txtTen.getText(),
					txtTuoi.getText(), kiemTraGT(), txtTienLuong.getText()};
			tableModel.addRow(row);
		}
	}
}
