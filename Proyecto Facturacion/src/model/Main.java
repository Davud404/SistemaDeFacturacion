/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import gui.InterfazInicioSesion;
import gui.PanelEmpresa;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazInicioSesion interfazInicio=new InterfazInicioSesion();
        interfazInicio.setVisible(true);
//        Hibernate.getSessionFactory();
//        Coneccion objetConeccion = new Coneccion();
//        objetConeccion.conectar();
        Empresa e = new Empresa("Lucho's Store S.A.", "014090240", 12, 30);
       
        Inventario i = new Inventario(e);
        
        Cliente c = new Cliente("Elon","Musk", "0125029529");
        
        Empleado emp = new Empleado("Lionel", "Messi", "1235982309", e);
        Empleado emp2 = new Empleado("Juan", "Espinosa", "1232309");
        
        Direccion d = new Direccion("Sauces", "03-45");
        c.setDireccion(d);
        Direccion dEmpresa = new Direccion("Argelia", "06-18");
        
        Factura f = new Factura(c, e, 0);
        
        Producto p = new Producto("Papel", 1f, 60,i);
        Producto p2 = new Producto("Lapiz", 2f, 10, i);
        Producto p3 = new Producto("Cuaderno", 3f, 55,i);
        Producto p4 = new Producto("Libro", 4f, 40, i);
        Producto p5 = new Producto("calculadora", 18f, 30, i);
        
        Detalle d1 = new Detalle(1, p, f);
        Detalle d2 = new Detalle(2, p4, f);
        Detalle d3 =new Detalle(4, p2);
        
        f.agregarDetalle(d1);
        f.agregarDetalle(d2);
        f.agregarDetalle(d3);
        e.agregarFactura(new Factura(new Cliente("David", "Campoverde", "1105983041"), e));
        f.calcularSubtotal();
        System.out.println("mdmsdks");
        System.out.println(f.getTotal());
    }
}
