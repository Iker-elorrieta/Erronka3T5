package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Model.DateLabelFormatter;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class Hasiera extends JFrame {

	private JPanel APP;
	private JTable taula_filmak;
	private JTable taula_laburpen;
	private JTextField nan_login;
	private JPasswordField pass_login;
	private JTextField textField_registroId;
	private JTextField textField_registroIzen;
	private JTextField textField_registroAbiz;
	private JTextField textField_registroNan;
	private JTextField textField_registroPas;
	JDatePickerImpl datePicker;

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
		super("Elorrieta Bideokluba");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hasiera.class.getResource("/resources/elorrieta_logo.png")));
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

		JPanel erregistratu = new JPanel();
		APP.add(erregistratu, "name_765607609293700");
		
						
		//////////////////////////////////
		// 			Label guztiak 		//
		//////////////////////////////////
		JLabel lbl_zinemak = new JLabel("Zinemak");
		lbl_zinemak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_zinemak.setBounds(299, 24, 75, 24);
		zinemak.add(lbl_zinemak);
		
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
		
		JLabel lbl_datak = new JLabel("Datak");
		lbl_datak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_datak.setBounds(286, 22, 55, 24);
		datak.add(lbl_datak);
		
		JLabel lbl_saioak = new JLabel("Saioak");
		lbl_saioak.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_saioak.setBounds(278, 24, 55, 24);
		saioak.add(lbl_saioak);
		
		JLabel lbl_ordutegi = new JLabel("Ordutegiak:");
		lbl_ordutegi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_ordutegi.setBounds(187, 104, 85, 30);
		saioak.add(lbl_ordutegi);
		
		JLabel lbl_aretoak = new JLabel("Aretoak:");
		lbl_aretoak.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_aretoak.setBounds(187, 169, 85, 30);
		saioak.add(lbl_aretoak);
		
		JLabel lbl_prezio = new JLabel("Prezioa:");
		lbl_prezio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_prezio.setBounds(187, 229, 85, 30);
		saioak.add(lbl_prezio);
		
		JLabel lbl_prezioa = new JLabel("New label");
		lbl_prezioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_prezioa.setBounds(278, 232, 150, 24);
		saioak.add(lbl_prezioa);		

		JLabel lbl_laburpen = new JLabel("Laburpena");
		lbl_laburpen.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_laburpen.setBounds(280, 31, 87, 30);
		laburpena.add(lbl_laburpen);
		
		JLabel lbl_login = new JLabel("Login");
		lbl_login.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_login.setBounds(300, 28, 49, 30);
		login.add(lbl_login);
		
		JLabel lbl_nan = new JLabel("NAN:");
		lbl_nan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_nan.setBounds(236, 129, 54, 24);
		login.add(lbl_nan);
		
		JLabel lbl_pass = new JLabel("Pasahitza:");
		lbl_pass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_pass.setBounds(223, 185, 76, 24);
		login.add(lbl_pass);	
		erregistratu.setLayout(null);
		
		JLabel lbl_erregistratu = new JLabel("Erregistratu");
		lbl_erregistratu.setBounds(272, 26, 99, 30);
		lbl_erregistratu.setFont(new Font("Tahoma", Font.BOLD, 15));
		erregistratu.add(lbl_erregistratu);
		
		JLabel lbl_id = new JLabel("ID:");
		lbl_id.setBounds(228, 67, 27, 30);
		lbl_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		erregistratu.add(lbl_id);
		
		JLabel izena_registro = new JLabel("Izena:");
		izena_registro.setBounds(228, 102, 51, 30);
		izena_registro.setFont(new Font("Tahoma", Font.BOLD, 14));
		erregistratu.add(izena_registro);
		
		JLabel abizena_registro = new JLabel("Abizena:");
		abizena_registro.setBounds(228, 136, 59, 30);
		abizena_registro.setFont(new Font("Tahoma", Font.BOLD, 14));
		erregistratu.add(abizena_registro);
		
		JLabel nan_registro = new JLabel("NAN:");
		nan_registro.setBounds(228, 215, 37, 30);
		nan_registro.setFont(new Font("Tahoma", Font.BOLD, 14));
		erregistratu.add(nan_registro);
		
		JLabel pass_registro = new JLabel("Pasahitza:");
		pass_registro.setBounds(228, 249, 70, 30);
		pass_registro.setFont(new Font("Tahoma", Font.BOLD, 14));
		erregistratu.add(pass_registro);		

		JLabel lbl_sexua = new JLabel("Sexua:");
		lbl_sexua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_sexua.setBounds(228, 171, 59, 30);
		erregistratu.add(lbl_sexua);
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
		
		//Zinemen botoiak sortu
		Connection conn;
		String[][] botoi_zinemak = new String[3][2];
		try {
			String url = "jdbc:mysql://localhost:3306/db_zinema";
			conn = (Connection) DriverManager.getConnection (url, "root","");
			Statement comando = (Statement) conn.createStatement();						
			
			ResultSet request = comando.executeQuery("SELECT bounds,route FROM zinema");
			
			int cont=0;
			while(request.next()) {
				botoi_zinemak[cont][0]=request.getString(1);
				botoi_zinemak[cont][1]=request.getString(2);
				cont++;
			}
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("ErrorCode: "+ ex.getErrorCode());
		}
		
		for(int j=0;j<botoi_zinemak.length;j++) {
			ImageIcon logo_zubi = new ImageIcon(new ImageIcon(botoi_zinemak[j][1]).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
			JButton btn_zine = new JButton(logo_zubi);
			btn_zine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					zinemak.setVisible(false);
					filmak.setVisible(true);
				}
			});
			String[] bounds = botoi_zinemak[j][0].split(",");
			btn_zine.setBounds(Integer.parseInt(bounds[0]), Integer.parseInt(bounds[1]), Integer.parseInt(bounds[2]), Integer.parseInt(bounds[3]));
			zinemak.add(btn_zine);
			btn_zine.setOpaque(false);
			btn_zine.setContentAreaFilled(false);
			btn_zine.setBorderPainted(false);
		}
		
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
		btn_aurrera_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datak.setVisible(false);
				saioak.setVisible(true);
			}
		});
		btn_aurrera_2.setBounds(596, 332, 44, 30);
		datak.add(btn_aurrera_2);
		btn_aurrera_2.setIcon(logo_aurrera);
		btn_aurrera_2.setOpaque(false);
		btn_aurrera_2.setContentAreaFilled(false);
		btn_aurrera_2.setBorderPainted(false);
		
		
		UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //Date min = new Date(2023, 3,3);
        //datePicker.setMinDate(min.getTime());
       /* datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });*/
        
        datePicker.setLocation(255, 81);
        datePicker.setSize(125, 30);
        
        datak.add(datePicker);
		
		
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
		btn_aurrera_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saioak.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		btn_aurrera_3.setOpaque(false);
		btn_aurrera_3.setContentAreaFilled(false);
		btn_aurrera_3.setBorderPainted(false);
		btn_aurrera_3.setBounds(596, 332, 44, 30);
		saioak.add(btn_aurrera_3);
		btn_aurrera_3.setIcon(logo_aurrera);
		
		JButton btn_atzera_4 = new JButton("");
		btn_atzera_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laburpena.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		btn_atzera_4.setOpaque(false);
		btn_atzera_4.setContentAreaFilled(false);
		btn_atzera_4.setBorderPainted(false);
		btn_atzera_4.setBounds(10, 332, 44, 30);
		laburpena.add(btn_atzera_4);
		btn_atzera_4.setIcon(logo_atzera);
		
		JButton btn_aurrera_4 = new JButton("");
		btn_aurrera_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laburpena.setVisible(false);
				login.setVisible(true);
			}
		});
		btn_aurrera_4.setOpaque(false);
		btn_aurrera_4.setContentAreaFilled(false);
		btn_aurrera_4.setBorderPainted(false);
		btn_aurrera_4.setBounds(596, 332, 44, 30);
		laburpena.add(btn_aurrera_4);
		btn_aurrera_4.setIcon(logo_aurrera);
		
		JButton btn_erregistratu = new JButton("Erregistratu");
		btn_erregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				erregistratu.setVisible(true);
			}
		});
		btn_erregistratu.setBounds(274, 258, 110, 23);
		login.add(btn_erregistratu);		

		JButton btn_erregistratuOk = new JButton("Erregistratu");
		btn_erregistratuOk.setBounds(203, 315, 109, 23);
		erregistratu.add(btn_erregistratuOk);
		
		JButton btn_loginRegistro = new JButton("Login");
		btn_loginRegistro.setBounds(354, 315, 89, 23);
		btn_loginRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erregistratu.setVisible(false);
				login.setVisible(true);
			}
		});
		erregistratu.add(btn_loginRegistro);

		ImageIcon homeicon = new ImageIcon(new ImageIcon("src/resources/casa.png").getImage().getScaledInstance(44, 34,Image.SCALE_DEFAULT));
		JButton btn_etxea_1 = new JButton(homeicon);
		btn_etxea_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		btn_etxea_1.setBounds(10, 11, 44, 34);
		login.add(btn_etxea_1);
		btn_etxea_1.setOpaque(false);
		btn_etxea_1.setContentAreaFilled(false);
		btn_etxea_1.setBorderPainted(false);
		
		JButton btn_etxea_2 = new JButton(homeicon);
		btn_etxea_2.setBounds(10, 11, 44, 34);
		btn_etxea_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erregistratu.setVisible(false);
				zinemak.setVisible(true);
			}
		});
		erregistratu.add(btn_etxea_2);
		btn_etxea_2.setOpaque(false);
		btn_etxea_2.setContentAreaFilled(false);
		btn_etxea_2.setBorderPainted(false);
		
		//////////////////////////////////
		// 			Taula guztiak		 //
		//////////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 61, 365, 215);
		filmak.add(scrollPane);		
		taula_filmak = new JTable();
		scrollPane.setViewportView(taula_filmak);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(89, 80, 469, 206);
		laburpena.add(scrollPane_1);		
		taula_laburpen = new JTable();
		scrollPane_1.setViewportView(taula_laburpen);
		
		
		//////////////////////////////////
		// 		Combo Box guztiak		//
		//////////////////////////////////
		JComboBox comboBox_filmak = new JComboBox();
		comboBox_filmak.setBounds(535, 58, 71, 22);
		filmak.add(comboBox_filmak);
		
		JComboBox comboBox_ordutegi = new JComboBox();
		comboBox_ordutegi.setBounds(282, 110, 146, 22);
		saioak.add(comboBox_ordutegi);
		
		JComboBox comboBox_aretoak = new JComboBox();
		comboBox_aretoak.setBounds(282, 175, 146, 22);
		saioak.add(comboBox_aretoak);		
		
		JComboBox comboBox_sexua = new JComboBox();
		comboBox_sexua.setBounds(315, 181, 86, 22);
		erregistratu.add(comboBox_sexua);		
		
		//////////////////////////////////
		// 		JTextField guztiak		//
		//////////////////////////////////
		
		nan_login = new JTextField();
		nan_login.setBounds(300, 133, 105, 20);
		login.add(nan_login);
		nan_login.setColumns(10);
		
		pass_login = new JPasswordField();
		pass_login.setBounds(309, 189, 96, 20);
		login.add(pass_login);
				
		textField_registroId = new JTextField();
		textField_registroId.setBounds(315, 74, 86, 20);
		erregistratu.add(textField_registroId);
		textField_registroId.setColumns(10);
		
		textField_registroIzen = new JTextField();
		textField_registroIzen.setBounds(315, 109, 86, 20);
		textField_registroIzen.setColumns(10);
		erregistratu.add(textField_registroIzen);
		
		textField_registroAbiz = new JTextField();
		textField_registroAbiz.setBounds(315, 143, 86, 20);
		textField_registroAbiz.setColumns(10);
		erregistratu.add(textField_registroAbiz);
		
		textField_registroNan = new JTextField();
		textField_registroNan.setBounds(315, 222, 86, 20);
		textField_registroNan.setColumns(10);
		erregistratu.add(textField_registroNan);
		
		textField_registroPas = new JTextField();
		textField_registroPas.setBounds(315, 256, 86, 20);
		textField_registroPas.setColumns(10);
		erregistratu.add(textField_registroPas);
		
	}
}
