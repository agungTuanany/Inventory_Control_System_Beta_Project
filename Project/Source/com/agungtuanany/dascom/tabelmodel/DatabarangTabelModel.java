package com.agungtuanany.dascom.tabelmodel;

import com.agungtuanany.dascom.model.Databarang;

public class DatabarangTabelModel extends BaseTableModelDasar<Databarang>{
	
	public DatabarangTabelModel() {
		
		super("idDataBarang","NamaBarang","Stok","HargaJual","HargaBeli","SatuanUkuran","Deskripsi","Keterangan");
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Databarang databarang = new Databarang();
		
		switch (columnIndex) {
		case 0:
			return databarang.getIdDatabarang();
		case 1:
			return databarang.getNamabarang();
		case 2:
			return databarang.getStok();
		case 3:
			return databarang.getHargajual();
		case 4:
			return databarang.getHargabeli();
		case 5:
			return databarang.getDeksripsi();
		case 6:
			return databarang.getKeterangan();
		}
		return null;
	}

}
