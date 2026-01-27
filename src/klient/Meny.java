
package klient;

import adt.FilmarkivADT;
import impl.Film;
import impl.Filmarkiv;
import impl.Sjanger;

import java.util.Scanner;

public class Meny{
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv){
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
		}
	public void start(){
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		// ..

        Film film1 = new Film(1,"HVl-studios", "Avatar", 2020, "E403", Sjanger.ADVENTURE);
        Film film2 = new Film(2,"Warner", "Iron man", 2021, "E402", Sjanger.ACTION);
        Film film3 = new Film(3,"AresHjem", "Pirates of the Caribbean", 2019, "E403", Sjanger.ADVENTURE);
        Film film4 = new Film(4,"Aretho", "Mr.Bean", 2002, "E405", Sjanger.HORROR);
        Film film5 = new Film(5,"HVl-studios", "Harry Potter", 2001, "E408", Sjanger.DRAMA);
        Film film6 = new Film(6,"Warner", "Ringens Herre", 1999, "E409", Sjanger.FANTASY);


        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Hva vil du gjøre?");
        System.out.println("(1): Legg til film");
        System.out.println("(2): Skriv ut film");
        System.out.println("(3): Skriv ut filmer med lignene tittel");
        System.out.println("(4): Skriv ut film-produsent");
        System.out.println("(5): Skriv ut statistikk fra arkivet");
        System.out.print("Velg et tall mellom (1-5): ");
        int valg = scanner.nextInt();
        switch (valg) {
            case 1 -> {
                Film film = tekstgr.lesFilm();
                filmarkiv.leggTilFilm(film);
            }
            case 2 -> {
                System.out.print("Skriv inn film-nummer: ");

                int nr = scanner.nextInt();
                Film film = filmarkiv.finnFilm(nr);
                tekstgr.skrivUtFilm(film);
            }
            case 3 -> {
                System.out.print("Skriv inn tittel: ");
                String tittel = scanner.nextLine();
                tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
            }
            case 4 -> noe;
            case 5 -> noe;

            scanner.close();
        }
	}	
}
