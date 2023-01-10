package Classi.Controller;

import Classi.TestoUtility;
import Classi.Database.PersonaleDatabase;
import Classi.View.ErroreView;

public final class AccessoController {
	//Inizializzazione dell'istanza
	private static AccessoController instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static AccessoController getInstance() {
		if(instance == null) {
			instance = new AccessoController();
		}
		
		return instance;
	}
	
	/*Funzione che permette di effettuare l'accesso. Tale funzione verifica se i campi siano validi.
	 * Se quest'ultimi sono validi, chiama la classe PersonaleDatabase per eseguire la Query
	 */
	public boolean effettuaAccesso(String email, char[] password) {
		boolean validaEmail = TestoUtility.verificaEmail(email);
		boolean validaPassword = TestoUtility.verificaPassword(password);
		
		if((validaEmail == false) && (validaPassword == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email e password non validi.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if(validaEmail == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if(validaPassword == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Password non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else {
			return PersonaleDatabase.getInstance().controlloAccesso(email, new String(password));
		}
		
		return false;
	}
}