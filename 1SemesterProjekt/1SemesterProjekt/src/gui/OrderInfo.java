package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import controller.OrderController;
import controller.ProductController;
import model.order.OrderLine;

public class OrderInfo extends JFrame {
	private OrderController orderController;
	private ProductController productController;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField barcodeField;
	private JTextField quantityField;
	private JTextField textField_2;
	private JPanel centerOfOL;

	private ArrayList<OrderLinePanel> orderLinePanels;
	
	public OrderInfo(OrderController orderController) {
		productController = new ProductController();
		this.orderController = orderController;
		orderLinePanels = new ArrayList<>();
		
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
		
		barcodeField = new JTextField();
		barcodeField.setColumns(10);
		panel_3_1.add(barcodeField);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_5.add(panel_3_1_1);
		panel_3_1_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblQuantity = new JLabel("Antal");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_1_1.add(lblQuantity);
		
		quantityField = new JTextField();
		quantityField.setColumns(10);
		panel_3_1_1.add(quantityField);
		
		JPanel panel_3_2 = new JPanel();
		panel_5.add(panel_3_2);
		panel_3_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnConfirm = new JButton("Tilføj");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct();
			}
		});
		panel_3_2.add(btnConfirm);
		
		JPanel panel_2_1 = new JPanel();
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblOrderInfo = new JLabel("Ordreoversigt");
		panel_4.add(lblOrderInfo);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(100);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOrderCancel = new JButton("Annuller");
		btnOrderCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		panel_2.add(btnOrderCancel);
		
		JButton btnOrderConfirm = new JButton("Bekræft");
		btnOrderConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm();
			}
		});
		panel_2.add(btnOrderConfirm);
		
		// Orderline setup
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2_1.add(scrollPane, BorderLayout.CENTER);
		
		centerOfOL = new JPanel();
		centerOfOL.setLayout(new BoxLayout(centerOfOL, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(centerOfOL);
		
		
	}
	
	private void addProduct() {
		try {
			int barcode = Integer.parseInt(barcodeField.getText());
			int quantity = Integer.parseInt(quantityField.getText());
			
			if(orderController.addProductByBarcode(quantity, barcode)) {
				String name = productController.getNameFromBarcode(barcode);
				
				if(orderLinePanelExists(name)) {
					OrderLinePanel panel = getOrderLinePanelFromName(name);
					panel.setQuantity(panel.getQuantity() + quantity);
					panel.getOrderLinePanel().revalidate();
				}
				else {
					createOrderLine(name, quantity);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Produkt findes ikke", "Fejl", JOptionPane.PLAIN_MESSAGE);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Input skal være et tal", "Fejl", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private OrderLinePanel getOrderLinePanelFromName(String name) {
		OrderLinePanel result = null;
		int i = -1;
		boolean found = false;
		
		while(!found && ++i < orderLinePanels.size()) {
			OrderLinePanel currPanel = orderLinePanels.get(i);
			if(currPanel.getName().equals(name)) {
				result = currPanel;
				found = true;
			}
		}
		return result;
	}
	
	private boolean orderLinePanelExists(String name) {
		boolean result = false;
		if(getOrderLinePanelFromName(name) != null) {
			result = true;
		}
		return result;
	}
	
	private void createOrderLine(String name, int quantity) {
		JPanel orderlinePanel = new JPanel();
		centerOfOL.add(orderlinePanel);
		orderlinePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel orderlineLabel = new JLabel(name);
		orderlinePanel.add(orderlineLabel);
		
		textField_2 = new JTextField(Integer.toString(quantity));
		textField_2.setColumns(2);
		orderlinePanel.add(textField_2);
		
		JButton btnDelete = new JButton("Fjern");
		btnDelete.setBackground(Color.RED);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePanel(getOrderLinePanelFromName(name));
			}
		});
		
		orderlinePanel.add(btnDelete);
		
		orderlinePanel.revalidate();
		
		orderLinePanels.add(new OrderLinePanel(orderlinePanel, textField_2, name, quantity));
	}
	
	private void deletePanel(OrderLinePanel panel) {
		if(orderController.deleteOrderLine(panel.getName())) {
			JPanel currentJPanel = panel.getOrderLinePanel();
			
			currentJPanel.removeAll();
			orderLinePanels.remove(panel);
			centerOfOL.remove(currentJPanel);
			revalidate();
			repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, "Noget gik galt...", "Fejl", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private void cancel() {
		new OrderMenu().setVisible(true);
		
		dispose();
	}
	
	private void confirm() {
		if(orderController.confirmOrder()) {
			new OrderPrint(orderController.getOrder()).setVisible(true);
			
			dispose();
		}
		else 
			JOptionPane.showMessageDialog(null, "Ordren er tom", "Fejl", JOptionPane.PLAIN_MESSAGE);
	}
}