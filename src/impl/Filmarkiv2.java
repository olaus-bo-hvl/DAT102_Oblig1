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
        return new Film[0];
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
