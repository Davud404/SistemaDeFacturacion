/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;
import java.util.List;

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
        
    public Empresa(String nombre, String ruc, Integer porcentajeIVA, Integer utilidad) {
        this(nombre, ruc);
        this.porcentajeIVA = porcentajeIVA;
        this.utilidad = utilidad;
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
    
    
    
}