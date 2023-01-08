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
		
		String query = "SELECT * FROM personale WHERE email = ? AND parola_chiave = ?";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setString(1, compilazioneEmail);
			ps.setString(2, compilazionePassword);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Portale finestraPortale = new Portale(getPersonaleByEmail(compilazioneEmail));
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
		PreparedStatement ps;
		ResultSet rs;

        String query = "SELECT * FROM Personale WHERE Email = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	// Crea un oggetto Personale e imposta i suoi campi con i dati del ResultSet
                Personale personale = new Personale(rs.getInt("ID_Centro"), rs.getString("Email"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Sesso"), rs.getDate("Data_di_nascita").toString(), rs.getObject("Tipologia").toString(), rs.getString("Matricola"));
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
		
		String query = "INSERT INTO Personale (id_centro, matricola, email, parola_chiave, nome, cognome, sesso, data_di_nascita, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setInt(1, p.getIdCentro());
			ps.setString(2, "N00000001");
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());
			ps.setString(5, p.getNome());
			ps.setString(6, p.getCognome());
			ps.setString(7, p.getSesso());
			ps.setDate(8, (Date.valueOf(p.getDataDiNascita())));
			ps.setObject(9, p.getTipologia(), Types.OTHER);
			
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
	
	//Funzione di ricerca personale nel database tramite Matricola. Essa restituisce le informazioni del Personale cercato.
	public Personale getPersonaleByMatricola(String matricola) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;

        String query = "SELECT * FROM Personale WHERE Matricola = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
            ps.setString(1, matricola);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	// Crea un oggetto Personale e imposta i suoi campi con i dati del ResultSet
                Personale personale = new Personale(rs.getInt("ID_Centro"), rs.getString("Email"), rs.getString("Nome"), rs.getString("Cognome"), rs.getString("Sesso"), rs.getDate("Data_di_nascita").toString(), rs.getObject("Tipologia").toString(), rs.getString("Matricola"));
                return personale;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	/*Funzione di utility. Genera una matricola nel formato NXXXXXXXX dove X sono delle cifre da 0 a 9.
	Realisticamente la creazione di una matricola è gestita da un server apposito, ma per questo progetto la creeremo sul progetto Java stesso*/
	  public String generaMatricola() throws SQLException {
	        Random rnd = new Random();
	        String matricola = "N";
	        
	        for (int i = 0; i < 8; i++) {
	            matricola += rnd.nextInt(10);
	        }
	        
	        Personale p = getPersonaleByMatricola(matricola);
	        
	        if(p == null) {
	        	return matricola;
	        }else {
	        	matricola = generaMatricola();
	        	return matricola;
	        }
	    }
	    
}
