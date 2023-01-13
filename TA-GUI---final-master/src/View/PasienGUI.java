package View;

import Entity.PenangananEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PasienGUI {

    JFrame Pasien = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarBerobat;
    JComboBox pilprak = new JComboBox(PenangananEntity.nama);
    int cek = Allobjctrl.Pasien.cekDaftarprak(Allobjctrl.Pasien.PasienEntity().getNik());

    public PasienGUI() {
        Pasien.setSize(720, 600);
        Pasien.setLayout(null);
        Pasien.getContentPane().setBackground(Color.LIGHT_GRAY);
        datadiri = new JLabel("Data Pasien");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Pasien.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pasien.add(area);
        daftarBerobat = new JLabel("Daftar Berobat");
        daftarBerobat.setBounds(450, 30, 250, 30);
        daftarBerobat.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Pasien.add(daftarBerobat);
        pilprak.setBounds(450, 90, 230, 30);
        Pasien.add(pilprak);
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Pasien.add(daftarbtn);
        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        Pasien.add(back);
        Pasien.setVisible(true);
        Pasien.setLocationRelativeTo(null);
        Pasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Daftar Berobat", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belun Daftar Berobat", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapasien());
        }
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexprak = pilprak.getSelectedIndex();
                Allobjctrl.Pasien.daftarPraktikum(indexprak, Allobjctrl.Pasien.getData(), false);
                area.setText(datapasien());
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pasien.dispose();
                GUI men = new GUI();
            }
        });
    }

    public String datapasien() {
        int cek = Allobjctrl.Pasien.cekDaftarprak(Allobjctrl.Pasien.PasienEntity().getNik());
        String cekverif;
        if (Allobjctrl.Pasien.showDaftarprak(cek).isVerified() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text = "Nik = " + Allobjctrl.Pasien.showDaftarprak(cek).getPasien().getNik() + "\n" + "Nama = " + Allobjctrl.Pasien.showDaftarprak(cek).getPasien().getNama() + "\n"
                + "No Telp = " + Allobjctrl.Pasien.showDaftarprak(cek).getPasien().getNo_telp() + "\n" + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").
                format(Allobjctrl.Pasien.showDaftarprak(cek).getPasien().getTglLahir()) + "\n" + "verifikasi = " + cekverif + "\n" + "Kelas = " + Allobjctrl.Pasien.
                showDaftarprak(cek).getPasien().getKelas() + "\n" + "praktikum = " + PenangananEntity.nama[Allobjctrl.Pasien.showDaftarprak(cek).getIndexBerobat()];
        return text;
    }
}
