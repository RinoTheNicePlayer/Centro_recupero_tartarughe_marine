package Classi.Controller;

import Classi.TestoUtility;
import Classi.View.ErroreView;

public final class RegistrazioneController {
	private static RegistrazioneController instance = null;
	
	public static RegistrazioneController getInstance() {
		if(instance == null) {
			instance = new RegistrazioneController();
		}
		
		return instance;
	}
	
	/*Funzione che permette di effettuare la registrazione. Tale funzione verifica se i campi siano validi.
	 * Se quest'ultimi sono validi, chiama la classe PersonaleDatabase per eseguire la Query
	 */
	public void effettuaRegistrazione(String nome, String cognome, String email, char[] password, char[] confermaPassword, String dataDiNascita, String sesso, int idCentro, String professione) {
		boolean validaNome = TestoUtility.verificaNome(nome);
		boolean validaCognome = TestoUtility.verificaNome(cognome);
		boolean validaEmail = TestoUtility.verificaEmail(email);
		boolean validaPassword = TestoUtility.verificaPassword(password);
		boolean passwordUguali = TestoUtility.controlloMatchingPassword(password, confermaPassword);
		boolean validaDataDiNascita = TestoUtility.verificaData(dataDiNascita);
		boolean validaSesso = TestoUtility.verificaSesso(sesso);
		boolean validaCentro = TestoUtility.verificaCentro(idCentro);
		boolean validaProfessione = TestoUtility.verificaProfessione(professione);
		
		if((validaNome == false) || (validaCognome == false) || (validaDataDiNascita == false) || (validaSesso == false) || (validaCentro == false) || (validaProfessione == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Ci sono campi compilati in modo non valido.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if((validaEmail == false) && (validaPassword == false)) {
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
		} else if(passwordUguali == false){
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Le password non corrispondono.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else{
			System.out.print("Funziona");
			//PersonaleDatabase.getInstance().registraPersonale(email, new String(password));
		}
	}
}