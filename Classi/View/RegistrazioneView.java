package Classi.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Classi.Controller.RegistrazioneController;
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
		
		JLabel titoloFinestra = new JLabel("Registrazione");
		titoloFinestra.setBackground(new Color(0, 0, 0));
		titoloFinestra.setForeground(new Color(255, 255, 255));
		titoloFinestra.setHorizontalAlignment(SwingConstants.LEFT);
		titoloFinestra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		titoloFinestra.setBounds(70, 0, 120, 50);
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
		testoNome.setHorizontalAlignment(SwingConstants.LEFT);
		testoNome.setBounds(40, 130, 60, 30);
		pannelloSinistro.add(testoNome);
		testoNome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JLabel testoCognome = new JLabel("Cognome");
		testoCognome.setForeground(new Color(0, 0, 0));
		testoCognome.setBackground(new Color(255, 255, 255));
		testoCognome.setHorizontalAlignment(SwingConstants.LEFT);
		testoCognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoCognome.setBounds(290, 130, 90, 30);
		pannelloSinistro.add(testoCognome);
		
		compilazioneNome = new JTextField();
		compilazioneNome.setToolTipText("La prima lettera del Nome deve essere maiuscola (Esempio: Mario)");
		compilazioneNome.setForeground(new Color(0, 0, 0));
		compilazioneNome.setBackground(new Color(255, 255, 255));
		compilazioneNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneNome.setBounds(40, 170, 170, 30);
		pannelloSinistro.add(compilazioneNome);
		compilazioneNome.setColumns(10);
		
		compilazioneCognome = new JTextField();
		compilazioneCognome.setToolTipText("La prima lettera del Cognome deve essere maiuscola (Esempio: Rossi)");
		compilazioneCognome.setForeground(new Color(0, 0, 0));
		compilazioneCognome.setBackground(new Color(255, 255, 255));
		compilazioneCognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneCognome.setColumns(10);
		compilazioneCognome.setBounds(290, 170, 170, 30);
		pannelloSinistro.add(compilazioneCognome);
		
		JLabel testoEmail = new JLabel("Email");
		testoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		testoEmail.setForeground(new Color(0, 0, 0));
		testoEmail.setBackground(new Color(255, 255, 255));
		testoEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoEmail.setBounds(40, 210, 60, 30);
		pannelloSinistro.add(testoEmail);
		
		compilazioneEmail = new JTextField();
		compilazioneEmail.setToolTipText("L'Email deve seguire il formato standard (Esempio: mariorossi@email.com)");
		compilazioneEmail.setForeground(new Color(0, 0, 0));
		compilazioneEmail.setBackground(new Color(255, 255, 255));
		compilazioneEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneEmail.setColumns(10);
		compilazioneEmail.setBounds(40, 250, 420, 30);
		pannelloSinistro.add(compilazioneEmail);
		
		JLabel testoPassword = new JLabel("Password");
		testoPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoPassword.setForeground(new Color(0, 0, 0));
		testoPassword.setBackground(new Color(255, 255, 255));
		testoPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoPassword.setBounds(40, 290, 90, 30);
		pannelloSinistro.add(testoPassword);
		
		JLabel testoConfermaPassword = new JLabel("Conferma password");
		testoConfermaPassword.setForeground(new Color(0, 0, 0));
		testoConfermaPassword.setBackground(new Color(255, 255, 255));
		testoConfermaPassword.setHorizontalAlignment(SwingConstants.LEFT);
		testoConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoConfermaPassword.setBounds(290, 290, 180, 30);
		pannelloSinistro.add(testoConfermaPassword);
		
		compilazionePassword = new JPasswordField();
		compilazionePassword.setToolTipText("La Password deve avere una lughezza compresa tra 8 e 16 caratteri");
		compilazionePassword.setEchoChar('*');
		compilazionePassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazionePassword.setForeground(new Color(0, 0, 0));
		compilazionePassword.setBackground(new Color(255, 255, 255));
		compilazionePassword.setBounds(40, 330, 170, 30);
		pannelloSinistro.add(compilazionePassword);
		
		compilazioneConfermaPassword = new JPasswordField();
		compilazioneConfermaPassword.setToolTipText("La Password deve essere uguale a quella che hai gi?? scritto");
		compilazioneConfermaPassword.setEchoChar('*');
		compilazioneConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneConfermaPassword.setForeground(new Color(0, 0, 0));
		compilazioneConfermaPassword.setBackground(new Color(255, 255, 255));
		compilazioneConfermaPassword.setBounds(290, 330, 170, 30);
		pannelloSinistro.add(compilazioneConfermaPassword);
		
		JLabel testoDataDiNascita = new JLabel("Data di nascita");
		testoDataDiNascita.setHorizontalAlignment(SwingConstants.LEFT);
		testoDataDiNascita.setForeground(new Color(0, 0, 0));
		testoDataDiNascita.setBackground(new Color(255, 255, 255));
		testoDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoDataDiNascita.setBounds(40, 370, 130, 30);
		pannelloSinistro.add(testoDataDiNascita);
		
		JLabel testoSesso = new JLabel("Sesso");
		testoSesso.setHorizontalAlignment(SwingConstants.LEFT);
		testoSesso.setForeground(new Color(0, 0, 0));
		testoSesso.setBackground(new Color(255, 255, 255));
		testoSesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		testoSesso.setBounds(290, 370, 50, 30);
		pannelloSinistro.add(testoSesso);
		
		compilazioneDataDiNascita = new JTextField();
		compilazioneDataDiNascita.setToolTipText("La Data deve corrispondere al seguente formato: AAAA-MM-GG (Esempio: 2002-11-15)");
		compilazioneDataDiNascita.setForeground(new Color(0, 0, 0));
		compilazioneDataDiNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		compilazioneDataDiNascita.setColumns(10);
		compilazioneDataDiNascita.setBackground(new Color(255, 255, 255));
		compilazioneDataDiNascita.setBounds(40, 410, 170, 30);
		pannelloSinistro.add(compilazioneDataDiNascita);
		
		JComboBox selezioneSesso = new JComboBox();
		selezioneSesso.setToolTipText("Selezionare il Sesso (M: Maschio, F: Femmina)");
		selezioneSesso.setForeground(new Color(0, 0, 0));
		selezioneSesso.setBackground(new Color(255, 255, 255));
		selezioneSesso.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		selezioneSesso.setSelectedIndex(-1);
		selezioneSesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneSesso.setMaximumRowCount(2);
		selezioneSesso.setBounds(290, 410, 170, 30);
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
		bottoneIndietro.setBounds(180, 452, 140, 35);
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
		
		JLabel testoInformativo3 = new JLabel("Definisci le tue informazioni lavorative:");
		testoInformativo3.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo3.setForeground(new Color(0, 0, 0));
		testoInformativo3.setBackground(new Color(255, 255, 255));
		testoInformativo3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo3.setBounds(0, 130, 500, 30);
		pannelloDestro.add(testoInformativo3);
		
		JLabel testoInformativo4 = new JLabel("indica il centro di appartenenza e la professione che svolgi");
		testoInformativo4.setForeground(new Color(0, 0, 0));
		testoInformativo4.setBackground(new Color(255, 255, 255));
		testoInformativo4.setHorizontalAlignment(SwingConstants.CENTER);
		testoInformativo4.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		testoInformativo4.setBounds(0, 150, 500, 30);
		pannelloDestro.add(testoInformativo4);
		
		JLabel testoCentro = new JLabel("Centro");
		testoCentro.setForeground(new Color(0, 0, 0));
		testoCentro.setBackground(new Color(255, 255, 255));
		testoCentro.setHorizontalAlignment(SwingConstants.CENTER);
		testoCentro.setBounds(170, 210, 170, 30);
		pannelloDestro.add(testoCentro);
		testoCentro.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox selezioneCentro = new JComboBox();
		selezioneCentro.setToolTipText("Selezionare il Centro di appartenenza");
		selezioneCentro.setForeground(new Color(0, 0, 0));
		selezioneCentro.setBounds(170, 250, 170, 30);
		pannelloDestro.add(selezioneCentro);
		selezioneCentro.setModel(new DefaultComboBoxModel(new String[] {"Centro Roma", "Centro Napoli", "Centro Parma"}));
		selezioneCentro.setSelectedIndex(-1);
		selezioneCentro.setMaximumRowCount(3);
		selezioneCentro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneCentro.setBackground(new Color(255, 255, 255));
		
		JLabel testoProfessione = new JLabel("Professione");
		testoProfessione.setForeground(new Color(0, 0, 0));
		testoProfessione.setBackground(new Color(255, 255, 255));
		testoProfessione.setHorizontalAlignment(SwingConstants.CENTER);
		testoProfessione.setBounds(170, 290, 170, 30);
		pannelloDestro.add(testoProfessione);
		testoProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox selezioneProfessione = new JComboBox();
		selezioneProfessione.setToolTipText("Selezionare la Professione");
		selezioneProfessione.setForeground(new Color(0, 0, 0));
		selezioneProfessione.setBounds(170, 330, 170, 30);
		pannelloDestro.add(selezioneProfessione);
		selezioneProfessione.setModel(new DefaultComboBoxModel(new String[] {"Operatore", "Ricercatore", "Tecnico di laboratorio", "Medico veterinario"}));
		selezioneProfessione.setSelectedIndex(-1);
		selezioneProfessione.setMaximumRowCount(4);
		selezioneProfessione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		selezioneProfessione.setBackground(new Color(255, 255, 255));
		
		JButton bottoneRegistrati = new JButton("Registrati");
		bottoneRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrazioneController.getInstance().effettuaRegistrazione(compilazioneNome.getText(), compilazioneCognome.getText(), compilazioneEmail.getText(), compilazionePassword.getPassword(), compilazioneConfermaPassword.getPassword(), compilazioneDataDiNascita.getText(), (selezioneSesso.getSelectedItem()!= null) ? selezioneSesso.getSelectedItem().toString() : "", selezioneCentro.getSelectedIndex(), (selezioneProfessione.getSelectedItem()!= null) ? selezioneProfessione.getSelectedItem().toString() : "");
			}
		});
		bottoneRegistrati.setBounds(50, 436, 400, 50);
		pannelloDestro.add(bottoneRegistrati);
		bottoneRegistrati.setForeground(new Color(0, 0, 0));
		bottoneRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bottoneRegistrati.setBackground(new Color(255, 255, 255));
	}
}