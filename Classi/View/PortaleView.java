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
import javax.swing.UIManager;

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
		titoloFinestra.setBounds(70, 0, 70, 50);
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
		iconaEsci.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setForeground(new Color(255, 255, 255));
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setBackground(new Color(255, 255, 255));
		iconaEsci.setBounds(940, 80, 30, 30);
		pannelloCentrale.add(iconaEsci);
		
		JLabel testoInformativo2 = new JLabel("Cosa vorresti fare oggi?");
		testoInformativo2.setHorizontalAlignment(SwingConstants.LEFT);
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(158, 140, 410, 30);
		pannelloCentrale.add(testoInformativo2);
		
		JLabel testoDati = new JLabel("Dati personali");
		testoDati.setHorizontalAlignment(SwingConstants.CENTER);
		testoDati.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoDati.setForeground(new Color(0, 0, 0));
		testoDati.setBackground(new Color(255, 255, 255));
		testoDati.setBounds(281, 207, 200, 40);
		pannelloCentrale.add(testoDati);
		
		JLabel testoTartaruga = new JLabel("Tartaruga");
		testoTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		testoTartaruga.setForeground(new Color(0, 0, 0));
		testoTartaruga.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoTartaruga.setBackground(new Color(255, 255, 255));
		testoTartaruga.setBounds(501, 207, 200, 40);
		pannelloCentrale.add(testoTartaruga);
		
		JLabel iconaDati = new JLabel("");
		iconaDati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DatiView finestraDati = new DatiView(PersonaleDatabase.getInstance().getPersonaleByEmail(personale.getEmail()));
					finestraDati.setLocationRelativeTo(null);
					finestraDati.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		iconaDati.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Dati.png")));
		iconaDati.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaDati.setForeground(new Color(255, 255, 255));
		iconaDati.setBackground(new Color(255, 255, 255));
		iconaDati.setHorizontalAlignment(SwingConstants.CENTER);
		iconaDati.setBounds(281, 247, 200, 200);
		pannelloCentrale.add(iconaDati);
		
		JLabel iconaTartaruga = new JLabel("");
		iconaTartaruga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					DatiView finestraDati = new DatiView(personale, "tartarughe", "");
					finestraDati.setLocationRelativeTo(null);
					finestraDati.setVisible(true);
					dispose();
			}
		});
		iconaTartaruga.setIcon(new ImageIcon(PortaleView.class.getResource("/Immagini/Tartaruga.png")));
		iconaTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		iconaTartaruga.setForeground(new Color(255, 255, 255));
		iconaTartaruga.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaTartaruga.setBackground(new Color(255, 255, 255));
		iconaTartaruga.setBounds(501, 247, 200, 200);
		pannelloCentrale.add(iconaTartaruga);
	}
}