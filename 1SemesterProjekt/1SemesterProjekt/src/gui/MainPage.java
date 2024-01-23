package gui;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tui.TryMe;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		TryMe.createTestData();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnOrderMenu = new JButton("Order menu");
		btnOrderMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goOrderMenu();
			}
		});
		panel_2.add(btnOrderMenu, "name_8201971681900");
		
		JButton btnCustomerMenu = new JButton("Kunde menu");
		panel.add(btnCustomerMenu);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JButton btnProductMenu = new JButton("Produkt menu");
		panel_3.add(btnProductMenu, "name_8207516186800");
		
		JButton btnSalesAssistant = new JButton("Medarbejder menu");
		panel.add(btnSalesAssistant);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Vestbjerg byggecenter A/S");
		panel_1.add(lblNewLabel);
	}

	private void goOrderMenu() {
		setVisible(false);
		
		new ordermenu().setVisible(true);
	}	
}