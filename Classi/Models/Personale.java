package Classi.Models;

public class Personale {
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String sesso;
	private int idCentro;
	private String tipologia;
	
	public Personale(String compilazioneEmail, String compilazionePassword, String compilazioneNome, String compilazioneCognome, String compilazioneDataDiNascita, String compilazioneSesso, int compilazioneidCentro, String compilazioneTipologia) {
		email = compilazioneEmail;
		password = compilazionePassword;
		nome = compilazioneNome;
		cognome = compilazioneCognome;
		dataDiNascita = compilazioneDataDiNascita;
		sesso = compilazioneSesso;
		idCentro = compilazioneidCentro;
		tipologia = compilazioneTipologia;
	}
}