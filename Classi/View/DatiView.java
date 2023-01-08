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
import javax.swing.border.EmptyBorder;
import Classi.Models.Personale;

import javax.swing.JButton;

public class DatiView extends JFrame {
	private JPanel pannello;
	
	//Creazione della finestra
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
		barraTitolo.setBounds(0, 0, 1000, 50);
		barraTitolo.setForeground(new Color(0, 0, 0));
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
		iconaMinimizza.setForeground(new Color(255, 255, 255));
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaMinimizza.setBackground(new Color(255, 255, 255));
		iconaMinimizza.setBounds(900, 0, 45, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel titoloFinestra = new JLabel("Dati");
		titoloFinestra.setVerticalAlignment(SwingConstants.TOP);
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(40, 11, 120, 28);
		barraTitolo.add(titoloFinestra);
		
		//Pannello sinistro
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannello.add(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JLabel iconaProfilo = new JLabel("");
		iconaProfilo.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Profilo utente (nero).png")));
		iconaProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaProfilo.setForeground(new Color(0, 0, 0));
		iconaProfilo.setBackground(new Color(255, 255, 255));
		iconaProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaProfilo.setBounds(200, 75, 100, 100);
		pannelloSinistro.add(iconaProfilo);
		
		JLabel iconaEsci = new JLabel("");
		iconaEsci.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setForeground(new Color(255, 255, 255));
		iconaEsci.setBackground(new Color(255, 255, 255));
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setBounds(445, 75, 30, 30);
		pannelloSinistro.add(iconaEsci);
		
		JLabel testoDati = new JLabel("Dati");
		testoDati.setHorizontalAlignment(SwingConstants.CENTER);
		testoDati.setForeground(new Color(0, 0, 0));
		testoDati.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoDati.setBackground(new Color(255, 255, 255));
		testoDati.setBounds(0, 190, 500, 70);
		pannelloSinistro.add(testoDati);
		
		JLabel testoMatricola = new JLabel("Matricola: " + personale.getMatricola());
		testoMatricola.setForeground(new Color(0, 0, 0));
		testoMatricola.setBackground(new Color(255, 255, 255));
		testoMatricola.setHorizontalAlignment(SwingConstants.LEFT);
		testoMatricola.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoMatricola.setBounds(40, 280, 300, 30);
		pannelloSinistro.add(testoMatricola);
		
		JLabel testoNome = new JLabel("Nome: " + personale.getNome());
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setBounds(40, 310, 300, 30);
		pannelloSinistro.add(testoNome);
		
		JLabel testoCognome = new JLabel("Cognome: " + personale.getCognome());
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setBounds(40, 340, 300, 30);
		pannelloSinistro.add(testoCognome);
		
		JLabel testoEmail = new JLabel("Email: " + personale.getEmail());
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setBounds(40, 370, 300, 30);
		pannelloSinistro.add(testoEmail);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita: " + personale.getDataDiNascita());
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setBounds(40, 400, 300, 30);
		pannelloSinistro.add(testoDataDiNascita);
		
		JLabel testoProfessione = new JLabel("Professione: " + personale.getTipologia());
		testoProfessione.setHorizontalAlignment(SwingConstants.LEFT);
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setBounds(40, 430, 300, 30);
		pannelloSinistro.add(testoProfessione);
		
		//Pannello destro
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannelloDestro.setForeground(new Color(255, 255, 255));
		pannelloDestro.setBackground(new Color(255, 255, 255));
		pannello.add(pannelloDestro);
		pannelloDestro.setLayout(null);
		
		JLabel immagineTartaruga = new JLabel("");
		immagineTartaruga.setIcon(new ImageIcon(DatiView.class.getResource("/Immagini/Tartaruga.png")));
		immagineTartaruga.setBounds(0, 0, 500, 500);
		immagineTartaruga.setForeground(new Color(255, 255, 255));
		immagineTartaruga.setBackground(new Color(255, 255, 255));
		immagineTartaruga.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		immagineTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		pannelloDestro.add(immagineTartaruga);
	}
}