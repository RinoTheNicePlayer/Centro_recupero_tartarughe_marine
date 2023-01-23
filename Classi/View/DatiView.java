package Classi.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Classi.Connessione;
import Classi.Controller.DatiController;
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DatiView extends JFrame {
	private JPanel pannello;
	private JTextField barraDelleRicerche;
	
	//Creazione della finestra per la visualizzazione dei dati del personale

	public DatiView(Personale personale) {
		//Pannello principale
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		pannello = new JPanel();
		pannello.setForeground(new Color(255, 255, 255));
		pannello.setBackground(new Color(255, 255, 255));
		pannello.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello);
		pannello.setLayout(null);
		
		//Barra del titolo
		JPanel barraTitolo = new JPanel();
		barraTitolo.setForeground(new Color(0, 0, 0));
		barraTitolo.setBackground(new Color(0, 0, 0));
		barraTitolo.setBounds(0, 0, 1000, 50);
		pannello.add(barraTitolo);
		barraTitolo.setLayout(null);
		
		JLabel iconaLogo = new JLabel("");
		iconaLogo.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Logo.png")));
		iconaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaLogo.setForeground(new Color(255, 255, 255));
		iconaLogo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaLogo.setBackground(new Color(255, 255, 255));
		iconaLogo.setBounds(10, 0, 50, 50);
		barraTitolo.add(iconaLogo);
		
		JLabel titoloFinestra = new JLabel("Dati");
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(70, 0, 40, 50);
		barraTitolo.add(titoloFinestra);
		
		JLabel iconaMinimizza = new JLabel("");
		iconaMinimizza.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Riduci a icona.png")));
		iconaMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iconaMinimizza.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona (blu).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconaMinimizza.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		iconaMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		iconaMinimizza.setForeground(new Color(255, 255, 255));
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaMinimizza.setBackground(new Color(255, 255, 255));
		iconaMinimizza.setBounds(900, 0, 50, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel iconaChiudi = new JLabel("");
		iconaChiudi.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Chiudi.png")));
		iconaChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iconaChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi (rosso).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconaChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		iconaChiudi.setHorizontalAlignment(SwingConstants.CENTER);
		iconaChiudi.setForeground(new Color(255, 255, 255));
		iconaChiudi.setBackground(new Color(255, 255, 255));
		iconaChiudi.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaChiudi.setBounds(940, 0, 50, 50);
		barraTitolo.add(iconaChiudi);
		
		//Pannello sinistro
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannello.add(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PortaleView finestraPortale = new PortaleView(PersonaleDatabase.getInstance().getPersonaleByEmail(personale.getEmail()));
					finestraPortale.setLocationRelativeTo(null);
					finestraPortale.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		bottoneIndietro.setForeground(new Color(0, 0, 0));
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(new Color(255, 255, 255));
		bottoneIndietro.setBounds(40, 80, 100, 40);
		pannelloSinistro.add(bottoneIndietro);
		
		JLabel iconaProfilo = new JLabel("");
		iconaProfilo.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Profilo utente.png")));
		iconaProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaProfilo.setForeground(new Color(255, 255, 255));
		iconaProfilo.setBackground(new Color(255, 255, 255));
		iconaProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaProfilo.setBounds(200, 80, 100, 100);
		pannelloSinistro.add(iconaProfilo);
		
		JLabel iconaEsci = new JLabel("");
		iconaEsci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessoView finestraAccesso = new AccessoView();
				finestraAccesso.setLocationRelativeTo(null);
				finestraAccesso.setVisible(true);
				dispose();
			}
		});
		iconaEsci.setToolTipText("Esci");
		iconaEsci.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setForeground(new Color(255, 255, 255));
		iconaEsci.setBackground(new Color(255, 255, 255));
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setBounds(440, 80, 30, 30);
		pannelloSinistro.add(iconaEsci);
		
		JLabel testoDati = new JLabel("Dati");
		testoDati.setHorizontalAlignment(SwingConstants.CENTER);
		testoDati.setForeground(new Color(0, 0, 0));
		testoDati.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoDati.setBackground(new Color(255, 255, 255));
		testoDati.setBounds(0, 180, 500, 50);
		pannelloSinistro.add(testoDati);
		
		JLabel testoInformativo1 = new JLabel("Qui puoi consultare le tue credenziali o eliminare il tuo account,");
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setBounds(0, 230, 500, 30);
		pannelloSinistro.add(testoInformativo1);
		
		JLabel testoInformativo2 = new JLabel("qualora non fossi più interessato a volerlo");
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(0, 250, 500, 30);
		pannelloSinistro.add(testoInformativo2);
		
		JLabel testoMatricola = new JLabel("Matricola: " + personale.getMatricola());
		testoMatricola.setForeground(new Color(0, 0, 0));
		testoMatricola.setBackground(new Color(255, 255, 255));
		testoMatricola.setHorizontalAlignment(SwingConstants.LEFT);
		testoMatricola.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoMatricola.setBounds(40, 300, 300, 30);
		pannelloSinistro.add(testoMatricola);
		
		JLabel testoNome = new JLabel("Nome: " + personale.getNome());
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setBounds(40, 330, 300, 30);
		pannelloSinistro.add(testoNome);
		
		JLabel testoCognome = new JLabel("Cognome: " + personale.getCognome());
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setBounds(40, 360, 300, 30);
		pannelloSinistro.add(testoCognome);
		
		JLabel testoEmail = new JLabel("Email: " + personale.getEmail());
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setBounds(40, 390, 300, 30);
		pannelloSinistro.add(testoEmail);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita: " + personale.getDataDiNascita());
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setBounds(40, 420, 300, 30);
		pannelloSinistro.add(testoDataDiNascita);
		
		JLabel testoProfessione = new JLabel("Professione: " + personale.getTipologia());
		testoProfessione.setHorizontalAlignment(SwingConstants.LEFT);
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setBounds(40, 450, 300, 30);
		pannelloSinistro.add(testoProfessione);
		
		JLabel iconaElimina = new JLabel("");
		iconaElimina.setToolTipText("Elimina definitivamente il tuo account");
		iconaElimina.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Elimina.png")));
		iconaElimina.setHorizontalAlignment(SwingConstants.CENTER);
		iconaElimina.setForeground(new Color(255, 255, 255));
		iconaElimina.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaElimina.setBackground(new Color(255, 255, 255));
		iconaElimina.setBounds(440, 450, 30, 30);
		pannelloSinistro.add(iconaElimina);
		
		//Pannello destro
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannelloDestro.setForeground(new Color(255, 255, 255));
		pannelloDestro.setBackground(new Color(255, 255, 255));
		pannello.add(pannelloDestro);
		pannelloDestro.setLayout(null);
		
		JLabel immagineTartaruga = new JLabel("");
		immagineTartaruga.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Tartaruga marina.png")));
		immagineTartaruga.setBounds(0, 0, 500, 500);
		immagineTartaruga.setForeground(new Color(255, 255, 255));
		immagineTartaruga.setBackground(new Color(255, 255, 255));
		immagineTartaruga.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		immagineTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		pannelloDestro.add(immagineTartaruga);
	}
	
	//Creazione della finestra per la visualizzazione dei dati riguardanti tartarughe/vasche/cartelle cliniche
	/**
	 * @wbp.parser.constructor
	 */
	public DatiView(Personale personale, String tipoContenuto) {
		//Pannello principale
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		pannello = new JPanel();
		pannello.setForeground(new Color(255, 255, 255));
		pannello.setBackground(new Color(255, 255, 255));
		pannello.setBorder(UIManager.getBorder("Tree.editorBorder"));
		setContentPane(pannello);
		pannello.setLayout(null);
			
		//Barra del titolo
		JPanel barraTitolo = new JPanel();
		barraTitolo.setForeground(new Color(0, 0, 0));
		barraTitolo.setBackground(new Color(0, 0, 0));
		barraTitolo.setBounds(0, 0, 1000, 50);
		pannello.add(barraTitolo);
		barraTitolo.setLayout(null);
			
		JLabel iconaLogo = new JLabel("");
		iconaLogo.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Logo.png")));
		iconaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaLogo.setForeground(new Color(255, 255, 255));
		iconaLogo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaLogo.setBackground(new Color(255, 255, 255));
		iconaLogo.setBounds(10, 0, 50, 50);
		barraTitolo.add(iconaLogo);
			
		JLabel titoloFinestra = new JLabel("Dati");
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(70, 0, 40, 50);
		barraTitolo.add(titoloFinestra);
			
		JLabel iconaMinimizza = new JLabel("");
		iconaMinimizza.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Riduci a icona.png")));
		iconaMinimizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iconaMinimizza.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona (blu).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconaMinimizza.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		iconaMinimizza.setHorizontalAlignment(SwingConstants.CENTER);
		iconaMinimizza.setForeground(new Color(255, 255, 255));
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaMinimizza.setBackground(new Color(255, 255, 255));
		iconaMinimizza.setBounds(900, 0, 50, 50);
		barraTitolo.add(iconaMinimizza);
			
		JLabel iconaChiudi = new JLabel("");
		iconaChiudi.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Chiudi.png")));
		iconaChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				iconaChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi (rosso).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				iconaChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		iconaChiudi.setHorizontalAlignment(SwingConstants.CENTER);
		iconaChiudi.setForeground(new Color(255, 255, 255));
		iconaChiudi.setBackground(new Color(255, 255, 255));
		iconaChiudi.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaChiudi.setBounds(940, 0, 50, 50);
		barraTitolo.add(iconaChiudi);
		
		//Pannello centrale
		JPanel pannelloCentrale = new JPanel();
		pannelloCentrale.setForeground(new Color(255, 255, 255));
		pannelloCentrale.setBackground(new Color(255, 255, 255));
		pannelloCentrale.setBounds(0, 0, 1000, 660);
		pannello.add(pannelloCentrale);
		pannelloCentrale.setLayout(null);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PortaleView finestraPortale = new PortaleView(PersonaleDatabase.getInstance().getPersonaleByEmail(personale.getEmail()));
					finestraPortale.setLocationRelativeTo(null);
					finestraPortale.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		bottoneIndietro.setForeground(new Color(0, 0, 0));
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(new Color(255, 255, 255));
		bottoneIndietro.setBounds(40, 80, 100, 40);
		pannelloCentrale.add(bottoneIndietro);
		
		JLabel iconaRicerca = new JLabel("");
        iconaRicerca.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Ricerca.png")));
        iconaRicerca.setToolTipText("Cerca");
        iconaRicerca.setHorizontalAlignment(SwingConstants.CENTER);
        iconaRicerca.setForeground(new Color(255, 255, 255));
        iconaRicerca.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        iconaRicerca.setBackground(new Color(255, 255, 255));
        iconaRicerca.setBounds(644, 80, 37, 40);
        pannelloCentrale.add(iconaRicerca);
        
        barraDelleRicerche = new JTextField();
        barraDelleRicerche.setToolTipText("La barra delle ricerche ti permette di cercare solo l'elemento che digiti, fornendo tutti i dati relativi a quest'ultimo (visualizzabili nella tabella)");
        barraDelleRicerche.setForeground(new Color(0, 0, 0));
        barraDelleRicerche.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        barraDelleRicerche.setColumns(10);
        barraDelleRicerche.setBackground(new Color(255, 255, 255));
        barraDelleRicerche.setBounds(334, 81, 300, 40);
        pannelloCentrale.add(barraDelleRicerche);
		
		/* 
	 	Se i contenuti della tabella riguardano cartelle cliniche e l'utente è un medico veterinario, 
	 	allora crea un bottone che permette l'aggiunta di una cartella clinica.
		*/
		if((personale.getTipologia().equals("Medico veterinario")) && (tipoContenuto == "cartellecliniche")) {
			
			JButton bottoneAggiungiCartellaClinica = new JButton("Aggiungi Cartella Clinica");
			
			bottoneAggiungiCartellaClinica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CartellaClinicaView finestraCartellaClinica = new CartellaClinicaView(personale);
					finestraCartellaClinica.setLocationRelativeTo(null);
					finestraCartellaClinica.setVisible(true);
					dispose();
				}
			});
			bottoneAggiungiCartellaClinica.setForeground(new Color(0, 0, 0));
	        bottoneAggiungiCartellaClinica.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	        bottoneAggiungiCartellaClinica.setBackground(new Color(255, 255, 255));
	        bottoneAggiungiCartellaClinica.setBounds(760, 80, 200, 40);
	        
			pannelloCentrale.add(bottoneAggiungiCartellaClinica);
			
		/*
		  Se i contenuti della tabella riguardano tartarughe, 
		  allora crea un bottone che permette l'aggiunta di una nuova tartaruga nel Database.
		*/
		} else if (tipoContenuto == "tartarughe") {
			
			JButton bottoneAggiungiTartaruga = new JButton("Aggiungi Tartaruga");
			
			bottoneAggiungiTartaruga.setForeground(new Color(0, 0, 0));
			bottoneAggiungiTartaruga.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			bottoneAggiungiTartaruga.setBackground(new Color(255, 255, 255));
			bottoneAggiungiTartaruga.setBounds(760, 80, 200, 40);
	        
			pannelloCentrale.add(bottoneAggiungiTartaruga);
			
		}
		
        JTable tabella = null;
        
		try {
			
			tabella = new JTable(DatiController.getInstance().creaTabella(personale, tipoContenuto));
			//Per ogni colonna della tabella, i valori non devono essere editabili. L'editor di ogni colonna è quindi settato a null.
			for (int i = 0; i < tabella.getColumnCount(); i++)
			{
			    Class<?> classeColonna = tabella.getColumnClass(i);
			    tabella.setDefaultEditor(classeColonna, null);
			}

			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        JScrollPane pannelloDiScorrimento = new JScrollPane(tabella);
        pannelloDiScorrimento.setBounds(40, 150, 920, 320);
        pannelloCentrale.add(pannelloDiScorrimento);
        pannelloCentrale.add(pannelloDiScorrimento);
        
	}
}