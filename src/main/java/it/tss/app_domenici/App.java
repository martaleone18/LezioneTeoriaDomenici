/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.app_domenici;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Anagrafica> contatti = new ArrayList<>();
        contatti.add(new Anagrafica("marta", "leone", 24));
        contatti.add(new Anagrafica("filippo", "leone", 15));
        contatti.add(new Anagrafica("stefano", "leone", 30));
        contatti.add(new Anagrafica("gian", "leone", 60));
        ordina(contatti);
        System.out.println(contatti);

        ArrayList<Calciatore> calciatori = new ArrayList<>();
        calciatori.add(new Calciatore("centrocampista", 1000, "marta", "leone", 24));
        calciatori.add(new Calciatore("difensore", 2500, "filippo", "leone", 15));
        calciatori.add(new Calciatore("difensore", 2000, "stefano", "leone", 30));
        calciatori.add(new Calciatore("portiere", 3000, "gian", "leone", 60));
        ordina(calciatori);
        System.out.println(calciatori);
    }
//ordina lista bubble sort

    private static <T extends Anagrafica> void ordina(ArrayList <T> list) {
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

class Anagrafica {

    String nome, cognome;
    int eta;

    public Anagrafica(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    //meotodo che ritorna <0 se sono piu piccolo, zero se uguale e > 0 
    //se piu grande 
    int confrontaCon(Anagrafica a) {
        if (this.eta == (a.eta)) {
            return 0;
        } else if (this.eta > a.eta) {
            return 1;
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.cognome);
        hash = 11 * hash + this.eta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anagrafica other = (Anagrafica) obj;
        if (this.eta != other.eta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }

}

class Calciatore extends Anagrafica {

    String ruolo;
    int valutazione;

    public Calciatore(String ruolo, int valutazione, String nome, String cognome, int eta) {
        super(nome, cognome, eta);
        this.ruolo = ruolo;
        this.valutazione = valutazione;
    }

    @Override
    int confrontaCon(Anagrafica a) {
        if (a instanceof Calciatore) {
            Calciatore calciatore = (Calciatore) a;
            if (this.valutazione == calciatore.valutazione) {
                return 0;
            } else if (this.valutazione > calciatore.valutazione) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("a non è un calciatore");

    }

    @Override
    public String toString() {
        return super.toString() + "-> + Calciatore{" + "ruolo=" + ruolo + ", valutazione=" + valutazione + '}';
    }
}
