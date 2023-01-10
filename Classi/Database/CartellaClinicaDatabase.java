package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import Classi.Connessione;
import Classi.Models.CartellaClinica;
import Classi.Models.Personale;

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