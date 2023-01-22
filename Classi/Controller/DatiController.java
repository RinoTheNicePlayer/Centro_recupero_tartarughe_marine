package Classi.Controller;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import Classi.Connessione;
import Classi.Database.TartarugaDatabase;
import Classi.Models.Personale;

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
	
	//La seguente funzione crea una tabella e con l'aiuto della classe interfacciata con il Database la riempie con le informazioni necessarie.
	public static DefaultTableModel creaTabella(Personale personale, String tipoContenuto) throws SQLException{

		DefaultTableModel modello = new DefaultTableModel();

		//Se la tabella deve contenere dati riguardanti tartaruga, allora svolge il codice di seguito.
		if(tipoContenuto == "tartarughe") {

			 modello.addColumn("Targhetta");
			 modello.addColumn("Nome");
			 modello.addColumn("Sesso");
			 modello.addColumn("Età");
			 modello.addColumn("Data d'alloggio");
			 modello.addColumn("Codice vasca");
			 
			 /*
			   Il motivo per cui raccolgo il numero di colonne prima della creazione delle ultime due colonne, è perchè le prossime due colonne
			   non contengono valori ricavati dal Database, ma contengono dei JButton, che saranno inseriti prossimamente. Lo scopo dell'attributo
			   numColonne è tener conto di quante sono le colonne che contengono un valore preso dal Database.
			  */
			 int numColonne = modello.getColumnCount();
			 
			 modello.addColumn("Cartelle cliniche");
			 modello.addColumn("");
			 
			 int indiceRiga = 1;
			 Object[] riga = null;
			 
			 //Affinchè mi venga restituita una riga che contiene valori, allora aggiungi una riga contenente quei valori alla mia tabella.
			 do {
				 riga = TartarugaDatabase.getInstance().getInfoTartarugaByIndiceRiga(indiceRiga, numColonne);
				 
				 if(riga != null) {
					 modello.addRow(riga);
					 indiceRiga++;
				 }
			 }while(riga != null);
			
		//Altrimenti se deve contenere dati riguardanti cartelle cliniche, allora svolge quest'altro codice.
		} else if (tipoContenuto == "cartellecliniche") {
			//modello = return TartarugaDatabase.getInstance().getAllTartarugheInfo(modello);	
		}
		
		return modello;
	}
	
}
