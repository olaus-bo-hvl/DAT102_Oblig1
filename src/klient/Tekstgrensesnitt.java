package klient;

import adt.FilmarkivADT;
import impl.Film;
import impl.Sjanger;
import java.util.Scanner;

public class Tekstgrensesnitt{
	Scanner nyInput = new Scanner(System.in);

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
        System.out.println("Hva er filmnummeret til filmen?");
        System.out.print("Filmnummer: ");
        int filmnr = nyInput.nextInt();
        nyInput.nextLine();

        System.out.println("Hvem er produsenten til filmen?");
        System.out.print("Produsent: ");
        String produsent = nyInput.nextLine();

        System.out.println("Hva er tittelen til filmen?");
        System.out.print("Tittel: ");
        String tittel = nyInput.nextLine();

        System.out.println("Hvilket år kom filmen ut?");
        System.out.print("Utgivelsesår: ");
        int aar = nyInput.nextInt();
        nyInput.nextLine();

        System.out.println("Hvilket studio laget filmen?");
        System.out.print("Studio: ");
        String studio = nyInput.nextLine();

        System.out.println("Hvilken sjanger har filmen? \n" +
                "ACTION, ADVENTURE, COMEDY, \n" +
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
		"| " + "\n" +
        "| Tittel: " + film.getTittel() + "\n" +
		"| Aar: " + film.getAar() + "\n" +
		"| Produsent: " + film.getProdusent() + "\n" +
		"| Studio: " + film.getStudio() + "\n" +
		"| Film nummer: " + film.getFilmnr() + "\n" +
        "| Sjanger: " + film.getSjanger().toString() + "\n" +
        "| "
		);
	}


	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		boolean funnet = false;

        Film[] filmtab = arkiv.soekTittel(delstreng);
        for (Film i : filmtab) {
            if (i != null) {
                skrivUtFilm(i);
                funnet = true;
            }
        }

        if (!funnet) {
            System.out.println("Ingen filmer funnet.");
        }
	}


	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        boolean funnet = false;

        Film[] filmtab = arkiv.soekProdusent(delstreng);
        for (Film i : filmtab) {
            if (i != null) {
                skrivUtFilm(i);
                funnet = true;
            }
        }

        if (!funnet) {
            System.out.println("Ingen filmer funnet.");
        }
	}


	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int antall = arkiv.antall();
        int action = arkiv.antall(Sjanger.ACTION);
        int adventure = arkiv.antall(Sjanger.ADVENTURE);
        int comedy = arkiv.antall(Sjanger.COMEDY);
        int documentary = arkiv.antall(Sjanger.DOCUMENTARY);
        int drama = arkiv.antall(Sjanger.DRAMA);
        int fantasy = arkiv.antall(Sjanger.FANTASY);
        int horror = arkiv.antall(Sjanger.HORROR);
        int reality = arkiv.antall(Sjanger.REALITY);
        int scifi = arkiv.antall(Sjanger.SCIFI);


        System.out.println(
                "| Antall filmer: " + antall + "\n" +
                "| Antall actionfilmer: " + action + "\n" +
                "| Antall advneturefilmer: " + adventure + "\n" +
                "| Antall comedyfilmer: " + comedy + "\n" +
                "| Antall documentaryfilmer: " + documentary + "\n" +
                "| Antall dramafilmer: " + drama + "\n" +
                "| Antall fantasyfilmer: " + fantasy + "\n" +
                "| Antall horrorfilmer: " + horror + "\n" +
                "| Antall realityfilmer: " + reality + "\n" +
                "| Antall scififilmer: " + scifi + "\n"
        );
	}


	// andre metoder her*/
}