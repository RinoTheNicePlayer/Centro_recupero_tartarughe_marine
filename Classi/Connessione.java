/*
 *
 * Il codice rappresenta una classe Java chiamata "Connessione" che si occupa di stabilire una connessione con il server di PostgreSQL.
 * Utilizza la libreria "java.sql" per accedere alle funzionalità per effettuare il collegamento al database "Centro_recupero_tartarughe_marine".
 * La classe definisce una variabile statica di tipo "Connection" denominata "connessione"
 * che verrà utilizzata per memorizzare l'oggetto di quest'ultima una volta che la connessione è stata stabilita.
 * Inoltre, dispone di un metodo statico "getConnection" che è responsabile di stabilire la connessione al database.
 * Il metodo utilizza la classe "Class" per caricare il driver JDBC per PostgreSQL,
 * che a sua volta sfrutta la classe "DriverManager" per favorire appunto la connessione, servendosi delle seguenti informazioni: URL del database, nome utente e password.
 * Se la connessione è stabilita con successo, viene stampato un messaggio di successo sulla console,
 * altrimenti viene stampato un messaggio di errore (stessa cosa vale per l'eccezione).
 * Infine, getConnection restituisce l'oggetto di connessione
 *
 */

package Classi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione {
	private static Connection connessione = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			
			if(connessione == null) {
				connessione = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Centro_recupero_tartarughe_marine", "postgres", "postgres");
				
				if(connessione != null) {
					System.out.println("La connessione al server di PostgreSQL e' avvenuta con successo!");
				
				} else {
					System.out.println("La connessione al server di PostgreSQL e' fallita!");
				}
			}
			
		} catch(Exception e) {
			System.out.println("" + e);
		}
		
		return connessione;
	}
}