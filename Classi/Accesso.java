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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accesso extends JFrame {
	private JPanel Pannello;
	private JTextField Email;
	private JPasswordField Password;
	private JLabel Occhio_chiuso;
	private JLabel Occhio_aperto;
	
	//Lancio dell'applicazione
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accesso Finestra_accesso = new Accesso();
					Finestra_accesso.setLocationRelativeTo(null);
					Finestra_accesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Creazione della finestra
	public Accesso() {
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		Pannello = new JPanel();
		Pannello.setForeground(new Color(255, 255, 255));
		Pannello.setBackground(new Color(255, 255, 255));
		Pannello.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Pannello);
		Pannello.setLayout(null);
		
		JPanel Barra_del_titolo = new JPanel();
		Barra_del_titolo.setForeground(new Color(0, 0, 0));
		Barra_del_titolo.setBackground(new Color(0, 0, 0));
		Barra_del_titolo.setBounds(0, 0, 1000, 50);
		Pannello.add(Barra_del_titolo);
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
		Riduci_a_icona.setForeground(new Color(255, 255, 255));
		Riduci_a_icona.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		Riduci_a_icona.setBackground(new Color(255, 255, 255));
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
		
		//Pannello destro
		JPanel Pannello_destro = new JPanel();
		Pannello_destro.setForeground(new Color(255, 255, 255));
		Pannello_destro.setBackground(new Color(255, 255, 255));
		Pannello_destro.setBounds(500, 0, 500, 500);
		Pannello.add(Pannello_destro);
		
		JLabel Testo_1 = new JLabel("Accesso");
		Testo_1.setBackground(new Color(255, 255, 255));
		Testo_1.setForeground(new Color(0, 0, 0));
		Testo_1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		Testo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_1.setBounds(0, 49, 500, 76);
		Pannello_destro.add(Testo_1);
		
		JLabel Testo_2 = new JLabel("Benvenuto!");
		Testo_2.setVerticalAlignment(SwingConstants.TOP);
		Testo_2.setForeground(new Color(0, 0, 0));
		Testo_2.setBackground(new Color(255, 255, 255));
		Testo_2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_2.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_2.setBounds(0, 120, 500, 30);
		Pannello_destro.add(Testo_2);
		
		JLabel Testo_3 = new JLabel("Compila i campi sottostanti per entrare nel portale");
		Testo_3.setVerticalAlignment(SwingConstants.TOP);
		Testo_3.setForeground(new Color(0, 0, 0));
		Testo_3.setBackground(new Color(255, 255, 255));
		Testo_3.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_3.setBounds(0, 145, 500, 30);
		Pannello_destro.add(Testo_3);
		
		JLabel Testo_Email = new JLabel("Email");
		Testo_Email.setBackground(new Color(255, 255, 255));
		Testo_Email.setForeground(new Color(0, 0, 0));
		Testo_Email.setVerticalAlignment(SwingConstants.TOP);
		Testo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Email.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Email.setBounds(40, 205, 120, 30);
		Pannello_destro.add(Testo_Email);
		
		JLabel emailValida = new JLabel("Email valida");
		emailValida.setVerticalAlignment(SwingConstants.TOP);
		emailValida.setHorizontalAlignment(SwingConstants.RIGHT);
		emailValida.setForeground(new Color(0, 255, 0));
		emailValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		emailValida.setBackground(new Color(255, 255, 255));
		emailValida.setBounds(215, 275, 190, 30);
		emailValida.setVisible(false);
		Pannello_destro.add(emailValida);
		
		JLabel emailNonValida = new JLabel("Email non valida");
		emailNonValida.setVerticalAlignment(SwingConstants.TOP);
		emailNonValida.setHorizontalAlignment(SwingConstants.RIGHT);
		emailNonValida.setForeground(new Color(255, 0, 0));
		emailNonValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		emailNonValida.setBackground(new Color(255, 255, 255));
		emailNonValida.setBounds(215, 275, 190, 30);
		emailNonValida.setVisible(false);
		Pannello_destro.add(emailNonValida);
		
		Email = new JTextField();
		Email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				boolean stato = Controllo.verificaEmail(Email.getText());
				
				if((stato == true) && (stato != emailValida.equals(""))) {
					emailValida.setVisible(true);
					emailNonValida.setVisible(false);
				} else {
					emailNonValida.setVisible(true);
					emailValida.setVisible(false);
				}
			}
		});
		Email.setHorizontalAlignment(SwingConstants.LEFT);
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Email.setForeground(new Color(0, 0, 0));
		Email.setBackground(new Color(255, 255, 255));
		Email.setBounds(40, 245, 365, 30);
		Pannello_destro.add(Email);
		Email.setColumns(10);
		
		JLabel Utente = new JLabel("");
		Utente.setForeground(new Color(0, 0, 0));
		Utente.setBackground(new Color(255, 255, 255));
		Utente.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Utente.png")));
		Utente.setHorizontalAlignment(SwingConstants.CENTER);
		Utente.setBounds(429, 245, 30, 30);
		Pannello_destro.add(Utente);
		
		JLabel Testo_Password = new JLabel("Password");
		Testo_Password.setForeground(new Color(0, 0, 0));
		Testo_Password.setBackground(new Color(255, 255, 255));
		Testo_Password.setVerticalAlignment(SwingConstants.TOP);
		Testo_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Password.setBounds(40, 285, 120, 30);
		Pannello_destro.add(Testo_Password);
		
		JLabel passwordValida = new JLabel("Password valida");
		passwordValida.setVerticalAlignment(SwingConstants.TOP);
		passwordValida.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordValida.setForeground(new Color(0, 255, 0));
		passwordValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passwordValida.setBackground(new Color(255, 255, 255));
		passwordValida.setBounds(215, 355, 190, 30);
		passwordValida.setVisible(false);
		Pannello_destro.add(passwordValida);
		
		JLabel passwordNonValida = new JLabel("Minimo 8 caratteri e massimo 16");
		passwordNonValida.setVerticalAlignment(SwingConstants.TOP);
		passwordNonValida.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordNonValida.setForeground(new Color(255, 0, 0));
		passwordNonValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passwordNonValida.setBackground(new Color(255, 255, 255));
		passwordNonValida.setBounds(175, 355, 230, 30);
		passwordNonValida.setVisible(false);
		Pannello_destro.add(passwordNonValida);
		
		Password = new JPasswordField();
		Password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				boolean stato = Controllo.verificaPassword(Password.getText());
				
				if((stato == true) && (stato == passwordNonValida.equals(""))) {
					passwordValida.setVisible(true);
					passwordNonValida.setVisible(false);
				} else {
					passwordNonValida.setVisible(true);
					passwordValida.setVisible(false);
				}
			}
		});
		Password.setHorizontalAlignment(SwingConstants.LEFT);
		Password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Password.setForeground(new Color(0, 0, 0));
		Password.setBackground(new Color(255, 255, 255));
		Password.setEchoChar('*');
		Password.setBounds(40, 325, 365, 30);
		Pannello_destro.add(Password);
		
		Occhio_chiuso = new JLabel("");
		Occhio_chiuso.setForeground(new Color(0, 0, 0));
		Occhio_chiuso.setBackground(new Color(255, 255, 255));
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
		Occhio_aperto.setForeground(new Color(0, 0, 0));
		Occhio_aperto.setBackground(new Color(255, 255, 255));
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
						Errore Finestra_errore = new Errore("Impossibile effettuare l'accesso!", "Indirizzo email/password invalidi.");
						Finestra_errore.setLocationRelativeTo(null);
						Finestra_errore.setVisible(true);
						
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
		Testo_4.setForeground(new Color(0, 0, 0));
		Testo_4.setBackground(new Color(255, 255, 255));
		Testo_4.setVerticalAlignment(SwingConstants.TOP);
		Testo_4.setHorizontalAlignment(SwingConstants.RIGHT);
		Testo_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Testo_4.setBounds(70, 450, 205, 21);
		Pannello_destro.add(Testo_4);
		
		JLabel Registrazione = new JLabel("Registrazione");
		Registrazione.setForeground(new Color(0, 0, 0));
		Registrazione.setBackground(new Color(255, 255, 255));
		Registrazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrazione Finestra_registrazione = new Registrazione();
				Finestra_registrazione.setLocationRelativeTo(null);
				Finestra_registrazione.setVisible(true);
				dispose();
			}
		});
		Registrazione.setVerticalAlignment(SwingConstants.TOP);
		Registrazione.setHorizontalAlignment(SwingConstants.LEFT);
		Registrazione.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Registrazione.setBounds(285, 450, 100, 21);
		Pannello_destro.add(Registrazione);
		
		//Pannello sinistro
		JLabel Pannello_sinistro = new JLabel("");
		Pannello_sinistro.setForeground(new Color(255, 255, 255));
		Pannello_sinistro.setBackground(new Color(255, 255, 255));
		Pannello_sinistro.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Centro recupero tartarughe marine.png")));
		Pannello_destro.setLayout(null);
		Pannello_sinistro.setBounds(0, 0, 500, 500);
		Pannello.add(Pannello_sinistro);
	}
}