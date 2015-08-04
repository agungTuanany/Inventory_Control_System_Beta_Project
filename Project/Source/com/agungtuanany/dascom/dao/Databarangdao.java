package com.agungtuanany.dascom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agungtuanany.dascom.model.Databarang;

public class Databarangdao {

	private static final String CREATE = //
	"INSERT INTO DataBarang (idDataBarang, NamaBarang, Stok, HargaJual, HargaBeli, SatuanUkuran, Deskripsi, Keterangan) VALUES (?,?,?,?,?,?,?,?)";

	private static final String UPDATE = //
	"UPDATE DataBarang SET NamaBarang=?, Stok=?, HargaJual?,HargaBeli=?, SatuanUkuran=?, Deskripsi=?, Keterangan=? WHERE IdDataBarang=?";

	private static final String DELETE = //
	"DELETE FROM DataBarang WHERE IdDataBarang=?";

	private static final String GET_ONE = //
	"SELECT * FROM DataBarang WHERE IdDataBarang = ?";

	private static final String GET_ALL = //
	"SELECT * FROM DataBarang";

	private static final String url = "jdbc:mysql://localhost:3306/DSCM5";
	private static final String username = "root";
	private static final String password = "admin";

	// membuat private preparestatement

	private PreparedStatement createDatabarang;
	private PreparedStatement updateDatabarang;
	private PreparedStatement deleteDatabarang;
	private PreparedStatement getOneDatabarang;
	private PreparedStatement getAllDatabarang;

	private Connection connection;

	public Databarangdao() {

		// seremonial
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			createDatabarang = connection.prepareStatement(CREATE);
			updateDatabarang = connection.prepareStatement(UPDATE);
			deleteDatabarang = connection.prepareStatement(DELETE);
			getOneDatabarang = connection.prepareStatement(GET_ONE);
			getAllDatabarang = connection.prepareStatement(GET_ALL);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void create(Databarang databarang) {

		try {
			createDatabarang.setString(1, databarang.getIdDatabarang());
			createDatabarang.setString(2, databarang.getNamabarang());
			createDatabarang.setInt(3, databarang.getStok());
			createDatabarang.setDouble(4, databarang.getHargajual());
			createDatabarang.setDouble(5, databarang.getHargabeli());
			createDatabarang.setString(6, databarang.getSatuanukuran());
			createDatabarang.setString(7, databarang.getDeksripsi());
			createDatabarang.setString(8, databarang.getKeterangan());
			// createDatabarang.setTimestamp(4, new
			// Timestamp(pegawai.getTanggal().getTime()));
			createDatabarang.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void update(Databarang databarang) {

		try {

			updateDatabarang.setString(1, databarang.getNamabarang());
			updateDatabarang.setInt(2, databarang.getStok());
			updateDatabarang.setDouble(3, databarang.getHargajual());
			updateDatabarang.setDouble(4, databarang.getHargabeli());
			updateDatabarang.setString(5, databarang.getSatuanukuran());
			updateDatabarang.setString(6, databarang.getDeksripsi());
			updateDatabarang.setString(7, databarang.getKeterangan());
			// updatePegawai.setTimestamp(3, new
			// Timestamp(pegawai.getTanggal().getTime()));
			// updatePegawai.setInt(4, pegawai.getNip());
			updateDatabarang.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(Databarang databarang) {

		try {
			deleteDatabarang.setString(1, databarang.getIdDatabarang());
			deleteDatabarang.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<Databarang> getAll() {
		try {
			ResultSet rs = getAllDatabarang.executeQuery();
			List<Databarang> listDatabarang = new ArrayList<>();
			while (rs.next()) {
				Databarang databarang = new Databarang();
				databarang.setIdDatabarang(rs.getString(1));
				databarang.setNamabarang(rs.getString(2));
				databarang.setStok(rs.getInt(3));
				databarang.setHargajual(rs.getDouble(4));
				databarang.setHargabeli(rs.getDouble(5));
				databarang.setSatuanukuran(rs.getString(6));
				databarang.setDeksripsi(rs.getString(7));
				databarang.setKeterangan(rs.getString(8));
				// databarang.setTanggal(new
				// Date(rs.getTimestamp(4).getTime()));
				listDatabarang.add(databarang);

			}
			return listDatabarang;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Databarang getOne(String idDatabarang) {
		try {
			getOneDatabarang.setString(1, idDatabarang);
			ResultSet rs = getOneDatabarang.executeQuery();
			if (rs.next()) {
				Databarang databarang = new Databarang();
				databarang.setIdDatabarang(rs.getString(1));
				databarang.setNamabarang(rs.getString(2));
				databarang.setStok(rs.getInt(3));
				databarang.setHargajual(rs.getDouble(4));
				databarang.setHargabeli(rs.getDouble(5));
				databarang.setSatuanukuran(rs.getString(6));
				databarang.setDeksripsi(rs.getString(7));
				databarang.setKeterangan(rs.getString(8));
				// databarang.setGaji(rs.getFloat(3));
				// databarang.setTanggal(new
				// Date(rs.getTimestamp(4).getTime()));

				return databarang;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
