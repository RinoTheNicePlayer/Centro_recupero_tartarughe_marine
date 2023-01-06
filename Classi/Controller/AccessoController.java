package Classi.Controller;

import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;

import Classi.Database.PersonaleDatabase;
import Classi.View.AccessoView;
import Classi.View.ErroreView;

public final class AccessoController {
	
	private static AccessoController instance = null;
	
	public static AccessoController getInstance() {
		if (instance == null) {
			instance = new AccessoController();
		}
		return instance;
	}
	
	//Funzione che controlla se una Email aderisce agli standard
	public boolean verificaEmail(String email) {
		boolean checkMatch = false;
		boolean checkEmail = false;
		
		String modelloEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
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
	
	//Funzione che controlla se una Password è conforme agli standard imposti
	public boolean verificaPassword(char[] password) {
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
	
	/*Funzione per effettuare l'accesso. Controlla che i campi siano validi. Se si chiama la classe PersonaleDatabase per la QUERY*/
	public void effettuaAccesso(String email, char[] password) {
		boolean validaEmail = verificaEmail(email);
		boolean validaPassword = verificaPassword(password);
		
		if((validaEmail == false) && (validaPassword == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email e password non validi.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		}else if(validaEmail == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		}else if(validaPassword == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Password non valida");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		}else {
			Personale personale = new Personale
			PersonaleDatabase.selectPersonale(email, password.toString());
		}

	}
	
	protected AccessoController() {
		
	}
}