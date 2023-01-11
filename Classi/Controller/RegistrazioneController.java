package Classi.Controller;

import Classi.TestoUtility;
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import Classi.View.ErroreView;

public final class RegistrazioneController {
	//Inizializzazione dell'istanza
	private static RegistrazioneController instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
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
		boolean passwordUguali = TestoUtility.confrontoPassword(password, confermaPassword);
		boolean validaDataDiNascita = TestoUtility.verificaData(dataDiNascita);
		boolean validaSesso = TestoUtility.verificaSesso(sesso);
		boolean validaCentro = TestoUtility.verificaCentro(idCentro);
		boolean validaProfessione = TestoUtility.verificaSelezione(professione);
		
		if((validaNome == false) || (validaCognome == false) || (validaDataDiNascita == false) || (validaSesso == false) || (validaCentro == false) || (validaProfessione == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Uno o più campi sono vuoti o compilati male.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if((validaEmail == false) && (validaPassword == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Email e password non validi.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if(validaEmail == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Email non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if(validaPassword == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Password non valida.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else if(passwordUguali == false){
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Le password non corrispondono.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		} else{
			Personale personale = new Personale (idCentro, email, new String(password), nome, cognome, sesso, dataDiNascita, professione);
			PersonaleDatabase.getInstance().registraPersonale(personale);
		}
	}
}