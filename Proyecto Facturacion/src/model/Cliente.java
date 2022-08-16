/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Cliente extends Persona{
    
    
    private List<Factura> facturaList;
    private Empresa empresa;

    public Cliente() {
        facturaList = new LinkedList<>();
    }

    public Cliente(String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
    }

    public Cliente(String nombre, String apellido, String cedula, Direccion direccion) {
        super(nombre, apellido, cedula, direccion);
    }
    
    
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    
    
    Coneccion conn=new Coneccion();
    
    public void insertar(String nombre, String apellido, String cedula, String direccion){
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "insert into cliente(nombre,apellido,cedula,direccion) values('"+nombre+"','"+apellido+"','"+cedula+"','"+direccion+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Cliente guardado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void mostrar(JTable panelCliente){
        Connection conexion=conn.conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        
        panelCliente.setModel(modelo);
        sql="select * from cliente;";
        String [] datos=new String[4];
        java.sql.Statement st;
        try {
            st=conn.conectar().createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    public void SeleccionarCliente(JTable tablaCliente, JTextField cedula){

        try {
            int fila=tablaCliente.getSelectedRow();
            if (fila>=0) {
                cedula.setText(tablaCliente.getValueAt(fila, 0).toString());             
            }else{
                JOptionPane.showMessageDialog(null, "fila mal seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
    }
    
    public void mostrar(JTextField cedula){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select * from Cliente where cedula='"+cedula.getText()+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setNombre(rs.getString("nombre"));
                setApellido(rs.getString("apellido"));
                setCedula(rs.getString("cedula"));
                setDireccionPersona(rs.getString("direccion"));

           
            }else{
                setNombre(rs.getString(""));
                setApellido(rs.getString(""));
                setCedula(rs.getString(""));
                setDireccionPersona(rs.getString(""));
            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    public void modificarCliente(String nombre, String apellido, String cedula, String direccion){   
        
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "UPDATE Cliente SET cedula='"+cedula+"', nombre='"+nombre+"', apellido='"+apellido+"', direccion='"+direccion+"' WHERE Cliente.cedula='"+cedula+"'";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Cliente actualizo corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void eliminarCliente(String cedula){   
        
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "Delete from Cliente where cliente.cedula='"+cedula+"';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Cliente eliminado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    
    
    
    
    
    
}