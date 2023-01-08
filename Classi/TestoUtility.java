package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TestoUtility {
	//Funzione che controlla se una stringa rispetta le regole grammaticali di un Nome/Cognome
	public static boolean verificaNome(String nome) {
		return nome.matches("^([A-Z][a-z]*)([ ]?[A-Z][a-z]*)*$");
	}
	
	//Funzione che controlla se una Email aderisce agli standard
	public static boolean verificaEmail(String email) {
		boolean controlloRelazione = false;
		boolean controlloEmail = false;
		
		String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]*)$";
			
		Pattern modello = Pattern.compile(modelloEmail);
		Matcher relazione = modello.matcher(email);
			
		if(relazione.matches()) {
			controlloRelazione = true;
		} else {
			controlloRelazione = false;
		}
		
		if((controlloRelazione == true) && (controlloRelazione != email.equals(""))) {
			controlloEmail = true;
		} else {
			controlloEmail = false;
		}
		
		return controlloEmail;
	}
	
	//Funzione che controlla se una Password è conforme agli standard imposti dal sistema
	public static boolean verificaPassword(char[] password) {
		int lunghezzaPassword = password.length + 1;
		boolean controlloPassword = false;
		
		if(lunghezzaPassword == 0) {
			controlloPassword = false;
		} else if(lunghezzaPassword < 8 || lunghezzaPassword > 16) {
			controlloPassword = false;
		} else {
			controlloPassword = true;
		}
		
		return controlloPassword;
	}
	
	//Funzione che confronta due Password e valuta se sono uguali
	public static boolean controlloMatchingPassword(char[] password, char[] confermaPassword) {
		return new String(password).matches(new String(confermaPassword));
	}
	
	//Funzione che controlla se una data rispetta il formato AAAA-MM-GG
	public static boolean verificaData(String data) {
		return data.matches("^(19[0-9][0-9]|20[0-1][0-9]|202[0-2])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
	}
	
	//Funzione che controlla se il sesso è valido
	public static boolean verificaSesso(String sesso) {
		if(sesso != null) {
			return true;
			
		} else {
			return false;
		}
	}
	
	//Funzione che controlla se il centro scelto è valido
	public static boolean verificaCentro(int idCentro) {
		if(idCentro < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//Funzione che controlla se la professione scelta è valida
	public static boolean verificaProfessione(String professione) {
		if(professione == null) {
			return false;
		} else {
			return true;
		}
	}
}