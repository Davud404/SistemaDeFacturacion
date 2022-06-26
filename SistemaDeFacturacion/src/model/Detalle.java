/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Detalle {

    protected Integer cantidad;
    private Float valorTotal;

    private Factura factura;
    protected Producto producto;

    public Detalle() {
    }

    public Detalle(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        calcularValorTotal();
        
    }

    public Detalle(Integer cantidad, Producto producto, Factura factura ) {
        this(cantidad, producto);
        this.factura = factura;
    }

    public void calcularValorTotal() {
        valorTotal = cantidad * producto.getPrecioUnitario();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Detalle{" + "cantidad=" + cantidad + "valor unitario: " + producto.getPrecioUnitario()+ ", valorTotal=" + valorTotal + ", producto=" + producto + '}';
    }
    
    
}