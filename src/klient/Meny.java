package klient;

import java.util.Scanner;

public class Meny{
	public Meny(){
		Scanner ska = new Scanner(System.in);
		String spor = "";
		while (!spor.equals("s")){
			System.out.println("hva onsker du a gjore?");
			spor = ska.nextLine();
		}
	}
}