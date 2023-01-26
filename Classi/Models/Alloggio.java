package Classi.Models;

public class Alloggio {
	//Proprietà private della classe
	private Tartaruga tartaruga;
	private Vasca vasca;
	private String dataInizio;
	
	//Costruttore
	public Alloggio(Tartaruga tartaruga, Vasca vasca, String dataInizio) {
		this.tartaruga = tartaruga;
		this.vasca = vasca;
		this.dataInizio = dataInizio;
	}
	
	//Metodi "getter" e "setter" per ricavare ed impostare ogni proprietà privata
	public Tartaruga getTartaruga() {
		return tartaruga;
	}
	
	public void setTartaruga(Tartaruga tartaruga) {
		this.tartaruga = tartaruga;
	}
	
	public Vasca getVasca() {
		return vasca;
	}
	
	public void setVasca(Vasca vasca) {
		this.vasca = vasca;
	}
	
	public String getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
}