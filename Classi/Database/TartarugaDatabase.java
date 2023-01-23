package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Classi.Connessione;
import Classi.Models.Tartaruga;

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
                Tartaruga tartaruga = new Tartaruga(rs.getInt("ID_tartaruga"), rs.getString("targhetta"), rs.getString("nome"), rs.getString("sesso"), rs.getInt("età"));
                return tartaruga;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
	
	/*
	  Funzione che permette di ricavare tutte le informazioni riguardanti una tartaruga + il codice di vasca + la data di alloggio e le inserisce
	  in un tipo Alloggio.
	*/
	public Object[] getInfoTartarugaByIndiceRiga(int indiceRiga, int numColonne) throws SQLException {
		
		PreparedStatement ps;
		ResultSet rs;
		
		Object[] riga = null;
		
		String query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
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
	        
	        riga = new Object[numColonne];
	            
	        /*
	          Una volta posizionato il cursore sull'indiceRiga desiderato, comincio a riempire l'array riga con i valori delle colonne della riga
	          puntata dal cursore.
	          In questo caso, l'attributo i rappresenta il cursore che punta le colonne della riga.
	        */
	        for(int i = 1; i <= numColonne; i++) {
	            riga[i - 1] = rs.getObject(i);
	        }

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
        return riga;
		
	}
}