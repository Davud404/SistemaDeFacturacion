/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Campoverde y David Intriago
 */
public class Factura {
    
    protected String numFactura;
    protected Float subtotal = 0f;
    private Float total = 15.522f;
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

    public Factura(Empresa empresa) {
        this.empresa = empresa;
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
    
    
    
    
    Coneccion conn=new Coneccion();
    
    public void insertarFactura(String numFactura, Float subtotal, Float total, Float montoIva, String fecha, String formapago, Integer porcentajeDescuento, Float valordescuento, String idEmpresa, String idCliente, String idDetalle){
        try {
            Connection conexion=conn.conectar();
            java.sql.Statement st=conexion.createStatement();
            String sql = "insert into factura(numfactura,subtototal,total,montoIva,fecha,formapago,porcentajeDescuento,valordescuento,idEmpresa,idcliente,iddetalle) values('"+numFactura+"','"+subtotal+"','"+total+"','"+montoIva+"','"+fecha+"','"+formapago+"','"+porcentajeDescuento+"','"+valordescuento+"','"+idEmpresa+"','"+idCliente+"','"+idDetalle+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Factura guardado corretamente");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar " +e.toString());

        }
    }
    
    public void mostrarFactura(String ruc){
        try {
        Connection conexion=conn.conectar();
        java.sql.Statement st;
        st=conexion.createStatement();
        String sql="select subtotal,valordescuento,empresa.porcentajeiva,total from factura,empresa where numfactura='"+ruc+"';";
        ResultSet rs=st.executeQuery(sql);
                
            if (rs.next()) {
                setSubtotal(rs.getFloat("subtotal"));
                setValorDescuento(rs.getFloat("valordescuento"));
                empresa.setPorcentajeIVA(rs.getInt("empresa.porcentajeiva"));
                setTotal(rs.getFloat("total"));
           
            }else{
                setSubtotal(rs.getFloat(""));
                setValorDescuento(rs.getFloat(""));
                empresa.setPorcentajeIVA(rs.getInt(""));
                setTotal(rs.getFloat(""));
            }
            
  
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    public void mostrar(JTable panelFactura){
        Connection conexion=conn.conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("numfactura");
        modelo.addColumn("Cliente");
        modelo.addColumn("numdetalle");
        modelo.addColumn("total");
        
        panelFactura.setModel(modelo);
        sql="select numfactura,cliente.nombre, numdetalle, total  from factura,detalle, producto, cliente where numfactura=num_factura and detalle.id_producto=producto.codigo and factura.id_cliente=cliente.cedula and detalle.numdetalle='1';";
        String [] datos=new String[4];
        java.sql.Statement st;
        try {
            st=conn.conectar().createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
                modelo.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }

    
}
