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
    
    
    
    
}