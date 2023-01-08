package Classi.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ErroreView extends JFrame {
	private JPanel pannello;
	
	//Creazione della finestra
	public ErroreView(String primoErrore, String secondoErrore) {
		//Pannello principale
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 500, 200);
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
		barraTitolo.setBounds(0, 0, 500, 50);
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
		iconaChiudi.setBounds(445, 0, 45, 50);
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
		iconaMinimizza.setBounds(390, 0, 45, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel titoloFinestra = new JLabel("Errore");
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
		pannelloCentrale.setBounds(0, 50, 500, 150);
		pannello.add(pannelloCentrale);
		pannelloCentrale.setLayout(null);
		
		JLabel testoInformativo1 = new JLabel(primoErrore);
		testoInformativo1.setVerticalAlignment(SwingConstants.BOTTOM);
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setBounds(0, 0, 500, 46);
		pannelloCentrale.add(testoInformativo1);
		
		JLabel testoInformativo2 = new JLabel(secondoErrore);
		testoInformativo2.setVerticalAlignment(SwingConstants.BOTTOM);
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(0, 50, 500, 35);
		pannelloCentrale.add(testoInformativo2);
		
		JButton bottoneOk = new JButton("Ok");
		bottoneOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessoView finestraAccesso = new AccessoView();
				dispose();
			}
		});
		bottoneOk.setForeground(new Color(0, 0, 0));
		bottoneOk.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneOk.setBackground(new Color(255, 255, 255));
		bottoneOk.setBounds(380, 104, 110, 35);
		pannelloCentrale.add(bottoneOk);
	}
}