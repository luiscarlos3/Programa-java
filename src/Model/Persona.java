/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;

/**
 *
 * @author clockwork
 */
abstract class Persona {
    
    protected  String identificacion;    
    protected  String nombre; 
    protected String apellido;
    protected  String direccion;
    protected  String telefono;
    
    protected boolean CreateFactory(String Consulta){
        
        return false;
    }
    protected boolean updateFactory (String Consulta, String column, String txt){
        
        return false;
    }
    
    protected boolean deleteFactory(String table, String column ,String text){
        
        return false;
    }
    
}
