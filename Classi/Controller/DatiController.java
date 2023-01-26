/*
 *
 * Il codice rappresenta una classe Java chiamata "DatiController".
 * La classe utilizza il pattern singleton per garantire che ci sia solo un'unica istanza della classe in tutto il programma.
 * Nella classe sono inclusi due metodi statici, "creaTabellaAlloggi" e "creaTabellaCartelleCliniche",
 * che sono utilizzati per creare una tabella di alloggi e una tabella di cartelle cliniche rispettivamente.
 * Il metodo "creaTabellaAlloggi" crea un'ArrayList di alloggi e utilizza una classe chiamata "AlloggioDatabase" per riempirla con ogni alloggio presente nel database.
 * In seguito, la funzione restituisce un'istanza di "AlloggiTableModel" che contiene la lista degli alloggi.
 * Il metodo "creaTabellaCartelleCliniche" è simile al metodo "creaTabellaAlloggi", ma invece di alloggi,
 * crea un'ArrayList di cartelle cliniche e utilizza una classe chiamata "CartellaClinicaDatabase" per riempirla con le cartelle cliniche presenti nel database.
 * Come "creaTabellaAlloggi", anche questo metodo restituisce un'istanza di "CartelleClinicheTableModel" che contiene la lista delle cartelle cliniche
 *
 */

package Classi.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import Classi.Database.AlloggioDatabase;
import Classi.Database.CartellaClinicaDatabase;
import Classi.Models.Alloggio;
import Classi.Models.CartellaClinica;
import Classi.View.AlloggiTableModel;
import Classi.View.CartelleClinicheTableModel;

public class DatiController {
	/*
	 *
	 * Funzione che restituisce un'istanza della classe DatiController, la genera se non esiste già.
	 * La variabile d'istanza "instance" viene usata per memorizzare l'unica istanza della classe ed assicura che non ne venga creata più di una
	 *
	 */
	private static DatiController instance = null;
	
	public static DatiController getInstance() {
		if(instance == null) {
			instance = new DatiController();
		}
		
		return instance;
	}
	
	//Metodo creaTabellaAlloggi senza valore passato
	public static AlloggiTableModel creaTabellaAlloggi() throws SQLException {
		int indiceRiga = 1;
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();
		Alloggio rigaAlloggio = null;
		
		do {
			rigaAlloggio = AlloggioDatabase.getInstance().getAlloggioByIndiceRiga(indiceRiga);
			
			if(rigaAlloggio != null) {
				alloggi.add(rigaAlloggio);
				indiceRiga++;
			}
		} while(rigaAlloggio != null);
		
		Alloggio[] alloggiArray = alloggi.toArray(new Alloggio[alloggi.size()]);
		
		return new AlloggiTableModel(alloggiArray);
	}
	
	//Metodo creaTabellaAlloggi con valore passato
	public static AlloggiTableModel creaTabellaAlloggi(String valore) throws SQLException {
		int indiceRiga = 1;
		ArrayList<Alloggio> alloggi = new ArrayList<Alloggio>();
		Alloggio rigaAlloggio = null;
		
		do {
			rigaAlloggio = AlloggioDatabase.getInstance().getAlloggioByIndiceRiga(indiceRiga, valore);
			
			if(rigaAlloggio != null) {
				alloggi.add(rigaAlloggio);
				indiceRiga++;
			}
		} while(rigaAlloggio != null);
		
		Alloggio[] alloggiArray = alloggi.toArray(new Alloggio[alloggi.size()]);
		
		return new AlloggiTableModel(alloggiArray);
	}
	
	public static CartelleClinicheTableModel creaTabellaCartelleCliniche(String targhetta) throws SQLException {
		int indiceRiga = 1;
		ArrayList<CartellaClinica> cartelleCliniche = new ArrayList<CartellaClinica>();
		CartellaClinica rigaCartellaClinica = null;
		
		do {
			rigaCartellaClinica =  CartellaClinicaDatabase.getInstance().getRigaCartellaClinicaByTarghetta(indiceRiga, targhetta);
			
			if(rigaCartellaClinica != null) {
				cartelleCliniche.add(rigaCartellaClinica);
				indiceRiga++;
			}
		} while(rigaCartellaClinica != null);
		
		CartellaClinica[] cartelleClinicheArray = cartelleCliniche.toArray(new CartellaClinica[cartelleCliniche.size()]);
		
		return new CartelleClinicheTableModel(cartelleClinicheArray);
	}
}