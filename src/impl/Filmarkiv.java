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
        //sjekke at det er plass
        if(antall<filmTab.length){
            filmTab[antall] = nyFilm;
            antall++;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {

        if(antall <= 0){
            return false;
        }

        for(int i = 0; i < antall; i++){
            if(filmTab[i].getFilmnr() == filmnr){
                filmTab[i] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        // Lager en midlertidig tabell som skal returneres på slutten av metoden
        Film[] tempTab = new Film[antall];
        int lengde = 0;     // skal indikere hvor i tempTab som er neste ledige plass
        // går gjennom tabellen og ser hvis tittelene matcher delstrengen. hvis ja, legges den filmen til i tempTab.
        for (int i = 0; i < antall; i++) {
            if (filmTab[i].getTittel().contains(delstreng)) {
                tempTab[lengde] = filmTab[i];
                lengde++;
            }
        }
        return tempTab;
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
