/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Empresa {
    
    private String nombre;
    private String ruc;
    private Integer porcentajeIVA;
    private Integer utilidad;
    private String telefono;
    private String correo;
    private String direccionEmpresa;
    
    private Inventario inventario;
    private List<Direccion> direccionList;
    private List<Cliente> clienteList;
    private List<Empleado> empleadoList;
    private List<Factura> facturaList;
    
    public Empresa() {
        direccionList = new LinkedList<>();
        clienteList = new LinkedList<>();
        empleadoList = new LinkedList<>();
        facturaList = new LinkedList<>();
    }

    public Empresa(String nombre, String ruc) {
        this();
        this.nombre = nombre;
        this.ruc = ruc;
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }
    
        
    public Empresa(String nombre, String ruc, Integer porcentajeIVA, Integer utilidad) {
        this(nombre, ruc);
        this.porcentajeIVA = porcentajeIVA;
        this.utilidad = utilidad;
    }

    public Empresa(String nombre, String ruc, Integer porcentajeIVA, Integer utilidad, String telefono, String correo) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.porcentajeIVA = porcentajeIVA;
        this.utilidad = utilidad;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    
    //Métodos
    public void agregarEmpleadoAEmpresa(Empleado empleado){
        this.empleadoList.add(new Empleado(empleado.getNombre(), empleado.getApellido(), empleado.getCedula()));
    }
    
    public void agregarCliente (Cliente cliente){
        this.clienteList.add(new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getCedula(), cliente.getDireccion()) );
    }
    
    public void agregarFactura(Factura factura){
        this.facturaList.add(new Factura(factura.getCliente(), this, factura.getPorcentajeDescuento(), factura.getNumFactura()));
    }
    
//    public void insertarNumFactura(){
//        for (Factura factura : facturaList) {
//            Integer aux = this.facturaList.indexOf(factura);
//            Integer numFactura = aux+1;
//            this.facturaList.get(aux).setNumFactura(numFactura.toString());
//            //facturaVenta.setNumFactura(numFactura.toString());
//        }
//    }
    
    public void buscarCliente(String numCedula){
        for (Cliente cliente : clienteList) {
            if (cliente.getCedula().equals(numCedula)){
                System.out.println(cliente);
            }
            
        }
    }
    
    public void buscarFactura(String numFactura){
        for (Factura factura : facturaList) {
            if(factura.getNumFactura().equals(numFactura)){
                System.out.println(factura);
            }
        }
    }
    
    public void informeVentasFechaSeleccionada(String fecha){
        for (Factura factura : facturaList) {
            System.out.println(factura.getDetalleList());
            if(factura.getFecha().toString().equals(fecha)){
                factura.calcularSubtotal();
            }
        }
    }
    
    //Getters and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Integer getPorcentajeIVA() {
        return porcentajeIVA;
    }

    public void setPorcentajeIVA(Integer porcentajeIVA) {
        this.porcentajeIVA = porcentajeIVA;
    }

    public Integer getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Integer utilidad) {
        this.utilidad = utilidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    
    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", ruc=" + ruc + ", porcentajeIVA=" 
                + porcentajeIVA + ", utilidad=" + utilidad + ", empleado=" + this.getEmpleadoList() 
                + ", inventario=" + this.getInventario() + '}';
    }

    Coneccion conn=new Coneccion();
    
    public void insertar(String nombre, String ruc, Integer porcentajeIva, Integer utilidad, String telefono, String correo){
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "insert into empresa(nombre,ruc,porcentajeIva,utilidad,telefono,correo) values('"+nombre+"','"+ruc+"','"+porcentajeIva+"','"+utilidad+"','"+telefono+"','"+correo+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Empresa guardado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void mostrar(String ruc){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select * from Empresa where ruc='"+ruc+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setNombre(rs.getString("nombre"));
                setRuc(rs.getString("ruc"));
                setPorcentajeIVA(rs.getInt("porcentajeIva"));
                setUtilidad(rs.getInt("utilidad"));
                setTelefono(rs.getString("telefono"));
                setCorreo(rs.getString("correo"));
                setDireccionEmpresa(rs.getString("direccion"));
           
            }else{
                setNombre(rs.getString(""));
                setRuc(rs.getString(""));
                setPorcentajeIVA(rs.getInt(""));
                setUtilidad(rs.getInt(""));
                setCorreo(rs.getString(""));
                setDireccionEmpresa(rs.getString(""));
            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    public void modificar(String nombre, String ruc, Integer porcentajeIva, Integer utilidad, String telefono, String correo, String direccion){       
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "UPDATE Empresa SET nombre='"+nombre+"', porcentajeIva='"+porcentajeIva+"', utilidad='"+utilidad+"', correo='"+correo+"', direccion='"+direccion+"' WHERE Empresa.ruc='"+ruc+"';";
            String sqlac= "update producto set preciounitario=(preciocompra+(preciocompra * (empresa.utilidad ))/100) from empresa;";
            st.execute(sql);
            st.execute(sqlac);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Empresa actializo corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    
    
    
}