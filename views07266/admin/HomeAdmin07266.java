package views07266.admin;

import controller07266.AdminController07266;
import core07266.Controller;
import core07266.Views;
import entity07266.AdminEntity07266;
import views07266.penduduk.TablePendudukView07266;
import views07266.penduduk.TambahDataView07266;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdmin07266 extends Views {
    private AdminEntity07266 adminLogged;

    public HomeAdmin07266(AdminEntity07266 admin) {
        adminLogged = admin;
        initWindow("Home Admin", 480, 480);
    }

    @Override
    protected void initComponent() {
        setButton(logoutBtn, Color.white, Color.black);
        logoutBtn.setBorderPainted(false);
        boundedAdd(logoutBtn, 10, 14, 100, 28);

        title.setFont(new Font(FONT, Font.BOLD, 22));
        boundedAdd(title, 125, 25, 246, 40);

        adminName.setText(adminLogged.getNama());
        adminName.setFont(new Font(FONT, Font.BOLD, 16));
        adminName.setHorizontalAlignment(SwingConstants.CENTER);
        boundedAdd(adminName, 105, 75, 246, 25);

        setButton(addBtn, Color.blue, Color.white);
        boundedAdd(addBtn, 50, 160, 165, 80);

        setButton(dataBtn, Color.blue, Color.white);
        boundedAdd(dataBtn, 250, 160, 165, 80);

        setButton(ubahPassBtn, Color.blue, Color.white);
        boundedAdd(ubahPassBtn, 50, 250, 165, 80);

        setButton(ubahNoTelpBtn, Color.blue, Color.white);
        boundedAdd(ubahNoTelpBtn, 250, 250, 165, 80);
    }

    @Override
    protected void event() {
        addDataEvent();
        showDataEvent();
        ubahNoTelpEvent();
        ubahPassEvent();
        logoutEvent();
    }

    private void addDataEvent(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.req(TambahDataView07266.class).setVisible(true);
            }
        });
    }

    private void showDataEvent(){
        dataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.req(TablePendudukView07266.class).setVisible(true);
            }
        });
    }

    private void ubahNoTelpEvent(){
        ubahNoTelpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String noTelpBaru = JOptionPane.showInputDialog("Masukan No Telpon baru");

                    if (noTelpBaru.length() > 0){
                        AdminEntity07266 admin = adminLogged;
                        admin.setNoTelp(noTelpBaru);
                        int status = Controller.req(AdminController07266.class).updateData(admin);

                        JOptionPane.showMessageDialog(null, (status > 0) ? "Berhasil" : "Gagal");
                    }
                } catch (Exception ex){}
            }
        });
    }

    private void ubahPassEvent(){
        ubahPassBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String passBaru = JOptionPane.showInputDialog("Masukan Password baru");

                    if (passBaru.length() > 0){
                        AdminEntity07266 admin = adminLogged;
                        admin.setPassword(passBaru);
                        int status = Controller.req(AdminController07266.class).updateData(admin);

                        JOptionPane.showMessageDialog(null, (status > 0) ? "Berhasil" : "Gagal");
                    }
                } catch (Exception ex){}
            }
        });
    }

    private void logoutEvent() {
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLogged = null;
                Controller.req(LoginAdmin07266.class).setVisible(true);
                setVisible(false);
            }
        });
    }

    private JLabel title, adminName;
    private JButton addBtn, dataBtn, ubahPassBtn, ubahNoTelpBtn, logoutBtn;

    {
        title = new JLabel("SELAMAT DATANG");
        adminName = new JLabel();
        addBtn = new JButton("Tambah Data");
        dataBtn = new JButton("Data");
        ubahPassBtn = new JButton("Ubah Password");
        ubahNoTelpBtn = new JButton("Ubah No Telpon");
        logoutBtn = new JButton("Log Out");
    }

}
