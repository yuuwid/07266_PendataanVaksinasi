package core07266;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Views extends JFrame {
    protected String FONT = "Arial";

    protected Component boundedAdd(Component comp, int x, int y, int width, int height){
        comp.setBounds(x, y, width, height);
        return add(comp);
    }

    protected JButton setButton(JButton comp, Color background, Color foreground){
        comp.setBackground(background);
        comp.setForeground(foreground);
        comp.setFocusPainted(false);

        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                comp.setBackground(foreground);
                comp.setForeground(background);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                comp.setBackground(background);
                comp.setForeground(foreground);
            }
        });

        return comp;
    }

    protected void initWindow(String title, int width, int height){
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, height);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);

        initComponent();
        event();
    }

    protected abstract void initComponent();
    protected abstract void event();
}