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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class Registrazione extends JFrame {
	private JPanel Pannello;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Email;
	private JTextField Data_di_nascita;
	private JPasswordField Password_2;
	private JPasswordField Password_1;
	
	//Lancio dell'applicazione
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione Finestra_registrazione = new Registrazione();
					Finestra_registrazione.setLocationRelativeTo(null);
					Finestra_registrazione.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Creazione della finestra
	public Registrazione() {
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		Pannello = new JPanel();
		Pannello.setForeground(new Color(255, 255, 255));
		Pannello.setBackground(new Color(255, 255, 255));

		setContentPane(Pannello);
		Pannello.setLayout(null);
		
		JPanel Barra_del_titolo = new JPanel();
		Barra_del_titolo.setBorder(UIManager.getBorder("Tree.editorBorder"));
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
		
		//Pannello destro
		JPanel Pannello_destro = new JPanel();
		Pannello_destro.setForeground(new Color(255, 255, 255));
		Pannello_destro.setBackground(new Color(255, 255, 255));
		Pannello_destro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		Pannello_destro.setBounds(500, 0, 500, 500);
		Pannello.add(Pannello_destro);
		Pannello_destro.setLayout(null);
		
		JLabel Informazioni_professionali = new JLabel("Informazioni professionali");
		Informazioni_professionali.setForeground(new Color(0, 0, 0));
		Informazioni_professionali.setBackground(new Color(255, 255, 255));
		Informazioni_professionali.setBounds(0, 50, 500, 70);
		Pannello_destro.add(Informazioni_professionali);
		Informazioni_professionali.setHorizontalAlignment(SwingConstants.CENTER);
		Informazioni_professionali.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		JLabel Testo_1 = new JLabel("Compila i campi sottostanti con le informazioni lavorative");
		Testo_1.setVerticalAlignment(SwingConstants.TOP);
		Testo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_1.setForeground(new Color(0, 0, 0));
		Testo_1.setBackground(new Color(255, 255, 255));
		Testo_1.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_1.setBounds(0, 131, 500, 28);
		Pannello_destro.add(Testo_1);
		
		JLabel Testo_2 = new JLabel("Indicare la sede e la professione desiderate");
		Testo_2.setForeground(new Color(0, 0, 0));
		Testo_2.setBackground(new Color(255, 255, 255));
		Testo_2.setVerticalAlignment(SwingConstants.TOP);
		Testo_2.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_2.setBounds(0, 160, 500, 28);
		Pannello_destro.add(Testo_2);
		
		JLabel Testo_Sede = new JLabel("Sede");
		Testo_Sede.setForeground(new Color(0, 0, 0));
		Testo_Sede.setBackground(new Color(255, 255, 255));
		Testo_Sede.setVerticalAlignment(SwingConstants.TOP);
		Testo_Sede.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_Sede.setBounds(171, 199, 170, 28);
		Pannello_destro.add(Testo_Sede);
		Testo_Sede.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox Sede = new JComboBox();
		Sede.setForeground(new Color(0, 0, 0));
		Sede.setBounds(171, 238, 170, 28);
		Pannello_destro.add(Sede);
		Sede.setModel(new DefaultComboBoxModel(new String[] {"Sede Roma", "Sede Napoli", "Sede Parma", ""}));
		Sede.setSelectedIndex(3);
		Sede.setMaximumRowCount(4);
		Sede.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Sede.setBackground(new Color(255, 255, 255));
		
		JLabel Testo_Professione = new JLabel("Professione");
		Testo_Professione.setForeground(new Color(0, 0, 0));
		Testo_Professione.setBackground(new Color(255, 255, 255));
		Testo_Professione.setVerticalAlignment(SwingConstants.TOP);
		Testo_Professione.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_Professione.setBounds(171, 277, 170, 28);
		Pannello_destro.add(Testo_Professione);
		Testo_Professione.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JComboBox Professione = new JComboBox();
		Professione.setForeground(new Color(0, 0, 0));
		Professione.setBounds(171, 316, 170, 28);
		Pannello_destro.add(Professione);
		Professione.setModel(new DefaultComboBoxModel(new String[] {"Operatore", "Medico veterinario", "Tecnico di laboratorio", "Ricercatore", ""}));
		Professione.setSelectedIndex(4);
		Professione.setMaximumRowCount(5);
		Professione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Professione.setBackground(new Color(255, 255, 255));
		
		JButton Registrati = new JButton("Registrati");
		Registrati.setBounds(40, 390, 419, 50);
		Pannello_destro.add(Registrati);
		Registrati.setForeground(new Color(0, 0, 0));
		Registrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Registrati.setBackground(new Color(255, 255, 255));
		
		//Pannello sinistro
		JPanel Pannello_sinistro = new JPanel();
		Pannello_sinistro.setForeground(new Color(255, 255, 255));
		Pannello_sinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		Pannello_sinistro.setBackground(new Color(255, 255, 255));
		Pannello_sinistro.setBounds(0, 0, 500, 500);
		Pannello.add(Pannello_sinistro);
		Pannello_sinistro.setLayout(null);
		
		JLabel Informazioni_personali = new JLabel("Informazioni personali");
		Informazioni_personali.setForeground(new Color(0, 0, 0));
		Informazioni_personali.setBackground(new Color(255, 255, 255));
		Informazioni_personali.setHorizontalAlignment(SwingConstants.CENTER);
		Informazioni_personali.setBounds(0, 50, 500, 70);
		Informazioni_personali.setFont(new Font("Segoe UI", Font.BOLD, 25));
		Pannello_sinistro.add(Informazioni_personali);
		
		JLabel Testo_Nome = new JLabel("Nome");
		Testo_Nome.setForeground(new Color(0, 0, 0));
		Testo_Nome.setBackground(new Color(255, 255, 255));
		Testo_Nome.setVerticalAlignment(SwingConstants.TOP);
		Testo_Nome.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Nome.setBounds(39, 131, 120, 28);
		Pannello_sinistro.add(Testo_Nome);
		Testo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		Nome = new JTextField();
		Nome.setForeground(new Color(0, 0, 0));
		Nome.setBackground(new Color(255, 255, 255));
		Nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Nome.setBounds(39, 170, 170, 28);
		Pannello_sinistro.add(Nome);
		Nome.setColumns(10);
		
		JLabel Testo_Cognome = new JLabel("Cognome");
		Testo_Cognome.setForeground(new Color(0, 0, 0));
		Testo_Cognome.setBackground(new Color(255, 255, 255));
		Testo_Cognome.setVerticalAlignment(SwingConstants.TOP);
		Testo_Cognome.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Cognome.setBounds(291, 131, 120, 28);
		Pannello_sinistro.add(Testo_Cognome);
		
		Cognome = new JTextField();
		Cognome.setForeground(new Color(0, 0, 0));
		Cognome.setBackground(new Color(255, 255, 255));
		Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Cognome.setColumns(10);
		Cognome.setBounds(291, 170, 170, 28);
		Pannello_sinistro.add(Cognome);
		
		JLabel Testo_Email = new JLabel("Email");
		Testo_Email.setVerticalAlignment(SwingConstants.TOP);
		Testo_Email.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Email.setForeground(new Color(0, 0, 0));
		Testo_Email.setBackground(new Color(255, 255, 255));
		Testo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Email.setBounds(39, 209, 120, 28);
		Pannello_sinistro.add(Testo_Email);
		
		Email = new JTextField();
		Email.setForeground(new Color(0, 0, 0));
		Email.setBackground(new Color(255, 255, 255));
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Email.setColumns(10);
		Email.setBounds(39, 248, 422, 28);
		Pannello_sinistro.add(Email);
		
		JLabel Testo_Password = new JLabel("Password");
		Testo_Password.setVerticalAlignment(SwingConstants.TOP);
		Testo_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Password.setForeground(new Color(0, 0, 0));
		Testo_Password.setBackground(new Color(255, 255, 255));
		Testo_Password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Password.setBounds(39, 287, 120, 28);
		Pannello_sinistro.add(Testo_Password);
		
		Password_1 = new JPasswordField();
		Password_1.setEchoChar('*');
		Password_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Password_1.setForeground(new Color(0, 0, 0));
		Password_1.setBackground(new Color(255, 255, 255));
		Password_1.setBounds(39, 326, 170, 28);
		Pannello_sinistro.add(Password_1);
		
		JLabel Testo_Conferma_Password = new JLabel("Conferma password");
		Testo_Conferma_Password.setVerticalAlignment(SwingConstants.TOP);
		Testo_Conferma_Password.setForeground(new Color(0, 0, 0));
		Testo_Conferma_Password.setBackground(new Color(255, 255, 255));
		Testo_Conferma_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Conferma_Password.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Conferma_Password.setBounds(291, 287, 190, 28);
		Pannello_sinistro.add(Testo_Conferma_Password);
		
		Password_2 = new JPasswordField();
		Password_2.setEchoChar('*');
		Password_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Password_2.setForeground(new Color(0, 0, 0));
		Password_2.setBackground(new Color(255, 255, 255));
		Password_2.setBounds(291, 326, 170, 28);
		Pannello_sinistro.add(Password_2);
		
		Data_di_nascita = new JTextField();
		Data_di_nascita.setBackground(new Color(255, 255, 255));
		Data_di_nascita.setToolTipText("AAAA-MM-GG");
		Data_di_nascita.setForeground(new Color(0, 0, 0));
		Data_di_nascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Data_di_nascita.setColumns(10);
		Data_di_nascita.setBounds(39, 404, 170, 28);
		Pannello_sinistro.add(Data_di_nascita);
		
		JLabel Testo_Data_di_nascita = new JLabel("Data di nascita");
		Testo_Data_di_nascita.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Data_di_nascita.setVerticalAlignment(SwingConstants.TOP);
		Testo_Data_di_nascita.setForeground(new Color(0, 0, 0));
		Testo_Data_di_nascita.setBackground(new Color(255, 255, 255));
		Testo_Data_di_nascita.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Data_di_nascita.setBounds(39, 365, 170, 28);
		Pannello_sinistro.add(Testo_Data_di_nascita);
		
		JLabel Testo_Sesso = new JLabel("Sesso");
		Testo_Sesso.setVerticalAlignment(SwingConstants.TOP);
		Testo_Sesso.setHorizontalAlignment(SwingConstants.LEFT);
		Testo_Sesso.setForeground(new Color(0, 0, 0));
		Testo_Sesso.setBackground(new Color(255, 255, 255));
		Testo_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Testo_Sesso.setBounds(291, 365, 120, 28);
		Pannello_sinistro.add(Testo_Sesso);
		
		JComboBox Sesso = new JComboBox();
		Sesso.setForeground(new Color(0, 0, 0));
		Sesso.setBackground(new Color(255, 255, 255));
		Sesso.setModel(new DefaultComboBoxModel(new String[] {"Maschio", "Femmina", ""}));
		Sesso.setSelectedIndex(2);
		Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Sesso.setMaximumRowCount(3);
		Sesso.setBounds(291, 404, 170, 28);
		Pannello_sinistro.add(Sesso);
		
		JButton Indietro = new JButton("Indietro");
		Indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accesso Finestra_accesso = new Accesso();
				Finestra_accesso.setLocationRelativeTo(null);
				Finestra_accesso.setVisible(true);
				dispose();
			}
		});
		Indietro.setForeground(new Color(0, 0, 0));
		Indietro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Indietro.setBackground(new Color(255, 255, 255));
		Indietro.setBounds(160, 450, 170, 28);
		Pannello_sinistro.add(Indietro);
	}
}