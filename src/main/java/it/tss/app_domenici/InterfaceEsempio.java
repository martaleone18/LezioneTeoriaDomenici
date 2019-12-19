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
public class InterfaceEsempio {
        public static void main(String[] args) {
            Sortable s;
            
        }
    private static <T extends Sortable> void ordina(ArrayList <T> list) {
        boolean ordinato;

        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                T corrente = list.get(i);
                T successiva = list.get(i + 1);
                if (corrente.confrontaCon(successiva) > 0) {
                    list.set(i, successiva);
                    list.set(i + 1, corrente);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
   
}
interface Sortable <T> {
 int confrontaCon(T o);

}

class Computer implements Sortable {

    @Override
    public int confrontaCon(Object o) {
        return 0;
    }
    
}