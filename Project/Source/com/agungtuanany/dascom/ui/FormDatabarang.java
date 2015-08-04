package com.agungtuanany.dascom.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.agungtuanany.dascom.dao.Databarangdao;
import com.agungtuanany.dascom.model.Databarang;
import com.agungtuanany.dascom.tabelmodel.DatabarangTabelModel;
import com.agungtuanany.dascom.ui.input.JdialogDatabarang;



@SuppressWarnings("serial")
public class FormDatabarang extends JDialog {
	private JTable jtabledatabarang;
	private JTextField jtextiddatabarang;
	private JTextField jtextnamabarang;
	private JTextField jtextstok;
	private JTextField jtexthargajual;
	private JTextField jtexthargabeli;
	private JTextField jtextdeskripsi;
	private JTextField jtextketerangan;
	private JComboBox jcomboBoxsatuanukuran;
	private JTable jtableDatabarang;

	// membuat table supaya muncul kedalam jtableDatabarang

	private Databarangdao databarangDao;
	private DatabarangTabelModel databarangTabelModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDatabarang dialog = new FormDatabarang();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormDatabarang() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("DATA BARANG MANAGEMENT");
		setSize(582, 671);
		// setBounds(100, 100, 582, 671);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Data Barang Editor", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 139, 139)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(36, 20, 475, 341);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblIdDataBarang = new JLabel("Id Data Barang :");
		lblIdDataBarang.setBounds(22, 38, 116, 16);
		panel.add(lblIdDataBarang);

		jtextiddatabarang = new JTextField();
		jtextiddatabarang.setBounds(169, 32, 210, 28);
		panel.add(jtextiddatabarang);
		jtextiddatabarang.setColumns(10);

		JLabel lblNamaBarang = new JLabel("Nama Barang :");
		lblNamaBarang.setBounds(22, 72, 116, 16);
		panel.add(lblNamaBarang);

		jtextnamabarang = new JTextField();
		jtextnamabarang.setColumns(10);
		jtextnamabarang.setBounds(169, 66, 210, 28);
		panel.add(jtextnamabarang);

		JLabel lblStok = new JLabel("Stok :");
		lblStok.setBounds(22, 106, 116, 16);
		panel.add(lblStok);

		jtextstok = new JTextField();
		jtextstok.setColumns(10);
		jtextstok.setBounds(169, 100, 210, 28);
		panel.add(jtextstok);

		JLabel lblHargaJual = new JLabel("Harga Jual :");
		lblHargaJual.setBounds(22, 140, 116, 16);
		panel.add(lblHargaJual);

		jtexthargajual = new JTextField();
		jtexthargajual.setColumns(10);
		jtexthargajual.setBounds(169, 134, 210, 28);
		panel.add(jtexthargajual);

		JLabel lblHargaBeli = new JLabel("Harga Beli :");
		lblHargaBeli.setBounds(22, 174, 116, 16);
		panel.add(lblHargaBeli);

		jtexthargabeli = new JTextField();
		jtexthargabeli.setColumns(10);
		jtexthargabeli.setBounds(169, 168, 210, 28);
		panel.add(jtexthargabeli);

		JLabel lblSatuanUkuran = new JLabel("Satuan Ukuran :");
		lblSatuanUkuran.setBounds(22, 208, 116, 16);
		panel.add(lblSatuanUkuran);

		JLabel lblDeskripsi = new JLabel("Deskripsi :");
		lblDeskripsi.setBounds(22, 242, 116, 16);
		panel.add(lblDeskripsi);

		jtextdeskripsi = new JTextField();
		jtextdeskripsi.setColumns(10);
		jtextdeskripsi.setBounds(169, 236, 210, 28);
		panel.add(jtextdeskripsi);

		JLabel lblKeterangan = new JLabel("Keterangan :");
		lblKeterangan.setBounds(22, 276, 116, 16);
		panel.add(lblKeterangan);

		jtextketerangan = new JTextField();
		jtextketerangan.setColumns(10);
		jtextketerangan.setBounds(169, 270, 210, 28);
		panel.add(jtextketerangan);

		JComboBox jcomboBoxsatuanukuran = new JComboBox(new String[] { "UNIT", "PCS" });
		jcomboBoxsatuanukuran.getSelectedItem();
		jcomboBoxsatuanukuran.setBounds(169, 204, 210, 27);
		panel.add(jcomboBoxsatuanukuran);

		JButton jbtnAddNew = new JButton("Add New");
		jbtnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// menambahkan action dengan mengambil dari class
				// JdialogDatabarang
				// yang ada di System.out.PrintLine yang ada di
				// JdialogDatabarang.java

				JdialogDatabarang dialog = new JdialogDatabarang();
				dialog.setisUpdate(false);
				dialog.setVisible(true);
				databarangTabelModel.setItem(databarangDao.getAll());// 2

			}
		});
		jbtnAddNew.setBounds(24, 383, 100, 29);
		getContentPane().add(jbtnAddNew);

		JButton jbtnupdate = new JButton("Update");
		jbtnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JdialogDatabarang dialog = new JdialogDatabarang();
				dialog.setisUpdate(true);
				// dialog.setVisible(true);

				int row = jtabledatabarang.getSelectedRow();
				if (row == -1) { // ()row == -1;
					// belum milih
					JOptionPane.showMessageDialog(null, "Silahkan pilihlah data");
				} else {
					Databarang databarang = databarangTabelModel.getItem(row);
					dialog.setData(databarang);
					dialog.setVisible(true);
					databarangTabelModel.setItem(databarangDao.getAll());// 3
				}

			}
		});
		jbtnupdate.setBounds(124, 383, 100, 29);
		getContentPane().add(jbtnupdate);

		JButton jbtndelete = new JButton("Delete");
		jbtndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = jtabledatabarang.getSelectedRow();
				if (row == -1) { // ()row == -1;
					// belum milih
					JOptionPane.showMessageDialog(null, "Silahkan pilihlah data");
				} else {

					int result = JOptionPane.showConfirmDialog(null, "apakah anda yakin ingin mneghapus", "Konfirmasi",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						Databarang databarang = databarangTabelModel.getItem(row);
						databarangDao.delete(databarang);
						databarangTabelModel.setItem(databarangDao.getAll());// 4
					}

				}

			}
		});
		jbtndelete.setBounds(226, 383, 100, 29);
		getContentPane().add(jbtndelete);

		JButton jbtnprintAll = new JButton("Print All");
		jbtnprintAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtnprintAll.setBounds(325, 383, 100, 29);
		getContentPane().add(jbtnprintAll);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnClose.setBounds(442, 611, 117, 29);
		getContentPane().add(btnClose);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 434, 469, 155);
		getContentPane().add(scrollPane);

		jtableDatabarang = new JTable();
		scrollPane.setViewportView(jtableDatabarang);

		// instansiasi

		databarangDao = new Databarangdao();

		databarangTabelModel = new DatabarangTabelModel();

		// menghubungkan table dengan jtableDatabarang
		jtabledatabarang.setModel(databarangTabelModel);
		databarangTabelModel.setItem(databarangDao.getAll());// 1

	}
}
