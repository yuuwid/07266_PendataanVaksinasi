package views07266.penduduk;

import controller07266.AdminController07266;
import controller07266.PendudukController07266;
import core07266.Controller;
import core07266.Views;
import entity07266.AdminEntity07266;
import entity07266.PendudukEntity07266;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataPendudukView07266 extends Views {
    PendudukEntity07266 penduduk;

    public DataPendudukView07266(PendudukEntity07266 penduduk) {
        this.penduduk = penduduk;
        initWindow("Data Perorang", 450, 400);
    }

    @Override
    protected void initComponent() {
        setButton(backBtn, Color.white, Color.black);
        backBtn.setBorderPainted(false);
        boundedAdd(backBtn, 18, 14, 122, 28);

        boundedAdd(nikLbl, 18, 83, 120, 28);
        nikField.setEditable(false);
        boundedAdd(nikField, 125, 83, 188, 28);

        boundedAdd(namaLbl, 18, 125, 120, 28);
        namaField.setEditable(false);
        boundedAdd(namaField, 125, 125, 188, 28);

        boundedAdd(alamatLbl, 18, 167, 120, 28);
        alamatField.setEditable(false);
        boundedAdd(alamatField, 125, 167, 188, 28);

        boundedAdd(noTelpLbl, 18, 210, 120, 28);
        noTelpField.setEditable(false);
        boundedAdd(noTelpField, 125, 210, 188, 28);
        setButton(ubahNoTelpBtn, Color.blue, Color.white);
        boundedAdd(ubahNoTelpBtn, 320, 210, 75, 28);

        boundedAdd(dosisLbl, 18, 250, 120, 28);
        dosisField.setEditable(false);
        boundedAdd(dosisField, 125, 250, 188, 28);
        setButton(ubahDosisBtn, Color.blue, Color.white);
        boundedAdd(ubahDosisBtn, 320, 250, 75, 28);

        boundedAdd(jenisVaksinLbl, 18, 293, 120, 28);
        jenisVaksinField.setEditable(false);
        boundedAdd(jenisVaksinField, 125, 293, 188, 28);

        inputData();
    }

    private void inputData() {
        nikField.setText(penduduk.getNik());
        namaField.setText(penduduk.getNama());
        alamatField.setText(penduduk.getAlamat());
        noTelpField.setText(penduduk.getNoTelp());
        dosisField.setText(penduduk.getDosis());
        jenisVaksinField.setText(penduduk.getJenisVaksin());
    }

    @Override
    protected void event() {
        backEvent();
        ubahNoTelpEvent();
        ubahDosisEvent();
    }

    private void backEvent() {
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void ubahNoTelpEvent() {
        ubahNoTelpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String noTelpBaru = JOptionPane.showInputDialog("Masukan No Telpon baru");
                    if (noTelpBaru.length() > 0){
                        penduduk.setNoTelp(noTelpBaru);
                        int status = Controller.req(PendudukController07266.class).updateData(penduduk);

                        JOptionPane.showMessageDialog(null, (status > 0) ? "Berhasil" : "Gagal");
                        inputData();
                    }
                } catch (Exception ex){}
            }
        });
    }

    private void ubahDosisEvent() {
        ubahDosisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String dosisBaru = JOptionPane.showInputDialog("Masukan Dosis");
                    if (dosisBaru.length() > 0){
                        penduduk.setDosis(dosisBaru);
                        int status = Controller.req(PendudukController07266.class).updateData(penduduk);

                        JOptionPane.showMessageDialog(null, (status > 0) ? "Berhasil" : "Gagal");
                        inputData();
                    }
                } catch (Exception ex){}
            }
        });
    }

    private JLabel nikLbl, namaLbl, alamatLbl, noTelpLbl, dosisLbl, jenisVaksinLbl;
    private JButton backBtn, ubahNoTelpBtn, ubahDosisBtn;
    private JTextField nikField, namaField, alamatField, noTelpField, dosisField, jenisVaksinField;

    {
        nikLbl = new JLabel("NIK");
        namaLbl = new JLabel("Nama");
        alamatLbl = new JLabel("Alamat");
        noTelpLbl = new JLabel("No Telpon");
        dosisLbl = new JLabel("Dosis");
        jenisVaksinLbl = new JLabel("Jenis Vaksin");

        backBtn = new JButton("Kembali");
        ubahNoTelpBtn = new JButton("Ubah");
        ubahDosisBtn = new JButton("Ubah");

        nikField = new JTextField();
        namaField = new JTextField();
        alamatField = new JTextField();
        noTelpField = new JTextField();
        dosisField = new JTextField();
        jenisVaksinField = new JTextField();
    }
}
