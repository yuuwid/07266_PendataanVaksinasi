package views07266.admin;

import controller07266.AdminController07266;
import core07266.Controller;
import core07266.Views;
import entity07266.AdminEntity07266;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAdmin07266 extends Views {

    public RegisterAdmin07266() {
        initWindow("Registrasi Admin", 480, 680);
        
    }

    @Override
    protected void initComponent() {

        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.setBackground(Color.WHITE);
        boundedAdd(backBtn, 46, 35, 90, 33);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        boundedAdd(titleLabel, 174, 73, 133, 33);

        boundedAdd(nipLabel, 46, 135, 91, 28);
        boundedAdd(nipField, 195, 135, 191, 28);

        boundedAdd(namaLabel,46, 183, 91, 28);
        boundedAdd(namaField, 195, 183, 191, 28);

        boundedAdd(alamatLabel, 46, 231, 91, 28);
        boundedAdd(alamatField, 195, 231, 191, 28);

        boundedAdd(passLabel, 46, 279, 113, 28);
        boundedAdd(passField, 195, 279, 191, 28);

        boundedAdd(noTelpLabel, 46, 327, 91, 28);
        boundedAdd(noTelpField, 195, 327, 191, 28);

        registBtn.setBackground(Color.BLUE);
        registBtn.setForeground(Color.WHITE);
        boundedAdd(registBtn, 122, 530, 206, 35);
    }


    @Override
    protected void event() {
        backEvent();
        regEvent();
    }

    private void backEvent(){
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void regEvent() {
        registBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nip, nama, alamat, password, noTelp;

                nip = nipField.getText();
                nama = namaField.getText();
                alamat = alamatField.getText();
                password = passField.getText();
                noTelp = noTelpField.getText();

                if (nip.length() != 0 && nama.length() != 0 && alamat.length() != 0 && password.length() != 0 && noTelp.length() != 0){
                    AdminEntity07266 newAdmin = new AdminEntity07266(0, nama, alamat, noTelp, nip, password);

                    int status = Controller.req(AdminController07266.class).insertData(newAdmin);

                    if (status > 0) {
                        JOptionPane.showMessageDialog(null, "Admin berhasil didaftarkan");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal didaftarkan");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                }
            }
        });
    }

    private JLabel titleLabel, nipLabel, namaLabel, alamatLabel, passLabel, noTelpLabel;
    private JButton backBtn, registBtn;
    private JTextField nipField, namaField, alamatField, noTelpField;
    private JPasswordField passField;

    {
        titleLabel = new JLabel("REGISTRASI");
        nipLabel = new JLabel("NIP");
        namaLabel = new JLabel("Nama");
        alamatLabel = new JLabel("Alamat");
        passLabel = new JLabel("Password");
        noTelpLabel = new JLabel("No Telp");

        backBtn = new JButton("<< Back");
        registBtn = new JButton("Registrasi");

        nipField = new JTextField();
        namaField = new JTextField();
        alamatField = new JTextField();
        passField = new JPasswordField();
        noTelpField = new JTextField();
    }

}
