package Classi.View;

import java.awt.Color;
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
import Classi.Controller.CartellaClinicaController;
import Classi.Models.Personale;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class CartellaClinicaView extends JFrame {
	private JPanel pannello;
	private JTextField compilazioneTarghetta;
	private JTextField compilazioneSpecie;
	private JTextField compilazioneLarghezza;
	private JTextField compilazioneDataDiRitrovamento;
	private JTextField compilazioneLunghezza;
	private JTextField compilazioneLuogoDiRitrovamento;
	private JTextField compilazionePeso;
	
	//Creazione della finestra
	public CartellaClinicaView(Personale personale) {
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
		
		JLabel titoloFinestra = new JLabel("Cartella clinica");
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(70, 0, 130, 50);
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
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannello.add(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JLabel testoInformativo1 = new JLabel("Informazioni tartaruga");
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setBounds(0, 50, 500, 70);
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		pannelloSinistro.add(testoInformativo1);
		
		JLabel testoTarghetta = new JLabel("Targhetta");
		testoTarghetta.setForeground(new Color(0, 0, 0));
		testoTarghetta.setBackground(new Color(255, 255, 255));
		testoTarghetta.setHorizontalAlignment(SwingConstants.LEFT);
		testoTarghetta.setBounds(40, 130, 90, 30);
		pannelloSinistro.add(testoTarghetta);
		testoTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JLabel testoSpecie = new JLabel("Specie");
		testoSpecie.setForeground(new Color(0, 0, 0));
		testoSpecie.setBackground(new Color(255, 255, 255));
		testoSpecie.setHorizontalAlignment(SwingConstants.LEFT);
		testoSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSpecie.setBounds(290, 130, 60, 30);
		pannelloSinistro.add(testoSpecie);
		
		compilazioneTarghetta = new JTextField();
		compilazioneTarghetta.setToolTipText("La Targhetta deve corrispondere al seguente formato: TXXXXXXXX,\r\ndove X è una cifra associata ad un numero compreso tra 0 e 9");
		compilazioneTarghetta.setForeground(new Color(0, 0, 0));
		compilazioneTarghetta.setBackground(new Color(255, 255, 255));
		compilazioneTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneTarghetta.setBounds(40, 170, 170, 30);
		pannelloSinistro.add(compilazioneTarghetta);
		compilazioneTarghetta.setColumns(10);
		
		compilazioneSpecie = new JTextField();
		compilazioneSpecie.setToolTipText("Digitare la Specie (Esempio: Caretta caretta)");
		compilazioneSpecie.setForeground(new Color(0, 0, 0));
		compilazioneSpecie.setBackground(new Color(255, 255, 255));
		compilazioneSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneSpecie.setColumns(10);
		compilazioneSpecie.setBounds(290, 170, 170, 30);
		pannelloSinistro.add(compilazioneSpecie);
		
		JLabel testoDataDiRitrovamento = new JLabel("Data di ritrovamento");
		testoDataDiRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiRitrovamento.setForeground(new Color(0, 0, 0));
		testoDataDiRitrovamento.setBackground(new Color(255, 255, 255));
		testoDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiRitrovamento.setBounds(40, 210, 190, 30);
		pannelloSinistro.add(testoDataDiRitrovamento);
		
		JLabel testoLuogoDiRitrovamento = new JLabel("Luogo di ritrovamento");
		testoLuogoDiRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoLuogoDiRitrovamento.setForeground(new Color(0, 0, 0));
		testoLuogoDiRitrovamento.setBackground(new Color(255, 255, 255));
		testoLuogoDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLuogoDiRitrovamento.setBounds(290, 210, 200, 30);
		pannelloSinistro.add(testoLuogoDiRitrovamento);
		
		compilazioneDataDiRitrovamento = new JTextField();
		compilazioneDataDiRitrovamento.setToolTipText("La Data deve corrispondere al seguente formato: AAAA-MM-GG (Esempio: 2002-11-15)");
		compilazioneDataDiRitrovamento.setForeground(new Color(0, 0, 0));
		compilazioneDataDiRitrovamento.setBackground(new Color(255, 255, 255));
		compilazioneDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneDataDiRitrovamento.setColumns(10);
		compilazioneDataDiRitrovamento.setBounds(40, 250, 170, 30);
		pannelloSinistro.add(compilazioneDataDiRitrovamento);
		
		compilazioneLuogoDiRitrovamento = new JTextField();
		compilazioneLuogoDiRitrovamento.setToolTipText("Digitare il Luogo di ritrovamento");
		compilazioneLuogoDiRitrovamento.setForeground(new Color(0, 0, 0));
		compilazioneLuogoDiRitrovamento.setBackground(new Color(255, 255, 255));
		compilazioneLuogoDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLuogoDiRitrovamento.setColumns(10);
		compilazioneLuogoDiRitrovamento.setBounds(290, 250, 170, 30);
		pannelloSinistro.add(compilazioneLuogoDiRitrovamento);
		
		JLabel testoLarghezza = new JLabel("Larghezza");
		testoLarghezza.setHorizontalAlignment(SwingConstants.LEFT);
		testoLarghezza.setForeground(new Color(0, 0, 0));
		testoLarghezza.setBackground(new Color(255, 255, 255));
		testoLarghezza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLarghezza.setBounds(40, 290, 90, 30);
		pannelloSinistro.add(testoLarghezza);
		
		JLabel testoLunghezza = new JLabel("Lunghezza");
		testoLunghezza.setForeground(new Color(0, 0, 0));
		testoLunghezza.setBackground(new Color(255, 255, 255));
		testoLunghezza.setHorizontalAlignment(SwingConstants.LEFT);
		testoLunghezza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLunghezza.setBounds(290, 290, 100, 30);
		pannelloSinistro.add(testoLunghezza);
		
		compilazioneLarghezza = new JTextField();
		compilazioneLarghezza.setToolTipText("La Larghezza deve essere espressa in cm (Centimetro)");
		compilazioneLarghezza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLarghezza.setForeground(new Color(0, 0, 0));
		compilazioneLarghezza.setBackground(new Color(255, 255, 255));
		compilazioneLarghezza.setBounds(40, 330, 100, 30);
		pannelloSinistro.add(compilazioneLarghezza);
		
		JLabel testoCm1 = new JLabel("cm");
		testoCm1.setHorizontalAlignment(SwingConstants.LEFT);
		testoCm1.setVerticalAlignment(SwingConstants.BOTTOM);
		testoCm1.setForeground(new Color(0, 0, 0));
		testoCm1.setBackground(new Color(255, 255, 255));
		testoCm1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoCm1.setBounds(150, 330, 30, 30);
		pannelloSinistro.add(testoCm1);
		
		compilazioneLunghezza = new JTextField();
		compilazioneLunghezza.setToolTipText("La Lunghezza deve essere espressa in cm (Centimetro)");
		compilazioneLunghezza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLunghezza.setForeground(new Color(0, 0, 0));
		compilazioneLunghezza.setBackground(new Color(255, 255, 255));
		compilazioneLunghezza.setBounds(290, 330, 100, 30);
		pannelloSinistro.add(compilazioneLunghezza);
		
		JLabel testoCm2 = new JLabel("cm");
		testoCm2.setHorizontalAlignment(SwingConstants.LEFT);
		testoCm2.setVerticalAlignment(SwingConstants.BOTTOM);
		testoCm2.setForeground(new Color(0, 0, 0));
		testoCm2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoCm2.setBackground(new Color(255, 255, 255));
		testoCm2.setBounds(400, 330, 30, 30);
		pannelloSinistro.add(testoCm2);
		
		JLabel testoPeso = new JLabel("Peso");
		testoPeso.setHorizontalAlignment(SwingConstants.LEFT);
		testoPeso.setForeground(new Color(0, 0, 0));
		testoPeso.setBackground(new Color(255, 255, 255));
		testoPeso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPeso.setBounds(40, 370, 50, 30);
		pannelloSinistro.add(testoPeso);
		
		compilazionePeso = new JTextField();
		compilazionePeso.setToolTipText("Il Peso deve essere espresso in kg (Chilogrammo)");
		compilazionePeso.setForeground(new Color(0, 0, 0));
		compilazionePeso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazionePeso.setColumns(10);
		compilazionePeso.setBackground(new Color(255, 255, 255));
		compilazionePeso.setBounds(40, 410, 100, 30);
		pannelloSinistro.add(compilazionePeso);
		
		JLabel testoKg = new JLabel("Kg");
		testoKg.setHorizontalAlignment(SwingConstants.LEFT);
		testoKg.setVerticalAlignment(SwingConstants.BOTTOM);
		testoKg.setForeground(new Color(0, 0, 0));
		testoKg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoKg.setBackground(new Color(255, 255, 255));
		testoKg.setBounds(150, 410, 30, 30);
		pannelloSinistro.add(testoKg);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatiView finestraDati = new DatiView(personale, "cartellaclinica", "");
				finestraDati.setLocationRelativeTo(null);
				finestraDati.setVisible(true);
				dispose();
			}
		});
		bottoneIndietro.setForeground(new Color(0, 0, 0));
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(new Color(255, 255, 255));
		bottoneIndietro.setBounds(180, 452, 140, 35);
		pannelloSinistro.add(bottoneIndietro);
		
		//Pannello destro
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setForeground(new Color(255, 255, 255));
		pannelloDestro.setBackground(new Color(255, 255, 255));
		pannelloDestro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannello.add(pannelloDestro);
		pannelloDestro.setLayout(null);
		
		JLabel testoInformativo2 = new JLabel("Condizioni tartaruga");
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(0, 50, 500, 70);
		pannelloDestro.add(testoInformativo2);
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel testoPinne = new JLabel("Pinne");
		testoPinne.setHorizontalAlignment(SwingConstants.CENTER);
		testoPinne.setForeground(new Color(0, 0, 0));
		testoPinne.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPinne.setBackground(new Color(255, 255, 255));
		testoPinne.setBounds(40, 130, 170, 30);
		pannelloDestro.add(testoPinne);
		
		JLabel testoCoda = new JLabel("Coda");
		testoCoda.setHorizontalAlignment(SwingConstants.CENTER);
		testoCoda.setForeground(new Color(0, 0, 0));
		testoCoda.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCoda.setBackground(new Color(255, 255, 255));
		testoCoda.setBounds(290, 130, 170, 30);
		pannelloDestro.add(testoCoda);
		
		JComboBox selezioneStatoPinne = new JComboBox();
		selezioneStatoPinne.setToolTipText("Selezionare lo stato di salute delle Pinne");
		selezioneStatoPinne.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoPinne.setSelectedIndex(-1);
		selezioneStatoPinne.setMaximumRowCount(5);
		selezioneStatoPinne.setForeground(new Color(0, 0, 0));
		selezioneStatoPinne.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoPinne.setBackground(new Color(255, 255, 255));
		selezioneStatoPinne.setBounds(40, 170, 170, 30);
		pannelloDestro.add(selezioneStatoPinne);
		
		JComboBox selezioneStatoCoda = new JComboBox();
		selezioneStatoCoda.setToolTipText("Selezionare lo stato di salute della Coda");
		selezioneStatoCoda.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoCoda.setSelectedIndex(-1);
		selezioneStatoCoda.setMaximumRowCount(5);
		selezioneStatoCoda.setForeground(new Color(0, 0, 0));
		selezioneStatoCoda.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoCoda.setBackground(new Color(255, 255, 255));
		selezioneStatoCoda.setBounds(290, 170, 170, 30);
		pannelloDestro.add(selezioneStatoCoda);
		
		JLabel testoCollo = new JLabel("Collo");
		testoCollo.setHorizontalAlignment(SwingConstants.CENTER);
		testoCollo.setForeground(new Color(0, 0, 0));
		testoCollo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCollo.setBackground(new Color(255, 255, 255));
		testoCollo.setBounds(40, 210, 170, 30);
		pannelloDestro.add(testoCollo);
		
		JLabel testoTesta = new JLabel("Testa");
		testoTesta.setHorizontalAlignment(SwingConstants.CENTER);
		testoTesta.setForeground(new Color(0, 0, 0));
		testoTesta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoTesta.setBackground(new Color(255, 255, 255));
		testoTesta.setBounds(290, 210, 170, 30);
		pannelloDestro.add(testoTesta);
		
		JComboBox selezioneStatoCollo = new JComboBox();
		selezioneStatoCollo.setToolTipText("Selezionare lo stato di salute del Collo");
		selezioneStatoCollo.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoCollo.setSelectedIndex(-1);
		selezioneStatoCollo.setMaximumRowCount(5);
		selezioneStatoCollo.setForeground(new Color(0, 0, 0));
		selezioneStatoCollo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoCollo.setBackground(new Color(255, 255, 255));
		selezioneStatoCollo.setBounds(40, 250, 170, 30);
		pannelloDestro.add(selezioneStatoCollo);
		
		JComboBox selezioneStatoTesta = new JComboBox();
		selezioneStatoTesta.setToolTipText("Selezionare lo stato di salute della Testa");
		selezioneStatoTesta.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoTesta.setSelectedIndex(-1);
		selezioneStatoTesta.setMaximumRowCount(5);
		selezioneStatoTesta.setForeground(new Color(0, 0, 0));
		selezioneStatoTesta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoTesta.setBackground(new Color(255, 255, 255));
		selezioneStatoTesta.setBounds(290, 250, 170, 30);
		pannelloDestro.add(selezioneStatoTesta);
		
		JLabel testoBecco = new JLabel("Becco");
		testoBecco.setHorizontalAlignment(SwingConstants.CENTER);
		testoBecco.setForeground(new Color(0, 0, 0));
		testoBecco.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoBecco.setBackground(new Color(255, 255, 255));
		testoBecco.setBounds(40, 290, 170, 30);
		pannelloDestro.add(testoBecco);
		
		JLabel testoNaso = new JLabel("Naso");
		testoNaso.setHorizontalAlignment(SwingConstants.CENTER);
		testoNaso.setForeground(new Color(0, 0, 0));
		testoNaso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNaso.setBackground(new Color(255, 255, 255));
		testoNaso.setBounds(290, 290, 170, 30);
		pannelloDestro.add(testoNaso);
		
		JComboBox selezioneStatoBecco = new JComboBox();
		selezioneStatoBecco.setToolTipText("Selezionare lo stato di salute del Becco");
		selezioneStatoBecco.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoBecco.setSelectedIndex(-1);
		selezioneStatoBecco.setMaximumRowCount(5);
		selezioneStatoBecco.setForeground(new Color(0, 0, 0));
		selezioneStatoBecco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoBecco.setBackground(new Color(255, 255, 255));
		selezioneStatoBecco.setBounds(40, 330, 170, 30);
		pannelloDestro.add(selezioneStatoBecco);
		
		JComboBox selezioneStatoNaso = new JComboBox();
		selezioneStatoNaso.setToolTipText("Selezionare lo stato di salute del Naso");
		selezioneStatoNaso.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoNaso.setSelectedIndex(-1);
		selezioneStatoNaso.setMaximumRowCount(5);
		selezioneStatoNaso.setForeground(new Color(0, 0, 0));
		selezioneStatoNaso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoNaso.setBackground(new Color(255, 255, 255));
		selezioneStatoNaso.setBounds(290, 330, 170, 30);
		pannelloDestro.add(selezioneStatoNaso);
		
		JLabel testoOcchi = new JLabel("Occhi");
		testoOcchi.setHorizontalAlignment(SwingConstants.CENTER);
		testoOcchi.setForeground(new Color(0, 0, 0));
		testoOcchi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoOcchi.setBackground(new Color(255, 255, 255));
		testoOcchi.setBounds(40, 370, 170, 30);
		pannelloDestro.add(testoOcchi);
		
		JComboBox selezioneStatoOcchi = new JComboBox();
		selezioneStatoOcchi.setToolTipText("Selezionare lo stato di salute degli Occhi");
		selezioneStatoOcchi.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Ferite superficiali", "Ferite profonde", "Compromesso"}));
		selezioneStatoOcchi.setSelectedIndex(-1);
		selezioneStatoOcchi.setMaximumRowCount(5);
		selezioneStatoOcchi.setForeground(new Color(0, 0, 0));
		selezioneStatoOcchi.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneStatoOcchi.setBackground(new Color(255, 255, 255));
		selezioneStatoOcchi.setBounds(40, 410, 170, 30);
		pannelloDestro.add(selezioneStatoOcchi);
		
		JButton bottoneAggiungi = new JButton("Aggiungi");
		bottoneAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CartellaClinicaController.getInstance().effettuaCaricamentoCartellaClinica(personale, compilazioneTarghetta.getText(), compilazioneSpecie.getText(), compilazioneDataDiRitrovamento.getText(), compilazioneLuogoDiRitrovamento.getText(), compilazioneLarghezza.getText(), compilazioneLunghezza.getText(), compilazionePeso.getText(), (selezioneStatoPinne.getSelectedItem()!= null) ? selezioneStatoPinne.getSelectedItem().toString() : "", (selezioneStatoCoda.getSelectedItem()!= null) ? selezioneStatoCoda.getSelectedItem().toString() : "", (selezioneStatoCollo.getSelectedItem()!= null) ? selezioneStatoCollo.getSelectedItem().toString() : "", (selezioneStatoTesta.getSelectedItem()!= null) ? selezioneStatoTesta.getSelectedItem().toString() : "", (selezioneStatoBecco.getSelectedItem()!= null) ? selezioneStatoBecco.getSelectedItem().toString() : "", (selezioneStatoNaso.getSelectedItem()!= null) ? selezioneStatoNaso.getSelectedItem().toString() : "", (selezioneStatoOcchi.getSelectedItem()!= null) ? selezioneStatoOcchi.getSelectedItem().toString() : "");
			}
		});
		bottoneAggiungi.setForeground(new Color(0, 0, 0));
		bottoneAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneAggiungi.setBackground(new Color(255, 255, 255));
		bottoneAggiungi.setBounds(180, 452, 140, 35);
		pannelloDestro.add(bottoneAggiungi);
	}
}