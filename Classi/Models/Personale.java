package Classi.Models;

import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Personale {
	private String email;
	private String password;
	private String confermaPassword;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String sesso;
	private int idCentro;
	private String tipologia;
	
	public Personale(JTextField compilazioneNome, JTextField compilazioneCognome, JTextField compilazioneEmail, JPasswordField compilazionePassword, JPasswordField compilazioneConfermaPassword, JTextField compilazioneDataDiNascita, JComboBox selezioneSesso, JComboBox selezioneCentro, JComboBox selezioneProfessione) {
		
	}
}
