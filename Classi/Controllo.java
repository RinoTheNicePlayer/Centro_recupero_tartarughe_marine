package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controllo {
	public static boolean verificaEmail(String Email) {
		boolean stato = false;
		
		String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		Pattern modello = Pattern.compile(modelloEmail);
		Matcher relazione = modello.matcher(Email);
		
		if(relazione.matches()) {
			stato = true;
		} else {
			stato = false;
		}
		
		return stato;
	}
	
	public static boolean verificaPassword(String Password) {
		boolean stato = false;
		
		String modelloPassword = "({8,16})";
		
		Pattern modello = Pattern.compile(modelloPassword);
		Matcher relazione = modello.matcher(Password);
		
		if(relazione.matches()) {
			stato = true;
		} else {
			stato = false;
		}
		
		return stato;
	}
}