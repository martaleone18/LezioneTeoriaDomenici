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
public class AbstractEsempio {
     public static void main(String[] args) {
       ArrayList<Veicolo> v = new ArrayList<>();
        v.add(new Veicolo(2019));
        v.add(new Veicolo(2017));
        v.add(new Veicolo(2015));
        
     }

   
    
}
  

abstract class Ordinabile{
    public abstract int confrontaCon(Object o);
}


class Veicolo extends Ordinabile{
    int anno;

    public Veicolo(int anno) {
        this.anno = anno;
    }
    
    @Override
    public int confrontaCon (Object o){
        if (o instanceof Veicolo){
            Veicolo veicolo = (Veicolo)o;
            
            if (this.anno== veicolo.anno){
                return 0;
                
            } else if (this.anno>veicolo.anno){
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("tipo errato");
    }

    @Override
    public String toString() {
        return "Veicolo{" + "anno=" + anno + '}';
    }
}


class Phone extends Ordinabile{
    int num;

    public Phone(int num) {
        this.num = num;
    }
    
    @Override
    public int confrontaCon (Object o){
        
        if (o instanceof Phone){
            Phone phone = (Phone)o;
            
            if (this.num== phone.num){
                return 0;
                
            } else if (this.num>phone.num){
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("tipo errato");
    }

    @Override
    public String toString() {
        return "Phone{" + "num=" + num + '}';
    }
        
    }
