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
public class Direccion {
    
    private String calles;
    private String numDomicilio;
    private String ciudad;
    
    private Empresa empresa;
    private List<Cliente> clienteList;

    public Direccion() {
        clienteList = new LinkedList<>();
    }

    public Direccion(String calles, String numDomicilio) {
        this();
        this.calles = calles;
        this.numDomicilio = numDomicilio;
    }
    
    
    
    public String getCalles() {
        return calles;
    }

    public void setCalles(String calles) {
        this.calles = calles;
    }

    public String getNumDomicilio() {
        return numDomicilio;
    }

    public void setNumDomicilio(String numDomicilio) {
        this.numDomicilio = numDomicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calles=" + calles + ", numDomicilio=" + numDomicilio + '}';
    }
    
    
    
}