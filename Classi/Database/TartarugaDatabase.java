/*
 *
 * Il codice rappresenta una classe Java chiamata "TartarugaDatabase" che fornisce funzionalità di accesso ai dati delle tartarughe presenti nel database.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * È composta da due metodi: "getTartarugaByTarghetta" e "getInfoTartarugaByIndiceRiga".
 * Il primo metodo permette di recuperare un'istanza della classe "Tartaruga" in base alla targhetta fornita come parametro,
 * utilizzando una query SQL per recuperare i dati dal database.
 * Il secondo restituisce un array di oggetti contenente informazioni su una tartaruga,
 * tra cui la data in cui è stata alloggiata in una vasca e il codice della vasca stessa, utilizzando un'altra query SQL.
 * In entrambi i casi, la classe utilizza la classe "Connessione" per ottenere una connessione al database e la classe "PreparedStatement" per eseguire le query
 *
 */

package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classi.Connessione;
import Classi.Models.Tartaruga;

public class TartarugaDatabase {
	/*
	 *
	 * Metodo che restituisce un'istanza della classe TartarugaDatabase, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static TartarugaDatabase instance = null;
	
	public static TartarugaDatabase getInstance() {
		if(instance == null) {
			instance = new TartarugaDatabase();
		}
		
		return instance;
	}
	
	public Tartaruga getTartarugaByTarghetta(String targhetta) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
        String query = "SELECT * FROM Tartaruga WHERE targhetta = ?";
        
        try {
        	ps = Connessione.getConnection().prepareStatement(query);
        	
            ps.setString(1, targhetta);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                Tartaruga tartaruga = new Tartaruga(rs.getInt("ID_tartaruga"), rs.getString("targhetta"), rs.getString("nome"), rs.getString("sesso"), rs.getInt("età"));
                
                return tartaruga;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	public Object[] getInfoTartarugaByIndiceRiga(int indiceRiga, int numeroColonne) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
		Object[] riga = null;
		
		String query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			rs = ps.executeQuery();
			
			for(int i = 0; i < indiceRiga; i++) {
				if(rs.next() == false) {
					return null;
				}
			}
	        
	        riga = new Object[numeroColonne];
	        
	        for(int i = 1; i <= numeroColonne; i++) {
	            riga[i - 1] = rs.getObject(i);
	        }
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
        return riga;
	}
}