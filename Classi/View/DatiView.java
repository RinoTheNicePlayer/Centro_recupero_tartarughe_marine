package Classi.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Classi.Controller.DatiController;
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class DatiView extends JFrame {
	private JPanel pannello;
	private JTable tabella;
	private boolean visualizzazione = false;
	private JButton bottoneCartelleCliniche;
    private JLabel testoCartelleCliniche;
	
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
		pannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
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
				} catch(SQLException e1) {
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
		
		JLabel testoMatricola = new JLabel("Matricola: " + personale.getMatricola());
		testoMatricola.setForeground(new Color(0, 0, 0));
		testoMatricola.setBackground(new Color(255, 255, 255));
		testoMatricola.setHorizontalAlignment(SwingConstants.LEFT);
		testoMatricola.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoMatricola.setBounds(40, 255, 300, 30);
		pannelloSinistro.add(testoMatricola);
		
		JLabel testoNome = new JLabel("Nome: " + personale.getNome());
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setBounds(40, 285, 300, 30);
		pannelloSinistro.add(testoNome);
		
		JLabel testoCognome = new JLabel("Cognome: " + personale.getCognome());
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setBounds(40, 315, 300, 30);
		pannelloSinistro.add(testoCognome);
		
		JLabel testoEmail = new JLabel("Email: " + personale.getEmail());
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setBounds(40, 345, 300, 30);
		pannelloSinistro.add(testoEmail);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita: " + personale.getDataDiNascita());
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setBounds(40, 375, 300, 30);
		pannelloSinistro.add(testoDataDiNascita);
		
		JLabel testoProfessione = new JLabel("Professione: " + personale.getTipologia());
		testoProfessione.setHorizontalAlignment(SwingConstants.LEFT);
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setBounds(40, 405, 300, 30);
		pannelloSinistro.add(testoProfessione);
		
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
	public DatiView(Personale personale, String tipoContenuto, String targhettaTartaruga) {
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
		pannelloCentrale.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloCentrale.setForeground(new Color(255, 255, 255));
		pannelloCentrale.setBackground(new Color(255, 255, 255));
		pannelloCentrale.setBounds(0, 0, 1000, 500);
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
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		bottoneIndietro.setForeground(new Color(0, 0, 0));
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(new Color(255, 255, 255));
		bottoneIndietro.setBounds(40, 80, 90, 40);
		pannelloCentrale.add(bottoneIndietro);
		
        //Se la modalit?? di apertura ?? "cartellecliniche", allora crea la tabella "Cartella clinica"
		if(tipoContenuto == "cartellecliniche") {
			//Se l'utente ?? un medico veterinario, allora crea un bottone che permette di aggiungere una "Cartella clinica" nel database
			if(personale.getTipologia().equals("Medico veterinario")) {
				JButton bottoneAggiungiCartellaClinica = new JButton("Aggiungi Cartella Clinica");
				bottoneAggiungiCartellaClinica.setForeground(new Color(0, 0, 0));
		        bottoneAggiungiCartellaClinica.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		        bottoneAggiungiCartellaClinica.setBackground(new Color(255, 255, 255));
		        bottoneAggiungiCartellaClinica.setBounds(760, 80, 200, 40);
				bottoneAggiungiCartellaClinica.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CartellaClinicaView finestraCartellaClinica = new CartellaClinicaView(personale, targhettaTartaruga);
						finestraCartellaClinica.setLocationRelativeTo(null);
						finestraCartellaClinica.setVisible(true);
						dispose();
					}
				});
				pannelloCentrale.add(bottoneAggiungiCartellaClinica);
			}
			
			try {
				tabella = new JTable(DatiController.getInstance().creaTabellaCartelleCliniche(targhettaTartaruga));
				tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//Per ogni colonna della tabella, i valori non devono essere editabili. L'editor di ogni colonna ?? quindi settato a null
				for(int i = 0; i < tabella.getColumnCount(); i++) {
				    Class<?> classeColonna = tabella.getColumnClass(i);
				    tabella.setDefaultEditor(classeColonna, null);
				}
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		//Se la modalit?? di apertura ?? "tartarughe", allora crea la tabella "Tartaruga"
		} else if(tipoContenuto == "tartarughe") {
			JTextField barraDelleRicerche = new JTextField();
	        barraDelleRicerche.setToolTipText("La barra delle ricerche ti permette di cercare solo l'elemento che digiti, fornendo tutti i dati relativi a quest'ultimo (visualizzabili nella tabella)");
	        barraDelleRicerche.setForeground(new Color(0, 0, 0));
	        barraDelleRicerche.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	        barraDelleRicerche.setColumns(10);
	        barraDelleRicerche.setBackground(new Color(255, 255, 255));
	        barraDelleRicerche.setBounds(200, 80, 300, 40);
	        pannelloCentrale.add(barraDelleRicerche);
			
			JButton bottoneRicerca = new JButton("");
	        bottoneRicerca.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Ricerca.png")));
	        bottoneRicerca.setForeground(new Color(255, 255, 255));
	        bottoneRicerca.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	        bottoneRicerca.setBackground(new Color(255, 255, 255));
	        bottoneRicerca.setBounds(520, 80, 40, 40);
	        pannelloCentrale.add(bottoneRicerca);
	        bottoneRicerca.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					bottoneCartelleCliniche.setEnabled(false);
					testoCartelleCliniche.setText("");
					
					try {
						if(barraDelleRicerche.getText().equals("") == false) {
							tabella.setModel(DatiController.getInstance().creaTabellaAlloggi(barraDelleRicerche.getText()));
						} else {
							tabella.setModel(DatiController.getInstance().creaTabellaAlloggi());
						}
					} catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
	        
			try {
				tabella = new JTable(DatiController.getInstance().creaTabellaAlloggi());
				tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		        
				//Per ogni colonna della tabella, i valori non devono essere editabili. L'editor di ogni colonna ?? quindi settato a null
				for(int i = 0; i < tabella.getColumnCount(); i++) {
				    Class<?> classeColonna = tabella.getColumnClass(i);
				    tabella.setDefaultEditor(classeColonna, null);
				}
		        
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			
	        bottoneCartelleCliniche = new JButton("Cartelle cliniche");
	        bottoneCartelleCliniche.setForeground(new Color(0, 0, 0));
	        bottoneCartelleCliniche.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	        bottoneCartelleCliniche.setBackground(new Color(255, 255, 255));
	        bottoneCartelleCliniche.setBounds(760, 80, 200, 40);
	        pannelloCentrale.add(bottoneCartelleCliniche);
	        bottoneCartelleCliniche.setEnabled(false);
	        
	        /*
	         *
	         * Viene creato un oggetto JLabel denominato "testoCartelleCliniche" e viene assegnato un ListSelectionListener alla selezione del modello della tabella.
	         * Quando una riga della tabella viene selezionata, viene controllato se la prima colonna della riga selezionata non ?? vuota.
	         * Se non ?? vuota, viene abilitato un bottone chiamato "bottoneCartelleCliniche", e vengono impostate le propriet?? del testo e del layout di "testoCartelleCliniche"
	         * per mostrare il valore della prima colonna della riga selezionata.
	         * Se visualizzazione ?? false, questo testo viene aggiunto al pannello centrale e visualizzazione diventa true.
	         * In caso contrario, il testo viene semplicemente modificato. Infine, il pannello viene ridisegnato
	         *
	         */
	        testoCartelleCliniche = new JLabel("Visualizza per: ");
		    
			tabella.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					if(tabella.getValueAt(tabella.getSelectedRow(), 0).toString().equals("") == false) {
						if(visualizzazione == false) {
					        bottoneCartelleCliniche.setEnabled(true);
							
					        testoCartelleCliniche.setForeground(new Color(0, 0, 0));
					        testoCartelleCliniche.setBackground(new Color(255, 255, 255));
						    testoCartelleCliniche.setText("Visualizza per: " + tabella.getValueAt(tabella.getSelectedRow(), 0).toString());
						    testoCartelleCliniche.setHorizontalAlignment(SwingConstants.CENTER);
						    testoCartelleCliniche.setFont(new Font("Segoe UI", Font.PLAIN, 10));
						    testoCartelleCliniche.setBounds(760, 120, 200, 20);
						    pannelloCentrale.add(testoCartelleCliniche);
						    
						    visualizzazione = true;
						    pannello.repaint();
						} else {
					        bottoneCartelleCliniche.setEnabled(true);
				       		testoCartelleCliniche.setText("Visualizza per: " + tabella.getValueAt(tabella.getSelectedRow(), 0).toString());
						}
					}
				}
			});
			
			//Cliccando il bottone "bottoneCartellaClinica" si aprir?? una nuova finestra DatiView, questa volta in modalit?? cartellecliniche
			bottoneCartelleCliniche.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					DatiView finestraDatiCartellaClinica = new DatiView(personale, "cartellecliniche", tabella.getValueAt(tabella.getSelectedRow(), 0).toString());
					finestraDatiCartellaClinica.setLocationRelativeTo(null);
					finestraDatiCartellaClinica.setVisible(true);
					dispose();
				}
			});
			
		} else {
			ErroreView finestraErrore = new ErroreView("Impossibile generare la tabella!", "Non ?? stato possibile ricavare alcun dato.");
			finestraErrore.setLocationRelativeTo(null);
			finestraErrore.setModal(true);
			finestraErrore.setVisible(true);
		}
		
		JScrollPane pannelloDiScorrimento = new JScrollPane(tabella);
		pannelloDiScorrimento.setBounds(40, 150, 920, 300);
		pannelloCentrale.add(pannelloDiScorrimento);
		
		JLabel testoInformativo1 = new JLabel("Cliccando su una riga della tabella ?? possibile visualizzare la cartella clinica associata alla targhetta della tartaruga selezionata");
		testoInformativo1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		testoInformativo1.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setBounds(40, 455, 660, 20);
		pannelloCentrale.add(testoInformativo1);
	}
}