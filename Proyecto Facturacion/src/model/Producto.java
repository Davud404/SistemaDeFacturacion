/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Producto {

    private String nombre;
    private String codigo;
    private Float precioUnitario;
    private Float precioCompra;
    private Integer stock = 0;

    private Inventario inventario;

    public Producto() {

    }

    public Producto(String nombre, Float precioCompra, Integer stock) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.stock = stock;
    }

    public Producto(String nombre, Float precioCompra, Integer stock, Inventario inventario) {
        this(nombre, precioCompra, stock);
        this.inventario = inventario;
        calcularPrecioUnitario(precioCompra);
    }

    public void calcularPrecioUnitario(Float precioCompra) {
        this.precioUnitario = precioCompra + (precioCompra * (inventario.getEmpresa().getUtilidad())) / 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precioCompra=" + precioCompra + ", stock=" + stock + '}';
    }

    Coneccion conn=new Coneccion();

    public void mostrarProductoExistente(String codigo){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select nombre,preciounitario,precioCompra from Producto where codigo='"+codigo+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setNombre(rs.getString("nombre"));
                setPrecioCompra(rs.getFloat("precioCompra"));
            }else{
                setNombre(rs.getString(""));
                setPrecioCompra(rs.getFloat(""));
            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir " +e.toString());

        }
    }
    
    public void SeleccionarCliente(JTable tablaProducto, JTextField codigo){

        try {
            int fila=tablaProducto.getSelectedRow();
            if (fila>=0) {
                codigo.setText(tablaProducto.getValueAt(fila, 0).toString());             
            }else{
                JOptionPane.showMessageDialog(null, "fila mal seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
    }
    
    public void mostrar(JTextField codigo){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select * from Producto where codigo='"+codigo.getText()+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setNombre(rs.getString("nombre"));
                setCodigo(rs.getString("codigo"));
                setPrecioCompra(rs.getFloat("precioCompra"));
                setStock(rs.getInt("stock"));

           
            }else{
                setNombre(rs.getString(""));
                setCodigo(rs.getString(""));
                setPrecioCompra(rs.getFloat(""));
                setStock(rs.getInt(""));
            }
            
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
        public void modificarProducto(String codigo, String nombre, Float preciocompra, Integer stock){   
        
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "UPDATE Producto SET codigo='"+codigo+"', nombre='"+nombre+"', preciocompra='"+preciocompra+"', stock='"+stock+"' WHERE Producto.codigo='"+codigo+"';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Producto actualizo corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void eliminarProducto(String codigo){   
        
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "Delete from Producto where producto.codigo='"+codigo+"';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Producto eliminado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " +e.toString());

        }
    }

}
