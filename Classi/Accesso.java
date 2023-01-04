package Classi;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accesso extends JFrame {

	private JPanel Finestra;
	private JTextField Email;
	private JPasswordField Password;
	private JLabel Occhio_chiuso;
	private JLabel Occhio_aperto;

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
		
		JLabel Titolo = new JLabel("Accesso");
		Titolo.setVerticalAlignment(SwingConstants.TOP);
		Titolo.setBackground(new Color(0, 0, 0));
		Titolo.setForeground(new Color(255, 255, 255));
		Titolo.setHorizontalAlignment(SwingConstants.LEFT);
		Titolo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Titolo.setBounds(40, 11, 120, 28);
		Barra_del_titolo.add(Titolo);
		
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
		
		JLabel Testo_Email = new JLabel("Email");
		Testo_Email.setVerticalAlignment(SwingConstants.TOP);
		Testo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Email.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Email.setBounds(40, 205, 120, 30);
		Pannello_destro.add(Testo_Email);
		
		Email = new JTextField();
		Email.setBounds(40, 245, 365, 30);
		Pannello_destro.add(Email);
		Email.setColumns(10);
		
		JLabel Testo_Password = new JLabel("Password");
		Testo_Password.setVerticalAlignment(SwingConstants.TOP);
		Testo_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Password.setBounds(40, 285, 120, 30);
		Pannello_destro.add(Testo_Password);
		
		Password = new JPasswordField();
		Password.setBounds(40, 325, 365, 30);
		Pannello_destro.add(Password);
		
		JLabel Utente = new JLabel("");
		Utente.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Utente.png")));
		Utente.setHorizontalAlignment(SwingConstants.CENTER);
		Utente.setBounds(429, 245, 30, 30);
		Pannello_destro.add(Utente);
		
		JButton Accesso = new JButton("Accesso");
		Accesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement ps;
				ResultSet rs;
				String Email_stringa = Email.getText();
				String Password_stringa = String.valueOf(Password.getPassword());
				
				String Query = "SELECT * FROM personale WHERE email = ? AND parola_chiave = ?";
				
				try {
					ps = Connessione.getConnection().prepareStatement(Query);
					
					ps.setString(1, Email_stringa);
					ps.setString(2, Password_stringa);
					
					rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Si");
					} else {
						JOptionPane.showMessageDialog(null, "No");
					}
				} catch (SQLException ex) {
					Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		Accesso.setForeground(new Color(0, 0, 0));
		Accesso.setBackground(new Color(255, 255, 255));
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
		
		Occhio_chiuso = new JLabel("");
		Occhio_chiuso.setVisible(false);
		Occhio_chiuso.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Occhio_aperto.setVisible(true);
				Occhio_chiuso.setVisible(false);
				Password.setEchoChar('*');
			}
		});
		Occhio_chiuso.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Occhio chiuso.png")));
		Occhio_chiuso.setHorizontalAlignment(SwingConstants.CENTER);
		Occhio_chiuso.setBounds(429, 325, 30, 30);
		Pannello_destro.add(Occhio_chiuso);
		
		Occhio_aperto = new JLabel("");
		Occhio_aperto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Occhio_chiuso.setVisible(true);
				Occhio_aperto.setVisible(false);
				Password.setEchoChar((char)0);
			}
		});
		Occhio_aperto.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Occhio aperto.png")));
		Occhio_aperto.setHorizontalAlignment(SwingConstants.CENTER);
		Occhio_aperto.setBounds(429, 325, 30, 30);
		Pannello_destro.add(Occhio_aperto);
		Pannello_sinistro.setBounds(0, 0, 500, 500);
		Finestra.add(Pannello_sinistro);
	}
}