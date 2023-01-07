package Classi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione {
	
	private static Connection connessione = null;
	
	//Funzione che permette di connettere Java a Postgres
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