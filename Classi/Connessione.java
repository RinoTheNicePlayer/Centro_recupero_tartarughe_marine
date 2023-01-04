package Classi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione
{
	public static Connection getConnection()
	{
		Connection Con = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Centro_recupero_tartarughe_marine", "postgres", "postgres");
			
			if(Con != null)
			{
				System.out.println("La connessione al server di PostgreSQL e' avvenuta con successo!");
			}
			
			else
			{
				System.out.println("La connessione al server di PostgreSQL e' fallita!");
			}
		}
		
		catch(Exception e)
		{
			System.out.println("" + e);
		}
		
		return Con;
	}
}