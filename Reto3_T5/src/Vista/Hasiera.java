package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Hasiera extends JFrame {

	private JPanel Hasiera;

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
		setBounds(100, 100, 467, 324);
		Hasiera = new JPanel();
		Hasiera.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Hasiera);
		Hasiera.setLayout(null);
		
		JLabel lbl_hasiera = new JLabel("Ongi Etorri!");
		lbl_hasiera.setFont(new Font("Verdana", Font.BOLD, 20));
		lbl_hasiera.setBounds(153, 96, 143, 61);
		Hasiera.add(lbl_hasiera);
		
		JButton btn_hasiera = new JButton("");
		btn_hasiera.setBounds(0, 0, 451, 285);
		Hasiera.add(btn_hasiera);
		btn_hasiera.setOpaque(false);
		btn_hasiera.setContentAreaFilled(false);
		btn_hasiera.setBorderPainted(false);
	}
}
