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
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class Registrazione extends JFrame {
	private JPanel pannello;
	private JTextField nome;
	private JTextField cognome;
	private JTextField email;
	private JTextField dataNascita;
	private JPasswordField passwordConferma;
	private JPasswordField password;
	
	//Creazione della finestra
	public Registrazione() {
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		pannello = new JPanel();
		pannello.setForeground(new Color(255, 255, 255));
		pannello.setBackground(new Color(255, 255, 255));

		setContentPane(pannello);
		pannello.setLayout(null);
		
		JPanel barraTitolo = new JPanel();
		barraTitolo.setBorder(UIManager.getBorder("Tree.editorBorder"));
		barraTitolo.setBackground(new Color(0, 0, 0));
		barraTitolo.setBounds(0, 0, 1000, 50);
		pannello.add(barraTitolo);
		barraTitolo.setLayout(null);
		
		JLabel testoChiudi = new JLabel("");
		testoChiudi.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Chiudi.png")));
		testoChiudi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				testoChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi (rosso).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				testoChiudi.setIcon(new ImageIcon(getClass().getResource("/Immagini/Chiudi.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		testoChiudi.setHorizontalAlignment(SwingConstants.CENTER);
		testoChiudi.setForeground(new Color(255, 255, 255));
		testoChiudi.setBackground(new Color(255, 255, 255));
		testoChiudi.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		testoChiudi.setBounds(945, 0, 45, 50);
		barraTitolo.add(testoChiudi);
		
		JLabel testoRiduci = new JLabel("");
		testoRiduci.setIcon(new ImageIcon(Accesso.class.getResource("/Immagini/Riduci a icona.png")));
		testoRiduci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				testoRiduci.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona (blu).png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				testoRiduci.setIcon(new ImageIcon(getClass().getResource("/Immagini/Riduci a icona.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		testoRiduci.setHorizontalAlignment(SwingConstants.CENTER);
		testoRiduci.setForeground(Color.WHITE);
		testoRiduci.setFont(new Font("Segoe UI", Font.PLAIN, 5));
		testoRiduci.setBackground(Color.WHITE);
		testoRiduci.setBounds(900, 0, 45, 50);
		barraTitolo.add(testoRiduci);
		
		JLabel testoBarra = new JLabel("Registrazione");
		testoBarra.setVerticalAlignment(SwingConstants.TOP);
		testoBarra.setBackground(new Color(0, 0, 0));
		testoBarra.setForeground(new Color(255, 255, 255));
		testoBarra.setHorizontalAlignment(SwingConstants.LEFT);
		testoBarra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoBarra.setBounds(40, 11, 120, 28);
		barraTitolo.add(testoBarra);
		
		//Pannello sinistro
		JPanel pannelloSinistro = new JPanel();
		pannelloSinistro.setForeground(new Color(255, 255, 255));
		pannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		pannelloSinistro.setBackground(new Color(255, 255, 255));
		pannelloSinistro.setBounds(0, 0, 500, 500);
		pannello.add(pannelloSinistro);
		pannelloSinistro.setLayout(null);
		
		JLabel testoInfoPersonali = new JLabel("Informazioni personali");
		testoInfoPersonali.setForeground(new Color(0, 0, 0));
		testoInfoPersonali.setBackground(new Color(255, 255, 255));
		testoInfoPersonali.setHorizontalAlignment(SwingConstants.CENTER);
		testoInfoPersonali.setBounds(0, 50, 500, 70);
		testoInfoPersonali.setFont(new Font("Segoe UI", Font.BOLD, 25));
		pannelloSinistro.add(testoInfoPersonali);
		
		JLabel testoNome = new JLabel("Nome");
		testoNome.setForeground(new Color(0, 0, 0));
		testoNome.setBackground(new Color(255, 255, 255));
		testoNome.setVerticalAlignment(SwingConstants.TOP);
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setBounds(39, 131, 120, 28);
		pannelloSinistro.add(testoNome);
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		nome = new JTextField();
		nome.setForeground(new Color(0, 0, 0));
		nome.setBackground(new Color(255, 255, 255));
		nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		nome.setBounds(39, 170, 170, 28);
		pannelloSinistro.add(nome);
		nome.setColumns(10);
		
		JLabel testoCognome = new JLabel("Cognome");
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setVerticalAlignment(SwingConstants.TOP);
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBounds(291, 131, 120, 28);
		pannelloSinistro.add(testoCognome);
		
		cognome = new JTextField();
		cognome.setForeground(new Color(0, 0, 0));
		cognome.setBackground(new Color(255, 255, 255));
		cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cognome.setColumns(10);
		cognome.setBounds(291, 170, 170, 28);
		pannelloSinistro.add(cognome);
		
		JLabel testoEmail = new JLabel("Email");
		testoEmail.setVerticalAlignment(SwingConstants.TOP);
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBounds(39, 209, 120, 28);
		pannelloSinistro.add(testoEmail);
		
		email = new JTextField();
		email.setForeground(new Color(0, 0, 0));
		email.setBackground(new Color(255, 255, 255));
		email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		email.setColumns(10);
		email.setBounds(39, 248, 422, 28);
		pannelloSinistro.add(email);
		
		JLabel testoPassword = new JLabel("Password");
		testoPassword.setVerticalAlignment(SwingConstants.TOP);
		testoPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoPassword.setForeground(new Color(0, 0, 0));
		testoPassword.setBackground(new Color(255, 255, 255));
		testoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPassword.setBounds(39, 287, 120, 28);
		pannelloSinistro.add(testoPassword);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password.setForeground(new Color(0, 0, 0));
		password.setBackground(new Color(255, 255, 255));
		password.setBounds(39, 326, 170, 28);
		pannelloSinistro.add(password);
		
		JLabel testoConfermaPassword = new JLabel("Conferma password");
		testoConfermaPassword.setVerticalAlignment(SwingConstants.TOP);
		testoConfermaPassword.setForeground(new Color(0, 0, 0));
		testoConfermaPassword.setBackground(new Color(255, 255, 255));
		testoConfermaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoConfermaPassword.setBounds(291, 287, 190, 28);
		pannelloSinistro.add(testoConfermaPassword);
		
		passwordConferma = new JPasswordField();
		passwordConferma.setEchoChar('*');
		passwordConferma.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passwordConferma.setForeground(new Color(0, 0, 0));
		passwordConferma.setBackground(new Color(255, 255, 255));
		passwordConferma.setBounds(291, 326, 170, 28);
		pannelloSinistro.add(passwordConferma);
		
		dataNascita = new JTextField();
		dataNascita.setBackground(new Color(255, 255, 255));
		dataNascita.setToolTipText("AAAA-MM-GG");
		dataNascita.setForeground(new Color(0, 0, 0));
		dataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		dataNascita.setColumns(10);
		dataNascita.setBounds(39, 404, 170, 28);
		pannelloSinistro.add(dataNascita);
		
		JLabel testoDataNascita = new JLabel("Data di nascita");
		testoDataNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataNascita.setVerticalAlignment(SwingConstants.TOP);
		testoDataNascita.setForeground(new Color(0, 0, 0));
		testoDataNascita.setBackground(new Color(255, 255, 255));
		testoDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataNascita.setBounds(39, 365, 170, 28);
		pannelloSinistro.add(testoDataNascita);
		
		JLabel testoSesso = new JLabel("Sesso");
		testoSesso.setVerticalAlignment(SwingConstants.TOP);
		testoSesso.setHorizontalAlignment(SwingConstants.LEFT);
		testoSesso.setForeground(new Color(0, 0, 0));
		testoSesso.setBackground(new Color(255, 255, 255));
		testoSesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSesso.setBounds(291, 365, 120, 28);
		pannelloSinistro.add(testoSesso);
		
		JComboBox sesso = new JComboBox();
		sesso.setForeground(new Color(0, 0, 0));
		sesso.setBackground(new Color(255, 255, 255));
		sesso.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		sesso.setSelectedIndex(-1);
		sesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		sesso.setMaximumRowCount(2);
		sesso.setBounds(291, 404, 170, 28);
		pannelloSinistro.add(sesso);
		
		JButton bottoneIndietro = new JButton("Indietro");
		bottoneIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso finestraAccesso = new Accesso();
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
		
		JLabel testoInfoProfessionali = new JLabel("Informazioni professionali");
		testoInfoProfessionali.setForeground(new Color(0, 0, 0));
		testoInfoProfessionali.setBackground(new Color(255, 255, 255));
		testoInfoProfessionali.setBounds(0, 50, 500, 70);
		pannelloDestro.add(testoInfoProfessionali);
		testoInfoProfessionali.setHorizontalAlignment(SwingConstants.CENTER);
		testoInfoProfessionali.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel testoInformativo = new JLabel("Compila i campi sottostanti con le informazioni lavorative");
		testoInformativo.setVerticalAlignment(SwingConstants.TOP);
		testoInformativo.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo.setForeground(new Color(0, 0, 0));
		testoInformativo.setBackground(new Color(255, 255, 255));
		testoInformativo.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo.setBounds(0, 131, 500, 28);
		pannelloDestro.add(testoInformativo);
		
		JLabel testoInformativo2 = new JLabel("Indicare la sede e la professione desiderate");
		testoInformativo2.setForeground(new Color(0, 0, 0));
		testoInformativo2.setBackground(new Color(255, 255, 255));
		testoInformativo2.setVerticalAlignment(SwingConstants.TOP);
		testoInformativo2.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo2.setBounds(0, 160, 500, 28);
		pannelloDestro.add(testoInformativo2);
		
		JLabel testoCentro = new JLabel("Centro");
		testoCentro.setForeground(new Color(0, 0, 0));
		testoCentro.setBackground(new Color(255, 255, 255));
		testoCentro.setVerticalAlignment(SwingConstants.TOP);
		testoCentro.setHorizontalAlignment(SwingConstants.CENTER);
		testoCentro.setBounds(171, 199, 170, 28);
		pannelloDestro.add(testoCentro);
		testoCentro.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox centro = new JComboBox();
		centro.setForeground(new Color(0, 0, 0));
		centro.setBounds(171, 238, 170, 28);
		pannelloDestro.add(centro);
		centro.setModel(new DefaultComboBoxModel(new String[] {"Centro Roma", "Centro Napoli", "Centro Parma"}));
		centro.setSelectedIndex(-1);
		centro.setMaximumRowCount(3);
		centro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		centro.setBackground(new Color(255, 255, 255));
		
		JLabel testoProfessione = new JLabel("Professione");
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setVerticalAlignment(SwingConstants.TOP);
		testoProfessione.setHorizontalAlignment(SwingConstants.CENTER);
		testoProfessione.setBounds(171, 277, 170, 28);
		pannelloDestro.add(testoProfessione);
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox professione = new JComboBox();
		professione.setForeground(new Color(0, 0, 0));
		professione.setBounds(171, 316, 170, 28);
		pannelloDestro.add(professione);
		professione.setModel(new DefaultComboBoxModel(new String[] {"Operatore", "Medico veterinario", "Tecnico di laboratorio", "Ricercatore"}));
		professione.setSelectedIndex(-1);
		professione.setMaximumRowCount(4);
		professione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		professione.setBackground(new Color(255, 255, 255));
		
		JButton bottoneRegistrati = new JButton("Registrati");
		bottoneRegistrati.setBounds(40, 390, 419, 50);
		pannelloDestro.add(bottoneRegistrati);
		bottoneRegistrati.setForeground(new Color(0, 0, 0));
		bottoneRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bottoneRegistrati.setBackground(new Color(255, 255, 255));
		
		bottoneRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					PreparedStatement ps;
					int rs;
					
					int idCentro = centro.getSelectedIndex()+1;
					String stringaEmail = email.getText();
					String stringaPassword = String.valueOf(password.getPassword());
					String stringaNome = nome.getText();
					String stringaCognome = cognome.getText();
					String stringaSesso = sesso.getSelectedItem().toString();
					String stringaData = dataNascita.getText();
					Date data = Date.valueOf(stringaData);
					String stringaTipologia = professione.getSelectedItem().toString();
					
					String query = "INSERT INTO Personale (id_centro, matricola, email, parola_chiave, nome, cognome, sesso, data_di_nascita, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					try {
						ps = Connessione.getConnection().prepareStatement(query);
						
						ps.setInt(1, idCentro);
						ps.setString(2, "N00000001");
						ps.setString(3, stringaEmail);
						ps.setString(4, stringaPassword);
						ps.setString(5, stringaNome);
						ps.setString(6, stringaCognome);
						ps.setString(7, stringaSesso);
						ps.setDate(8, data);
						ps.setObject(9, stringaTipologia, Types.OTHER);
						
						rs = ps.executeUpdate();
						
						if(rs==0) {
							JOptionPane.showMessageDialog(null, "Si");
						} else {
							Errore Finestra_errore = new Errore("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
							Finestra_errore.setLocationRelativeTo(null);
							Finestra_errore.setVisible(true);
							
						}
					}catch (SQLException ex) {
						Logger.getLogger(Accesso.class.getName()).log(Level.SEVERE, null, ex);
						Errore Finestra_errore = new Errore("Impossibile effettuare la registrazione!", "Controlla che tutti i campi siano stati riempiti correttamente!");
						Finestra_errore.setLocationRelativeTo(null);
						Finestra_errore.setVisible(true);
					}
				}
		});
	}
}