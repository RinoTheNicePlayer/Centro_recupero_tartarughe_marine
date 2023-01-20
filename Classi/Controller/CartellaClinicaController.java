package Classi.Controller;

import java.sql.SQLException;
import java.util.Random;

import Classi.TestoUtility;
import Classi.Database.CartellaClinicaDatabase;
import Classi.Database.TartarugaDatabase;
import Classi.Models.CartellaClinica;
import Classi.Models.Personale;
import Classi.Models.Tartaruga;
import Classi.View.ErroreView;

public final class CartellaClinicaController {
	//Inizializzazione dell'istanza
	private static CartellaClinicaController instance = null;
	
	//Creazione della funzione getInstance(), la quale restituisce l'unica istanza esistente della classe. Se non esiste la genera.
	public static CartellaClinicaController getInstance() {
		if(instance == null) {
			instance = new CartellaClinicaController();
		}
		
		return instance;
	}
	
	/*Funzione che permette di effettuare il caricamento di una cartella clinica. Tale funzione verifica se i campi siano validi.
	 * Se quest'ultimi sono validi, chiama la classe CartellaClinicaDatabase per eseguire la Query
	 */
	public void effettuaCaricamentoCartellaClinica(Personale personale, String targhetta, String specie, String dataRitrovamento, String luogoRitrovamento, String larghezza, String lunghezza, String peso, String statoPinne, String statoCoda, String statoCollo, String statoTesta, String statoBecco, String statoNaso, String statoOcchi) {
		
		//Controllo se la targhetta inserita esiste. Se questa non esiste, fai comparire una finestra di errore e termina la funzione.
		boolean validaDataRitrovamento = TestoUtility.verificaData(dataRitrovamento);
		boolean validaStatoPinne = TestoUtility.verificaSelezione(statoPinne);
		boolean validaStatoCoda = TestoUtility.verificaSelezione(statoCoda);
		boolean validaStatoCollo = TestoUtility.verificaSelezione(statoCollo);
		boolean validaStatoTesta = TestoUtility.verificaSelezione(statoTesta);
		boolean validaStatoBecco = TestoUtility.verificaSelezione(statoBecco);
		boolean validaStatoNaso = TestoUtility.verificaSelezione(statoNaso);
		boolean validaStatoOcchi = TestoUtility.verificaSelezione(statoOcchi);
		
		System.out.print(validaStatoPinne);
		System.out.print(validaStatoCoda);
		System.out.print(validaStatoCollo);
		System.out.print(validaStatoTesta);
		System.out.print(validaStatoBecco);
		System.out.print(validaStatoNaso);
		System.out.print(validaStatoOcchi);
		
		
		//Effettuo vari controlli su gli altri campi di compilazione della finestra CartellaClinicaView.
		if((validaDataRitrovamento == false) && (validaStatoPinne == false) && (validaStatoCoda == false) && (validaStatoCollo == false) && (validaStatoTesta == false) && (validaStatoBecco == false) && (validaStatoNaso == false) && (validaStatoOcchi == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Ci sono campi non compilati");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		}else if(validaDataRitrovamento == false) {
			ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "La data deve rispettare il formato AAAA-MM-GG");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		} else if((validaStatoPinne == false) || (validaStatoCoda == false) || (validaStatoCollo == false) || (validaStatoTesta == false) || (validaStatoBecco == false) || (validaStatoNaso == false) || (validaStatoOcchi == false)) {
			ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Uno o più campi di 'Condizione tartaruga' sono vuoti");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setVisible(true);
			
		} else {
			try {
				String identificativoInterno = generatoreDiIdentificativiInterni();
				Tartaruga tartaruga = TartarugaDatabase.getInstance().getTartarugaByTarghetta(targhetta);
				CartellaClinica cartellaClinica = new CartellaClinica(personale.getIdPersonale(), tartaruga.getIdTartaruga(), identificativoInterno, specie, dataRitrovamento, luogoRitrovamento, Integer.parseInt(larghezza), Integer.parseInt(lunghezza), Integer.parseInt(peso), statoPinne, statoCoda, statoCollo, statoTesta, statoBecco, statoNaso, statoOcchi);
				CartellaClinicaDatabase.getInstance().caricaCartellaClinica(cartellaClinica);
				
			} catch(NumberFormatException e) {
				ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "I campi 'Larghezza', 'Lunghezza' e 'Peso' devono contenere valori numerici.");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
			    e.printStackTrace();
			    
			} catch (SQLException e) {
				ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Non esiste alcuna tartaruga associata a quella targhetta.");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
				e.printStackTrace();
				
			} catch (NullPointerException e) {
				ErroreView finestraErrore = new ErroreView("Impossibile caricare la cartella clinica!", "Non esiste alcuna tartaruga associata a quella targhetta.");
				finestraErrore.setLocationRelativeTo(null);
				finestraErrore.setVisible(true);
				e.printStackTrace();
				
			}
		}
	}
	
	//Funzione che produce in maniera randomica un identificativo con formato IXXXXXXXX, dove X è una cifra corrispondente ad un numero compreso tra 0 e 9
	public String generatoreDiIdentificativiInterni() throws SQLException {
		Random rnd = new Random();
	    String identificativoInterno = "I";
	    
	    for(int i = 0; i < 8; i++) {
	    	identificativoInterno += rnd.nextInt(10);
	    }
	    
	    CartellaClinica cartellaClinica = CartellaClinicaDatabase.getInstance().getCartellaClinicaByIdentificativo(identificativoInterno);
	    
	    if(cartellaClinica == null) {
	    	return identificativoInterno;
	    	
	    } else {
	    	identificativoInterno = generatoreDiIdentificativiInterni();
	    	return identificativoInterno;
	    	
	    }
	}
}