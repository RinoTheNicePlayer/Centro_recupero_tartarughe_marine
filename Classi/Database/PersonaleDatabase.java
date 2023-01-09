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
import Classi.Models.Personale;
import Classi.View.AccessoView;
import Classi.View.ErroreView;
import Classi.View.DatiView;
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
	
	/*Funzione che verifica se l'email e la password inserite dall'utente sono presenti nel database.
	 * Se lo sono, si apre una finestra grafica, in alternativa solleva un errore
	 */
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
				DatiView finestraPortale = new DatiView(getPersonaleByEmail(compilazioneEmail));
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
	
	//Funzione che permette di eseguire la memorizzazione di diverse credenziali dell'utente nel database
	public void registraPersonale(Personale personale) {
		PreparedStatement ps;
		int rs;
		
		String query = "INSERT INTO Personale (id_centro, matricola, email, parola_chiave, nome, cognome, sesso, data_di_nascita, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setInt(1, personale.getIdCentro() + 1);
			ps.setString(2, generatoreDiMatricole());
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
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(RegistrazioneView.class.getName()).log(Level.SEVERE, null, ex);
			ErroreView finestraErrore = new ErroreView("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		}
	}
	
	//Funzione che consente di cercare un personale specifico nel database mediante l'email fornita come parametro
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
	
	//Funzione che consente di cercare un personale specifico nel database mediante la matricola fornita come parametro
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
	
	//Funzione che produce in maniera randomica una matricola del tipo NXXXXXXXX, dove X è una cifra che corrispondere ad un numero compreso tra 0 e 9
	public String generatoreDiMatricole() throws SQLException {
		Random rnd = new Random();
	    String matricola = "N";
	    
	    for(int i = 0; i < 8; i++) {
	    	matricola += rnd.nextInt(10);
	    }
	    
	    Personale personale = getPersonaleByMatricola(matricola);
	    
	    if(personale == null) {
	    	return matricola;
	    } else {
	    	matricola = generatoreDiMatricole();
	    	return matricola;
	    }
	}
}