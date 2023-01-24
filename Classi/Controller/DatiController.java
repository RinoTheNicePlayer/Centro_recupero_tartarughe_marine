package Classi.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Classi.Connessione;
import Classi.Database.AlloggioDatabase;
import Classi.Database.CartellaClinicaDatabase;
import Classi.Database.TartarugaDatabase;
import Classi.Models.Alloggio;
import Classi.Models.CartellaClinica;
import Classi.Models.Personale;
import Classi.View.AlloggiTableModel;
import Classi.View.CartelleClinicheTableModel;

public class DatiController {

	//Inizializzazione dell'istanza
	private static DatiController instance = null;
		
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static DatiController getInstance() {
		if(instance == null) {
			instance = new DatiController();
		}
		
		return instance;
	}
	
	/*
	  La seguente funzione crea un ArrayList di alloggi e con l'aiuto della classe interfacciata con il Database la riempie con ogni alloggio presente
	  al suo interno. Essa restituisce poi una Table che contiene alloggi.
	*/
	public static AlloggiTableModel creaTabellaAlloggi() throws SQLException{

		int indiceRiga = 1;
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();
		Alloggio rigaAlloggio = null;
			 
		//Finchè mi viene restituito un Alloggio valido, allora aggiungi quell'istanza di Alloggio alla lista di alloggi.
		do { 
			rigaAlloggio = AlloggioDatabase.getInstance().getAlloggioByIndiceRiga(indiceRiga);
				 
			if(rigaAlloggio != null) {
				alloggi.add(rigaAlloggio);
				indiceRiga++;
			}
		}while(rigaAlloggio != null);
		
		//Trasformo la mia Lista di alloggi in un array di alloggi siccome AlloggiTableModel è capace di trattare solo array di alloggi, e la restituisco.
		Alloggio[] alloggiArray = alloggi.toArray(new Alloggio[alloggi.size()]);
		return new AlloggiTableModel(alloggiArray);
	}
	
	/*
	  La seguente funzione crea un ArrayList di cartelle cliniche e con l'aiuto della classe interfacciata con il Database la riempie con le
	  cartelle cliniche al suo interno. Essa restituisce poi una Table che contiene le cartelle cliniche.
	*/
	public static CartelleClinicheTableModel creaTabellaCartelleCliniche(String targhetta) throws SQLException{

		int indiceRiga = 1;
		ArrayList<CartellaClinica> cartelleCliniche = new ArrayList<CartellaClinica>();
		CartellaClinica rigaCartellaClinica = null;
			 
		//Finchè mi viene restituito una CartellaClinica valida, allora aggiungi quell'istanza di CartellaClinica alla lista di cartelle cliniche.
		do { 
			rigaCartellaClinica =  CartellaClinicaDatabase.getInstance().getRigaCartellaClinicaByTarghetta(indiceRiga, targhetta);
				 
			if(rigaCartellaClinica != null) {
				cartelleCliniche.add(rigaCartellaClinica);
				indiceRiga++;
			}
		}while(rigaCartellaClinica != null);
		
		//Trasformo la mia Lista di alloggi in un array di alloggi siccome AlloggiTableModel è capace di trattare solo array di alloggi, e la restituisco.
		CartellaClinica[] cartelleClinicheArray = cartelleCliniche.toArray(new CartellaClinica[cartelleCliniche.size()]);
		return new CartelleClinicheTableModel(cartelleClinicheArray);
	}
	
}
