import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author D15kY
 */
public class Koneksi {
    String dbUrl = "jdbc:mysql://localhost:8080/perpustakaan";
    String dbUsername = "root";
    String dbPassword = "";
   
    Connection konek;
    String data[] = new String[2];
    static String[] username;
    Statement statement; 
    public Koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            konek = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
        
    }
    void masukanData(String username, String password) {
        try {
            if(!cekUser(username)){
                String query = "INSERT INTO `admin`(`username`,`password`) "
                    + "VALUES('" + username + "','" + password + "')";

                statement = konek.createStatement();
                statement.executeUpdate(query);

                System.out.println("Masuk Berhasil!");
                JOptionPane.showMessageDialog(null, "Register telah Berhasil!");
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Ada!!");
            }
            
        } catch (Exception ex) {
            System.out.println("masuk tidak berhasil!");
        }
    }
    
    
    
    boolean cekLogin(String username, String password){
         try {
             String query = "SELECT * FROM `admin` WHERE username='"+username+"'";
            statement = konek.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
                data[1] = rs.getString("password");
            }
            statement.close();
             System.out.println(data[1].toString());
             System.out.println(password);
            if(data[1].toString().equals(password)){
                return true;
            }else{
                return false;
            }
            
         } catch (Exception e) {
            return false;
         }
       
     }
    
    boolean cekUser(String username){
         try {
             String query = "SELECT * FROM `admin` WHERE username='"+username+"'";
            statement = konek.createStatement();
            ResultSet rs = statement.executeQuery(query);

            
            while(rs.next()){ 
                data[0] = rs.getString("username"); 
            }
            statement.close();
            data[0].toString();
            return true;
         } catch (Exception e) {
            return false;
         }
       
     }
    
    void masukanDatap(String nama, String nohp, String buku) {
        try {
           
                String query = "INSERT INTO `users`(`nama`,`nohp`,'buku') "
                    + "VALUES('" + nama + "','" + nohp + "','" + buku + "')";

                statement = konek.createStatement();
                statement.executeUpdate(query);

                System.out.println("Masuk Berhasil!");
                JOptionPane.showMessageDialog(null, "Data Telah Di Input!");
            
            
        } catch (Exception ex) {
            System.out.println("masuk tidak berhasil!");
        }
    }
    
    void readdata() {
        try {   
                Guip per = new Guip();
                int no = 1;
                DefaultTableModel model = new DefaultTableModel();
                String query = "SELECT * FROM 'users'";
                

                statement = konek.createStatement();
                ResultSet res = statement.executeQuery(query);
                
                while(res.next()){
                    model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3)});
                    
                }
  

            
        } catch (Exception ex) {
            System.out.println("masuk tidak berhasil!");
        }
    }
    
}
