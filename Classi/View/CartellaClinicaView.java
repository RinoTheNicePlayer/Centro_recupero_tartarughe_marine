package Classi.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class CartellaClinicaView extends JFrame {
	
	private JPanel pannello;
	private JTextField compilazioneTarghetta;
	private JTextField compilazioneSpecie;
	private JTextField compilazioneLarghezza;
	private JPasswordField compilazionePeso;
	private JTextField compilazioneDataDiRitrovamento;
	private JTextField compilazioneLunghezza;
	private JTextField compilazioneLuogoDiRitrovamento;
	
	//Creazione della finestra
	public CartellaClinicaView() {
		//Pannello principale
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		pannello = new JPanel();
		pannello.setForeground(new Color(255, 255, 255));
		pannello.setBackground(new Color(255, 255, 255));
		setContentPane(pannello);
		pannello.setLayout(null);
		
		//Barra del titolo
		JPanel barraTitolo = new JPanel();
		barraTitolo.setBounds(0, 0, 1000, 50);
		barraTitolo.setBorder(UIManager.getBorder("Tree.editorBorder"));
		barraTitolo.setBackground(new Color(0, 0, 0));
		pannello.add(barraTitolo);
		barraTitolo.setLayout(null);
		
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
		iconaChiudi.setBounds(945, 0, 45, 50);
		barraTitolo.add(iconaChiudi);
		
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
		iconaMinimizza.setForeground(Color.WHITE);
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaMinimizza.setBackground(Color.WHITE);
		iconaMinimizza.setBounds(900, 0, 45, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel titoloFinestra = new JLabel("Cartella clinica");
		titoloFinestra.setVerticalAlignment(SwingConstants.TOP);
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(40, 11, 130, 28);
		barraTitolo.add(titoloFinestra);
		
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setLayout(null);
		pannelloDestro.setForeground(Color.WHITE);
		pannelloDestro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloDestro.setBackground(Color.WHITE);
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannello.add(pannelloDestro);
		
		JLabel testoInformativo2 = new JLabel("Condizioni della tartaruga");
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setForeground(Color.BLACK);
		testoInformativo2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoInformativo2.setBackground(Color.WHITE);
		testoInformativo2.setBounds(0, 50, 500, 70);
		pannelloDestro.add(testoInformativo2);
		
		JLabel testoPinne = new JLabel("Pinne");
		testoPinne.setHorizontalAlignment(SwingConstants.CENTER);
		testoPinne.setForeground(Color.BLACK);
		testoPinne.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPinne.setBackground(Color.WHITE);
		testoPinne.setBounds(50, 117, 170, 30);
		pannelloDestro.add(testoPinne);
		
		JComboBox selezioneCentro = new JComboBox();
		selezioneCentro.setToolTipText("Selezionare il Centro di appartenenza.");
		selezioneCentro.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneCentro.setSelectedIndex(-1);
		selezioneCentro.setMaximumRowCount(5);
		selezioneCentro.setForeground(Color.BLACK);
		selezioneCentro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneCentro.setBackground(Color.WHITE);
		selezioneCentro.setBounds(50, 157, 170, 30);
		pannelloDestro.add(selezioneCentro);
		
		JLabel testoCollo = new JLabel("Collo");
		testoCollo.setHorizontalAlignment(SwingConstants.CENTER);
		testoCollo.setForeground(Color.BLACK);
		testoCollo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCollo.setBackground(Color.WHITE);
		testoCollo.setBounds(50, 197, 170, 30);
		pannelloDestro.add(testoCollo);
		
		JComboBox selezioneProfessione = new JComboBox();
		selezioneProfessione.setToolTipText("Selezionare la propria professione.");
		selezioneProfessione.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneProfessione.setSelectedIndex(-1);
		selezioneProfessione.setMaximumRowCount(5);
		selezioneProfessione.setForeground(Color.BLACK);
		selezioneProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione.setBackground(Color.WHITE);
		selezioneProfessione.setBounds(50, 237, 170, 30);
		pannelloDestro.add(selezioneProfessione);
		
		JButton bottoneCarica = new JButton("Carica cartella clinica");
		bottoneCarica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		bottoneCarica.setForeground(Color.BLACK);
		bottoneCarica.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bottoneCarica.setBackground(Color.WHITE);
		bottoneCarica.setBounds(50, 436, 400, 50);
		pannelloDestro.add(bottoneCarica);
		
		JLabel testoCoda = new JLabel("Coda");
		testoCoda.setHorizontalAlignment(SwingConstants.CENTER);
		testoCoda.setForeground(Color.BLACK);
		testoCoda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCoda.setBackground(Color.WHITE);
		testoCoda.setBounds(280, 117, 170, 30);
		pannelloDestro.add(testoCoda);
		
		JComboBox selezioneCentro_1 = new JComboBox();
		selezioneCentro_1.setToolTipText("Selezionare il Centro di appartenenza.");
		selezioneCentro_1.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneCentro_1.setSelectedIndex(-1);
		selezioneCentro_1.setMaximumRowCount(5);
		selezioneCentro_1.setForeground(Color.BLACK);
		selezioneCentro_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneCentro_1.setBackground(Color.WHITE);
		selezioneCentro_1.setBounds(280, 157, 170, 30);
		pannelloDestro.add(selezioneCentro_1);
		
		JLabel testoTesta = new JLabel("Testa");
		testoTesta.setHorizontalAlignment(SwingConstants.CENTER);
		testoTesta.setForeground(Color.BLACK);
		testoTesta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoTesta.setBackground(Color.WHITE);
		testoTesta.setBounds(280, 197, 170, 30);
		pannelloDestro.add(testoTesta);
		
		JComboBox selezioneProfessione_1 = new JComboBox();
		selezioneProfessione_1.setToolTipText("Selezionare la propria professione.");
		selezioneProfessione_1.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneProfessione_1.setSelectedIndex(-1);
		selezioneProfessione_1.setMaximumRowCount(5);
		selezioneProfessione_1.setForeground(Color.BLACK);
		selezioneProfessione_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione_1.setBackground(Color.WHITE);
		selezioneProfessione_1.setBounds(280, 237, 170, 30);
		pannelloDestro.add(selezioneProfessione_1);
		
		JComboBox selezioneProfessione_1_1 = new JComboBox();
		selezioneProfessione_1_1.setToolTipText("Selezionare la propria professione.");
		selezioneProfessione_1_1.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneProfessione_1_1.setSelectedIndex(-1);
		selezioneProfessione_1_1.setMaximumRowCount(5);
		selezioneProfessione_1_1.setForeground(Color.BLACK);
		selezioneProfessione_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione_1_1.setBackground(Color.WHITE);
		selezioneProfessione_1_1.setBounds(280, 317, 170, 30);
		pannelloDestro.add(selezioneProfessione_1_1);
		
		JLabel testoNaso = new JLabel("Naso");
		testoNaso.setHorizontalAlignment(SwingConstants.CENTER);
		testoNaso.setForeground(Color.BLACK);
		testoNaso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNaso.setBackground(Color.WHITE);
		testoNaso.setBounds(280, 277, 170, 30);
		pannelloDestro.add(testoNaso);
		
		JLabel testoBecco = new JLabel("Becco");
		testoBecco.setHorizontalAlignment(SwingConstants.CENTER);
		testoBecco.setForeground(Color.BLACK);
		testoBecco.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoBecco.setBackground(Color.WHITE);
		testoBecco.setBounds(50, 277, 170, 30);
		pannelloDestro.add(testoBecco);
		
		JComboBox selezioneProfessione_2 = new JComboBox();
		selezioneProfessione_2.setToolTipText("Selezionare la propria professione.");
		selezioneProfessione_2.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneProfessione_2.setSelectedIndex(-1);
		selezioneProfessione_2.setMaximumRowCount(5);
		selezioneProfessione_2.setForeground(Color.BLACK);
		selezioneProfessione_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione_2.setBackground(Color.WHITE);
		selezioneProfessione_2.setBounds(50, 317, 170, 30);
		pannelloDestro.add(selezioneProfessione_2);
		
		JComboBox selezioneProfessione_1_1_1 = new JComboBox();
		selezioneProfessione_1_1_1.setToolTipText("Selezionare la propria professione.");
		selezioneProfessione_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneProfessione_1_1_1.setSelectedIndex(-1);
		selezioneProfessione_1_1_1.setMaximumRowCount(5);
		selezioneProfessione_1_1_1.setForeground(Color.BLACK);
		selezioneProfessione_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione_1_1_1.setBackground(Color.WHITE);
		selezioneProfessione_1_1_1.setBounds(50, 397, 170, 30);
		pannelloDestro.add(selezioneProfessione_1_1_1);
		
		JLabel testoOcchi = new JLabel("Occhi");
		testoOcchi.setHorizontalAlignment(SwingConstants.CENTER);
		testoOcchi.setForeground(Color.BLACK);
		testoOcchi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoOcchi.setBackground(Color.WHITE);
		testoOcchi.setBounds(50, 357, 170, 30);
		pannelloDestro.add(testoOcchi);
		
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setLayout(null);
		pannelloSinistro.setForeground(Color.WHITE);
		pannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloSinistro.setBackground(Color.WHITE);
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannello.add(pannelloSinistro);
		
		JLabel lblInformazioniTartaruga = new JLabel("Informazioni tartaruga");
		lblInformazioniTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformazioniTartaruga.setForeground(Color.BLACK);
		lblInformazioniTartaruga.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblInformazioniTartaruga.setBackground(Color.WHITE);
		lblInformazioniTartaruga.setBounds(0, 50, 500, 70);
		pannelloSinistro.add(lblInformazioniTartaruga);
		
		JLabel testoTarghetta = new JLabel("Codice targhetta");
		testoTarghetta.setHorizontalAlignment(SwingConstants.LEFT);
		testoTarghetta.setForeground(Color.BLACK);
		testoTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoTarghetta.setBackground(Color.WHITE);
		testoTarghetta.setBounds(40, 119, 170, 30);
		pannelloSinistro.add(testoTarghetta);
		
		compilazioneTarghetta = new JTextField();
		compilazioneTarghetta.setToolTipText("Inserire la targhetta identificativa della tartaruga (Es.: Mario).");
		compilazioneTarghetta.setForeground(Color.BLACK);
		compilazioneTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneTarghetta.setColumns(10);
		compilazioneTarghetta.setBackground(Color.WHITE);
		compilazioneTarghetta.setBounds(40, 159, 170, 30);
		pannelloSinistro.add(compilazioneTarghetta);
		
		JLabel testoSpecie = new JLabel("Specie");
		testoSpecie.setHorizontalAlignment(SwingConstants.LEFT);
		testoSpecie.setForeground(Color.BLACK);
		testoSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSpecie.setBackground(Color.WHITE);
		testoSpecie.setBounds(290, 119, 90, 28);
		pannelloSinistro.add(testoSpecie);
		
		compilazioneSpecie = new JTextField();
		compilazioneSpecie.setToolTipText("Inserire la specie della tartaruga.");
		compilazioneSpecie.setForeground(Color.BLACK);
		compilazioneSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneSpecie.setColumns(10);
		compilazioneSpecie.setBackground(Color.WHITE);
		compilazioneSpecie.setBounds(290, 159, 170, 30);
		pannelloSinistro.add(compilazioneSpecie);
		
		JLabel testoLarghezza = new JLabel("Larghezza:");
		testoLarghezza.setHorizontalAlignment(SwingConstants.LEFT);
		testoLarghezza.setForeground(Color.BLACK);
		testoLarghezza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLarghezza.setBackground(Color.WHITE);
		testoLarghezza.setBounds(40, 277, 103, 30);
		pannelloSinistro.add(testoLarghezza);
		
		compilazioneLarghezza = new JTextField();
		compilazioneLarghezza.setToolTipText("Larghezza espressa in cm.");
		compilazioneLarghezza.setForeground(Color.BLACK);
		compilazioneLarghezza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLarghezza.setColumns(10);
		compilazioneLarghezza.setBackground(Color.WHITE);
		compilazioneLarghezza.setBounds(40, 317, 103, 30);
		pannelloSinistro.add(compilazioneLarghezza);
		
		JLabel testoPeso = new JLabel("Peso:");
		testoPeso.setHorizontalAlignment(SwingConstants.LEFT);
		testoPeso.setForeground(Color.BLACK);
		testoPeso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPeso.setBackground(Color.WHITE);
		testoPeso.setBounds(40, 357, 50, 30);
		pannelloSinistro.add(testoPeso);
		
		compilazionePeso = new JPasswordField();
		compilazionePeso.setToolTipText("Peso espresso in kg.");
		compilazionePeso.setForeground(Color.BLACK);
		compilazionePeso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazionePeso.setEchoChar('*');
		compilazionePeso.setBackground(Color.WHITE);
		compilazionePeso.setBounds(40, 394, 103, 30);
		pannelloSinistro.add(compilazionePeso);
		
		JLabel testoDataDiRitrovamento = new JLabel("Data ritrovamento");
		testoDataDiRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiRitrovamento.setForeground(Color.BLACK);
		testoDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiRitrovamento.setBackground(Color.WHITE);
		testoDataDiRitrovamento.setBounds(40, 199, 185, 30);
		pannelloSinistro.add(testoDataDiRitrovamento);
		
		compilazioneDataDiRitrovamento = new JTextField();
		compilazioneDataDiRitrovamento.setToolTipText("Formato: AAAA-MM-GG (Es.: 2002-11-15");
		compilazioneDataDiRitrovamento.setForeground(Color.BLACK);
		compilazioneDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneDataDiRitrovamento.setColumns(10);
		compilazioneDataDiRitrovamento.setBackground(Color.WHITE);
		compilazioneDataDiRitrovamento.setBounds(40, 237, 170, 30);
		pannelloSinistro.add(compilazioneDataDiRitrovamento);
		
		JLabel testoLuogoRitrovamento = new JLabel("Luogo ritrovamento");
		testoLuogoRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoLuogoRitrovamento.setForeground(Color.BLACK);
		testoLuogoRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLuogoRitrovamento.setBackground(Color.WHITE);
		testoLuogoRitrovamento.setBounds(290, 199, 185, 30);
		pannelloSinistro.add(testoLuogoRitrovamento);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.setForeground(Color.BLACK);
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(Color.WHITE);
		bottoneIndietro.setBounds(173, 442, 140, 35);
		pannelloSinistro.add(bottoneIndietro);
		
		JLabel testoLunghezza = new JLabel("Lunghezza:");
		testoLunghezza.setHorizontalAlignment(SwingConstants.LEFT);
		testoLunghezza.setForeground(Color.BLACK);
		testoLunghezza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLunghezza.setBackground(Color.WHITE);
		testoLunghezza.setBounds(290, 277, 103, 30);
		pannelloSinistro.add(testoLunghezza);
		
		compilazioneLunghezza = new JTextField();
		compilazioneLunghezza.setToolTipText("Lunghezza espressa in cm.");
		compilazioneLunghezza.setForeground(Color.BLACK);
		compilazioneLunghezza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLunghezza.setColumns(10);
		compilazioneLunghezza.setBackground(Color.WHITE);
		compilazioneLunghezza.setBounds(290, 317, 103, 30);
		pannelloSinistro.add(compilazioneLunghezza);
		
		JLabel testoCentimetri1 = new JLabel("cm");
		testoCentimetri1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCentimetri1.setBounds(153, 314, 72, 30);
		pannelloSinistro.add(testoCentimetri1);
		
		JLabel testoCentimetri2 = new JLabel("cm");
		testoCentimetri2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCentimetri2.setBounds(403, 314, 72, 30);
		pannelloSinistro.add(testoCentimetri2);
		
		JLabel testoChilogrammi = new JLabel("kg");
		testoChilogrammi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoChilogrammi.setBounds(153, 391, 72, 30);
		pannelloSinistro.add(testoChilogrammi);
		
		compilazioneLuogoDiRitrovamento = new JTextField();
		compilazioneLuogoDiRitrovamento.setToolTipText("Inserire il luogo di ritrovamento della tartaruga.");
		compilazioneLuogoDiRitrovamento.setForeground(Color.BLACK);
		compilazioneLuogoDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLuogoDiRitrovamento.setColumns(10);
		compilazioneLuogoDiRitrovamento.setBackground(Color.WHITE);
		compilazioneLuogoDiRitrovamento.setBounds(290, 237, 170, 30);
		pannelloSinistro.add(compilazioneLuogoDiRitrovamento);
	}
}