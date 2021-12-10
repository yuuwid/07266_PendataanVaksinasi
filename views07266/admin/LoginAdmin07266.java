package views07266.admin;

import controller07266.AdminController07266;
import core07266.*;
import entity07266.AdminEntity07266;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginAdmin07266 extends Views {
    private AdminEntity07266 logged;
    private String pathImage = "./src/images07266/login_img.png";

    private BufferedImage bufferedImage = null;
    private Image imageResize;

    public LoginAdmin07266() {
        initWindow("Admin Login", 480, 680);
    }

    @Override
    protected void initComponent(){
        loadImage();

        //
        nipField.setText("357826");
        passField.setText("123");

        boundedAdd(frameImage,80, 70, 300, 300);

        boundedAdd(nipLabel, 52, 385, 117, 28);
        boundedAdd(nipField, 150, 385, 250, 28);

        boundedAdd(passLabel, 52, 445, 117, 28);

        boundedAdd(passField, 150, 445, 250, 28);

        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        boundedAdd(btnLogin, 170, 538, 157, 38);

        registAdmin.setBackground(Color.WHITE);
        registAdmin.setBorderPainted(false);
        boundedAdd(registAdmin, 165, 585, 170, 38);

    }

    private void loadImage() {
        try {
            bufferedImage = ImageIO.read(new File(pathImage));
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        imageResize = bufferedImage.getScaledInstance(
                300,
                300,
                Image.SCALE_SMOOTH);
        frameImage.setIcon(new ImageIcon(imageResize));

    }

    @Override
    protected void event(){
        loginEvent();
        registerEvent();
    }

    private void registerEvent(){
        registAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.req(RegisterAdmin07266.class).setVisible(true);
            }
        });
    }

    private void loginEvent(){
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nip = nipField.getText();
                String pass = passField.getText();

                logged = Controller.req(
                        AdminController07266.class
                ).login(nip, pass);

                if (logged != null){
//                    Controller.req(HomeAdmin07266.class).setVisible(true);
                    new HomeAdmin07266(logged).setVisible(true);
                    dispose();
                } else {
                    String msg = "NIP atau Password Salah";
                    JOptionPane.showMessageDialog(null, msg);
                }
            }
        });
    }


    private JLabel nipLabel, passLabel;
    private JTextField nipField;
    private JPasswordField passField;
    private JButton btnLogin, registAdmin;
    private JLabel frameImage;

    {
        frameImage = new JLabel();
        nipLabel = new JLabel("NIP");
        passLabel = new JLabel("Password");
        nipField = new JTextField();
        passField = new JPasswordField();

        btnLogin = new JButton("Login");
        registAdmin = new JButton("Registrasi Admin");
    }

}
