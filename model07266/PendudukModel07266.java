package model07266;

import core07266.Model;
import entity07266.PendudukEntity07266;

import javax.swing.*;
import java.util.ArrayList;

public class PendudukModel07266 extends Model {

    public PendudukModel07266() {
        connect();
    }

    /**
     * Proses ambil data dari database
     * @param sql String query SQL
     * @return ArrayList
     */
    private ArrayList<PendudukEntity07266> getData(String sql){
        ArrayList<PendudukEntity07266> data = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                PendudukEntity07266 temp = new PendudukEntity07266(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("noTelp"),
                        rs.getString("nik"),
                        rs.getString("dosis"),
                        rs.getString("jenis_vaksin")
                );
                data.add(temp);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }

    /**
     * Method default ambil semua data dari database
     * @return ArrayList
     */
    public ArrayList<PendudukEntity07266> getData(){
        return getData("SELECT * FROM penduduk");
    }

    /**
     * Method ambil data berdasarkan key dan value yang dicari
     * @param key nama kolom
     * @param value data yang dicari
     * @param option dapat diisi dengan equals (=) atau LIKE
     * @return ArrayList
     */
    public ArrayList<PendudukEntity07266> getData(String key, Object value, String option){
        sql = "SELECT * FROM penduduk WHERE %s %s %s";
        value = (value.getClass().getSimpleName().equals("String")) ? "'" + value + "'" : value;
        query = String.format(sql, key, option, value);

        return getData(query);
    }

    public int insertData(PendudukEntity07266 pendudukEntity){
        sql = "INSERT INTO penduduk(nama, alamat, noTelp, nik, dosis, jenis_vaksin) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pendudukEntity.getNama());
            pstmt.setString(2, pendudukEntity.getAlamat());
            pstmt.setString(3, pendudukEntity.getNoTelp());
            pstmt.setString(4, pendudukEntity.getNik());
            pstmt.setString(5, pendudukEntity.getDosis());
            pstmt.setString(6, pendudukEntity.getJenisVaksin());

            return pstmt.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public int updateData(PendudukEntity07266 pendudukEntity){
        sql = "UPDATE penduduk SET noTelp = ? , dosis = ? WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pendudukEntity.getNoTelp());
            pstmt.setString(2, pendudukEntity.getDosis());
            pstmt.setInt(3, pendudukEntity.getId());

            return pstmt.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public int deleteData(int id){
        sql = "DELETE FROM penduduk WHERE id = " + id;

        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public int cekData(String nik){
        return (getData("nik", nik, "=").size() > 0) ? 1 : 0;
    }
}
