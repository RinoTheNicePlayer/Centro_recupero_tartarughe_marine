package Classi.Controller;

import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;

import Classi.TestoUtility;
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
	
	/*Funzione per effettuare l'accesso. Controlla che i campi siano validi. Se si chiama la classe PersonaleDatabase per la QUERY*/
	public void effettuaAccesso(String email, char[] password) {
		boolean validaEmail = TestoUtility.verificaEmail(email);
		boolean validaPassword = TestoUtility.verificaPassword(password);
		
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
			PersonaleDatabase.getInstance().controlloAccesso(email, new String(password));
		}

	}
	
	protected AccessoController() {
		
	}
}