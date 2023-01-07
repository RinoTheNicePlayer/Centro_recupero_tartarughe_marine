package Classi.View;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.TestoUtility;
import Classi.Controller.AccessoController;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccessoView extends JFrame {
	private JPanel pannello;
	private JTextField compilazioneEmail;
	private JPasswordField compilazionePassword;
	private JLabel iconaOcchioChiuso;
	private JLabel iconaOcchioAperto;
	
	//Lancio dell'applicazione
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessoView finestraAccesso = new AccessoView();
					finestraAccesso.setLocationRelativeTo(null);
					finestraAccesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Creazione della finestra
	public AccessoView() {
		
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
		
		JLabel titoloFinestra = new JLabel("Accesso");
		titoloFinestra.setVerticalAlignment(SwingConstants.TOP);
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(40, 11, 120, 28);
		barraTitolo.add(titoloFinestra);
		
		//Pannello sinistro
		JLabel pannelloSinistro = new JLabel("");
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannelloSinistro.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Centro recupero tartarughe marine.png")));
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannello.add(pannelloSinistro);
		
		//Pannello destro
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setForeground(new Color(255, 255, 255));
		pannelloDestro.setBackground(new Color(255, 255, 255));
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannello.add(pannelloDestro);
		
		JLabel testoInformativo1 = new JLabel("Accesso");
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setBounds(0, 50, 500, 75);
		pannelloDestro.add(testoInformativo1);
		
		JLabel testoInformativo2 = new JLabel("Benvenuto!");
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setBounds(0, 120, 500, 30);
		pannelloDestro.add(testoInformativo2);
		
		JLabel testoInformativo3 = new JLabel("Compila i campi sottostanti per entrare nel portale");
		testoInformativo3.setForeground(new Color(0, 0, 0));
		testoInformativo3.setBackground(new Color(255, 255, 255));
		testoInformativo3.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo3.setBounds(0, 140, 500, 30);
		pannelloDestro.add(testoInformativo3);
		
		JLabel testoEmail = new JLabel("Email");
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setVerticalAlignment(SwingConstants.TOP);
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setBounds(40, 205, 120, 30);
		pannelloDestro.add(testoEmail);
		
		JLabel testoEmailValida = new JLabel("Email valida");
		testoEmailValida.setVerticalAlignment(SwingConstants.TOP);
		testoEmailValida.setHorizontalAlignment(SwingConstants.RIGHT);
		testoEmailValida.setForeground(new Color(0, 255, 0));
		testoEmailValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoEmailValida.setBackground(new Color(255, 255, 255));
		testoEmailValida.setBounds(215, 275, 190, 30);
		testoEmailValida.setVisible(false);
		pannelloDestro.add(testoEmailValida);
		
		JLabel testoEmailNonValida = new JLabel("Email non valida");
		testoEmailNonValida.setVerticalAlignment(SwingConstants.TOP);
		testoEmailNonValida.setHorizontalAlignment(SwingConstants.RIGHT);
		testoEmailNonValida.setForeground(new Color(255, 0, 0));
		testoEmailNonValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoEmailNonValida.setBackground(new Color(255, 255, 255));
		testoEmailNonValida.setBounds(215, 275, 190, 30);
		testoEmailNonValida.setVisible(false);
		pannelloDestro.add(testoEmailNonValida);
		
		compilazioneEmail = new JTextField();

		compilazioneEmail.setHorizontalAlignment(SwingConstants.LEFT);
		compilazioneEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneEmail.setForeground(new Color(0, 0, 0));
		compilazioneEmail.setBackground(new Color(255, 255, 255));
		compilazioneEmail.setBounds(40, 245, 365, 30);
		pannelloDestro.add(compilazioneEmail);
		compilazioneEmail.setColumns(10);
		compilazioneEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				boolean checkEmail = TestoUtility.verificaEmail(compilazioneEmail.getText());
				
				testoEmailValida.setVisible(checkEmail);
				testoEmailNonValida.setVisible(!checkEmail);
			}
		});
		
		JLabel iconaUtente = new JLabel("");
		iconaUtente.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaUtente.setForeground(new Color(0, 0, 0));
		iconaUtente.setBackground(new Color(255, 255, 255));
		iconaUtente.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Utente.png")));
		iconaUtente.setHorizontalAlignment(SwingConstants.CENTER);
		iconaUtente.setBounds(430, 245, 30, 30);
		pannelloDestro.add(iconaUtente);
		
		JLabel testoPassword = new JLabel("Password");
		testoPassword.setForeground(new Color(0, 0, 0));
		testoPassword.setBackground(new Color(255, 255, 255));
		testoPassword.setVerticalAlignment(SwingConstants.TOP);
		testoPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPassword.setBounds(40, 285, 120, 30);
		pannelloDestro.add(testoPassword);
		
		JLabel testoPasswordValida = new JLabel("Password valida");
		testoPasswordValida.setVerticalAlignment(SwingConstants.TOP);
		testoPasswordValida.setHorizontalAlignment(SwingConstants.RIGHT);
		testoPasswordValida.setForeground(new Color(0, 255, 0));
		testoPasswordValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoPasswordValida.setBackground(new Color(255, 255, 255));
		testoPasswordValida.setBounds(215, 355, 190, 30);
		testoPasswordValida.setVisible(false);
		pannelloDestro.add(testoPasswordValida);
		
		JLabel testoPasswordNonValida = new JLabel("Minimo 8 caratteri e massimo 16");
		testoPasswordNonValida.setVerticalAlignment(SwingConstants.TOP);
		testoPasswordNonValida.setHorizontalAlignment(SwingConstants.RIGHT);
		testoPasswordNonValida.setForeground(new Color(255, 0, 0));
		testoPasswordNonValida.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoPasswordNonValida.setBackground(new Color(255, 255, 255));
		testoPasswordNonValida.setBounds(175, 355, 230, 30);
		testoPasswordNonValida.setVisible(false);
		pannelloDestro.add(testoPasswordNonValida);
		
		compilazionePassword = new JPasswordField();
		compilazionePassword.setHorizontalAlignment(SwingConstants.LEFT);
		compilazionePassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazionePassword.setForeground(new Color(0, 0, 0));
		compilazionePassword.setBackground(new Color(255, 255, 255));
		compilazionePassword.setEchoChar('*');
		compilazionePassword.setBounds(40, 325, 365, 30);
		pannelloDestro.add(compilazionePassword);
		compilazionePassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				boolean passwordCheck = TestoUtility.verificaPassword(compilazionePassword.getPassword());
				
					testoPasswordNonValida.setVisible(!passwordCheck);
					testoPasswordValida.setVisible(passwordCheck);
			}
		});
		
		iconaOcchioChiuso = new JLabel("");
		iconaOcchioChiuso.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaOcchioChiuso.setForeground(new Color(0, 0, 0));
		iconaOcchioChiuso.setBackground(new Color(255, 255, 255));
		iconaOcchioChiuso.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				iconaOcchioAperto.setVisible(true);
				iconaOcchioChiuso.setVisible(false);
				compilazionePassword.setEchoChar('*');
			}
		});
		iconaOcchioChiuso.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Occhio chiuso.png")));
		iconaOcchioChiuso.setHorizontalAlignment(SwingConstants.CENTER);
		iconaOcchioChiuso.setBounds(430, 325, 30, 30);
		pannelloDestro.add(iconaOcchioChiuso);
		
		iconaOcchioAperto = new JLabel("");
		iconaOcchioAperto.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		iconaOcchioAperto.setForeground(new Color(0, 0, 0));
		iconaOcchioAperto.setBackground(new Color(255, 255, 255));
		iconaOcchioAperto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				iconaOcchioChiuso.setVisible(true);
				iconaOcchioAperto.setVisible(false);
				compilazionePassword.setEchoChar((char)0);
			}
		});
		iconaOcchioAperto.setIcon(new ImageIcon(AccessoView.class.getResource("/Immagini/Occhio aperto.png")));
		iconaOcchioAperto.setHorizontalAlignment(SwingConstants.CENTER);
		iconaOcchioAperto.setBounds(430, 325, 30, 30);
		pannelloDestro.add(iconaOcchioAperto);
		
		JButton bottoneAccesso = new JButton("Accesso");
		bottoneAccesso.setForeground(new Color(0, 0, 0));
		bottoneAccesso.setBackground(new Color(255, 255, 255));
		bottoneAccesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bottoneAccesso.setBounds(40, 390, 420, 50);
		pannelloDestro.add(bottoneAccesso);
		bottoneAccesso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessoController.getInstance().effettuaAccesso(compilazioneEmail.getText(), compilazionePassword.getPassword());
			}
		});
		
		JLabel testoInformativo4 = new JLabel("Non ti sei ancora registrato?");
		testoInformativo4.setForeground(new Color(0, 0, 0));
		testoInformativo4.setBackground(new Color(255, 255, 255));
		testoInformativo4.setHorizontalAlignment(SwingConstants.RIGHT);
		testoInformativo4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		testoInformativo4.setBounds(70, 450, 205, 25);
		pannelloDestro.add(testoInformativo4);
		
		JLabel registrazione = new JLabel("Registrazione");
		registrazione.setForeground(new Color(0, 0, 0));
		registrazione.setBackground(new Color(255, 255, 255));
		registrazione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrazioneView finestraRegistrazione = new RegistrazioneView();
				finestraRegistrazione.setLocationRelativeTo(null);
				finestraRegistrazione.setVisible(true);
				dispose();
			}
		});
		registrazione.setHorizontalAlignment(SwingConstants.LEFT);
		registrazione.setFont(new Font("Segoe UI", Font.BOLD, 15));
		registrazione.setBounds(285, 450, 100, 25);
		pannelloDestro.add(registrazione);
		pannelloDestro.setLayout(null);
	}
}