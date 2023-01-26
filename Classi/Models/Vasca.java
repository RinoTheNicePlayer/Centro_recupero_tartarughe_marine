package Classi.Models;

public class Vasca {
	//Proprietà private della classe
	private int idVasca;
	private String codiceVasca;
	
	//Costruttore
	public Vasca(int idVasca, String codiceVasca) {
		this.idVasca = idVasca;
		this.codiceVasca = codiceVasca;
	}
	
	//Metodi "getter" e "setter" per ricavare ed impostare ogni proprietà privata
	public int getIdVasca() {
		return idVasca;
	}
	
	public void setIdVasca(int idVasca) {
		this.idVasca = idVasca;
	}
	
	public String getCodiceVasca() {
		return codiceVasca;
	}
	
	public void setCodiceVasca(String codiceVasca) {
		this.codiceVasca = codiceVasca;
	}
}