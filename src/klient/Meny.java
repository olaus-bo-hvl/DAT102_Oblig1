
package klient;

import adt.FilmarkivADT;
import impl.Film;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hva vil du gjøre?");
        System.out.println("(1): Finn film");
        System.out.println("(2): Skriv ut film");
        System.out.println("(3): Skriv ut filmer med lignene tittel");
        System.out.println("(4): Skriv ut film-produsent");
        System.out.println("(5: Skriv ut statistikk fra arkivet");
        System.out.print("Velg et tall mellom (1-5): ");
        int valg = scanner.nextInt();
        switch (valg){
            case 1 -> tekstgr.finnFilm();
            case 2 -> System.out.print("Hvilken film vil du skrive ut? : ");
            Film film = scanner.nextLine();
                    tekstgr.skrivUtFilm();
            case 3 -> noe;
            case 4 -> noe;
            case 5 -> noe;

            scanner.close();
        }
	}	
}
