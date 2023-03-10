/*
 *
 * Il codice rappresenta una classe Java chiamata "TestoUtility" che contiene diversi metodi per la verifica di varie stringhe e caratteri in base a determinati criteri.
 * La classe, in particolare, importa la libreria "java.util.regex" per l'utilizzo di espressioni regolari
 * necessarie per la creazione di modelli che l'utente deve seguire per registrare le proprie credenziali correttamente
 *
 */

package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TestoUtility {
	//Metodo che controlla se una stringa rispetta le regole grammaticali di un Nome/Cognome
	public static boolean verificaNome(String nome) {
		return nome.matches("^([A-Z][a-z]*)([ ]?[A-Z][a-z]*)*$");
	}
	
	//Metodo che controlla se una Email aderisce al modello standard delle Email
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
	
	//Metodo che controlla se una Password è conforme agli standard imposti dal sistema
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
	
	//Metodo che confronta due Password e valuta se sono uguali
	public static boolean confrontoPassword(char[] password, char[] confermaPassword) {
		return new String(password).matches(new String(confermaPassword));
	}
	
	//Metodo che controlla se una data rispetta il formato AAAA-MM-GG
	public static boolean verificaData(String data) {
		return data.matches("^(19[0-9][0-9]|20[0-1][0-9]|202[0-2])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
	}
	
	//Metodo che controlla se il sesso è valido
	public static boolean verificaSesso(String sesso) {
		if(sesso != null) {
			return true;
			
		} else {
			return false;
		}
	}
	
	//Metodo che controlla se il centro scelto è valido
	public static boolean verificaCentro(int idCentro) {
		if(idCentro < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//Metodo che controlla se la professione scelta è valida
	public static boolean verificaSelezione(String elementoSelezionato) {
		if(elementoSelezionato == "") {
			return false;
		} else {
			return true;
		}
	}
	
	//Metodo che controlla se la stringa è un numero
	public static boolean verificaNumero(String stringa) {
		try {
		    Integer.parseInt(stringa);
		    
		    return true;
		} catch(NumberFormatException e) {
		    return false;
		}
	}
}