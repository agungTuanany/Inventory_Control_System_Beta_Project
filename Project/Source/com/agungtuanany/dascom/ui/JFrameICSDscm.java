package com.agungtuanany.dascom.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class JFrameICSDscm extends JFrame {

	/**
	 * Launch the
	 * application.http://marketplace.eclipse.org/marketplace-client-intro?
	 * mpc_install=27025
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameICSDscm frame = new JFrameICSDscm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameICSDscm() {
		getContentPane().setBackground(new Color(64, 224, 208));
		getContentPane().setLayout(null);

		JLabel lblWellcomeToInventory = new JLabel("WELLCOME TO INVENTORY CONTROL SYSTEM");
		lblWellcomeToInventory.setBounds(179, 231, 277, 15);
		getContentPane().add(lblWellcomeToInventory);

		JLabel lblDascomJayaSakti = new JLabel("DASCOM JAYA SAKTI");
		lblDascomJayaSakti.setBounds(249, 276, 139, 15);
		getContentPane().add(lblDascomJayaSakti);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 381);

		JMenuBar jmenuBar1 = new JMenuBar();
		jmenuBar1.setBackground(new Color(65, 105, 225));
		setJMenuBar(jmenuBar1);

		JMenu jmenu1 = new JMenu("Master Data");
		jmenuBar1.add(jmenu1);

		JMenu jMenuItem1 = new JMenu("Data Barang");
		jmenu1.add(jMenuItem1);

		JMenu jMenuItem2 = new JMenu("Data Pelanggan");
		jmenu1.add(jMenuItem2);

		JMenu jMenuItem3 = new JMenu("Data Supplier");
		jmenu1.add(jMenuItem3);

		JMenu jMenuItem4 = new JMenu("Data Shipper");
		jmenu1.add(jMenuItem4);

		JMenu jmenu2 = new JMenu("Transaksi");
		jmenuBar1.add(jmenu2);

		JMenu jMenuItem5 = new JMenu("Material Request");
		jmenu2.add(jMenuItem5);

		JMenu jMenuItem6 = new JMenu("Purchase Order");
		jmenu2.add(jMenuItem6);

		JMenu jMenuItem7 = new JMenu("Delivery Order");
		jmenu2.add(jMenuItem7);

		JMenu jmenu3 = new JMenu("Laporan");
		jmenuBar1.add(jmenu3);

		JMenu jMenuItem8 = new JMenu("Laporan MR");
		jmenu3.add(jMenuItem8);

		JMenu jMenuItem9 = new JMenu("Laporan PO");
		jmenu3.add(jMenuItem9);

		JMenu jMenuItem10 = new JMenu("Laporan DO");
		jmenu3.add(jMenuItem10);

		JMenu jmenu4 = new JMenu("Log Out");
		jmenuBar1.add(jmenu4);

		JMenu jMenuItem11 = new JMenu(" Exit Window");
		jmenu4.add(jMenuItem11);

	}
}
