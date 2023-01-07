package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TestoUtility {
	//Funzione che controlla se una Email aderisce agli standard
		public static boolean verificaEmail(String email) {
			boolean checkMatch = false;
			boolean checkEmail = false;
			
			String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]*)$";
			
			Pattern modello = Pattern.compile(modelloEmail);
			Matcher relazione = modello.matcher(email);
			
			if(relazione.matches()) {
				checkMatch = true;
				
			} else {
				checkMatch = false;
			}
			
			if((checkMatch == true) && (checkMatch != email.equals(""))) {
				checkEmail = true;
				
			} else {
				checkEmail = false;
			}
			return checkEmail;
		}
		
		//Funzione che controlla se una Password è conforme agli standard imposti dal programma
		public static boolean verificaPassword(char[] password) {
			int lunghezzaPassword = password.length+1;
			boolean checkPassword = false;
			
			if(lunghezzaPassword == 0) {
				checkPassword = false;
				
			} else if(lunghezzaPassword < 8 || lunghezzaPassword > 16){
				checkPassword = false;
				
			} else {
				checkPassword = true;
			}
			
			return checkPassword;
		}
}
