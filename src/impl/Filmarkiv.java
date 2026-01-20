package impl;

import adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    Film[] filmTab;
    private int antall;

    public Filmarkiv(int lengde){
        filmTab = new Film[lengde];
        antall = 0;
    }


    @Override
    public Film finnFilm(int nr) {
        if (nr > antall) {
            return null;
        }
        return filmTab[nr];
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        for(Film i : filmTab){
            if(i == null && filmTab.lengde != 0){
                i = nyFilm;
            }
        }
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
