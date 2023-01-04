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
					Registrazione frame = new Registrazione();
					frame.setVisible(true);
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
		
		JPanel PannelloDestro = new JPanel();
		PannelloDestro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		PannelloDestro.setBounds(528, 49, 472, 451);
		Finestra.add(PannelloDestro);
		PannelloDestro.setLayout(null);
		
		JLabel Pannello_sinistro = new JLabel("");
		Pannello_sinistro.setIcon(new ImageIcon(Registrazione.class.getResource("/Immagini/Centro recupero tartarughe marine.png")));
		Pannello_sinistro.setBounds(0, -49, 500, 500);
		PannelloDestro.add(Pannello_sinistro);
		
		JPanel PannelloSinistro = new JPanel();
		PannelloSinistro.setBorder(UIManager.getBorder("Tree.editorBorder"));
		PannelloSinistro.setBackground(new Color(255, 255, 255));
		PannelloSinistro.setBounds(0, 49, 528, 451);
		Finestra.add(PannelloSinistro);
		PannelloSinistro.setLayout(null);
		
		JLabel Testo_1 = new JLabel("Registrazione");
		Testo_1.setHorizontalAlignment(SwingConstants.CENTER);
		Testo_1.setBounds(156, 10, 219, 46);
		Testo_1.setFont(new Font("Segoe UI", Font.BOLD, 34));
		PannelloSinistro.add(Testo_1);
		
		JLabel Testo_2 = new JLabel("Compila i campi sottostanti per completare la registrazione");
		Testo_2.setBounds(79, 66, 384, 21);
		Testo_2.setFont(new Font("Segoe UI", Font.ITALIC, 15));
		PannelloSinistro.add(Testo_2);
		
		JLabel Testo_Nome = new JLabel("Nome");
		Testo_Nome.setBounds(63, 98, 60, 28);
		PannelloSinistro.add(Testo_Nome);
		Testo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		
		Nome = new JTextField();
		Nome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Nome.setBounds(63, 127, 170, 28);
		PannelloSinistro.add(Nome);
		Nome.setColumns(10);
		
		JLabel Testo_Cognome = new JLabel("Cognome");
		Testo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Cognome.setBounds(303, 97, 94, 29);
		PannelloSinistro.add(Testo_Cognome);
		
		Cognome = new JTextField();
		Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Cognome.setColumns(10);
		Cognome.setBounds(302, 127, 180, 28);
		PannelloSinistro.add(Cognome);
		
		JLabel Testo_Email = new JLabel("Email");
		Testo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Email.setBounds(64, 165, 60, 31);
		PannelloSinistro.add(Testo_Email);
		
		Email = new JTextField();
		Email.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Email.setColumns(10);
		Email.setBounds(63, 197, 419, 28);
		PannelloSinistro.add(Email);
		
		JLabel Testo_Password = new JLabel("Password");
		Testo_Password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Password.setBounds(63, 235, 99, 32);
		PannelloSinistro.add(Testo_Password);
		
		Password_1 = new JPasswordField();
		Password_1.setBounds(62, 268, 170, 28);
		PannelloSinistro.add(Password_1);
		
		JLabel Testo_Conferma_Password = new JLabel("Conferma password");
		Testo_Conferma_Password.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Conferma_Password.setBounds(301, 235, 199, 32);
		PannelloSinistro.add(Testo_Conferma_Password);
		
		Password_2 = new JPasswordField();
		Password_2.setBounds(301, 268, 180, 28);
		PannelloSinistro.add(Password_2);
		
		Data_di_nascita = new JTextField();
		Data_di_nascita.setToolTipText("AAAA-MM-GG");
		Data_di_nascita.setForeground(new Color(64, 128, 128));
		Data_di_nascita.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Data_di_nascita.setColumns(10);
		Data_di_nascita.setBounds(63, 335, 170, 28);
		PannelloSinistro.add(Data_di_nascita);
		
		JLabel Testo_Data_Nascita = new JLabel("Data di nascita");
		Testo_Data_Nascita.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Data_Nascita.setBounds(63, 306, 170, 28);
		PannelloSinistro.add(Testo_Data_Nascita);
		
		JLabel Testo_Sesso = new JLabel("Sesso");
		Testo_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		Testo_Sesso.setBounds(302, 306, 170, 28);
		PannelloSinistro.add(Testo_Sesso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Maschio", "Femmina"}));
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(302, 335, 180, 28);
		PannelloSinistro.add(comboBox);
		
		JButton Pulsante_1 = new JButton("Indietro");
		Pulsante_1.setForeground(Color.BLACK);
		Pulsante_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		Pulsante_1.setBackground(Color.WHITE);
		Pulsante_1.setBounds(10, 19, 94, 38);
		PannelloSinistro.add(Pulsante_1);
		
		JButton Registrati = new JButton("Registrati");
		Registrati.setForeground(Color.BLACK);
		Registrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		Registrati.setBackground(Color.WHITE);
		Registrati.setBounds(63, 378, 419, 50);
		PannelloSinistro.add(Registrati);
	}
}