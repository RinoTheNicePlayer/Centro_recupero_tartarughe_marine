package Classi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classi.TestoUtility;
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import Classi.View.ErroreView;

public final class RegistrazioneController {

	private static RegistrazioneController instance = null;
	
	public static RegistrazioneController getInstance() {
		if (instance == null) {
			instance = new RegistrazioneController();
		}
		return instance;
	}
	
	/*Funzione per effettuare la registrazione. Controlla che i campi siano validi. Se si, chiama la classe PersonaleDatabase per la INSERT*/
	public void effettuaRegistrazione(String nome, String cognome, String email, char[] password, char[] confermaPassword, String dataNascita, String sesso, int idCentro, String professione) {
		
		boolean validaNome = TestoUtility.verificaNome(nome);
		boolean validaCognome = TestoUtility.verificaNome(cognome);
		boolean validaEmail = TestoUtility.verificaEmail(email);
		boolean validaPassword = TestoUtility.verificaPassword(password);
		boolean passwordUguali = TestoUtility.controlloMatchingPassword(password, confermaPassword);
		boolean validaDataNascita = TestoUtility.verificaData(dataNascita);
		boolean validaSesso = TestoUtility.verificaSesso(sesso);
		boolean validaCentro = TestoUtility.verificaCentro(idCentro);
		boolean validaProfessione = TestoUtility.verificaProfessione(professione);
		
		if((validaNome == false) || (validaCognome == false) || (validaDataNascita == false) || (validaSesso == false) || (validaCentro == false) || (validaProfessione == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Ci sono campi compilati in modo non valido.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		}else if((validaEmail == false) && (validaPassword == false)) {
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
			
		}else if(passwordUguali == false){
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Le password non corrispondono.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);

		}else{
			System.out.print("Funziona");
			//PersonaleDatabase.getInstance().registraPersonale(email, new String(password));

		}
	}
	
	public RegistrazioneController() {

	}
	
}
