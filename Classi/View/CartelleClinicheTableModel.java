package Classi.View;

import javax.swing.table.AbstractTableModel;

import Classi.Models.CartellaClinica;

public class CartelleClinicheTableModel extends AbstractTableModel{
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
			 switch (colonna) {
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

