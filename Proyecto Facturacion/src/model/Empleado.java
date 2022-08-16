/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Empleado extends Persona{
    
    private String idEmpleado;
    private String contraseña;
    
    private Empresa empresa;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
    }

    public Empleado(String nombre, String apellido, String cedula, Empresa empresa) {
        super(nombre, apellido, cedula);
        this.empresa = empresa;
    }

    public Empleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    

//    @Override
//    public String toString() {
//        return "Empleado{" + "idEmpleado=" + idEmpleado + '}';
//    }
    Coneccion conn=new Coneccion();

    public void mostrarEmpleado(String id_empleado){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select * from Empleado where id_empleado='"+id_empleado+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setNombre(rs.getString("nombre"));
                setIdEmpleado(rs.getString("id_empleado"));
                setContraseña(rs.getString("contraseña"));

           
            }else{
                setNombre(rs.getString(""));
                setIdEmpleado(rs.getString(""));
                setContraseña(rs.getString(""));

            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    
}