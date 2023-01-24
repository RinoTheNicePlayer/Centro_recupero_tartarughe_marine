package Classi.View;

import javax.swing.table.AbstractTableModel;

import Classi.Models.Alloggio;

public class AlloggiTableModel extends AbstractTableModel{
	
		 protected Alloggio[] alloggi;
		 protected String[] nomiColonne = new String[] {"Targhetta", "Nome", "Sesso", "Età", "Data di alloggio", "Codice vasca"};
		 
		 public AlloggiTableModel(Alloggio[] alloggi) {
			 this.alloggi = alloggi;
		 }
		 
		 public int getColumnCount() {
			 return nomiColonne.length;
		 }
		 
		 public String getColumnName(int colonna) {
			 return nomiColonne[colonna];
		 }
		 
		 public int getRowCount() {
			 return alloggi.length;
		 }
		 
		 public Object getValueAt(int riga, int colonna) {
			 switch (colonna) {
				 case 0:
					 return alloggi[riga].getTartaruga().getTarghetta();
				 case 1:
					 return alloggi[riga].getTartaruga().getNome();
				 case 2:
					 return alloggi[riga].getTartaruga().getSesso();
				 case 3:
					 return alloggi[riga].getTartaruga().getEta();
				 case 4:
					 return alloggi[riga].getDataInizio();
				 case 5:
					 return alloggi[riga].getVasca().getCodiceVasca();
				 default:
					 return null;
			 }
		}
}