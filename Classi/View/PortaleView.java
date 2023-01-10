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
import Classi.Models.Personale;

public class PortaleView extends JFrame {

	private JPanel pannello;
	
	//Creazione della finestra
	public PortaleView(Personale personale) {
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
		
		JLabel titoloFinestra = new JLabel("Portale");
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
		pannelloCentrale.setBounds(0, 0, 1000, 500);
		pannello.add(pannelloCentrale);
		pannelloCentrale.setLayout(null);
		
		JLabel iconaProfilo = new JLabel("");
		iconaProfilo.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Profilo utente.png")));
		iconaProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		iconaProfilo.setForeground(new Color(0, 0, 0));
		iconaProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaProfilo.setBackground(new Color(255, 255, 255));
		iconaProfilo.setBounds(40, 80, 100, 100);
		pannelloCentrale.add(iconaProfilo);
		
		JLabel testoSaluto = new JLabel("Ciao, " + personale.getNome() + "!");
		testoSaluto.setHorizontalAlignment(SwingConstants.LEFT);
		testoSaluto.setForeground(new Color(0, 0, 0));
		testoSaluto.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoSaluto.setBackground(new Color(255, 255, 255));
		testoSaluto.setBounds(160, 80, 350, 50);
		pannelloCentrale.add(testoSaluto);
		
		JLabel iconaEsci = new JLabel("");
		iconaEsci.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setForeground(Color.WHITE);
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setBackground(Color.WHITE);
		iconaEsci.setBounds(940, 80, 30, 30);
		pannelloCentrale.add(iconaEsci);
		
		JLabel testoDati = new JLabel("Dati personali");
		testoDati.setHorizontalAlignment(SwingConstants.CENTER);
		testoDati.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoDati.setForeground(new Color(0, 0, 0));
		testoDati.setBackground(new Color(255, 255, 255));
		testoDati.setBounds(40, 230, 200, 40);
		pannelloCentrale.add(testoDati);
		
		JLabel testoCartellaClinica = new JLabel("Cartella clinica");
		testoCartellaClinica.setHorizontalAlignment(SwingConstants.CENTER);
		testoCartellaClinica.setForeground(new Color(0, 0, 0));
		testoCartellaClinica.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoCartellaClinica.setBackground(new Color(255, 255, 255));
		testoCartellaClinica.setBounds(280, 230, 200, 40);
		pannelloCentrale.add(testoCartellaClinica);
		
		JLabel testoTartarughe = new JLabel("Tartarughe");
		testoTartarughe.setHorizontalAlignment(SwingConstants.CENTER);
		testoTartarughe.setForeground(new Color(0, 0, 0));
		testoTartarughe.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoTartarughe.setBackground(new Color(255, 255, 255));
		testoTartarughe.setBounds(520, 230, 200, 40);
		pannelloCentrale.add(testoTartarughe);
		
		JLabel testoVasche = new JLabel("Vasche");
		testoVasche.setHorizontalAlignment(SwingConstants.CENTER);
		testoVasche.setForeground(new Color(0, 0, 0));
		testoVasche.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoVasche.setBackground(new Color(255, 255, 255));
		testoVasche.setBounds(760, 230, 200, 40);
		pannelloCentrale.add(testoVasche);
		
		JLabel iconaDati = new JLabel("");
		iconaDati.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Dati.png")));
		iconaDati.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaDati.setForeground(new Color(255, 255, 255));
		iconaDati.setBackground(new Color(255, 255, 255));
		iconaDati.setHorizontalAlignment(SwingConstants.CENTER);
		iconaDati.setBounds(40, 270, 200, 200);
		pannelloCentrale.add(iconaDati);
		
		JLabel iconaCartellaClinica = new JLabel("");
		iconaCartellaClinica.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Cartella clinica.png")));
		iconaCartellaClinica.setHorizontalAlignment(SwingConstants.CENTER);
		iconaCartellaClinica.setForeground(new Color(255, 255, 255));
		iconaCartellaClinica.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaCartellaClinica.setBackground(new Color(255, 255, 255));
		iconaCartellaClinica.setBounds(280, 270, 200, 200);
		pannelloCentrale.add(iconaCartellaClinica);
		
		JLabel iconaTartaruga = new JLabel("");
		iconaTartaruga.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Tartaruga.png")));
		iconaTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		iconaTartaruga.setForeground(new Color(255, 255, 255));
		iconaTartaruga.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaTartaruga.setBackground(new Color(255, 255, 255));
		iconaTartaruga.setBounds(520, 270, 200, 200);
		pannelloCentrale.add(iconaTartaruga);
		
		JLabel iconaTartarugaNellaVasca = new JLabel("");
		iconaTartarugaNellaVasca.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Tartaruga nella vasca.png")));
		iconaTartarugaNellaVasca.setHorizontalAlignment(SwingConstants.CENTER);
		iconaTartarugaNellaVasca.setForeground(new Color(255, 255, 255));
		iconaTartarugaNellaVasca.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaTartarugaNellaVasca.setBackground(new Color(255, 255, 255));
		iconaTartarugaNellaVasca.setBounds(760, 270, 200, 200);
		pannelloCentrale.add(iconaTartarugaNellaVasca);
	}
}