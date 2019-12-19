/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.app_domenici;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Generics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
    }
    
}


class Test {
    String cognome;

    public Test(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Test{" + "cognome=" + cognome + '}';
    }
    
}

class Box<T,K>{
    private T contenuto;
    private K contenuto1;

    public Box(T contenuto, K contenuto1) {
        this.contenuto = contenuto;
        this.contenuto1 = contenuto1;
        
    }
    public T getContenuto (){
        return contenuto;
    }
    public K getContenuto1 (){
        return contenuto1;
    }
 
}