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
public class Inventario {

    private List<Producto> productoList;
    private Empresa empresa;

    public Inventario() {
        productoList = new LinkedList<>();
    }

    
    public Inventario(Empresa empresa) {
        this();
        this.empresa = empresa;
    }
    
    public void agregarProducto(Producto producto){
        this.productoList.add(producto);
    }
    
    public void agregarStock(Producto producto, Integer cantidad){
        Integer aux = producto.getStock() + cantidad;
        producto.setStock(aux);
    }
    
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Inventario{" + "productoList=" + productoList + '}';
    }

}