package com.agungtuanany.dascom.ui.input;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.agungtuanany.dascom.dao.Databarangdao;
import com.agungtuanany.dascom.model.Databarang;

public class JdialogDatabarang extends JDialog {
	private JTextField jtextidDatabarang;
	private JTextField jtextNamabarang;
	private JTextField jtextStok;
	private JTextField jtextHargajual;
	private JTextField jtextHargabeli;
	private JTextField jtextDeskripsi;
	private JTextField jtextKeterangan;
	private JComboBox comboBox;

	// add some field
	private boolean isUpdate;

	private Databarangdao databarangdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogDatabarang dialog = new JdialogDatabarang();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setisUpdate(boolean isUpdate) {
		// this merefer ke screeninput
		this.isUpdate = isUpdate;
		if (isUpdate) {
			setTitle("Update Data Lama");
			jtextidDatabarang.setEnabled(false);
		} else {
			setTitle("Buat Data Baru");
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogDatabarang() {
		setBounds(100, 100, 502, 419);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveData();
						dispose();
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Data Barang Editor", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(0, 139, 139)));
			panel.setBackground(Color.WHITE);
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JLabel label = new JLabel("Id Data Barang :");
				label.setBounds(22, 38, 116, 16);
				panel.add(label);
			}
			{
				jtextidDatabarang = new JTextField();
				jtextidDatabarang.setColumns(10);
				jtextidDatabarang.setBounds(169, 32, 210, 28);
				panel.add(jtextidDatabarang);
			}
			{
				JLabel label = new JLabel("Nama Barang :");
				label.setBounds(22, 72, 116, 16);
				panel.add(label);
			}
			{
				jtextNamabarang = new JTextField();
				jtextNamabarang.setColumns(10);
				jtextNamabarang.setBounds(169, 66, 210, 28);
				panel.add(jtextNamabarang);
			}
			{
				JLabel label = new JLabel("Stok :");
				label.setBounds(22, 106, 116, 16);
				panel.add(label);
			}
			{
				jtextStok = new JTextField();
				jtextStok.setColumns(10);
				jtextStok.setBounds(169, 100, 210, 28);
				panel.add(jtextStok);
			}
			{
				JLabel label = new JLabel("Harga Jual :");
				label.setBounds(22, 140, 116, 16);
				panel.add(label);
			}
			{
				jtextHargajual = new JTextField();
				jtextHargajual.setColumns(10);
				jtextHargajual.setBounds(169, 134, 210, 28);
				panel.add(jtextHargajual);
			}
			{
				JLabel label = new JLabel("Harga Beli :");
				label.setBounds(22, 174, 116, 16);
				panel.add(label);
			}
			{
				jtextHargabeli = new JTextField();
				jtextHargabeli.setColumns(10);
				jtextHargabeli.setBounds(169, 168, 210, 28);
				panel.add(jtextHargabeli);
			}
			{
				JLabel label = new JLabel("Satuan Ukuran :");
				label.setBounds(22, 208, 116, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Deskripsi :");
				label.setBounds(22, 242, 116, 16);
				panel.add(label);
			}
			{
				jtextDeskripsi = new JTextField();
				jtextDeskripsi.setColumns(10);
				jtextDeskripsi.setBounds(169, 236, 210, 28);
				panel.add(jtextDeskripsi);
			}
			{
				JLabel label = new JLabel("Keterangan :");
				label.setBounds(22, 276, 116, 16);
				panel.add(label);
			}
			{
				jtextKeterangan = new JTextField();
				jtextKeterangan.setColumns(10);
				jtextKeterangan.setBounds(169, 270, 210, 28);
				panel.add(jtextKeterangan);
			}
			{
				comboBox = new JComboBox(new Object[] { "Unit", "Pcs" });
				comboBox.setBounds(169, 204, 210, 27);
				panel.add(comboBox);
			}
		}
	}

	public void saveData() {
		Databarang databarang = new Databarang();
		jtextidDatabarang.setText(String.valueOf(databarang.getIdDatabarang()));
		jtextNamabarang.setText(String.valueOf(databarang.getNamabarang()));
		jtextStok.setText(String.valueOf(databarang.getStok()));
		jtextHargajual.setText(String.valueOf(databarang.getHargajual()));
		jtextHargabeli.setText(String.valueOf(databarang.getHargabeli()));
		comboBox.setSelectedItem(databarang.getSatuanukuran());
		jtextDeskripsi.setText(String.valueOf(databarang.getDeksripsi()));
		jtextKeterangan.setText(String.valueOf(databarang.getKeterangan()));

		if (isUpdate) {
			// ubah databarang
			databarangdao.update(databarang);
		} else {
			// bikin databarang
			databarangdao.create(databarang);
		}

	}

	public void setData(Databarang databarang) {
		jtextidDatabarang.setText(String.valueOf(databarang.getIdDatabarang()));
		jtextNamabarang.setText(String.valueOf(databarang.getNamabarang()));
		jtextStok.setText(String.valueOf(databarang.getStok()));
		jtextHargajual.setText(String.valueOf(databarang.getHargajual()));
		jtextHargabeli.setText(String.valueOf(databarang.getHargabeli()));
		comboBox.setSelectedItem(databarang.getSatuanukuran());
		jtextDeskripsi.setText(String.valueOf(databarang.getDeksripsi()));
		jtextKeterangan.setText(String.valueOf(databarang.getKeterangan()));
	}

}
