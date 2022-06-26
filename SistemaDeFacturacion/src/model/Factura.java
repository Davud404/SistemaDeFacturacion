/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Factura {
    
    protected String numFactura;
    protected Float subtotal = 0f;
    private Float total = 0f;
    protected Float montoIVA = 0f;
    private String fecha;
    private String formaPago;
    private String numAutorizacion;
    protected Integer porcentajeDescuento;
    private Float valorDescuento = 0f;
    
    private Empresa empresa;
    private Cliente cliente;
    private List<Detalle> detalleList;
    private List<Factura> facturaList;

    public Factura() {
        detalleList = new LinkedList<>();
        facturaList = new LinkedList<>();
    }

    public Factura(Cliente cliente) {
        this();
        this.cliente = cliente;
    }

    public Factura(Cliente cliente, Empresa empresa) {
        this(cliente);
        this.empresa = empresa;
    }

    public Factura(Cliente cliente, Empresa empresa, Integer porcentajeDescuento) {
        this(cliente, empresa);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Factura(Cliente cliente, Empresa empresa, Integer porcentajeDescuento, String numFactura) {
        this(cliente, empresa, porcentajeDescuento);
        this.numFactura = numFactura;
    }
    
    public void agregarDetalle(Detalle detalle){
        this.detalleList.add(new Detalle(detalle.getCantidad(), detalle.getProducto(),this));
    }

   
    public void calcularSubtotal(){
    for (Detalle detalle : detalleList) {
            this.subtotal = subtotal + detalle.getValorTotal();
        }
        
        if (this.porcentajeDescuento != null){
            valorDescuento = subtotal * porcentajeDescuento/100;
            this.subtotal = subtotal - valorDescuento;
        }
        
        calcularIva();
        disminuirInventario();
    }
    
    
    public void calcularIva(){
        this.montoIVA = subtotal * empresa.getPorcentajeIVA()/100;
        calcularTotal();
    }
    
    public void calcularTotal (){
        this.total = subtotal + montoIVA;
        
    }
    
    public void disminuirInventario(){
        for (Detalle detalle : detalleList) {  
              int aux = detalle.getProducto().getStock()- detalle.getCantidad();
              detalle.getProducto().setStock(aux);
        }             
    }
    
    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getMontoIVA() {
        return montoIVA;
    }

    public void setMontoIVA(Float montoIVA) {
        this.montoIVA = montoIVA;
    }

    public LocalDate getFecha() {
        LocalDate fecha = LocalDate.now();
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(String numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Float getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Float valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
    

    @Override
    public String toString() {
        return "\nFactura{" + "fecha=" + this.getFecha() + ", cliente=" + cliente + " , numero= "+ numFactura+ ", Valor Descuento= " + this.getValorDescuento()+ ", Total= "+this.getTotal()+'}';
    }
    
    
}
