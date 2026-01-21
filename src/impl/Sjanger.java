package impl;

public enum Sjanger {
	ACTION, ADVENTURE, COMEDY, 
	DOCUMENTARY, DRAMA, FANTASY, 
	HORROR, REALITY, SCIFI;
	
	public static Sjanger sok(String sjanger){
		for (Sjanger s : Sjanger.values()){
			if (s.toString().equals(sjanger.toUpperCase())){
				return s;
			}
		}
		// hvis sjangeren ikke er listet
		return null;
	}
}