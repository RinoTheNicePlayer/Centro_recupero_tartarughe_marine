package Classi.Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classi.Connessione;

public class Personale {
    private String matricola;
    private String nome;
    private String cognome;
    private String sesso;
    private Date dataDiNascita;
    private String tipologia;
    
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
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
    
    public Date getDataDiNascita() {
        return dataDiNascita;
    }
    
    public void setDataDiNascita(Date dataDiNascita) {
    	this.dataDiNascita = dataDiNascita;
    }
    
    public String getTipologia() {
        return tipologia;
    }
    
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    
    public static Personale getPersonaleByEmail(String email) throws SQLException {
    	Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
        	connection = Connessione.getConnection();
            String sql = "SELECT * FROM Personale WHERE Email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
            	// Crea un oggetto Personale e imposta i suoi campi con i dati del ResultSet
                Personale personale = new Personale();
                personale.setMatricola(resultSet.getString("Matricola"));
                personale.setNome(resultSet.getString("Nome"));
                personale.setCognome(resultSet.getString("Cognome"));
                personale.setSesso(resultSet.getString("Sesso"));
                personale.setDataDiNascita(resultSet.getDate("Data_di_nascita"));
                personale.setTipologia(resultSet.getString("Tipologia"));
                
                return personale;
            }
        } catch(SQLException e) {
        	e.printStackTrace();
            throw e;
        }
        
        return null;
    }
}