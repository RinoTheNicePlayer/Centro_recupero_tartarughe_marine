package Classi;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrazione extends JFrame {

	private JPanel Finestra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione frame = new Registrazione();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registrazione() {
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		Finestra = new JPanel();
		Finestra.setBackground(new Color(255, 255, 255));
		Finestra.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Finestra);
		Finestra.setLayout(null);
		
		JPanel Barra_del_titolo = new JPanel();
		Barra_del_titolo.setBackground(new Color(0, 0, 0));
		Barra_del_titolo.setBounds(0, 0, 1000, 50);
		Finestra.add(Barra_del_titolo);
		Barra_del_titolo.setLayout(null);
		
		JLabel Chiudi = new JLabel("");
		Chiudi.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Chiudi.png")));
		Chiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Chiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi (rosso).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Chiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Chiudi.setHorizontalAlignment(SwingConstants.CENTER);
		Chiudi.setForeground(new Color(255, 255, 255));
		Chiudi.setBackground(new Color(255, 255, 255));
		Chiudi.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		Chiudi.setBounds(945, 0, 45, 50);
		Barra_del_titolo.add(Chiudi);
		
		JLabel Riduci_a_icona = new JLabel("");
		Riduci_a_icona.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Riduci a icona.png")));
		Riduci_a_icona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Riduci_a_icona.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona (blu).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Riduci_a_icona.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		Riduci_a_icona.setHorizontalAlignment(SwingConstants.CENTER);
		Riduci_a_icona.setForeground(Color.WHITE);
		Riduci_a_icona.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		Riduci_a_icona.setBackground(Color.WHITE);
		Riduci_a_icona.setBounds(900, 0, 45, 50);
		Barra_del_titolo.add(Riduci_a_icona);
		
		JLabel Titolo = new JLabel("Registrazione");
		Titolo.setVerticalAlignment(SwingConstants.TOP);
		Titolo.setBackground(new Color(0, 0, 0));
		Titolo.setForeground(new Color(255, 255, 255));
		Titolo.setHorizontalAlignment(SwingConstants.LEFT);
		Titolo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Titolo.setBounds(40, 11, 120, 28);
		Barra_del_titolo.add(Titolo);
	}
}