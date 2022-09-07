/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author clockwork
 */
public class ParCombo {
    
     private int value;   
    private String label;

   
    
    public ParCombo(int value, String label){
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }
   
  
    public String toString(){
        return label;
    }
    
}
