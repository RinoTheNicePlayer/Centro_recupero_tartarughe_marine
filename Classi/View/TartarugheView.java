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
import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TartarugheView extends JFrame {
	
	private JPanel pannello;
	private JTextField compilazioneTarghetta;
	private JTextField compilazioneNome;
	private JTextField compilazioneEta;
	private JTextField compilazioneIdentificativoInterno;
	private JTextField compilazioneDataDiRitrovamento;
	private JTextField compilazioneLuogoDiRitrovamento;
	private JTextField compilazioneSpecie;

	//Creazione della finestra
	public TartarugheView(Personale personale) {
		//Pannello principale
		setUndecorated(true);
		setBounds(100, 100, 1000, 660);
		pannello = new JPanel();
		pannello.setForeground(new Color(255, 255, 255));
		pannello.setBackground(new Color(255, 255, 255));
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
		
		JLabel titoloFinestra = new JLabel("Tartarughe");
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(70, 0, 100, 50);
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
		
		JButton bottoneAggiungi = new JButton("Aggiungi");
		bottoneAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CartellaClinicaView finestraCartellaClinica = new CartellaClinicaView(PersonaleDatabase.getInstance().getPersonaleByEmail(personale.getEmail()));
					finestraCartellaClinica.setLocationRelativeTo(null);
					finestraCartellaClinica.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		bottoneAggiungi.setForeground(new Color(0, 204, 0));
		bottoneAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneAggiungi.setBackground(new Color(255, 255, 255));
		bottoneAggiungi.setBounds(870, 360, 100, 40);
		pannelloCentrale.add(bottoneAggiungi);
		
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
		iconaEsci.setIcon(new ImageIcon(TartarugheView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setToolTipText("Esci");
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setForeground(new Color(255, 255, 255));
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setBackground(new Color(255, 255, 255));
		iconaEsci.setBounds(940, 80, 30, 30);
		pannelloCentrale.add(iconaEsci);
		
		JLabel testoTarghetta = new JLabel("Targhetta");
		testoTarghetta.setHorizontalAlignment(SwingConstants.LEFT);
		testoTarghetta.setForeground(new Color(0, 0, 0));
		testoTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoTarghetta.setBackground(new Color(255, 255, 255));
		testoTarghetta.setBounds(40, 240, 90, 30);
		pannelloCentrale.add(testoTarghetta);
		
		JLabel testoNome = new JLabel("Nome");
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setBounds(40, 280, 60, 30);
		pannelloCentrale.add(testoNome);
		
		JLabel testoSesso = new JLabel("Sesso");
		testoSesso.setHorizontalAlignment(SwingConstants.LEFT);
		testoSesso.setForeground(new Color(0, 0, 0));
		testoSesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSesso.setBackground(new Color(255, 255, 255));
		testoSesso.setBounds(40, 320, 50, 30);
		pannelloCentrale.add(testoSesso);
		
		JLabel testoEta = new JLabel("Età");
		testoEta.setHorizontalAlignment(SwingConstants.LEFT);
		testoEta.setForeground(new Color(0, 0, 0));
		testoEta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEta.setBackground(new Color(255, 255, 255));
		testoEta.setBounds(40, 360, 30, 30);
		pannelloCentrale.add(testoEta);
		
		JLabel testoIdentificativoInterno = new JLabel("Identificativo interno");
		testoIdentificativoInterno.setHorizontalAlignment(SwingConstants.LEFT);
		testoIdentificativoInterno.setForeground(new Color(0, 0, 0));
		testoIdentificativoInterno.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoIdentificativoInterno.setBackground(new Color(255, 255, 255));
		testoIdentificativoInterno.setBounds(40, 480, 190, 30);
		pannelloCentrale.add(testoIdentificativoInterno);
		
		JLabel testoDataDiRitrovamento = new JLabel("Data di ritrovamento");
		testoDataDiRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiRitrovamento.setForeground(new Color(0, 0, 0));
		testoDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiRitrovamento.setBackground(new Color(255, 255, 255));
		testoDataDiRitrovamento.setBounds(40, 520, 190, 30);
		pannelloCentrale.add(testoDataDiRitrovamento);
		
		JLabel testoLuogoDiRitrovamento = new JLabel("Luogo di ritrovamento");
		testoLuogoDiRitrovamento.setHorizontalAlignment(SwingConstants.LEFT);
		testoLuogoDiRitrovamento.setForeground(new Color(0, 0, 0));
		testoLuogoDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoLuogoDiRitrovamento.setBackground(new Color(255, 255, 255));
		testoLuogoDiRitrovamento.setBounds(40, 560, 200, 30);
		pannelloCentrale.add(testoLuogoDiRitrovamento);
		
		JLabel testoSpecie = new JLabel("Specie");
		testoSpecie.setHorizontalAlignment(SwingConstants.LEFT);
		testoSpecie.setForeground(new Color(0, 0, 0));
		testoSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSpecie.setBackground(new Color(255, 255, 255));
		testoSpecie.setBounds(40, 600, 60, 30);
		pannelloCentrale.add(testoSpecie);
		
		JLabel testoTartaruga = new JLabel("Tartaruga");
		testoTartaruga.setHorizontalAlignment(SwingConstants.LEFT);
		testoTartaruga.setForeground(new Color(0, 0, 0));
		testoTartaruga.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoTartaruga.setBackground(new Color(255, 255, 255));
		testoTartaruga.setBounds(40, 180, 120, 40);
		pannelloCentrale.add(testoTartaruga);
		
		JLabel testoCartellaClinica = new JLabel("Cartella clinica");
		testoCartellaClinica.setHorizontalAlignment(SwingConstants.LEFT);
		testoCartellaClinica.setForeground(new Color(0, 0, 0));
		testoCartellaClinica.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoCartellaClinica.setBackground(new Color(255, 255, 255));
		testoCartellaClinica.setBounds(40, 420, 170, 40);
		pannelloCentrale.add(testoCartellaClinica);
		
		compilazioneTarghetta = new JTextField();
		compilazioneTarghetta.setToolTipText("");
		compilazioneTarghetta.setForeground(new Color(0, 0, 0));
		compilazioneTarghetta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneTarghetta.setColumns(10);
		compilazioneTarghetta.setBackground(new Color(255, 255, 255));
		compilazioneTarghetta.setBounds(140, 240, 170, 30);
		pannelloCentrale.add(compilazioneTarghetta);
		
		compilazioneNome = new JTextField();
		compilazioneNome.setToolTipText("");
		compilazioneNome.setForeground(new Color(0, 0, 0));
		compilazioneNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneNome.setColumns(10);
		compilazioneNome.setBackground(new Color(255, 255, 255));
		compilazioneNome.setBounds(140, 280, 170, 30);
		pannelloCentrale.add(compilazioneNome);
		
		JComboBox selezioneSesso = new JComboBox();
		selezioneSesso.setToolTipText("");
		selezioneSesso.setSelectedIndex(-1);
		selezioneSesso.setMaximumRowCount(2);
		selezioneSesso.setForeground(new Color(0, 0, 0));
		selezioneSesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneSesso.setBackground(new Color(255, 255, 255));
		selezioneSesso.setBounds(140, 320, 170, 30);
		pannelloCentrale.add(selezioneSesso);
		
		compilazioneEta = new JTextField();
		compilazioneEta.setToolTipText("");
		compilazioneEta.setForeground(new Color(0, 0, 0));
		compilazioneEta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneEta.setColumns(10);
		compilazioneEta.setBackground(new Color(255, 255, 255));
		compilazioneEta.setBounds(140, 360, 60, 30);
		pannelloCentrale.add(compilazioneEta);
		
		compilazioneIdentificativoInterno = new JTextField();
		compilazioneIdentificativoInterno.setToolTipText("");
		compilazioneIdentificativoInterno.setForeground(new Color(0, 0, 0));
		compilazioneIdentificativoInterno.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneIdentificativoInterno.setColumns(10);
		compilazioneIdentificativoInterno.setBackground(new Color(255, 255, 255));
		compilazioneIdentificativoInterno.setBounds(260, 480, 170, 30);
		pannelloCentrale.add(compilazioneIdentificativoInterno);
		
		compilazioneDataDiRitrovamento = new JTextField();
		compilazioneDataDiRitrovamento.setToolTipText("");
		compilazioneDataDiRitrovamento.setForeground(new Color(0, 0, 0));
		compilazioneDataDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneDataDiRitrovamento.setColumns(10);
		compilazioneDataDiRitrovamento.setBackground(new Color(255, 255, 255));
		compilazioneDataDiRitrovamento.setBounds(260, 520, 170, 30);
		pannelloCentrale.add(compilazioneDataDiRitrovamento);
		
		compilazioneLuogoDiRitrovamento = new JTextField();
		compilazioneLuogoDiRitrovamento.setToolTipText("");
		compilazioneLuogoDiRitrovamento.setForeground(new Color(0, 0, 0));
		compilazioneLuogoDiRitrovamento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneLuogoDiRitrovamento.setColumns(10);
		compilazioneLuogoDiRitrovamento.setBackground(new Color(255, 255, 255));
		compilazioneLuogoDiRitrovamento.setBounds(260, 560, 170, 30);
		pannelloCentrale.add(compilazioneLuogoDiRitrovamento);
		
		compilazioneSpecie = new JTextField();
		compilazioneSpecie.setToolTipText("");
		compilazioneSpecie.setForeground(new Color(0, 0, 0));
		compilazioneSpecie.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneSpecie.setColumns(10);
		compilazioneSpecie.setBackground(new Color(255, 255, 255));
		compilazioneSpecie.setBounds(260, 600, 170, 30);
		pannelloCentrale.add(compilazioneSpecie);
		
		JLabel testoInformativo1 = new JLabel("Ricerca");
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setBounds(400, 50, 200, 75);
		pannelloCentrale.add(testoInformativo1);
		
		JLabel testoInformativo2 = new JLabel("Mediante le tabelle puoi visualizzare le tartarughe accolte al Centro e le cartelle cliniche associate ad esse.");
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(160, 120, 680, 30);
		pannelloCentrale.add(testoInformativo2);
		
		JLabel testoInformativo3 = new JLabel("I campi che richiedono del testo ti aiutano ad effettuare una ricerca più rapida");
		testoInformativo3.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo3.setForeground(new Color(0, 0, 0));
		testoInformativo3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo3.setBackground(new Color(255, 255, 255));
		testoInformativo3.setBounds(160, 140, 680, 30);
		pannelloCentrale.add(testoInformativo3);
		
		JLabel iconaRicerca1 = new JLabel("");
		iconaRicerca1.setIcon(new ImageIcon(TartarugheView.class.getResource("/Immagini/Ricerca.png")));
		iconaRicerca1.setToolTipText("Cerca");
		iconaRicerca1.setHorizontalAlignment(SwingConstants.CENTER);
		iconaRicerca1.setForeground(new Color(255, 255, 255));
		iconaRicerca1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaRicerca1.setBackground(new Color(255, 255, 255));
		iconaRicerca1.setBounds(170, 185, 30, 30);
		pannelloCentrale.add(iconaRicerca1);
		
		JLabel iconaRicerca2 = new JLabel("");
		iconaRicerca2.setIcon(new ImageIcon(TartarugheView.class.getResource("/Immagini/Ricerca.png")));
		iconaRicerca2.setToolTipText("Cerca");
		iconaRicerca2.setHorizontalAlignment(SwingConstants.CENTER);
		iconaRicerca2.setForeground(new Color(255, 255, 255));
		iconaRicerca2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaRicerca2.setBackground(new Color(255, 255, 255));
		iconaRicerca2.setBounds(230, 425, 30, 30);
		pannelloCentrale.add(iconaRicerca2);
	}
}