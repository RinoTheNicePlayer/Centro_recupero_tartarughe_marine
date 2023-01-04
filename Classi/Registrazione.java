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

	static JFrame Registrazione;
	private JPanel Finestra;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Email;
	private JTextField Data_di_nascita;
	private JPasswordField Password_2;
	private JPasswordField Password_1;


	// Lancio l'applicazione
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione Finestra_registrazione = new Registrazione();
					Finestra_registrazione.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//Creazione del frame
	
	public Registrazione() {
		
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		Finestra = new JPanel();
		Finestra.setBackground(new Color(255, 255, 255));

		setContentPane(Finestra);
		Finestra.setLayout(null);
		
		JPanel Barra_del_titolo = new JPanel();
		Barra_del_titolo.setBorder(UIManager.getBorder("Tree.editorBorder"));
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
		
		//Pannello destro
		
		JPanel PannelloDestro = new JPanel();
		PannelloDestro.setBackground(new Color(255, 255, 255));
		PannelloDestro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		PannelloDestro.setBounds(494, 49, 506, 451);
		Finestra.add(PannelloDestro);
		PannelloDestro.setLayout(null);
		
		JLabel Testo_Professione = new JLabel("Professione");
		Testo_Professione.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Professione.setBounds(158, 227, 170, 28);
		PannelloDestro.add(Testo_Professione);
		
		JLabel Testo_3 = new JLabel("Compila i campi sottostanti con le informazioni lavorative");
		Testo_3.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_3.setBounds(57, 15, 399, 28);
		PannelloDestro.add(Testo_3);
		
		JLabel Testo_4 = new JLabel("relative al centro di appartenenza");
		Testo_4.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		Testo_4.setBounds(135, 40, 235, 28);
		PannelloDestro.add(Testo_4);
		
		JLabel Testo_Centro = new JLabel("Centro lavorativo");
		Testo_Centro.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Centro.setBounds(158, 119, 170, 28);
		PannelloDestro.add(Testo_Centro);
		
		JComboBox Scelta_Professione_1 = new JComboBox();
		Scelta_Professione_1.setModel(new DefaultComboBoxModel(new String[] {"Sede Roma", "Sede Napoli", "Sede Parma"}));
		Scelta_Professione_1.setMaximumRowCount(3);
		Scelta_Professione_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Scelta_Professione_1.setBackground(Color.WHITE);
		Scelta_Professione_1.setBounds(158, 148, 180, 44);
		PannelloDestro.add(Scelta_Professione_1);
		
		JLabel Testo_2 = new JLabel("Informazioni professionali");
		Testo_2.setBounds(120, 78, 314, 31);
		PannelloDestro.add(Testo_2);
		Testo_2.setVerticalAlignment(SwingConstants.TOP);
		Testo_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JComboBox Scelta_Professione = new JComboBox();
		Scelta_Professione.setModel(new DefaultComboBoxModel(new String[] {"Operatore", "Medico veterinario", "Tecnico di laboratorio", "Ricercatore"}));
		Scelta_Professione.setMaximumRowCount(4);
		Scelta_Professione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Scelta_Professione.setBackground(Color.WHITE);
		Scelta_Professione.setBounds(158, 256, 180, 44);
		PannelloDestro.add(Scelta_Professione);
		
		JButton Registrati = new JButton("Registrati");
		Registrati.setBounds(37, 357, 419, 50);
		PannelloDestro.add(Registrati);
		Registrati.setForeground(Color.BLACK);
		Registrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Registrati.setBackground(Color.WHITE);
		
		//Pannello sinistro
		
		JPanel PannelloSinistro = new JPanel();
		PannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		PannelloSinistro.setBackground(new Color(255, 255, 255));
		PannelloSinistro.setBounds(0, 49, 495, 451);
		Finestra.add(PannelloSinistro);
		PannelloSinistro.setLayout(null);
		
		JButton Pulsante_1 = new JButton("Torna al Log-in");
		Pulsante_1.setForeground(Color.BLACK);
		Pulsante_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Pulsante_1.setBackground(Color.WHITE);
		Pulsante_1.setBounds(135, 20, 205, 38);
		PannelloSinistro.add(Pulsante_1);
		
		Pulsante_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel Testo_1 = new JLabel("Informazioni personali");
		Testo_1.setVerticalAlignment(SwingConstants.TOP);
		Testo_1.setBounds(132, 78, 228, 41);
		Testo_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		PannelloSinistro.add(Testo_1);
		
		JLabel Testo_Nome = new JLabel("Nome");
		Testo_Nome.setBounds(41, 120, 60, 28);
		PannelloSinistro.add(Testo_Nome);
		Testo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		Nome = new JTextField();
		Nome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Nome.setBounds(41, 149, 170, 28);
		PannelloSinistro.add(Nome);
		Nome.setColumns(10);
		
		JLabel Testo_Cognome = new JLabel("Cognome");
		Testo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Cognome.setBounds(281, 119, 94, 29);
		PannelloSinistro.add(Testo_Cognome);
		
		Cognome = new JTextField();
		Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Cognome.setColumns(10);
		Cognome.setBounds(280, 149, 180, 28);
		PannelloSinistro.add(Cognome);
		
		JLabel Testo_Email = new JLabel("Email");
		Testo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Email.setBounds(42, 187, 60, 31);
		PannelloSinistro.add(Testo_Email);
		
		Email = new JTextField();
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Email.setColumns(10);
		Email.setBounds(41, 219, 419, 28);
		PannelloSinistro.add(Email);
		
		JLabel Testo_Password = new JLabel("Password");
		Testo_Password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Password.setBounds(42, 267, 99, 32);
		PannelloSinistro.add(Testo_Password);
		
		Password_1 = new JPasswordField();
		Password_1.setBounds(41, 300, 170, 28);
		PannelloSinistro.add(Password_1);
		
		JLabel Testo_Conferma_Password = new JLabel("Conferma password");
		Testo_Conferma_Password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Conferma_Password.setBounds(280, 267, 199, 32);
		PannelloSinistro.add(Testo_Conferma_Password);
		
		Password_2 = new JPasswordField();
		Password_2.setBounds(280, 300, 180, 28);
		PannelloSinistro.add(Password_2);
		
		Data_di_nascita = new JTextField();
		Data_di_nascita.setToolTipText("AAAA-MM-GG");
		Data_di_nascita.setForeground(new Color(64, 128, 128));
		Data_di_nascita.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Data_di_nascita.setColumns(10);
		Data_di_nascita.setBounds(40, 375, 170, 28);
		PannelloSinistro.add(Data_di_nascita);
		
		JLabel Testo_Data_Nascita = new JLabel("Data di nascita");
		Testo_Data_Nascita.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Data_Nascita.setBounds(40, 346, 170, 28);
		PannelloSinistro.add(Testo_Data_Nascita);
		
		JLabel Testo_Sesso = new JLabel("Sesso");
		Testo_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Sesso.setBounds(279, 346, 170, 28);
		PannelloSinistro.add(Testo_Sesso);
		
		JComboBox Scelta_Sesso = new JComboBox();
		Scelta_Sesso.setBackground(new Color(255, 255, 255));
		Scelta_Sesso.setModel(new DefaultComboBoxModel(new String[] {"Maschio", "Femmina"}));
		Scelta_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Scelta_Sesso.setMaximumRowCount(2);
		Scelta_Sesso.setBounds(279, 375, 180, 28);
		PannelloSinistro.add(Scelta_Sesso);
		
	}
}