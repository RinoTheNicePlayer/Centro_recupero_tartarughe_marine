/*
 *
 * Il codice rappresenta una classe Java chiamata "AlloggioDatabase"
 * che fornisce metodi per recuperare informazioni riguardanti l'alloggio di una tartaruga in una determinata vasca, utilizzando un database SQL.
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * Il metodo principale è "getAlloggioByIndiceRiga" che accetta un intero come parametro e restituisce un oggetto "Alloggio"
 * contenente informazioni sulla tartaruga, la vasca e la data dell'alloggio della tartaruga stessa.
 * Il metodo esegue una query SQL per recuperare queste informazioni dal database, utilizzando un oggetto "PreparedStatement" e "ResultSet" per eseguire la query e gestire i risultati.
 * Il cursore del ResultSet viene spostato alla riga specificata dall'indiceRiga e quindi vengono creati oggetti "Tartaruga" e "Vasca" e inizializzati con i valori della riga corrente.
 * Infine, questi oggetti vengono inseriti nell'oggetto "Alloggio" che viene restituito dal metodo. In caso di eccezioni SQL, viene sollevato un errore
 *
 */

package Classi.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classi.Connessione;
import Classi.TestoUtility;
import Classi.Models.Alloggio;
import Classi.Models.Tartaruga;
import Classi.Models.Vasca;

public class AlloggioDatabase {
	/*
	 *
	 * Funzione che restituisce un'istanza della classe AlloggioDatabase, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static AlloggioDatabase instance = null;
	
	public static AlloggioDatabase getInstance() {
		if(instance == null) {
			instance = new AlloggioDatabase();
		}
		
		return instance;
	}
	
	//Metodo getAlloggioByIndiceRiga senza valore passato
	public Alloggio getAlloggioByIndiceRiga(int indiceRiga) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		
		Alloggio rigaAlloggio = null;
		
		String query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca";
		
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			rs = ps.executeQuery();
			
			for(int i = 0; i<indiceRiga; i++) {
				if(rs.next() == false) {
					return null;
				}
			}
			
	        Vasca vasca = new Vasca(0, rs.getString("codice_vasca"));
	        Tartaruga tartaruga = new Tartaruga(0, rs.getString("targhetta"), rs.getString("nome"), rs.getString("sesso"), rs.getInt("età"));
	        rigaAlloggio = new Alloggio(tartaruga, vasca, rs.getDate("data_inizio").toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rigaAlloggio;
	}
	
	//Metodo getAlloggioByIndiceRiga con valore passato
	public Alloggio getAlloggioByIndiceRiga(int indiceRiga, String valore) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		String query = null;
		
		Alloggio rigaAlloggio = null;
		
		if(TestoUtility.isNumero(valore)) {
			query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca AND (tartaruga.età = '" + Integer.parseInt(valore)+ "')";
		}else if(TestoUtility.verificaData(valore)){
			query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca AND (alloggiare.data_inizio = '" + valore + "')";
		}else {
			query = "SELECT tartaruga.targhetta, tartaruga.nome, tartaruga.sesso, tartaruga.età, alloggiare.data_inizio, vasca.codice_vasca FROM tartaruga, alloggiare, vasca WHERE tartaruga.id_tartaruga = alloggiare.id_tartaruga AND alloggiare.id_vasca = vasca.id_vasca AND ((tartaruga.targhetta = '" + valore + "') OR (tartaruga.nome = '" + valore + "') OR (tartaruga.sesso = '" + valore + "') OR (vasca.codice_vasca = '" + valore + "'))";
		}
		try {
			ps = Connessione.getConnection().prepareStatement(query);
			
			rs = ps.executeQuery();
			
			for(int i = 0; i<indiceRiga; i++) {
				if(rs.next() == false) {
					return null;
				}
			}
			
	        Vasca vasca = new Vasca(0, rs.getString("codice_vasca"));
	        Tartaruga tartaruga = new Tartaruga(0, rs.getString("targhetta"), rs.getString("nome"), rs.getString("sesso"), rs.getInt("età"));
	        rigaAlloggio = new Alloggio(tartaruga, vasca, rs.getDate("data_inizio").toString());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rigaAlloggio;
	}
}