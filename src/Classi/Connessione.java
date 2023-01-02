package Classi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione
{
	public static void main(String[] args)
	{
		Connection connessione = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			connessione = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Centro_recupero_tartarughe_marine", "postgres", "postgres");
			
			if(connessione != null)
			{
				System.out.println("La connessione al server di PostgreSQL è avvenuta con successo!");
			}
			
			else
			{
				System.out.println("La connessione al server di PostgreSQL è fallita!");
			}
		}
		
		catch(Exception e)
		{
			System.out.println("" + e);
		}
	}
}