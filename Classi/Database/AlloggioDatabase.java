package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.Connessione;
import Classi.Controller.AccessoController;
import Classi.Models.Alloggio;
import Classi.Models.Tartaruga;
import Classi.Models.Vasca;

public class AlloggioDatabase {
	//Inizializzazione dell'istanza
	private static AlloggioDatabase instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static AlloggioDatabase getInstance() {
		if(instance == null) {
			instance = new AlloggioDatabase();
		}
		
		return instance;
	}
	
	/*
	  Funzione che permette di ricavare tutte le informazioni riguardanti una tartaruga + il codice di vasca + la data di alloggio e le inserisce
	  in un tipo Alloggio.
	*/
	public Alloggio getAlloggioByIndiceRiga(int indiceRiga) throws SQLException {
		
		PreparedStatement ps;
		ResultSet rs;
		
		Alloggio rigaAlloggio = null;
		
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
	        
	        /*
	          Una volta posizionato il cursore sull'indiceRiga desiderato, creo una tartaruga, vasca e li inizializzo con i valori della riga puntata,
	          e li inserisco in Alloggio.
	        */
	        Vasca vasca = new Vasca(0, rs.getString("codice_vasca"));
	        Tartaruga tartaruga = new Tartaruga(0, rs.getString("targhetta"), rs.getString("nome"), rs.getString("sesso"), rs.getInt("età"));
	        rigaAlloggio = new Alloggio(tartaruga, vasca, rs.getDate("data_inizio").toString());

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
      return rigaAlloggio;
		
	}
}
