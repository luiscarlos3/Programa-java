/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Database.conection;

/**
 *
 * @author clockwork
 */
public class Enfermero extends Persona {
   
    private String Rol;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    @Override
    public boolean CreateFactory(String Consulta) {
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
        return estado; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateFactory(String Consulta, String column, String txt) {
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

    @Override
    public boolean deleteFactory(String table, String column, String text) {
        //To change body of generated methods, choose Tools | Templates.
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
    
    
    
    
}
