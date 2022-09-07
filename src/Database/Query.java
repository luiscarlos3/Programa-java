/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author clockwork
 */
public class Query {
    
    public  static  boolean insertar(String Consulta){
         boolean estado = true;
         PreparedStatement ps; 
         try {
             conection sql = new  conection();             
             Connection  con = null;
             con = sql.Conectar();
            ps = con.prepareStatement(Consulta);
            ps.executeUpdate();
            estado = true;          
             
             
         } catch (SQLException ex) {
              System.out.println(ex.toString());
              estado = false;
             
         }
        return estado;
    }
    
    public static ResultSet lista() throws Exception{          
            
              String Consulta ="select identificacion from cliente;";           
              PreparedStatement ps = null;             
               conection sql = new  conection();      
              Connection con = null;
              con = sql.Conectar();
              ps = con.prepareStatement(Consulta);
              ResultSet res = ps.executeQuery();
              return res;            
              
         
          }
    
    public static ResultSet ComboBox(String columns, String table){
         String Consulta = "select "+ columns +" from " + table;
         ResultSet res = null;
         PreparedStatement ps;
         
        try {         
        
         conection sql = new  conection();      
         Connection con = null;
         con = sql.Conectar();
         ps = con.prepareStatement(Consulta);
         res = ps.executeQuery();
        } catch (SQLException e) {
            
            System.out.println(e.toString());
        }       
        
         return res;
        
        
    }
    
    public static void buscar(JTable tabla, String id,  String [] Columnas, String extend_query ){
         String Search = extend_query + " where " + Columnas[0] +  " like" + "'%" + id + "%'";
        try {
            DefaultTableModel modelo = new DefaultTableModel();
             tabla.setModel(modelo);
             conection sql = new  conection();     
            Connection con = sql.Conectar();
            PreparedStatement ps = con.prepareStatement(Search);
            ResultSet ms = ps.executeQuery();
            ResultSetMetaData rmsd = ms.getMetaData();
            int cantidad = rmsd.getColumnCount();
             //String [] Columnas = {"cedula", "nombre", "apellido", "direccion", "telefono", "usuario", "funcion"};
              for (int i = 0; i < Columnas.length; i++) {
                 modelo.addColumn(Columnas[i]);                 
             }
              while (ms.next())
             {                 
                 Object[] filas = new Object[cantidad];
                 for (int i = 0; i < cantidad; i++) {
                     filas[i] = ms.getObject(i + 1);
                 }
                 modelo.addRow(filas);
             }
            
        } catch (Exception e) {
        }
        
    }
    
     public static ResultSet read(String Query) {              
         ResultSet res =null;
         try {
           PreparedStatement ps;
         conection sql = new  conection();      
         Connection con = null;
         con = sql.Conectar();
         ps = con.prepareStatement(Query);
         res = ps.executeQuery();
        } catch (SQLException e) {
             System.out.println(e.toString());
        }
        
         return res;       
      
    }
    
     public static boolean update (String Consulta, String column, String txt ){
        String Query = Consulta + " where "+ column + " = '" + txt + "'";
        
        boolean estado = true;
         PreparedStatement ps; 
         try {
             conection sql = new  conection();    
             Connection  con = null;
             con = sql.Conectar();
            ps = con.prepareStatement(Query);
            ps.executeUpdate();
            estado = true;           
             
             
         } catch (SQLException ex) {
              System.out.println(ex.toString());
              estado = false;
             
         }
        return estado;
    
    }
     
     public static boolean delete(String table, String column ,String text ){        
          boolean estado = false;
          String Consulta= "delete from " + table +" where " + column +" = " + "'" + text + "'";
        PreparedStatement ps;
        try {
            conection sql = new  conection();   
            Connection con = null;
            con = sql.Conectar();
            ps = con.prepareStatement(Consulta);
            ps.executeUpdate();
            estado = true;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            estado=false;
        }
        return estado;
    }
     
      public static boolean login(String Usuario, String Contraseña, String table){
        String Consulta = "select identificacion, contraseña from " + table + " where identificacion = "+ "'" + Usuario + "'"+ " and " + " contraseña = "+ "'"+Contraseña+"'";
        boolean find = false;
        try {
             conection sql = new  conection();      
            Connection con = sql.Conectar();
            PreparedStatement ps = con.prepareStatement(Consulta);
            ResultSet validar = ps.executeQuery();
            if(validar.next()){
                find = true;
            }else{
                find = false;
            }
                    
            
        } catch (SQLException e) {
             System.out.println(e.toString());
            
        }
        
        return find;
        
    }
    
     public static boolean validar(String Usuario, String table, String column){
        String Consulta = "select " + column +  " from " + table + " where " + column +" = "+ "'" + Usuario + "'";
        boolean find = false;
        try {
             conection sql = new  conection();    
            Connection con = sql.Conectar();
            PreparedStatement ps = con.prepareStatement(Consulta);
            ResultSet validar = ps.executeQuery();
            if(validar.next()){
                find = true;
            }else{
                find = false;
            }
                    
            
        } catch (SQLException e) {
             System.out.println(e.toString());
            
        }
        
        return find;
        
    }
      
     
      
      public static ResultSet Factura( String Consulta) throws Exception{          
         PreparedStatement ps;
      conection sql = new  conection();   
       Connection con = null;
       con = sql.Conectar();
       ps = con.prepareStatement(Consulta);
       ResultSet res = ps.executeQuery();
       return res;
    }
    
}
