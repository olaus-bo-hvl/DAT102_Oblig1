package impl;

import adt.FilmarkivADT;

import java.util.LinkedList;

public class Filmarkiv2 implements FilmarkivADT {
    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2(){
        start = null;
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.getData().getFilmnr() == nr) {
                return current.getData();
            } else {
                current = current.getNeste();
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> ny = new LinearNode<>(nyFilm);
        ny.setNeste(start);
        start = ny;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start.getData().getFilmnr() == filmnr) {
            start = start.getNeste();
            antall--;
            return true;
        }
        LinearNode<Film> forrige = start;
        LinearNode<Film> current = start.getNeste();
        while (current != null) {
            if (current.getData().getFilmnr() == filmnr) {
                forrige.setNeste(current.getNeste());
                antall--;
                return true;
            } else {
                forrige = current;
                current = current.getNeste();
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        // Sjekker at listen ikke er tom
        if (antall == 0) {
            return null;
        }

        // Lager tabellen som skal returneres, lager den like lang som antall sånn at den er lang nok
        Film[] tempTab = new Film[antall];
        //Lager en peker som peker på den noden som vi ser på
        LinearNode<Film> current = start;
        //Lager en temp antall som sier hvor i tabellen vi er, starter på 0
        int ant = 0;
        //Lager en while løkke som stopper når vi kommer ut av listen
        while (current != null) {
            //If-løkken sjekker om delstrengen er med i produsentnavnet til current og hvis det stemmer legges current til i tabellen
            if (current.getData().getProdusent().contains(delstreng)) {
                tempTab[ant] = current.getData();
                ant++;
            }
            //current blir satt til neste node i listen
            current = current.getNeste();
        }
        //returnerer tabellen med filmene med produsenter som inneholder delstreng i navnet
        return tempTab;
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }
}
