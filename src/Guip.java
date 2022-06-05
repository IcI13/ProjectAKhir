/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author D15kY
 */
public class Guip extends JFrame {
    JLabel lnama = new JLabel("Nama");
    JLabel lnohp = new JLabel("No. HP");
    JLabel lbuku = new JLabel("Buku");
    
    
    JTextField fnama = new JTextField();
    JTextField fnohp = new JTextField();
    JTextField fbuku = new JTextField();
    
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnLogout = new JButton("Log Out");
    
    JTable Tabeldata = new JTable();
    
    private void tampilkandata(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Nama");
        model.addColumn("No.HP");
        model.addColumn("Buku");
        Koneksi kn = new Koneksi();
        kn.readdata();
        Tabeldata.setModel(model);
    }
    
    public Guip(){
        setTitle("Login");
        setLayout(null);
        
        add(lnama);
        add(lnohp);
        add(lbuku);
        
        add(fnama);
        add(fnohp);
        add(fbuku);
        
        add(Tabeldata);
        add(btnTambah);
        add(btnLogout);
        
        lnama.setBounds(50,60,100,50);
        fnama.setBounds(110,75,160,20);
        lnohp.setBounds(50,90,100,50);
        fnohp.setBounds(110,105,160,20);
        lbuku.setBounds(50,120,100,50);
        fbuku.setBounds(110,135,160,20);
        
        btnTambah.setBounds(60,170,160,40);
        btnLogout.setBounds(10,10,100,30);
        
        Tabeldata.setBounds(10,220,400,200);
        
        setSize(435,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnTambah.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Koneksi kn = new Koneksi();
                String nama = fnama.getText();
                String nohp = fnohp.getText();
                String buku = fbuku.getText();
        if(!nama.isEmpty() && !nohp.isEmpty() && !buku.isEmpty()){
            kn.masukanDatap(nama, nohp, buku);
        }
        else if(nama.isEmpty() || nohp.isEmpty() || buku.isEmpty()){
            JOptionPane.showMessageDialog(null, "Jangan DiKosongkan");
        }
           }
       });
        
       btnLogout.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Login lg = new Login();
                lg.setVisible(true);
                setSize(300,400);
                lg.setLocationRelativeTo(null);
                lg.setDefaultCloseOperation(perpus.EXIT_ON_CLOSE);
           }
       }); 
       tampilkandata();
    }
}
