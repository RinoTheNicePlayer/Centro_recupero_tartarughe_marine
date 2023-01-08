package Classi.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Classi.Connessione;
import Classi.Portale;
import Classi.Controller.AccessoController;
import Classi.Models.Personale;
import Classi.View.AccessoView;
import Classi.View.ErroreView;
import Classi.View.RegistrazioneView;

public final class PersonaleDatabase {
	//Inizializzazione dell'istanza
	private static PersonaleDatabase instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static PersonaleDatabase getInstance() {
		if(instance == null) {
			instance = new PersonaleDatabase();
		}
		
		return instance;
	}
	
	public void controlloAccesso(String compilazioneEmail, String compilazionePassword) {
		PreparedStatement ps;
		ResultSet rs;
		
		String email = compilazioneEmail;
		String password = compilazionePassword;
		
		String query = "SELECT * FROM personale WHERE email = ? AND parola_chiave = ?";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Portale finestraPortale = new Portale();
				finestraPortale.setLocationRelativeTo(null);
				finestraPortale.setVisible(true);
			} else {
				ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email o password non registrati.");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(AccessoView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/*
	//Funzione di INSERT per il Personale
	void insertPersonale(Personale p) {
		PreparedStatement ps;
		int rs;
		
		int idCentro = selezioneCentro.getSelectedIndex() + 1;
		String email = compilazioneEmail.getText();
		Accesso l = new Accesso(email);
		String password = String.valueOf(compilazionePassword.getPassword());
		String nome = compilazioneNome.getText();
		String cognome = compilazioneCognome.getText();
		String sesso = selezioneSesso.getSelectedItem().toString();
		String dataDiNascita = compilazioneDataDiNascita.getText();
		Date data = Date.valueOf(dataDiNascita);
		String tipologia = selezioneProfessione.getSelectedItem().toString();
		
		String query = "INSERT INTO Personale (id_centro, matricola, email, parola_chiave, nome, cognome, sesso, data_di_nascita, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setInt(1, idCentro);
			ps.setString(2, "N00000001");
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, nome);
			ps.setString(6, cognome);
			ps.setString(7, sesso);
			ps.setDate(8, data);
			ps.setObject(9, tipologia, Types.OTHER);
			
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Utente aggiunto al database!");
			} else {
				Errore finestraErrore = new Errore("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
			}
		}catch(SQLException ex) {
			Logger.getLogger(Registrazione.class.getName()).log(Level.SEVERE, null, ex);
			Errore finestraErrore = new Errore("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		}
	}
	*/
}