package Classi.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;
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
	
	/*Funzione di ricerca Personale per Email e Password. Tale funzione permette l'accesso se nel database esiste un utente con
	  la Email e Password compilati */
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
	
	//Funzione di ricerca personale nel database tramite Email. Essa restituisce le informazioni del Personale cercato.
	public Personale getPersonaleByEmail(String email) throws SQLException {
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	connection = Connessione.getConnection();
            String sql = "SELECT * FROM Personale WHERE Email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	// Crea un oggetto Personale e imposta i suoi campi con i dati del ResultSet
                Personale personale = new Personale();
                personale.setMatricola(resultSet.getString("Matricola"));
                personale.setNome(resultSet.getString("Nome"));
                personale.setCognome(resultSet.getString("Cognome"));
                personale.setSesso(resultSet.getString("Sesso"));
                personale.setDataDiNascita(resultSet.getDate("Data_di_nascita").toString());
                personale.setTipologia(resultSet.getString("Tipologia"));
                
                return personale;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	
	//Funzione di INSERT per il Personale registrato
	public void registraPersonale(Personale p) {
		PreparedStatement ps;
		int rs;
		
		int idCentro = selezioneCentro.getSelectedIndex() + 1;
		String email = compilazioneEmail.getText();
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
				ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
			}
		}catch(SQLException ex) {
			Logger.getLogger(RegistrazioneView.class.getName()).log(Level.SEVERE, null, ex);
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		}
	}

	/*Funzione di utility. Genera una matricola nel formato NXXXXXXXX dove X sono delle cifre da 0 a 9.
	Realisticamente la creazione di una matricola è gestita da un server apposito, ma per questo progetto la creeremo sul progetto Java stesso*/
	  public String generaMatricola() {
	        Random rnd = new Random();
	        String matricola = "N";
	        
	        for (int i = 0; i < 8; i++) {
	            matricola += rnd.nextInt(10);
	        }
	        
	        return matricola;
	    }
	    
}
