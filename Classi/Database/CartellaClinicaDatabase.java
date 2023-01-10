package Classi.Database;

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
import Classi.Models.CartellaClinica;
import Classi.Models.Personale;
import Classi.View.ErroreView;
import Classi.View.RegistrazioneView;

public class CartellaClinicaDatabase {
	//Inizializzazione dell'istanza
	private static CartellaClinicaDatabase instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static CartellaClinicaDatabase getInstance() {
		if(instance == null) {
			instance = new CartellaClinicaDatabase();
		}
		
		return instance;
	}
	
	//Funzione che permette di eseguire la memorizzazione della cartella clinica nel Database
	public void caricaCartellaClinica(CartellaClinica cartellaClinica) {
		PreparedStatement ps;
		int rs;
		
		String query = "INSERT INTO Cartella_clinica (id_personale, id_tartaruga, identificativo_interno, data_del_ritrovamento, luogo_del_ritrovamento, specie, larghezza, lunghezza, peso, naso, becco, testa, collo, occhi, coda, pinne) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			ps.setInt(1, cartellaClinica.getIdPersonale());
			ps.setInt(2, cartellaClinica.getIdTartaruga());
			ps.setString(3, cartellaClinica.getIdentificativoInterno());
			ps.setDate(4, Date.valueOf(cartellaClinica.getDataRitrovamento()));
			ps.setString(5, cartellaClinica.getLuogoRitrovamento());
			ps.setString(6, cartellaClinica.getSpecie());
			ps.setInt(7, cartellaClinica.getLarghezza());
			ps.setInt(8, cartellaClinica.getLunghezza());
			ps.setInt(9, cartellaClinica.getPeso());
			ps.setObject(10, cartellaClinica.getStatoNaso(), Types.OTHER);
			ps.setObject(11, cartellaClinica.getStatoBecco(), Types.OTHER);
			ps.setObject(12, cartellaClinica.getStatoTesta(), Types.OTHER);
			ps.setObject(13, cartellaClinica.getStatoCollo(), Types.OTHER);
			ps.setObject(14, cartellaClinica.getStatoOcchi(), Types.OTHER);
			ps.setObject(15, cartellaClinica.getStatoCoda(), Types.OTHER);
			ps.setObject(16, cartellaClinica.getStatoPinne(), Types.OTHER);
			
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				JOptionPane.showMessageDialog(null, "Cartella clinica aggiunta al database!");
			} else {
				ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Controlla che tutti i campi siano stati riempiti correttamente!");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(RegistrazioneView.class.getName()).log(Level.SEVERE, null, ex);
			ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Controlla che tutti i campi siano stati riempiti correttamente!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
		}
	}
	
	//Funzione che ricava una cartella clinica tramite identificativo interno
	public CartellaClinica getCartellaClinicaByIdentificativo(String identificativo) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
        String query = "SELECT * FROM Cartella_clinica WHERE identificativo_interno = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, identificativo);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                CartellaClinica cartellaClinica = new CartellaClinica(rs.getInt("ID_cartella_clinica"), rs.getInt("ID_personale"), rs.getInt("ID_tartaruga"), rs.getString("identificativo_interno"), rs.getDate("data_del_ritrovamento").toString(), rs.getString("luogo_del_ritrovamento"), rs.getString("specie"), rs.getInt("larghezza"), rs.getInt("lunghezza"), rs.getInt("peso"),  rs.getObject("naso").toString(), rs.getObject("becco").toString(), rs.getObject("testa").toString(), rs.getObject("collo").toString(), rs.getObject("occhi").toString(), rs.getObject("coda").toString(), rs.getObject("pinne").toString());
                return cartellaClinica;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	//Funzione che produce in maniera randomica un identificativo con formato IXXXXXXXX, dove X è una cifra corrispondente ad un numero compreso tra 0 e 9
	public String generatoreDiIdentificativoClinico() throws SQLException {
		Random rnd = new Random();
	    String identificativoClinico = "I";
	    
	    for(int i = 0; i < 8; i++) {
	    	identificativoClinico += rnd.nextInt(10);
	    }
	    
	    CartellaClinica cartellaClinica = getCartellaClinicaByIdentificativo(identificativoClinico);
	    
	    if(cartellaClinica == null) {
	    	return identificativoClinico;
	    } else {
	    	identificativoClinico = generatoreDiIdentificativoClinico();
	    	return identificativoClinico;
	    }
	}
}