/*
 *
 * Il codice rappresenta una classe Java chiamata "RegistrazioneController" che elabora la registrazione di un utente all'interno del sistema.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * La classe dispone di un metodo "effettuaRegistrazione" che accetta i parametri essenziali per la registrazione di un utente,
 * verifica la validità di questi parametri attraverso i metodi della classe "TestoUtility" e, se tutti i parametri sono validi,
 * fa uso della classe "PersonaleDatabase" per eseguire la query per l'inserimento dell'utente nel database. In caso di parametri non validi,
 * viene visualizzata una finestra di errore indicando l'errore specifico
 *
 */

package Classi.Controller;

import java.sql.SQLException;
import java.util.Random;
import Classi.TestoUtility;
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import Classi.View.ErroreView;

public final class RegistrazioneController {
	/*
	 *
	 * Funzione che restituisce un'istanza della classe RegistrazioneController, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static RegistrazioneController instance = null;
	
	public static RegistrazioneController getInstance() {
		if(instance == null) {
			instance = new RegistrazioneController();
		}
		
		return instance;
	}
	
	/*
	 *
	 * Funzione che permette di effettuare la registrazione di un utente all'applicazione. Tale funzione verifica se le credenziali dell'utente sono valide.
	 * Se quest'ultime sono valide, viene interpellata la classe PersonaleDatabase per eseguire la query
	 *
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
	
	//Funzione che produce in maniera randomica una matricola con formato NXXXXXXXX, dove X è una cifra corrispondente ad un numero compreso tra 0 e 9
	public String generatoreDiMatricole() throws SQLException {
		Random rnd = new Random();
	    String matricola = "N";
	    
	    for(int i = 0; i < 8; i++) {
	    	matricola += rnd.nextInt(10);
	    }
	    
	    Personale personale = PersonaleDatabase.getInstance().getPersonaleByMatricola(matricola);
	    
	    if(personale == null) {
	    	return matricola;
	    } else {
	    	matricola = generatoreDiMatricole();
	    	
	    	return matricola;
	    }
	}
}