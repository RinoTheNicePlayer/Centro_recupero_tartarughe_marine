package Classi.Models;

public class Alloggio {
	private Tartaruga tartaruga;
	private Vasca vasca;
	private String dataInizio;
	
	public Alloggio(Tartaruga tartaruga, Vasca vasca, String dataInizio) {
		this.tartaruga = tartaruga;
		this.vasca = vasca;
		this.dataInizio = dataInizio;
	}
	
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
