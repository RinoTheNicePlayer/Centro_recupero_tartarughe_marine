package Classi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TestoUtility {
	//Funzione che controlla se una Email aderisce agli standard
		public static boolean verificaEmail(String email) {
			boolean controlloMatch = false;
			boolean controlloEmail = false;
			
			String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]*)$";
			
			Pattern modello = Pattern.compile(modelloEmail);
			Matcher relazione = modello.matcher(email);
			
			if(relazione.matches()) {
				controlloMatch = true;
				
			} else {
				controlloMatch = false;
			}
			
			if((controlloMatch == true) && (controlloMatch != email.equals(""))) {
				controlloEmail = true;
				
			} else {
				controlloEmail = false;
			}
			return controlloEmail;
		}
		
		//Funzione che controlla se una Password è conforme agli standard imposti dal programma
		public static boolean verificaPassword(char[] password) {
			int lunghezzaPassword = password.length+1;
			boolean controlloPassword = false;
			
			if(lunghezzaPassword == 0) {
				controlloPassword = false;
				
			} else if(lunghezzaPassword < 8 || lunghezzaPassword > 16){
				controlloPassword = false;
				
			} else {
				controlloPassword = true;
			}
			
			return controlloPassword;
		}
}
