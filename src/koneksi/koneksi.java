/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelompok 5
 */
public class koneksi {
    public static Connection con;
    
    public static Connection getKoneksi(){
        if(con == null){
            try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal!");
        } 
        }
        return con; 
  }
}