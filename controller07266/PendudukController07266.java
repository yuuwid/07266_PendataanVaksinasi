package controller07266;

import core07266.Controller;
import entity07266.PendudukEntity07266;
import model07266.PendudukModel07266;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PendudukController07266 extends Controller {
    public int insertData(PendudukEntity07266 pendudukEntity){
        return model(PendudukModel07266.class).insertData(pendudukEntity);
    }

    public int updateData(PendudukEntity07266 pendudukEntity){
        return model(PendudukModel07266.class).updateData(pendudukEntity);
    }

    public int deleteData(int id){
        return model(PendudukModel07266.class).deleteData(id);
    }

    public ArrayList<PendudukEntity07266> getData(String key, Object value, String option){
        return model(PendudukModel07266.class).getData(key, value, option);
    }

    public ArrayList<PendudukEntity07266> getData(String key, Object value){
        return getData(key, value, "=");
    }

    public DefaultTableModel getDataTable(){

        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] cols = {
                "id", "Nama", "Alamat", "No Telp", "NIK", "Dosis", "Jenis Vaksin"
        };
        dataTable.setColumnIdentifiers(cols);

        ArrayList<PendudukEntity07266> dataMurid = model(PendudukModel07266.class).getData();
        for (PendudukEntity07266 murid : dataMurid) {
            Object[] data = {
                    murid.getId(), murid.getNama(),
                    murid.getAlamat(), murid.getNoTelp(),
                    murid.getNik(), murid.getDosis(), murid.getJenisVaksin()
            };
            dataTable.addRow(data);
        }
        return dataTable;
    }

}
