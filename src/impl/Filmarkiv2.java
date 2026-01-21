package impl;

import adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    Film[] filmTab;
    private int antall;

    public Filmarkiv2(int lengde){
        filmTab = new Film[lengde];
        antall = 0;
    }


    @Override
    public Film finnFilm(int nr) {
        // går gjennom tabellen og sjekker om filmnr er likt nr og returnerer filmen hvis nr stemmer
        for (int i = 0; i < antall; i++) {
            if (nr == filmTab[i].getFilmnr()) {
                return filmTab[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(antall==filmTab.length){
            utvid(filmTab);
        }
        //sjekke at det er plass
        if(antall<filmTab.length){
            filmTab[antall] = nyFilm;
            antall++;
        }
    }
    private void utvid(Film[] tab){
        Film[] nyTab = new Film[tab.length*2];
        for(int i=0;i<filmTab.length;i++){
            nyTab[i] = filmTab[i];
        }
        filmTab = nyTab;
    }

    @Override
    public boolean slettFilm(int filmnr) {

        //Gå gjennom tabellen og sjekke om filmene i tabellen har samme nummer som parameteren
        //Hvis nummeret er likt blir filmen slettet
        for(int i = 0; i < antall; i++){
            if(filmTab[i] !=null && filmTab[i].getFilmnr() == filmnr){
                filmTab[i] = filmTab[antall - 1];
                filmTab[antall - 1] = null;
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
        // går gjennom tabellen og ser hvis tittelene inneholder delstrengen. hvis ja, legges den filmen til i tempTab.
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
        // Lager en midlertidig tabell som skal returneres på slutten av metoden
        Film[] tempTab = new Film[antall];
        int lengde = 0;     // skal indikere hvor i tempTab som er neste ledige plass
        // går gjennom tabellen og ser hvis produsenten inneholder delstrengen. hvis ja, legges den filmen til i tempTab.
        for (int i = 0; i < antall; i++) {
            if (filmTab[i].getProdusent().contains(delstreng)) {
                tempTab[lengde] = filmTab[i];
                lengde++;
            }
        }
        return tempTab;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;
        for (Film i : filmTab) {
            if (i != null && i.getSjanger().equals(sjanger)) {
                antallSjanger++;
            }
        }
        return antallSjanger;
    }

    @Override
    public int antall() {
        return antall;
    }
}
