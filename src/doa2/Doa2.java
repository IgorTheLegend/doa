/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa2;

import Sangue.Sangue;

/**
 *
 * @author italo
 */
public class Doa2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("executou");
        Sangue s = new Sangue();
        s.setFatorRh("+");
        s.setTipoSanguineo("A");
        s.save();
    }
    
}
