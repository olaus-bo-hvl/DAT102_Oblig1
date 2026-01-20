package impl;

public class Film{
	private int	filmnr;
	private String produsent;
	private String tittel;
	private int aar;
	public enum Sjanger{Action, Drama, History, SciFi}
	private String studio;
	private Sjanger sjanger;
	
	public Film(Sjanger sjanger){
		this.sjanger = sjanger;
	}
	public Film(int filmnr, String produsent, String tittel, int aar, String studio){
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.aar = aar;
		this.studio = studio;
	}
	public int getFilmnr(){
		return filmnr;
	}
	public void setFilmnr(int filmnr){
		this.filmnr = filmnr;
	}
	public String getProdusent(){
		return produsent;
	}
	public void setProdusent(){
		this.produsent = produsent;
	}
	public String getTittel(){
		return tittel;
	}
	public void setTittel(String tittel){
		this.tittel = tittel;
	}
	public int getAar(){
		return aar;
	}
	public void setAar(int aar){
		this.aar = aar;
	}
	public String getStudio(){
		return studio;
	}
	public void setStudio(String studio){
		this.studio = studio;
	}
	// equals, hashcode
	public boolean equals(int filmnr1, int filmnr2){
		if (filmnr1 == filmnr2){
			System.out.println("like.");
			return true;
		}
		System.out.println("ulike.");
		return false;
	}
	
}