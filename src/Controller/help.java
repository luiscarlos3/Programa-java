/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Random;

/**
 *
 * @author clockwork
 */
public class help {
    public static int Codigo(){
        Random rnd = new Random(123L);
        return rnd.nextInt(100);
    }
    
}
