/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Empleado extends Persona{
    
    private String idEmpleado;
    
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

//    @Override
//    public String toString() {
//        return "Empleado{" + "idEmpleado=" + idEmpleado + '}';
//    }
    
    
}