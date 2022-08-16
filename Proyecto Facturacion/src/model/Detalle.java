/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Detalle {
    
    private String numDetalle;
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

    public String getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(String numDetalle) {
        this.numDetalle = numDetalle;
    }
    
    

    @Override
    public String toString() {
        return "Detalle{" + "cantidad=" + cantidad + "valor unitario: " + producto.getPrecioUnitario()+ ", valorTotal=" + valorTotal + ", producto=" + producto + '}';
    }
    
            Coneccion conn=new Coneccion();
//            precioCompra + (precioCompra * (inventario.getEmpresa().getUtilidad())) / 100;
            Inventario empresa = new Inventario();
            
    
    public void insertar(String codigo, String nombre, Float precioCompra, Integer cantidad){                    
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "insert into producto(codigo,nombre,precioCompra,stock) values('"+codigo+"','"+nombre+"','"+precioCompra+"','"+cantidad+"');";
            String sqlac= "update producto set preciounitario=(preciocompra+(preciocompra * (empresa.utilidad ))/100) from empresa;";
            st.execute(sql);
            st.execute(sqlac);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Producto guardado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void insertarDetallle(String numDetalle, String idProducto, Integer cantidad, String numFactura){
        try {
            
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "insert into Detalle(numdetalle,id_producto,cantidad,num_factura) values('"+numDetalle+"','"+idProducto+"','"+cantidad+"','"+numFactura+"');";
            String sqla ="update detalle set precioTotal=producto.preciounitario*cantidad from producto;";
            st.execute(sql);
            st.execute(sqla);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Detalle guardado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void mostrarDetalle(JTable panelDetalle){
        Connection conexion=conn.conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Precio Total");
        
        panelDetalle.setModel(modelo);
        sql="select id_producto, producto.nombre, cantidad, producto.preciounitario,precioTotal from Detalle,producto where id_producto=codigo;";
        String [] datos=new String[5];
        java.sql.Statement st;
        try {
            st=conn.conectar().createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    
    
    
        public void mostrar(JTable panelProductos){
        Connection conexion=conn.conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Unitario");
        
        panelProductos.setModel(modelo);
        sql="select * from Producto;";
        String [] datos=new String[5];
        java.sql.Statement st;
        try {
            st=conn.conectar().createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
              
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
        }
        
        public void insertarProductoExistente(String codigo, Integer cantidad){ 
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "UPDATE Producto SET stock=stock+'"+cantidad+"' WHERE Producto.codigo='"+codigo+"';";
            String sqlac= "update producto set preciounitario=(preciocompra+(preciocompra * (empresa.utilidad ))/100) from empresa;";
            st.execute(sql);
            st.execute(sqlac);          
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Producto añadido Correctamente ");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
        }
        
        
    
    
    
    
}