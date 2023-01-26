package Classi.Models;

public class Personale {
	//Proprietà private della classe
	private int idPersonale;
	private int idCentro;
    private String matricola;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String sesso;
    private String dataDiNascita;
    private String tipologia;
    
    //Costruttore principale
    private Personale(int idPersonale, int idCentro, String matricola, String email, String password, String nome, String cognome, String sesso, String dataDiNascita, String tipologia) {
    	this.idPersonale = idPersonale;
    	this.idCentro = idCentro;
    	this.matricola = matricola;
    	this.email = email;
    	this.password = password;
    	this.nome = nome;
    	this.cognome = cognome;
    	this.sesso = sesso;
    	this.dataDiNascita = dataDiNascita;
    	this.tipologia = tipologia;
    }
    
    /*
     *
     * Costruttore secondario. È stata usata la tecnica "Overload" per costruire un secondo costruttore
     * che passa il valore "0" al primo parametro e il valore nullo al terzo
     *
     */
    public Personale(int idCentro, String email, String password, String nome, String cognome, String sesso, String dataDiNascita, String tipologia) {
    	this(0, idCentro, "", email, password, nome, cognome, sesso, dataDiNascita, tipologia);
    }
    
    /*
     * 
     * Costruttore secondario. È stata usata la tecnica "Overload" per costruire un terzo costruttore
     * che passa il valore nullo al quinto parametro
     * 
     */
    public Personale(int idPersonale, int idCentro, String matricola, String email, String nome, String cognome, String sesso, String dataDiNascita, String tipologia) {
    	this(idPersonale, idCentro, matricola, email, "", nome, cognome, sesso, dataDiNascita, tipologia);
    }
    
    //Metodi "getter" e "setter" per ricavare ed impostare ogni proprietà privata
    public int getIdPersonale() {
        return idPersonale;
    }

    public void setIdPersonale(int IdPersonale) {
        this.idPersonale = IdPersonale;
    }
    
    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }
    
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return matricola;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    
    public String getDataDiNascita() {
        return dataDiNascita;
    }
    
    public void setDataDiNascita(String dataDiNascita) {
    	this.dataDiNascita = dataDiNascita;
    }
    
    public String getTipologia() {
        return tipologia;
    }
    
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}