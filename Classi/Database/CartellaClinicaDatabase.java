/*
 *
 * Il codice rappresenta una classe Java chiamata "CartellaClinicaDatabase" che ha lo scopo di salvare i dati della cartella clinica di una tartaruga marina nel database.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * Il metodo "caricaCartellaClinica" accetta un oggetto "CartellaClinica" come parametro e utilizza una query SQL per inserire i dati della cartella clinica nel database.
 * La classe sfrutta la libreria JDBC per la connessione al database e utilizza le classi "PreparedStatement" e "ResultSet" per eseguire la query e ottenere il risultato.
 * In caso di esito positivo dell'operazione di inserimento viene visualizzato un messaggio di conferma, altrimenti viene visualizzata una finestra di errore
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
import Classi.Models.CartellaClinica;
import Classi.View.ErroreView;
import Classi.View.RegistrazioneView;

public class CartellaClinicaDatabase {
	/*
	 *
	 * Funzione che restituisce un'istanza della classe CartellaClinicaDatabase, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static CartellaClinicaDatabase instance = null;
	
	public static CartellaClinicaDatabase getInstance() {
		if(instance == null) {
			instance = new CartellaClinicaDatabase();
		}
		
		return instance;
	}
	
	//Funzione che permette di eseguire la memorizzazione della cartella clinica nel database
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
	
	//Funzione che ricava una cartella clinica tramite targhetta della tartaruga
	public CartellaClinica getRigaCartellaClinicaByTarghetta(int indiceRiga, String targhetta) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
		CartellaClinica cartellaClinica = null;
		
        String query = "SELECT Cartella_clinica.Identificativo_interno, Cartella_clinica.Data_del_ritrovamento, Cartella_clinica.Luogo_del_ritrovamento, Cartella_clinica.Specie, Cartella_clinica.Larghezza, Cartella_clinica.Lunghezza, Cartella_clinica.Peso, Cartella_clinica.Naso, Cartella_clinica.Becco, Cartella_clinica.Testa, Cartella_clinica.Collo, Cartella_clinica.Occhi, Cartella_clinica.Coda, Cartella_clinica.Pinne FROM Cartella_clinica, Tartaruga WHERE Cartella_clinica.id_tartaruga = Tartaruga.id_tartaruga AND Tartaruga.targhetta = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, targhetta);
            
            rs = ps.executeQuery();
            
			/*
			  Muovo il cursore del ResultSet verso la riga nella posizione specificata dall'indiceRiga.
			  In questo caso il cursore del ResultSet è rappresentato dall'attributo i.
			  Bisogna tener conto che la posizione default del cursore è sempre precedente alla prima riga, per questo i è inizializzato a 0.
			*/
			
			for(int i = 0; i<indiceRiga; i++) {
				if(rs.next() == false) {
					return null;
				}
			}
			
	        /*
	          Una volta posizionato il cursore sull'indiceRiga desiderato, inserisco in CartellaClinica i valori della riga puntata.
	        */
            cartellaClinica = new CartellaClinica(0, 0, 0, rs.getString("identificativo_interno"), rs.getDate("data_del_ritrovamento").toString(), rs.getString("luogo_del_ritrovamento"), rs.getString("specie"), rs.getInt("larghezza"), rs.getInt("lunghezza"), rs.getInt("peso"),  rs.getObject("naso").toString(), rs.getObject("becco").toString(), rs.getObject("testa").toString(), rs.getObject("collo").toString(), rs.getObject("occhi").toString(), rs.getObject("coda").toString(), rs.getObject("pinne").toString());
                
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return cartellaClinica;
    }
}