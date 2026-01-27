package klient;

import adt.FilmarkivADT;
import impl.Film;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Tekstgrensesnitt{
	Scanner nyInput = new Scanner(System.in);

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film finnFilm(){
		System.out.println("Hvordan vil du finne filmen? 1.Tittel, 2.Filmnummer");
        String input = nyInput.nextLine();

        while (!input.equals("1") || !input.equals("2")) {
            System.out.println("Feil input. Prøv igjen.");
            System.out.println("Hvordan vil du finne filmen? 1.Tittel, 2.Filmnummer");
            System.out.print("Svar ");
            input = nyInput.nextLine();
        }

        if (input.equals("1")) {
            System.out.print("Hva er tittelen til filmen du leter etter: ");
            String tittel = nyInput.nextLine();
            return arkiv.soekTittel(tittel);
        }

		return Film.getTittel(les);
	}
    /*
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println(
		"| Tittel: " + film.getTittel() + "\n" +
		"| Aar: " + film.getAar() + "\n" +
		"| Produsent: " + film.getProdusent() + "\n" +
		"| Studio: " + film.getStudio() + "\n" +
		"| Film nummer: " + film.getFilmnr()
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
	// andre metoder her*/
}