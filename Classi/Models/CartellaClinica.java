package Classi.Models;

public class CartellaClinica {
	//Proprietà private della classe
	private int idCartellaClinica;
	private int idPersonale;
	private int idTartaruga;
	private String identificativoInterno;
	private String dataRitrovamento;
	private String luogoRitrovamento;
	private String specie;
	private int larghezza;
	private int lunghezza;
	private int peso;
	private String statoNaso;
	private String statoBecco;
	private String statoTesta;
	private String statoCollo;
	private String statoOcchi;
	private String statoCoda;
	private String statoPinne;
	
	//Costruttore principale
	public CartellaClinica(int idCartellaClinica, int idPersonale, int idTartaruga, String identificativoInterno, String dataRitrovamento, String luogoRitrovamento, String specie, int larghezza, int lunghezza, int peso, String statoNaso, String statoBecco, String statoTesta, String statoCollo, String statoOcchi, String statoCoda, String statoPinne) {
		this.idCartellaClinica = idCartellaClinica;
		this.idPersonale = idPersonale;
		this.idTartaruga = idTartaruga;
		this.identificativoInterno = identificativoInterno;
		this.dataRitrovamento = dataRitrovamento;
		this.luogoRitrovamento = luogoRitrovamento;
		this.specie = specie;
		this.larghezza = larghezza;
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.statoNaso = statoNaso;
		this.statoBecco = statoBecco;
		this.statoTesta = statoTesta;
		this.statoCollo = statoCollo;
		this.statoOcchi = statoOcchi;
		this.statoCoda = statoCoda;
		this.statoPinne = statoPinne;
	}
	
	//Costruttore secondario. È stata usata la tecnica "Overload" per costruire un secondo costruttore, utile per determinati scopi
	public CartellaClinica(int idPersonale, int idTartaruga, String identificativoInterno, String specie, String dataRitrovamento, String luogoRitrovamento, int larghezza, int lunghezza, int peso, String statoPinne, String statoCoda, String statoCollo, String statoTesta, String statoBecco, String statoNaso, String statoOcchi) {
		this.idPersonale = idPersonale;
		this.idTartaruga = idTartaruga;
		this.identificativoInterno = identificativoInterno;
		this.specie = specie;
		this.dataRitrovamento = dataRitrovamento;
		this.luogoRitrovamento = luogoRitrovamento;
		this.larghezza = larghezza;
		this.lunghezza = lunghezza;
		this.peso = peso;
		this.statoPinne = statoPinne;
		this.statoCoda = statoCoda;
		this.statoCollo = statoCollo;
		this.statoTesta = statoTesta;
		this.statoBecco = statoBecco;
		this.statoNaso = statoNaso;
		this.statoOcchi = statoOcchi;
	}
	
	//Metodi "getter" e "setter" per ricavare ed impostare ogni proprietà privata
	public int getIdCartellaClinica() {
		return idCartellaClinica;
	}
	
	public void setIdCartellaClinica(int idCartellaClinica){
		this.idCartellaClinica = idCartellaClinica;
	}
	
	public int getIdPersonale() {
		return idPersonale;
	}
	
	public void setIdPersonale(int idPersonale){
		this.idPersonale = idPersonale;
	}
	
	public int getIdTartaruga() {
		return idTartaruga;
	}
	
	public void setIdTartaruga(int idTartaruga){
		this.idTartaruga = idTartaruga;
	}
	
	public String getIdentificativoInterno() {
		return identificativoInterno;
	}
	
	public void setIdentificativoInterno(String identificativoInterno) {
		this.identificativoInterno = identificativoInterno;
	}
	
	public String getDataRitrovamento() {
		return dataRitrovamento;
	}
	
	public void setDataRitrovamento(String dataRitrovamento) {
		this.dataRitrovamento = dataRitrovamento;
	}
	
	public String getLuogoRitrovamento() {
		return luogoRitrovamento;
	}
	
	public void setLuogoRitrovamento(String luogoRitrovamento) {
		this.luogoRitrovamento = luogoRitrovamento;
	}
	
	public String getSpecie() {
		return specie;
	}
	
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	
	public int getLarghezza() {
		return larghezza;
	}
	
	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	
	public int getLunghezza() {
		return lunghezza;
	}
	
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String getStatoNaso() {
		return statoNaso;
	}
	
	public void setStatoNaso(String statoNaso) {
		this.statoNaso = statoNaso;
	}
	
	public String getStatoBecco() {
		return statoBecco;
	}
	
	public void setStatoBecco(String statoBecco) {
		this.statoBecco = statoBecco;
	}
	
	public String getStatoTesta() {
		return statoTesta;
	}
	
	public void setStatoTesta(String statoTesta) {
		this.statoTesta = statoTesta;
	}
	
	public String getStatoCollo() {
		return statoCollo;
	}
	
	public void setStatoCollo(String statoCollo) {
		this.statoCollo = statoCollo;
	}
	
	public String getStatoOcchi() {
		return statoOcchi;
	}
	
	public void setStatoOcchi(String statoOcchi) {
		this.statoOcchi = statoOcchi;
	}
	
	public String getStatoCoda() {
		return statoCoda;
	}
	
	public void setStatoCoda(String statoCoda) {
		this.statoCoda = statoCoda;
	}
	
	public String getStatoPinne() {
		return statoPinne;
	}
	
	public void setStatoPinne(String statoPinne) {
		this.statoPinne = statoPinne;
	}
}