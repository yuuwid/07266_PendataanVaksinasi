package views07266.penduduk;

import controller07266.PendudukController07266;
import core07266.Controller;
import core07266.Views;
import entity07266.PendudukEntity07266;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TambahDataView07266 extends Views {

    public TambahDataView07266() {
        initWindow("Tambah Data Penduduk", 400, 680);
    }

    @Override
    protected void initComponent() {
        setButton(backBtn, Color.white, Color.black);
        backBtn.setBorderPainted(false);
        boundedAdd(backBtn, 18, 14, 90, 28);

        title.setFont(new Font(FONT, Font.BOLD, 20));
        boundedAdd(title, 85, 55, 260, 28);

        boundedAdd(namaLbl, 22, 115, 151, 28);
        boundedAdd(namaField, 22, 155, 340, 28);

        boundedAdd(alamatLbl, 22, 193, 151, 28);
        boundedAdd(alamatField, 22, 232, 340, 28);

        boundedAdd(noTelpLbl, 22, 270, 151, 28);
        boundedAdd(noTelpField, 22, 310, 340, 28);

        boundedAdd(nikLbl, 22, 350, 151, 28);
        boundedAdd(nikField, 22, 388, 340, 28);

        boundedAdd(dosisLbl, 22, 427, 120, 28);
        boundedAdd(dosisField, 22, 466, 85, 28);

        boundedAdd(jenisVaksinLbl, 194, 427, 186, 28);
        boundedAdd(jenisVaksinField, 194, 466, 85, 28);

        setButton(resetBtn, Color.RED, Color.WHITE);
        setButton(submitBtn, Color.BLUE, Color.white);
        boundedAdd(resetBtn, 95, 550, 82, 28);

        boundedAdd(submitBtn, 200, 550, 82, 28);
    }

    @Override
    protected void event() {
        backEvent();
        resetEvent();
        submitEvent();
    }

    private void backEvent(){
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void resetEvent(){
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namaField.setText("");
                alamatField.setText("");
                noTelpField.setText("");
                nikField.setText("");
                dosisField.setText("");
                jenisVaksinField.setText("");
            }
        });
    }

    private void submitEvent(){
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama, alamat, noTelp, nik, dosis, jenisVaksin;
                nama = namaField.getText();
                alamat = alamatField.getText();
                noTelp = noTelpField.getText();
                nik = nikField.getText();
                dosis = dosisField.getText();
                jenisVaksin = jenisVaksinField.getText();

                if (nama.length() != 0 && alamat.length() != 0 &&
                        noTelp.length() != 0 && nik.length() != 0 &&
                        dosis.length() != 0 && jenisVaksin.length() != 0){
                    PendudukEntity07266 pendudukBaru = new PendudukEntity07266(0, nama, alamat,
                            noTelp, nik, dosis, jenisVaksin);
                    int status = Controller.req(PendudukController07266.class).insertData(pendudukBaru);

                    String msg = (status > 0) ? "Data berhasil ditambah" : "Data GAGAL ditambah";
                    JOptionPane.showMessageDialog(null, msg);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak boleh kosong");
                }
            }
        });
    }

    private JButton backBtn, resetBtn, submitBtn;
    private JLabel title, namaLbl, alamatLbl, noTelpLbl, nikLbl, dosisLbl, jenisVaksinLbl;
    private JTextField namaField, alamatField, noTelpField, nikField, dosisField, jenisVaksinField;

    {
        backBtn = new JButton("Kembali");
        resetBtn = new JButton("Reset");
        submitBtn = new JButton("Submit");

        title = new JLabel("Tambah Data Penduduk");
        namaLbl = new JLabel("Nama");
        alamatLbl = new JLabel("Alamat");
        noTelpLbl = new JLabel("No Telpon");
        nikLbl = new JLabel("NIK");
        dosisLbl = new JLabel("Dosis");
        jenisVaksinLbl = new JLabel("Jenis Vaksin");

        namaField = new JTextField();
        alamatField = new JTextField();
        noTelpField = new JTextField();
        nikField = new JTextField();
        dosisField = new JTextField();
        jenisVaksinField = new JTextField();
    }
}
