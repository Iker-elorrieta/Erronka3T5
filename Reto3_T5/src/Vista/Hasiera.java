package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class Hasiera extends JFrame {

	private JPanel APP;
	private JTable taula_filmak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hasiera frame = new Hasiera();
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
	public Hasiera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 422);
		APP = new JPanel();
		APP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(APP);
		APP.setLayout(new CardLayout(0, 0));
		
		//Panelak
		JPanel ongi_etorri = new JPanel();
		APP.add(ongi_etorri, "name_689304451220100");
		ongi_etorri.setLayout(null);
		
		JPanel zinemak = new JPanel();
		APP.add(zinemak, "name_689953724398500");
		zinemak.setLayout(null);
		
		JLabel lbl_zinemak = new JLabel("Zinemak");
		lbl_zinemak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_zinemak.setBounds(299, 24, 75, 24);
		zinemak.add(lbl_zinemak);
		
		JPanel filmak = new JPanel();
		APP.add(filmak, "name_689955089247300");
		filmak.setLayout(null);
		
		
		JPanel datak = new JPanel();
		APP.add(datak, "name_689957039953600");
		datak.setLayout(null);
				
		JPanel saioak = new JPanel();
		APP.add(saioak, "name_689958848377900");
		saioak.setLayout(null);
		
			
		JPanel laburpena = new JPanel();
		APP.add(laburpena, "name_689960384523100");
		laburpena.setLayout(null);
		
		JPanel login = new JPanel();
		APP.add(login, "name_689963400782600");
		login.setLayout(null);
				
		//////////////////////////////////
		// 			Label guztiak 		//
		//////////////////////////////////

		JLabel lbl_elorrieta = new JLabel("");
		lbl_elorrieta.setBounds(124, 135, 392, 151);
		ongi_etorri.add(lbl_elorrieta);
		ImageIcon icon_elorieta = new ImageIcon("src/resources/elorrieta.png");
		Image img = icon_elorieta.getImage();
		Image imgScale = img.getScaledInstance(lbl_elorrieta.getWidth(), lbl_elorrieta.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		lbl_elorrieta.setIcon(scaledIcon);
		
		
		JLabel lbl_ongietorri = new JLabel("Ongi Etorri!");
		lbl_ongietorri.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_ongietorri.setBounds(253, 69, 122, 55);
		ongi_etorri.add(lbl_ongietorri);		
		
		JLabel lbl_filmak = new JLabel("Filmak");
		lbl_filmak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_filmak.setBounds(286, 26, 55, 24);
		filmak.add(lbl_filmak);
		
		//////////////////////////////////
		// 			Botoi guztiak		 //
		//////////////////////////////////
		JButton btn_ongietorri = new JButton("");
		btn_ongietorri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongi_etorri.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		btn_ongietorri.setBounds(0, 0, 650, 373);
		ongi_etorri.add(btn_ongietorri);
		btn_ongietorri.setOpaque(false);
		btn_ongietorri.setContentAreaFilled(false);
		btn_ongietorri.setBorderPainted(false);
		

		ImageIcon logo_zubi = new ImageIcon(new ImageIcon("src/resources/zubi.png").getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		JButton btn_zubi = new JButton(logo_zubi);
		btn_zubi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zinemak.setVisible(false);
				filmak.setVisible(true);
			}
		});
		btn_zubi.setBounds(10, 69, 199, 168);
		zinemak.add(btn_zubi);
		btn_zubi.setOpaque(false);
		btn_zubi.setContentAreaFilled(false);
		btn_zubi.setBorderPainted(false);
		
		ImageIcon logo_max = new ImageIcon(new ImageIcon("src/resources/max_cinesa.png").getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		JButton btn_max = new JButton(logo_max);
		btn_max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zinemak.setVisible(false);
				filmak.setVisible(true);
			}
		});
		btn_max.setBounds(219, 69, 199, 168);
		zinemak.add(btn_max);
		btn_max.setOpaque(false);
		btn_max.setContentAreaFilled(false);
		btn_max.setBorderPainted(false);
		
		ImageIcon logo_alho = new ImageIcon(new ImageIcon("src/resources/golem.png").getImage().getScaledInstance(180,150,Image.SCALE_DEFAULT));
		JButton btn_alhon = new JButton(logo_alho);
		btn_alhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zinemak.setVisible(false);
				filmak.setVisible(true);
			}
		});
		btn_alhon.setBounds(428, 69, 212, 168);
		zinemak.add(btn_alhon);
		btn_alhon.setOpaque(false);
		btn_alhon.setContentAreaFilled(false);
		btn_alhon.setBorderPainted(false);
		
		JButton btn_amaitu = new JButton("Amaitu");
		btn_amaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zinemak.setVisible(false);
				laburpena.setVisible(true);
			}
		});
		btn_amaitu.setBounds(288, 313, 89, 23);
		zinemak.add(btn_amaitu);
		
		JButton btn_atzera_1 = new JButton("");
		btn_atzera_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmak.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		btn_atzera_1.setBounds(10, 332, 44, 30);
		filmak.add(btn_atzera_1);
		ImageIcon logo_atzera = new ImageIcon(new ImageIcon("src/resources/flecha_atras.png").getImage().getScaledInstance(btn_atzera_1.getWidth(),btn_atzera_1.getHeight(),Image.SCALE_DEFAULT));
		btn_atzera_1.setIcon(logo_atzera);
		btn_atzera_1.setOpaque(false);
		btn_atzera_1.setContentAreaFilled(false);
		btn_atzera_1.setBorderPainted(false);
		
		JButton btn_aurrera_1 = new JButton("");
		btn_aurrera_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmak.setVisible(false);
				datak.setVisible(true);
			}
		});
		btn_aurrera_1.setBounds(596, 332, 44, 30);
		filmak.add(btn_aurrera_1);
		ImageIcon logo_aurrera = new ImageIcon(new ImageIcon("src/resources/flecha_alante.png").getImage().getScaledInstance(btn_aurrera_1.getWidth(),btn_aurrera_1.getHeight(),Image.SCALE_DEFAULT));
		btn_aurrera_1.setIcon(logo_aurrera);
		btn_aurrera_1.setOpaque(false);
		btn_aurrera_1.setContentAreaFilled(false);
		btn_aurrera_1.setBorderPainted(false);
		

		JButton btn_atzera_2 = new JButton("");
		btn_atzera_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datak.setVisible(false);
				filmak.setVisible(true);
			}
		});
		btn_atzera_2.setBounds(10, 332, 44, 30);
		datak.add(btn_atzera_2);
		btn_atzera_2.setIcon(logo_atzera);
		btn_atzera_2.setOpaque(false);
		btn_atzera_2.setContentAreaFilled(false);
		btn_atzera_2.setBorderPainted(false);
		
		
		JButton btn_aurrera_2 = new JButton("");
		btn_aurrera_2.setBounds(596, 332, 44, 30);
		datak.add(btn_aurrera_2);
		btn_aurrera_2.setIcon(logo_aurrera);
		btn_aurrera_2.setOpaque(false);
		btn_aurrera_2.setContentAreaFilled(false);
		btn_aurrera_2.setBorderPainted(false);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setEditable(false);
		formattedTextField.setBounds(255, 81, 125, 20);
		datak.add(formattedTextField);
		
		JLabel lbl_datak = new JLabel("Datak");
		lbl_datak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_datak.setBounds(286, 22, 55, 24);
		datak.add(lbl_datak);
		
		JButton btn_atzera_3 = new JButton("");
		btn_atzera_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saioak.setVisible(false);
				datak.setVisible(true);
			}
		});
		btn_atzera_3.setOpaque(false);
		btn_atzera_3.setContentAreaFilled(false);
		btn_atzera_3.setBorderPainted(false);
		btn_atzera_3.setBounds(10, 332, 44, 30);
		saioak.add(btn_atzera_3);
		btn_atzera_3.setIcon(logo_atzera);
		
		JButton btn_aurrera_3 = new JButton("");
		btn_aurrera_3.setOpaque(false);
		btn_aurrera_3.setContentAreaFilled(false);
		btn_aurrera_3.setBorderPainted(false);
		btn_aurrera_3.setBounds(596, 332, 44, 30);
		saioak.add(btn_aurrera_3);
		btn_aurrera_3.setIcon(logo_aurrera);
		
		JLabel lbl_saioak = new JLabel("Saioak");
		lbl_saioak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_saioak.setBounds(278, 24, 55, 24);
		saioak.add(lbl_saioak);
		
		//////////////////////////////////
		// 			Taula guztiak		 //
		//////////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 61, 365, 215);
		filmak.add(scrollPane);
		
		taula_filmak = new JTable();
		scrollPane.setViewportView(taula_filmak);
		
		
		//////////////////////////////////
		// 		Combo Box guztiak		//
		//////////////////////////////////
		JComboBox comboBox_filmak = new JComboBox();
		comboBox_filmak.setBounds(535, 58, 71, 22);
		filmak.add(comboBox_filmak);
		
	}
}
