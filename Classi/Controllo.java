package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controllo {
	//Funzione che valuta se l'email inserita dall'utente è coerente col modello standard delle email
	public static boolean verificaEmail(String email) {
		boolean stato = false;
		
		String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern modello = Pattern.compile(modelloEmail);
		Matcher relazione = modello.matcher(email);
		
		if(relazione.matches()) {
			stato = true;
		} else {
			stato = false;
		}
		
		return stato;
	}
}