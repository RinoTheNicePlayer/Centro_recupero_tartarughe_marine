/*
 *
 * Il codice rappresenta una classe Java chiamata "CartelleClinicheTableModel" che estende la classe "AbstractTableModel".
 * Questa classe non è altro che un modello per una tabella che visualizza informazioni su diverse cartelle cliniche.
 * Essa contiene un array di oggetti "CartellaClinica" e un array di stringhe che rappresentano i nomi delle colonne della tabella.
 * Il costruttore della classe accetta un array di "CartellaClinica" come input.
 * La classe sovrascrive i metodi "getColumnCount", "getColumnName", "getRowCount" e "getValueAt" della classe "AbstractTableModel"
 * per fornire informazioni sui dati da visualizzare nella tabella della classe "DatiView".
 * In particolare, il metodo "getValueAt" utilizza uno switch-case per determinare il valore da restituire
 * per una determinata cella della tabella in base alla riga e alla colonna specificate
 *
 */

package Classi.View;

import javax.swing.table.AbstractTableModel;
import Classi.Models.CartellaClinica;

public class CartelleClinicheTableModel extends AbstractTableModel {
		protected CartellaClinica[] cartelleCliniche;
		protected String[] nomiColonne = new String[] {"Identificativo interno", "Data ritrovamento", "Luogo ritrovamento", "Specie", "Larghezza", "Lunghezza", "Peso", "Naso", "Becco", "Testa", "Collo", "Occhi", "Coda", "Pinne"};
		
		public CartelleClinicheTableModel(CartellaClinica[] cartelleCliniche) {
			this.cartelleCliniche = cartelleCliniche;
		}
		
		public int getColumnCount() {
			 return nomiColonne.length;
		}
		
		public String getColumnName(int colonna) {
			 return nomiColonne[colonna];
		}
		
		public int getRowCount() {
			 return cartelleCliniche.length;
		}
		
		public Object getValueAt(int riga, int colonna) {
			switch(colonna) {
				case 0:
					return cartelleCliniche[riga].getIdentificativoInterno();
				case 1:
					return cartelleCliniche[riga].getDataRitrovamento();
				case 2:
					return cartelleCliniche[riga].getLuogoRitrovamento();
				case 3:
					return cartelleCliniche[riga].getSpecie();
				case 4:
					return cartelleCliniche[riga].getLarghezza();
				case 5:
					return cartelleCliniche[riga].getLunghezza();
				case 6:
					return cartelleCliniche[riga].getPeso();
				case 7:
					return cartelleCliniche[riga].getStatoNaso();
				case 8:
					return cartelleCliniche[riga].getStatoBecco();
				case 9:
					return cartelleCliniche[riga].getStatoTesta();
				case 10:
					return cartelleCliniche[riga].getStatoCollo();
				case 11:
					return cartelleCliniche[riga].getStatoOcchi();
				case 12:
					return cartelleCliniche[riga].getStatoCoda();
				case 13:
					return cartelleCliniche[riga].getStatoPinne();
				default:
					return null;
			}
		}
}