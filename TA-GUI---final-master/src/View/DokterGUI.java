package View;

import Controller.AllObjectModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.PasienController;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DokterGUI {

    private static PasienController Pasien = new PasienController();
    JFrame Dokter = new JFrame();
    JTable tabelpraktikan = new JTable();
    JScrollPane scrollaslab = new JScrollPane(tabelpraktikan);
    JButton back, verif;
    JLabel admin, Niklabel, passlabel;
    JTextField Niktext, passtext;

    public DokterGUI() {
        Dokter.setSize(650, 500);
        Dokter.setLayout(null);
        Dokter.getContentPane().setBackground(Color.PINK);
        admin = new JLabel("Admin");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Dokter.add(admin);
        scrollaslab.setBounds(30, 100, 570, 200);
        tabelpraktikan.setModel(Pasien.daftarpasien());
        Dokter.add(scrollaslab);
        Niklabel = new JLabel("NIK");
        Niklabel.setBounds(50, 320, 100, 30);
        Dokter.add(Niklabel);
        Niktext = new JTextField();
        Niktext.setBounds(50, 350, 100, 30);
        Dokter.add(Niktext);
        passlabel = new JLabel("password");
        passlabel.setBounds(200, 320, 100, 30);
        Dokter.add(passlabel);
        passtext = new JTextField();
        passtext.setBounds(200, 350, 100, 30);
        Dokter.add(passtext);
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.RED);
        Dokter.add(verif);
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        Dokter.add(back);
        Dokter.setLocationRelativeTo(null);
        Dokter.setVisible(true);
        Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                GUI men = new GUI();
            }
        });
        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nik = Niktext.getText();
                String pass = passtext.getText();
                int index = AllObjectModel.daftarpasienModel.cekData(Nik, pass);
                Allobjctrl.doktor.updateIsVerified(index, Allobjctrl.Pasien.showDaftarprak(index).getIndexBerobat(), Allobjctrl.Pasien.showDaftarprak(index).getPasien());
                tabelpraktikan.setModel(Pasien.daftarpasien());
            }
        });
        tabelpraktikan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpraktikan.getSelectedRow();
                Niktext.setText(Allobjctrl.Pasien.daftarpasien().getValueAt(i, 0).toString());
                passtext.setText(Allobjctrl.Pasien.daftarpasien().getValueAt(i, 1).toString());
            }
        });
    }
}
