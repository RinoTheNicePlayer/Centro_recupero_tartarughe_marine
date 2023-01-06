package Classi;

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
import javax.swing.border.EmptyBorder;

import Classi.View.AccessoView;

import javax.swing.JList;
import javax.swing.JButton;

public class Portale extends JFrame {
	private JPanel pannello;
	
	//Lancio dell'applicazione
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portale finestraPortale = new Portale();
					finestraPortale.setLocationRelativeTo(null);
					finestraPortale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Creazione della finestra
	public Portale() {
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
		iconaChiudi.setFont(new Font("Segoe UI", Font.PLAIN, 5));
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
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		iconaMinimizza.setBackground(new Color(255, 255, 255));
		iconaMinimizza.setBounds(900, 0, 45, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel titoloFinestra = new JLabel("Pannello");
		titoloFinestra.setVerticalAlignment(SwingConstants.TOP);
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(40, 11, 120, 28);
		barraTitolo.add(titoloFinestra);
		
		//Pannello centrale
		JPanel pannelloCentrale = new JPanel();
		pannelloCentrale.setForeground(new Color(255, 255, 255));
		pannelloCentrale.setBackground(new Color(255, 255, 255));
		pannelloCentrale.setBounds(0, 50, 1000, 450);
		pannello.add(pannelloCentrale);
		pannelloCentrale.setLayout(null);
		
		JLabel iconaProfilo = new JLabel("");
		iconaProfilo.setIcon(new ImageIcon(Portale.class.getResource("/Immagini/Profilo utente.png")));
		iconaProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaProfilo.setForeground(new Color(0, 0, 0));
		iconaProfilo.setBackground(new Color(255, 255, 255));
		iconaProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaProfilo.setBounds(25, 25, 100, 90);
		pannelloCentrale.add(iconaProfilo);
		
		JLabel testoInformativo1 = new JLabel("Ciao");
		testoInformativo1.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setBounds(150, 25, 80, 40);
		pannelloCentrale.add(testoInformativo1);
		
		JLabel testoInformativo2 = new JLabel("Questo è il tuo profilo personale.");
		testoInformativo2.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(150, 70, 210, 25);
		pannelloCentrale.add(testoInformativo2);
		
		JLabel testoInformativo3 = new JLabel("Qui puoi consultare le tue credenziali e aggiungere una nuova cartella clinica,");
		testoInformativo3.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo3.setForeground(new Color(0, 0, 0));
		testoInformativo3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo3.setBackground(new Color(255, 255, 255));
		testoInformativo3.setBounds(150, 90, 500, 25);
		pannelloCentrale.add(testoInformativo3);
		
		JLabel testoInformativo4 = new JLabel("qualora è stata accolta al centro una nuova tartarughina.");
		testoInformativo4.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo4.setForeground(new Color(0, 0, 0));
		testoInformativo4.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo4.setBackground(new Color(255, 255, 255));
		testoInformativo4.setBounds(150, 110, 370, 25);
		pannelloCentrale.add(testoInformativo4);
		
		JLabel testoInformativo5 = new JLabel("Solo il medico veterinario specializzato può inserire questa nuova cartella al Database!");
		testoInformativo5.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo5.setForeground(new Color(0, 0, 0));
		testoInformativo5.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo5.setBackground(new Color(255, 255, 255));
		testoInformativo5.setBounds(150, 130, 560, 25);
		pannelloCentrale.add(testoInformativo5);
		
		JButton bottoneEsci = new JButton("Esci");
		bottoneEsci.setForeground(new Color(0, 0, 0));
		bottoneEsci.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneEsci.setBackground(new Color(255, 255, 255));
		bottoneEsci.setBounds(820, 380, 150, 50);
		pannelloCentrale.add(bottoneEsci);
		
		JLabel testoDati = new JLabel("Dati");
		testoDati.setHorizontalAlignment(SwingConstants.LEFT);
		testoDati.setForeground(new Color(0, 0, 0));
		testoDati.setFont(new Font("Segoe UI", Font.BOLD, 20));
		testoDati.setBackground(new Color(255, 255, 255));
		testoDati.setBounds(25, 180, 80, 30);
		pannelloCentrale.add(testoDati);
		
		JLabel testoMatricola = new JLabel("Matricola");
		testoMatricola.setForeground(new Color(0, 0, 0));
		testoMatricola.setBackground(new Color(255, 255, 255));
		testoMatricola.setHorizontalAlignment(SwingConstants.LEFT);
		testoMatricola.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoMatricola.setBounds(25, 220, 70, 25);
		pannelloCentrale.add(testoMatricola);
		
		JLabel testoNome = new JLabel("Nome");
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setBounds(25, 250, 70, 25);
		pannelloCentrale.add(testoNome);
		
		JLabel testoCognome = new JLabel("Cognome");
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setBounds(25, 280, 70, 25);
		pannelloCentrale.add(testoCognome);
		
		JLabel testoEmail = new JLabel("Email");
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setBounds(25, 310, 70, 25);
		pannelloCentrale.add(testoEmail);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita");
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setBounds(25, 340, 120, 25);
		pannelloCentrale.add(testoDataDiNascita);
		
		JLabel testoProfessione = new JLabel("Professione");
		testoProfessione.setHorizontalAlignment(SwingConstants.LEFT);
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setBounds(25, 370, 100, 25);
		pannelloCentrale.add(testoProfessione);
	}
}