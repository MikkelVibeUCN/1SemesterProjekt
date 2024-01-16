package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import java.awt.Color;

public class orderinfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderinfo frame = new orderinfo();
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
	public orderinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_5.add(panel_3_1);
		panel_3_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblBarcode = new JLabel("Varenummer");
		panel_3_1.add(lblBarcode);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3_1.add(textField);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_5.add(panel_3_1_1);
		panel_3_1_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblQuantity = new JLabel("Antal");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1_1.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3_1_1.add(textField_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_5.add(panel_3_2);
		panel_3_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnConfirm = new JButton("Tilføj");
		panel_3_2.add(btnConfirm);
		
		JPanel panel_2_1 = new JPanel();
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblOrderInfo = new JLabel("Ordreoversigt");
		panel_4.add(lblOrderInfo);
		
		// Orderlines
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2_1.add(scrollPane, BorderLayout.CENTER);
		
		JPanel centerOfOL = new JPanel();
		centerOfOL.setLayout(new BoxLayout(centerOfOL, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(centerOfOL);
		
		for(int i = 0; i < 10; i++) {
			
			JPanel orderlinePane = new JPanel();
			centerOfOL.add(orderlinePane);
			orderlinePane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel orderlineLabel = new JLabel("test");
			orderlinePane.add(orderlineLabel);
			
			JLabel lblNewLabel = new JLabel("Antal:");
			orderlinePane.add(lblNewLabel);
			
			textField_2 = new JTextField();
			textField_2.setColumns(2);
			orderlinePane.add(textField_2);
			
			JButton btnDelete = new JButton("Fjern");
			btnDelete.setBackground(Color.RED);
			orderlinePane.add(btnDelete);
			System.out.print("sdada");
		}		
	}

}
