package Classi.Models;

public class Tartaruga {
	private int idTartaruga;
	private String targhetta;
	private String nome;
	private String sesso;
	private int eta;
	
	public Tartaruga(int idTartaruga, String targhetta, String nome, String sesso, int eta) {
		this.idTartaruga = idTartaruga;
		this.targhetta = targhetta;
		this.nome = nome;
		this.sesso = sesso;
		this.eta = eta;
	}
	
	public int getIdTartaruga() {
		return idTartaruga;
	}
	
	public void setIdTartaruga(int idTartaruga) {
		this.idTartaruga = idTartaruga;
	}
	
	public String getTarghetta() {
		return targhetta;
	}
	
	public void setTarghetta(String targhetta) {
		this.targhetta = targhetta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSesso() {
		return sesso;
	}
	
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
}