package model07266;

import core07266.Model;
import entity07266.AdminEntity07266;

import javax.swing.*;
import java.util.ArrayList;

public class AdminModel07266 extends Model {

    public AdminModel07266() {
        connect();
    }

    public int insertData(AdminEntity07266 adminEntity){
        sql = "INSERT INTO admin(nama, nip, password, alamat, noTelp) VALUES " +
                "(?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminEntity.getNama());
            pstmt.setString(2, adminEntity.getNip());
            pstmt.setString(3, adminEntity.getPassword());
            pstmt.setString(4, adminEntity.getAlamat());
            pstmt.setString(5, adminEntity.getNoTelp());

            return pstmt.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public int updateData(AdminEntity07266 adminEntity){
        sql = "UPDATE admin SET noTelp = ?, password = ? WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, adminEntity.getNoTelp());
            pstmt.setString(2, adminEntity.getPassword());
            pstmt.setInt(3, adminEntity.getId());

            return pstmt.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public int deleteData(AdminEntity07266 adminEntity){
        sql = "DELETE FROM admin WHERE id = " + adminEntity.getId();
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }

    public AdminEntity07266 login(String nip, String password){
        sql = "SELECT * FROM admin WHERE nip = ? AND password = ?";
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, nip);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            while (rs.next()){
                return new AdminEntity07266(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("noTelp"),
                        rs.getString("nip"),
                        rs.getString("password")
                );
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
