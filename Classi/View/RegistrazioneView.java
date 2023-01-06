package Classi.View;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller.RegistrazioneController;
import Classi.Models.Personale;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class RegistrazioneView extends JFrame {
	private JPanel pannello;
	private JTextField compilazioneNome;
	private JTextField compilazioneCognome;
	private JTextField compilazioneEmail;
	private JTextField compilazioneDataDiNascita;
	private JPasswordField compilazioneConfermaPassword;
	private JPasswordField compilazionePassword;
	
	//Creazione della finestra
	public RegistrazioneView() {
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
		barraTitolo.setBorder(UIManager.getBorder("Tree.editorBorder"));
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
		iconaMinimizza.setForeground(Color.WHITE);
		iconaMinimizza.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		iconaMinimizza.setBackground(Color.WHITE);
		iconaMinimizza.setBounds(900, 0, 45, 50);
		barraTitolo.add(iconaMinimizza);
		
		JLabel titoloFinestra = new JLabel("Registrazione");
		titoloFinestra.setVerticalAlignment(SwingConstants.TOP);
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(40, 11, 120, 28);
		barraTitolo.add(titoloFinestra);
		
		//Pannello sinistro
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannello.add(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JLabel testoInformativo1 = new JLabel("Informazioni personali");
		testoInformativo1.setForeground(new Color(0, 0, 0));
		testoInformativo1.setBackground(new Color(255, 255, 255));
		testoInformativo1.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo1.setBounds(0, 50, 500, 70);
		testoInformativo1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		pannelloSinistro.add(testoInformativo1);
		
		JLabel testoNome = new JLabel("Nome");
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setVerticalAlignment(SwingConstants.TOP);
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setBounds(39, 131, 120, 28);
		pannelloSinistro.add(testoNome);
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		compilazioneNome = new JTextField();
		compilazioneNome.setForeground(new Color(0, 0, 0));
		compilazioneNome.setBackground(new Color(255, 255, 255));
		compilazioneNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneNome.setBounds(39, 170, 170, 28);
		pannelloSinistro.add(compilazioneNome);
		compilazioneNome.setColumns(10);
		
		JLabel testoCognome = new JLabel("Cognome");
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setVerticalAlignment(SwingConstants.TOP);
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBounds(291, 131, 120, 28);
		pannelloSinistro.add(testoCognome);
		
		compilazioneCognome = new JTextField();
		compilazioneCognome.setForeground(new Color(0, 0, 0));
		compilazioneCognome.setBackground(new Color(255, 255, 255));
		compilazioneCognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneCognome.setColumns(10);
		compilazioneCognome.setBounds(291, 170, 170, 28);
		pannelloSinistro.add(compilazioneCognome);
		
		JLabel testoEmail = new JLabel("Email");
		testoEmail.setVerticalAlignment(SwingConstants.TOP);
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBounds(39, 209, 120, 28);
		pannelloSinistro.add(testoEmail);
		
		compilazioneEmail = new JTextField();
		compilazioneEmail.setForeground(new Color(0, 0, 0));
		compilazioneEmail.setBackground(new Color(255, 255, 255));
		compilazioneEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneEmail.setColumns(10);
		compilazioneEmail.setBounds(39, 248, 422, 28);
		pannelloSinistro.add(compilazioneEmail);
		
		JLabel testoPassword = new JLabel("Password");
		testoPassword.setVerticalAlignment(SwingConstants.TOP);
		testoPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoPassword.setForeground(new Color(0, 0, 0));
		testoPassword.setBackground(new Color(255, 255, 255));
		testoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPassword.setBounds(39, 287, 120, 28);
		pannelloSinistro.add(testoPassword);
		
		compilazionePassword = new JPasswordField();
		compilazionePassword.setEchoChar('*');
		compilazionePassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazionePassword.setForeground(new Color(0, 0, 0));
		compilazionePassword.setBackground(new Color(255, 255, 255));
		compilazionePassword.setBounds(39, 326, 170, 28);
		pannelloSinistro.add(compilazionePassword);
		
		JLabel testoConfermaPassword = new JLabel("Conferma password");
		testoConfermaPassword.setVerticalAlignment(SwingConstants.TOP);
		testoConfermaPassword.setForeground(new Color(0, 0, 0));
		testoConfermaPassword.setBackground(new Color(255, 255, 255));
		testoConfermaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoConfermaPassword.setBounds(291, 287, 190, 28);
		pannelloSinistro.add(testoConfermaPassword);
		
		compilazioneConfermaPassword = new JPasswordField();
		compilazioneConfermaPassword.setEchoChar('*');
		compilazioneConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneConfermaPassword.setForeground(new Color(0, 0, 0));
		compilazioneConfermaPassword.setBackground(new Color(255, 255, 255));
		compilazioneConfermaPassword.setBounds(291, 326, 170, 28);
		pannelloSinistro.add(compilazioneConfermaPassword);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita");
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setVerticalAlignment(SwingConstants.TOP);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiNascita.setBounds(39, 365, 170, 28);
		pannelloSinistro.add(testoDataDiNascita);
		
		compilazioneDataDiNascita = new JTextField();
		compilazioneDataDiNascita.setBackground(new Color(255, 255, 255));
		compilazioneDataDiNascita.setToolTipText("AAAA-MM-GG");
		compilazioneDataDiNascita.setForeground(new Color(0, 0, 0));
		compilazioneDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneDataDiNascita.setColumns(10);
		compilazioneDataDiNascita.setBounds(39, 404, 170, 28);
		pannelloSinistro.add(compilazioneDataDiNascita);
		
		JLabel testoSesso = new JLabel("Sesso");
		testoSesso.setVerticalAlignment(SwingConstants.TOP);
		testoSesso.setHorizontalAlignment(SwingConstants.LEFT);
		testoSesso.setForeground(new Color(0, 0, 0));
		testoSesso.setBackground(new Color(255, 255, 255));
		testoSesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSesso.setBounds(291, 365, 120, 28);
		pannelloSinistro.add(testoSesso);
		
		JComboBox selezioneSesso = new JComboBox();
		selezioneSesso.setForeground(new Color(0, 0, 0));
		selezioneSesso.setBackground(new Color(255, 255, 255));
		selezioneSesso.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		selezioneSesso.setSelectedIndex(-1);
		selezioneSesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneSesso.setMaximumRowCount(2);
		selezioneSesso.setBounds(291, 404, 170, 28);
		pannelloSinistro.add(selezioneSesso);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessoView finestraAccesso = new AccessoView();
				finestraAccesso.setLocationRelativeTo(null);
				finestraAccesso.setVisible(true);
				dispose();
			}
		});
		bottoneIndietro.setForeground(new Color(0, 0, 0));
		bottoneIndietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bottoneIndietro.setBackground(new Color(255, 255, 255));
		bottoneIndietro.setBounds(160, 450, 170, 28);
		pannelloSinistro.add(bottoneIndietro);
		
		//Pannello destro
		JPanel pannelloDestro = new JPanel();
		pannelloDestro.setForeground(new Color(255, 255, 255));
		pannelloDestro.setBackground(new Color(255, 255, 255));
		pannelloDestro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloDestro.setBounds(500, 0, 500, 500);
		pannello.add(pannelloDestro);
		pannelloDestro.setLayout(null);
		
		JLabel testoInformativo2 = new JLabel("Informazioni professionali");
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setBounds(0, 50, 500, 70);
		pannelloDestro.add(testoInformativo2);
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel testoInformativo3 = new JLabel("Compila i campi sottostanti con le informazioni lavorative");
		testoInformativo3.setVerticalAlignment(SwingConstants.TOP);
		testoInformativo3.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo3.setForeground(new Color(0, 0, 0));
		testoInformativo3.setBackground(new Color(255, 255, 255));
		testoInformativo3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo3.setBounds(0, 131, 500, 28);
		pannelloDestro.add(testoInformativo3);
		
		JLabel testoInformativo4 = new JLabel("Indicare la sede e la professione desiderate");
		testoInformativo4.setForeground(new Color(0, 0, 0));
		testoInformativo4.setBackground(new Color(255, 255, 255));
		testoInformativo4.setVerticalAlignment(SwingConstants.TOP);
		testoInformativo4.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo4.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo4.setBounds(0, 160, 500, 28);
		pannelloDestro.add(testoInformativo4);
		
		JLabel testoCentro = new JLabel("Centro");
		testoCentro.setForeground(new Color(0, 0, 0));
		testoCentro.setBackground(new Color(255, 255, 255));
		testoCentro.setVerticalAlignment(SwingConstants.TOP);
		testoCentro.setHorizontalAlignment(SwingConstants.CENTER);
		testoCentro.setBounds(171, 199, 170, 28);
		pannelloDestro.add(testoCentro);
		testoCentro.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox selezioneCentro = new JComboBox();
		selezioneCentro.setForeground(new Color(0, 0, 0));
		selezioneCentro.setBounds(171, 238, 170, 28);
		pannelloDestro.add(selezioneCentro);
		selezioneCentro.setModel(new DefaultComboBoxModel(new String[] {"Centro Roma", "Centro Napoli", "Centro Parma"}));
		selezioneCentro.setSelectedIndex(-1);
		selezioneCentro.setMaximumRowCount(3);
		selezioneCentro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneCentro.setBackground(new Color(255, 255, 255));
		
		JLabel testoProfessione = new JLabel("Professione");
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setVerticalAlignment(SwingConstants.TOP);
		testoProfessione.setHorizontalAlignment(SwingConstants.CENTER);
		testoProfessione.setBounds(171, 277, 170, 28);
		pannelloDestro.add(testoProfessione);
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox selezioneProfessione = new JComboBox();
		selezioneProfessione.setForeground(new Color(0, 0, 0));
		selezioneProfessione.setBounds(171, 316, 170, 28);
		pannelloDestro.add(selezioneProfessione);
		selezioneProfessione.setModel(new DefaultComboBoxModel(new String[] {"Operatore", "Ricercatore", "Tecnico di laboratorio", "Medico veterinario"}));
		selezioneProfessione.setSelectedIndex(-1);
		selezioneProfessione.setMaximumRowCount(4);
		selezioneProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione.setBackground(new Color(255, 255, 255));
		
		JButton bottoneRegistrati = new JButton("Registrati");
		bottoneRegistrati.setBounds(40, 390, 419, 50);
		pannelloDestro.add(bottoneRegistrati);
		bottoneRegistrati.setForeground(new Color(0, 0, 0));
		bottoneRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bottoneRegistrati.setBackground(new Color(255, 255, 255));
	}
}