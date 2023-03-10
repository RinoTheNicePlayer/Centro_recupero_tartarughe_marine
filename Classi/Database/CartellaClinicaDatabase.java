/*
 *
 * Il codice rappresenta una classe Java chiamata "CartellaClinicaDatabase" che ha lo scopo di salvare i dati della cartella clinica di una tartaruga marina nel database.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * Il metodo "caricaCartellaClinica" accetta un oggetto "CartellaClinica" come parametro e utilizza una query SQL per inserire i dati della cartella clinica nel database.
 * Inoltre, nella classe sono inclusi altri due metodi che permettono di recuperare informazioni dalla tabella "Cartella_clinica" del database.
 * Il primo metodo, "getCartellaClinicaByIdentificativo", accetta come parametro una stringa "identificativo" e restituisce un oggetto "CartellaClinica"
 * corrispondente alla riga nella tabella "Cartella_clinica" con un valore di "identificativo_interno" uguale alla stringa passata come parametro.
 * Questo metodo sfrutta una query SQL per recuperare i dati dalla tabella e crea un nuovo oggetto "CartellaClinica" con i valori recuperati dalla query stessa.
 * Il secondo metodo, "getRigaCartellaClinicaByTarghetta", accetta come parametri un intero "indiceRiga" e una stringa "targhetta" e restituisce un oggetto "CartellaClinica"
 * corrispondente alla riga nella tabella "Cartella_clinica" con un valore di "targhetta" uguale alla stringa passata come parametro.
 * Tale metodo utilizza una query SQL per recuperare i dati dalla tabella e crea un nuovo oggetto "CartellaClinica"
 * con i valori recuperati dalla query stessa, proprio come avviene nel metodo precedente.
 * Utilizza anche un cursore per scorrere le righe del risultato della query fino alla riga specificata dall'indiceRiga.
 * I tre metodi sfruttano un oggetto "Connessione" per stabilire una connessione col database e utilizzano le classi "PreparedStatement" e "ResultSet"
 * per preparare e eseguire la query. In caso di eccezione, viene sollevato un errore
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
	 * Metodo che restituisce un'istanza della classe CartellaClinicaDatabase, la genera se non esiste gi??.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata pi?? di una
	 *
	 */
	private static CartellaClinicaDatabase instance = null;
	
	public static CartellaClinicaDatabase getInstance() {
		if(instance == null) {
			instance = new CartellaClinicaDatabase();
		}
		
		return instance;
	}
	
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
				finestraErrore.setModal(true);
				finestraErrore.setVisible(true);
			}
		} catch(SQLException ex) {
			Logger.getLogger(RegistrazioneView.class.getName()).log(Level.SEVERE, null, ex);
			ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Controlla che tutti i campi siano stati riempiti correttamente!");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		}
	}
	
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
	
	public CartellaClinica getRigaCartellaClinicaByTarghetta(int indiceRiga, String targhetta) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
		CartellaClinica cartellaClinica = null;
		
        String query = "SELECT Cartella_clinica.Identificativo_interno, Cartella_clinica.Data_del_ritrovamento, Cartella_clinica.Luogo_del_ritrovamento, Cartella_clinica.Specie, Cartella_clinica.Larghezza, Cartella_clinica.Lunghezza, Cartella_clinica.Peso, Cartella_clinica.Naso, Cartella_clinica.Becco, Cartella_clinica.Testa, Cartella_clinica.Collo, Cartella_clinica.Occhi, Cartella_clinica.Coda, Cartella_clinica.Pinne FROM Cartella_clinica, Tartaruga WHERE Cartella_clinica.id_tartaruga = Tartaruga.id_tartaruga AND Tartaruga.targhetta = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, targhetta);
            
            rs = ps.executeQuery();
            
			for(int i = 0; i < indiceRiga; i++) {
				if(rs.next() == false) {
					return null;
				}
			}
			
            cartellaClinica = new CartellaClinica(0, 0, 0, rs.getString("identificativo_interno"), rs.getDate("data_del_ritrovamento").toString(), rs.getString("luogo_del_ritrovamento"), rs.getString("specie"), rs.getInt("larghezza"), rs.getInt("lunghezza"), rs.getInt("peso"),  rs.getObject("naso").toString(), rs.getObject("becco").toString(), rs.getObject("testa").toString(), rs.getObject("collo").toString(), rs.getObject("occhi").toString(), rs.getObject("coda").toString(), rs.getObject("pinne").toString());
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return cartellaClinica;
    }
}