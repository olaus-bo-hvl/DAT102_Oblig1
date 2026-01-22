package impl;

import adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private LinearNode<Film> filmTab;
    private LinearNode<Film> start;
    private int antall;

    public Filmarkiv2(Film nyFilm){
        filmTab = new LinearNode<>(nyFilm);
        start = null;
        antall = 1;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode current;
        for (int i = 0; i < antall; i++) {
            if (filmTab.getData().getFilmnr() == nr) {
                return filmTab.getData();
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {

    }

    @Override
    public boolean slettFilm(int filmnr) {
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
