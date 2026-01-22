/*
package klient;

import adt.FilmarkivADT;
import impl.Film;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Tekstgrensesnitt{
	Scanner ska = new Scanner(System.in);
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
		System.out.println("film?:" );
		les = ska.nextLine();
		return Film.getTittel(les);
	}
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println(
		"| Tittel: " + Film.getTittel(film) + "\n" +
		"| Aar: " + Film.getAar(film) + "\n" +
		"| Produsent: " + Film.getProdusent(film) + "\n" +
		"| Studio: " + Film.getStudio(film) + "\n" +
		"| Film nummer: " + Film.getFilmnr(film)
		);
	}
	// Skriver ut alle filmer med en spesiell delstreng i tittecdlen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		for (String tittel : arkiv){ // må trolig endre type her
			if (tittel.contains(delstreng)){
				System.out.println(tittel);
			}
		}
	}
	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		for (int i = 0; i < arkiv.length; i++){
			if (arkiv[i].equals(Film.getProdusent(delstreng))){
				System.out.println(arkiv[i]);
			}
		}
	}
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int antallFilmer = 0;
		HashMap<Film, Integer> stats = new HashMap<>();
		for (Film film : arkiv){
			antallFilmer++;
			stats.put(getSjanger(film), stats.getOrDefault(film, 0)+1);
		}
		for (Map.Entry<Film, Integer> entry : stats.entrySet()){
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	// andre metoder her
}

 */
