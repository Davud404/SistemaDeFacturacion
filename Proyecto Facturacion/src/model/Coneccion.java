/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.sun.source.tree.TryTree;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Coneccion {
    Connection conn=null;
    String BD = "jdbc:postgresql://localhost:5432/facturacion";
    String usuario="facturacion";
    String contra = "facturacion";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(BD, usuario, contra);
//            JOptionPane.showMessageDialog(null, "Base de datos conectada.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al coenctar: " +e.toString());

        }
  return conn;

    
}
}

