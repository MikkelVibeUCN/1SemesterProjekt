package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.OrderController;

public class ordermenu extends JFrame {

	private OrderController orderController;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ordermenu frame = new ordermenu();
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
	public ordermenu() {
		orderController = new OrderController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Ordre menu");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JButton btnOrderCreate = new JButton("Opret ordre");
		
		btnOrderCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					createOrder();
			}
		});
		panel_2.add(btnOrderCreate, "name_254181741858900");
		
		JButton btnFind = new JButton("Slet ordre");
		panel_1.add(btnFind);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JButton btnDeleteOrder = new JButton("Slet ordre");
		panel_3.add(btnDeleteOrder, "name_254194213853500");
		
		JButton btnOnlineOrder = new JButton("Online ordre");
		panel_1.add(btnOnlineOrder);
	}
	
	private void createOrder() {
		this.setVisible(false);
		
		orderController.createOrder(1);
		
		new popup(orderController).setVisible(true);
	}
}