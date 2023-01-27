/*
 *
 * Il codice rappresenta una classe Java chiamata "PersonaleDatabase" che gestisce l'accesso e la registrazione degli utenti all'interno del database.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * È composta da quattro metodi, quelli per cui è necessario dare una spiegazione completa sono: "controlloAccesso" e "registraPersonale",
 * gli altri due non meno importanti sono "getPersonaleByEmail" e "getPersonaleByMatricola".
 * Il metodo "controlloAccesso" riceve come input l'email e la password inserite dall'utente e verifica se esistono nel database.
 * Se esistono, l'utente accede correttamente al portale, altrimenti viene visualizzata una finestra di errore.
 * Il metodo "registraPersonale" riceve come input un oggetto "Personale" e lo memorizza nel database.
 * Utilizza una query SQL per inserire i dati nella tabella "personale" del database. In caso di errori durante l'esecuzione della query, viene generato un messaggio di errore
 *
 */

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
import Classi.Controller.RegistrazioneController;
import Classi.Models.Personale;
import Classi.View.AccessoView;
import Classi.View.ErroreView;
import Classi.View.PortaleView;
import Classi.View.RegistrazioneView;

public final class PersonaleDatabase {
	/*
	 *
	 * Metodo che restituisce un'istanza della classe PersonaleDatabase, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static PersonaleDatabase instance = null;
	
	public static PersonaleDatabase getInstance() {
		if(instance == null) {
			instance = new PersonaleDatabase();
		}
		
		return instance;
	}
	
	public boolean controlloAccesso(String compilazioneEmail, String compilazionePassword) {
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM personale WHERE email = ? AND parola_chiave = ?";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setString(1, compilazioneEmail);
			ps.setString(2, compilazionePassword);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				PortaleView finestraPortale = new PortaleView(getPersonaleByEmail(compilazioneEmail));
				finestraPortale.setLocationRelativeTo(null);
				finestraPortale.setVisible(true);
				
				return true;
			} else {
				ErroreView finestraErrore = new ErroreView("Impossibile effettuare l'accesso!", "Email o password non registrati.");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setModal(true);
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(AccessoView.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	public void registraPersonale(Personale personale) {
		PreparedStatement ps;
		int rs;
		
		String query = "INSERT INTO Personale (id_centro, matricola, email, parola_chiave, nome, cognome, sesso, data_di_nascita, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setInt(1, personale.getIdCentro() + 1);
			ps.setString(2, RegistrazioneController.getInstance().generatoreDiMatricole());
			ps.setString(3, personale.getEmail());
			ps.setString(4, personale.getPassword());
			ps.setString(5, personale.getNome());
			ps.setString(6, personale.getCognome());
			ps.setString(7, personale.getSesso());
			ps.setDate(8, Date.valueOf(personale.getDataDiNascita()));
			ps.setObject(9, personale.getTipologia(), Types.OTHER);
			
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Utente aggiunto al database!");
			} else {
				ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setModal(true);
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(RegistrazioneView.class.getName()).log(Level.SEVERE, null, ex);
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Email già in uso!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		}
	}
	
	//Metodo che permette di cercare un personale specifico nel database mediante l'email fornita come parametro
	public Personale getPersonaleByEmail(String email) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;

        String query = "SELECT * FROM Personale WHERE Email = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, email);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                Personale personale = new Personale(rs.getInt("ID_Personale"), rs.getInt("ID_Centro"), rs.getString("Matricola"), rs.getString("Email"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Sesso"), rs.getDate("Data_di_nascita").toString(), rs.getObject("Tipologia").toString());
                return personale;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	//Metodo che permette di cercare un personale specifico nel database mediante la matricola fornita come parametro
	public Personale getPersonaleByMatricola(String matricola) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
        String query = "SELECT * FROM Personale WHERE Matricola = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, matricola);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                Personale personale = new Personale(rs.getInt("ID_Personale"), rs.getInt("ID_Centro"), rs.getString("Matricola"), rs.getString("Email"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Sesso"), rs.getDate("Data_di_nascita").toString(), rs.getObject("Tipologia").toString());
                
                return personale;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
}