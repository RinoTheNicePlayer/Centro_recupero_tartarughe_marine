package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classi.Connessione;
import Classi.Models.CartellaClinica;
import Classi.Models.Tartaruga;
import Classi.View.ErroreView;

public class TartarugaDatabase {
	//Inizializzazione dell'istanza
	private static TartarugaDatabase instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static TartarugaDatabase getInstance() {
		if(instance == null) {
			instance = new TartarugaDatabase();
		}
		
		return instance;
	}
	
	//Funzione che permette di ricavare una tartaruga tramite la sua targhetta
	public Tartaruga getTartarugaByTarghetta(String targhetta) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
        String query = "SELECT * FROM Tartaruga WHERE targhetta = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, targhetta);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                Tartaruga tartaruga = new Tartaruga(rs.getInt("ID_tartaruga"), rs.getInt("ID_personale"), rs.getInt("ID_tartaruga"), rs.getString("identificativo_interno"), rs.getDate("data_del_ritrovamento").toString(), rs.getString("luogo_del_ritrovamento"),);
                return tartaruga;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
}