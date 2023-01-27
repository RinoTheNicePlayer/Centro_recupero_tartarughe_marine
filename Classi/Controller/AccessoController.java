/*
 *
 * Il codice rappresenta una classe Java chiamata "AccessoController" che gestisce l'accesso degli utenti all'applicazione.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * In più, sfrutta la classe "TestoUtility" per verificare la validità dell'indirizzo email e della password inseriti dall'utente.
 * In caso di dati non validi, viene visualizzata una finestra di errore con un messaggio specifico.
 * Se i dati sono validi, la classe AccessoController chiama la classe "PersonaleDatabase" per eseguire la query di accesso e verificare se l'utente esiste nel sistema
 *
 */

package Classi.Controller;

import Classi.TestoUtility;
import Classi.Database.PersonaleDatabase;
import Classi.View.ErroreView;

public final class AccessoController {
	/*
	 *
	 * Metodo che restituisce un'istanza della classe AccessoController, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static AccessoController instance = null;
	
	public static AccessoController getInstance() {
		if(instance == null) {
			instance = new AccessoController();
		}
		
		return instance;
	}
	
	/*
	 *
	 * Metodo che consente ad un utente di effettuare l'accesso all'applicazione. Tale metodo verifica se l'email e la password dell'utente sono valide.
	 * Se quest'ultime sono valide, viene interpellata la classe PersonaleDatabase per eseguire la query
	 *
	 */
	public boolean effettuaAccesso(String email, char[] password) {
		boolean validaEmail = TestoUtility.verificaEmail(email);
		boolean validaPassword = TestoUtility.verificaPassword(password);
		
		if((validaEmail == false) && (validaPassword == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email e password non valide.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		} else if(validaEmail == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		} else if(validaPassword == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Password non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		} else {
			return PersonaleDatabase.getInstance().controlloAccesso(email, new String(password));
		}
		
		return false;
	}
}