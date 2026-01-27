package klient;

import adt.FilmarkivADT;
import impl.Film;
import impl.Filmarkiv;
import impl.Sjanger;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Tekstgrensesnitt{
	Scanner nyInput = new Scanner(System.in);

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
        System.out.println("Hva er filmnummeret til filmen?");
        System.out.print("Filmnummer: ");
        int filmnr = nyInput.nextInt();

        System.out.println("Hvem er produsenten til filmen?");
        System.out.print("Produsent: ");
        String produsent = nyInput.nextLine();

        System.out.println("Hva er tittelen til filmen?");
        System.out.print("Tittel: ");
        String tittel = nyInput.nextLine();

        System.out.println("Hvilket år kom filmen ut?");
        System.out.print("Utgivelsesår: ");
        int aar = nyInput.nextInt();

        System.out.println("Hvilket studio laget filmen?");
        System.out.print("Studio: ");
        String studio = nyInput.nextLine();

        System.out.println("Hvilken sjanger har filmen? ACTION, ADVENTURE, COMEDY, \n" +
                "DOCUMENTARY, DRAMA, FANTASY, \n" +
                "HORROR, REALITY, SCIFI;");
        System.out.print("Sjanger: ");
        String tempsjanger = nyInput.nextLine();
        Sjanger sjanger = Sjanger.sok(tempsjanger);

        Film film = new Film(filmnr,produsent,tittel,aar,studio,sjanger);
		return film;
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println(
		"| Tittel: " + film.getTittel() + "\n" +
		"| Aar: " + film.getAar() + "\n" +
		"| Produsent: " + film.getProdusent() + "\n" +
		"| Studio: " + film.getStudio() + "\n" +
		"| Film nummer: " + film.getFilmnr() + "\n" +
        "| Sjanger: " + film.getSjanger().toString()
		);
	}

	/*
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
	// andre metoder her*/
}