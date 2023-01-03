package Classi;

import java.awt.EventQueue;

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

public class Accesso extends JFrame {

	private JPanel Finestra;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accesso frame = new Accesso();
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
	public Accesso() {
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		Finestra = new JPanel();
		Finestra.setBackground(new Color(192, 192, 192));
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
		Chiudi.setHorizontalAlignment(SwingConstants.CENTER);
		Chiudi.setForeground(new Color(255, 255, 255));
		Chiudi.setBackground(new Color(255, 255, 255));
		Chiudi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Chiudi.setBounds(940, 10, 50, 30);
		Barra_del_titolo.add(Chiudi);
		
		JLabel Riduci_a_icona = new JLabel("");
		Riduci_a_icona.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Riduci a icona.png")));
		Riduci_a_icona.setHorizontalAlignment(SwingConstants.CENTER);
		Riduci_a_icona.setForeground(Color.WHITE);
		Riduci_a_icona.setFont(new Font("Segoe UI", Font.BOLD, 20));
		Riduci_a_icona.setBackground(Color.WHITE);
		Riduci_a_icona.setBounds(880, 10, 50, 30);
		Barra_del_titolo.add(Riduci_a_icona);
		
		JPanel Pannello_destro = new JPanel();
		Pannello_destro.setBackground(new Color(255, 255, 255));
		Pannello_destro.setBounds(500, 0, 500, 500);
		Finestra.add(Pannello_destro);
		
		JLabel Pannello_sinistro = new JLabel("");
		Pannello_sinistro.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Centro recupero tartarughe marine.png")));
		Pannello_destro.setLayout(null);
		
		JLabel Testo_1 = new JLabel("Accesso");
		Testo_1.setForeground(new Color(0, 0, 0));
		Testo_1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		Testo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_1.setBounds(0, 49, 500, 76);
		Pannello_destro.add(Testo_1);
		
		JLabel Testo_2 = new JLabel("Benvenuto!");
		Testo_2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_2.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_2.setBounds(0, 120, 500, 30);
		Pannello_destro.add(Testo_2);
		
		JLabel Testo_3 = new JLabel("Compila i campi sottostanti per entrare nel portale");
		Testo_3.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_3.setBounds(0, 145, 500, 30);
		Pannello_destro.add(Testo_3);
		
		JLabel Email = new JLabel("Email");
		Email.setVerticalAlignment(SwingConstants.TOP);
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Email.setHorizontalAlignment(SwingConstants.LEFT);
		Email.setBounds(40, 205, 120, 30);
		Pannello_destro.add(Email);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(40, 245, 365, 30);
		Pannello_destro.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel Password = new JLabel("Password");
		Password.setVerticalAlignment(SwingConstants.TOP);
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Password.setBounds(40, 285, 120, 30);
		Pannello_destro.add(Password);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(40, 325, 365, 30);
		Pannello_destro.add(textFieldPassword);
		
		JLabel Utente = new JLabel("");
		Utente.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Utente.png")));
		Utente.setHorizontalAlignment(SwingConstants.CENTER);
		Utente.setBounds(429, 245, 30, 30);
		Pannello_destro.add(Utente);
		
		JLabel Occhio = new JLabel("");
		Occhio.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Occhio chiuso.png")));
		Occhio.setHorizontalAlignment(SwingConstants.CENTER);
		Occhio.setBounds(429, 325, 30, 30);
		Pannello_destro.add(Occhio);
		
		JButton Accesso = new JButton("Accesso");
		Accesso.setForeground(new Color(0, 0, 0));
		Accesso.setBackground(new Color(0, 0, 0));
		Accesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Accesso.setBounds(40, 390, 419, 50);
		Pannello_destro.add(Accesso);
		
		JLabel Testo_4 = new JLabel("Non ti sei ancora registrato?");
		Testo_4.setVerticalAlignment(SwingConstants.TOP);
		Testo_4.setHorizontalAlignment(SwingConstants.RIGHT);
		Testo_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Testo_4.setBounds(70, 450, 205, 21);
		Pannello_destro.add(Testo_4);
		
		JLabel Registrazione = new JLabel("Registrazione");
		Registrazione.setVerticalAlignment(SwingConstants.TOP);
		Registrazione.setHorizontalAlignment(SwingConstants.LEFT);
		Registrazione.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Registrazione.setBounds(285, 450, 100, 21);
		Pannello_destro.add(Registrazione);
		Pannello_sinistro.setBounds(0, 0, 500, 500);
		Finestra.add(Pannello_sinistro);
	}
}