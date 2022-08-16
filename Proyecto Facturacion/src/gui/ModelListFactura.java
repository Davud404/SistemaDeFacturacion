/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.DefaultListModel;
import model.Empresa;
import model.Factura;

/**
 *
 * @author Usuario
 */
public class ModelListFactura extends DefaultListModel<Factura>{

    public ModelListFactura() {
        Empresa e1=new Empresa("fdsg");
       Factura f1 =new Factura(e1);
        addElement(f1);
       
    }
     
    
    
}
