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
        LinearNode<Film> current = start;   //Lager en temp node-peker som peker på start
        //while-løkke og if-else-løkke som går gjennom listen og leter etter filmen
        while (current != null) {
            if (current.getData().getFilmnr() == nr) {      //hvis noden som vi ser på nå har samme filmnr som blir gitt returnerer den filmen
                return current.getData();
            } else {        //hvis ikke setter vi current til neste node i listen
                current = current.getNeste();
            }
        }
        return null;        //returnerer null hvis den ikke finner listen
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> ny = new LinearNode<>(nyFilm); //Oppretter noden som skal legges til i listen
        ny.setNeste(start); //setter den nye noden til å peke på forrige start
        start = ny; //setter den nye noden som start
        antall++;   //øker antall med 1
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (antall == 0) return false;  //sjekker om listen er tom
        //Sletter filmen, om den ligger på første plass i listen
        if (start.getData().getFilmnr() == filmnr) {
            start = start.getNeste();
            antall--;
            return true;
        }
        //Lager to node-pekere for å holde styr på to plasser i listen om gangen, starter med plass 1 og 2
        LinearNode<Film> forrige = start;
        LinearNode<Film> current = start.getNeste();
        //While-løkke og if-løkke som går gjennom listen og finner filmen som skal slettes
        while (current != null) {
            if (current.getData().getFilmnr() == filmnr) {
                forrige.setNeste(current.getNeste());   //Setter forrige node til å peke på noden etter den noden som slettes
                antall--;   //minker antall med 1 siden en film slettes
                return true;
            }
            //flytter forrige og current et steg videre i listen
            forrige = current;
            current = current.getNeste();
        }
        return false;   //returnerer false hvis filmen ikke var i listen
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        //det bli gjort det samme her som i soekProdusent. soekProdusent er neste metode.
        Film[] tempTab = new Film[antall];
        int ant = 0;

        LinearNode<Film> current = start;

        while(current != null){
            if(current.getData().getTittel().contains(delstreng)){
                tempTab[ant] = current.getData();
                ant++;
            }
            current = current.getNeste();
        }
        return tempTab;

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
        int antallSjanger = 0;  //Lager en int som skal returneres med antall filmer med samme sjanger
        LinearNode<Film> current = start;   //Lager current
        //While-løkke som går gjennom listen og sjekker om sjangeren på filmene er lik den som søkes etter, antallSjanger++ hvis det er likt
        while (current != null) {
            if (current.getData().getSjanger() == sjanger) {
                antallSjanger++;
            }
            current = current.getNeste();
        }
        return antallSjanger;   //returnerer antallSjanger
    }

    @Override
    public int antall() {
        return antall;
    }
}
