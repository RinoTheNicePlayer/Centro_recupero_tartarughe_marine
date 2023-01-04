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

public class Errore extends JFrame {

	private JPanel Finestra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Errore Finestra_errore = new Errore();
					Finestra_errore.setLocationRelativeTo(null);
					Finestra_errore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Errore() {
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 500, 200);
		Finestra = new JPanel();
		Finestra.setForeground(new Color(255, 255, 255));
		Finestra.setBackground(new Color(255, 255, 255));
		Finestra.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Finestra);
		Finestra.setLayout(null);
		
		JPanel Barra_del_titolo = new JPanel();
		Barra_del_titolo.setForeground(new Color(0, 0, 0));
		Barra_del_titolo.setBackground(new Color(0, 0, 0));
		Barra_del_titolo.setBounds(0, 0, 500, 50);
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
		Chiudi.setBounds(445, 0, 45, 50);
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
		Riduci_a_icona.setForeground(new Color(255, 255, 255));
		Riduci_a_icona.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		Riduci_a_icona.setBackground(new Color(255, 255, 255));
		Riduci_a_icona.setBounds(390, 0, 45, 50);
		Barra_del_titolo.add(Riduci_a_icona);
		
		JLabel Titolo = new JLabel("Errore");
		Titolo.setVerticalAlignment(SwingConstants.TOP);
		Titolo.setBackground(new Color(0, 0, 0));
		Titolo.setForeground(new Color(255, 255, 255));
		Titolo.setHorizontalAlignment(SwingConstants.LEFT);
		Titolo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Titolo.setBounds(40, 11, 120, 28);
		Barra_del_titolo.add(Titolo);
		
		JPanel Pannello_centrale = new JPanel();
		Pannello_centrale.setForeground(new Color(255, 255, 255));
		Pannello_centrale.setBackground(new Color(255, 255, 255));
		Pannello_centrale.setBounds(0, 50, 500, 150);
		Finestra.add(Pannello_centrale);
		Pannello_centrale.setLayout(null);
		
		JLabel Titolo_1 = new JLabel("Impossibie trovare il tuo account!");
		Titolo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Titolo_1.setForeground(Color.BLACK);
		Titolo_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Titolo_1.setBackground(Color.WHITE);
		Titolo_1.setBounds(0, 0, 500, 46);
		Pannello_centrale.add(Titolo_1);
		
		JLabel Titolo_1_1 = new JLabel("Indirizzo email, o password, invalidi");
		Titolo_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Titolo_1_1.setForeground(Color.BLACK);
		Titolo_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Titolo_1_1.setBackground(Color.WHITE);
		Titolo_1_1.setBounds(0, 50, 500, 35);
		Pannello_centrale.add(Titolo_1_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso Finestra_accesso = new Accesso();
				Finestra_accesso.setLocationRelativeTo(null);
				Finestra_accesso.setVisible(true);
			}
		});
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(380, 104, 110, 35);
		Pannello_centrale.add(btnOk);
	}
}