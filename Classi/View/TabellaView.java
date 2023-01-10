package Classi.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Classi.Database.PersonaleDatabase;
import Classi.Models.Personale;
import javax.swing.JButton;

public class TabellaView extends JFrame {
	
	private JPanel pannello;

	//Creazione della finestra
	public TabellaView(Personale personale) {
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
		
		JLabel titoloFinestra = new JLabel("Tabella");
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
		bottoneAggiungi.setBounds(800, 80, 100, 40);
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
		iconaEsci.setIcon(new ImageIcon(TabellaView.class.getResource("/Immagini/Esci.png")));
		iconaEsci.setToolTipText("Esci");
		iconaEsci.setHorizontalAlignment(SwingConstants.CENTER);
		iconaEsci.setForeground(new Color(255, 255, 255));
		iconaEsci.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaEsci.setBackground(new Color(255, 255, 255));
		iconaEsci.setBounds(940, 80, 30, 30);
		pannelloCentrale.add(iconaEsci);
	}
}