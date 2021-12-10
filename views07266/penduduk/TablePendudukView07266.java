package views07266.penduduk;

import controller07266.PendudukController07266;
import core07266.Controller;
import core07266.Views;
import entity07266.PendudukEntity07266;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TablePendudukView07266 extends Views {
    private String pathImage = "./src/images07266/update_img.png";

    private BufferedImage bufferedImage = null;
    private Image imageResize;

    public TablePendudukView07266() {
        initWindow("Data Penduduk", 700, 550);
    }

    @Override
    protected void initComponent() {
        dataTable();
        boundedAdd(pendudukSc, 28, 40, 628, 310);

        setButton(refreshBtn, Color.YELLOW, Color.BLUE);
        boundedAdd(refreshBtn, 82, 385, 122, 40);

        setButton(deleteBtn, Color.RED, Color.white);
        boundedAdd(deleteBtn, 82, 440, 122, 40);

        loadImage();
        setButton(updateFrame, Color.white, Color.white);
        updateFrame.setBorderPainted(false);
        boundedAdd(updateFrame,253, 380, 100, 100);

        cekTitleLbl.setFont(new Font(FONT, Font.BOLD, 18));
        boundedAdd(cekTitleLbl, 430, 370, 165, 36);

        boundedAdd(nikLbl, 430, 425, 128, 28);
        boundedAdd(nikField, 430, 460, 128, 28);
        setButton(cekBtn, Color.orange, Color.white);
        boundedAdd(cekBtn, 560, 460, 64, 28);

    }

    private void loadImage(){
        try {
            bufferedImage = ImageIO.read(new File(pathImage));
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        imageResize = bufferedImage.getScaledInstance(
                100,
                100,
                Image.SCALE_SMOOTH);
        updateFrame.setIcon(new ImageIcon(imageResize));
    }

    private void dataTable(){
        pendudukTbl.setModel(
                Controller.req(PendudukController07266.class).getDataTable()
        );
    }
    public void refreshTable(){
        dataTable();
    }


    @Override
    protected void event() {
        tableEvent();
        refreshEvent();
        deleteEvent();
        updateEvent();
        cekEvent();
    }

    private void tableEvent(){
        add(selectedField);
        pendudukTbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = pendudukTbl.getSelectedRow();
                String select = Controller.req(PendudukController07266.class).getDataTable()
                        .getValueAt(i, 0).toString();
                selectedField.setText(select);
            }
        });
    }

    private void refreshEvent(){
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
    }

    private void deleteEvent(){
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(selectedField.getText());
                    char konf = JOptionPane.showInputDialog("Yakin ingin menghapus data dengan id " + id + " (Y/n)").toLowerCase().charAt(0);

                    if (konf == 'y'){
                        int status = Controller.req(PendudukController07266.class).deleteData(id);
                        JOptionPane.showMessageDialog(null, (status > 0) ? "Berhasil dihapus" : "Gagal dihapus");
                    }
                } catch (Exception ex){}
            }
        });
    }

    private void updateEvent(){
        updateFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = selectedField.getText();
                int id = 0;
                if (select.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pilih Data pada Tabel terlebih dahulu");
                } else {
                    id = Integer.parseInt(select);
                }

                if (id > 0) {
                    PendudukEntity07266 penduduk = Controller.req(PendudukController07266.class).getData("id", id).get(0);
                    new DataPendudukView07266(penduduk).setVisible(true);
                }
            }
        });
    }

    private void cekEvent(){
        cekBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nik = nikField.getText();
                if (nik.length() > 0){
                    ArrayList<PendudukEntity07266> pendudukList = Controller.req(PendudukController07266.class).getData("nik", nik);
                    if (pendudukList.size() > 0){
                        PendudukEntity07266 penduduk = pendudukList.get(0);
                        String msg = penduduk.getNama() + " (" + penduduk.getNik() + ")" + " | Dosis : " + penduduk.getDosis();
                        JOptionPane.showMessageDialog(null, msg);
                    } else {
                        JOptionPane.showMessageDialog(null, "Tidak ada Data");
                    }
                }
            }
        });
    }

    private JButton deleteBtn, refreshBtn, cekBtn;
    private JButton updateFrame;

    private JTextField selectedField;
    private JScrollPane pendudukSc;
    private JTable pendudukTbl;

    private JLabel cekTitleLbl, nikLbl;
    private JTextField nikField;

    {
        deleteBtn = new JButton("Delete");
        refreshBtn = new JButton("Refresh");
        cekBtn = new JButton("Cek");

        updateFrame = new JButton();
        selectedField = new JTextField();
        pendudukTbl = new JTable();
        pendudukSc = new JScrollPane(pendudukTbl);

        cekTitleLbl = new JLabel("Cek Data");
        nikLbl = new JLabel("Masukan NIK");
        nikField = new JTextField();
    }
}
