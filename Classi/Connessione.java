package Classi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione {
	//Funzione che permette di connettere Eclipse a PostgreSQL
	public static Connection getConnection() {
		Connection connessione = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			connessione = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Centro_recupero_tartarughe_marine", "postgres", "postgres");
			
			if(connessione != null) {
				System.out.println("La connessione al server di PostgreSQL e' avvenuta con successo!");
			}
			
			else {
				System.out.println("La connessione al server di PostgreSQL e' fallita!");
			}
		} catch(Exception e) {
			System.out.println("" + e);
		}
		
		return connessione;
	}
}