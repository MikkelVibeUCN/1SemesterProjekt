package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderLinePanel {
	private JPanel orderLinePanel;
	private JTextField quantityField;
	private String name;
	private int quantity;
	
	public OrderLinePanel(JPanel orderLinePanel, JTextField quantityField, String name, int quantity) {
		this.orderLinePanel = orderLinePanel;
		this.quantityField = quantityField;
		this.name = name;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public JPanel getOrderLinePanel() {
		return orderLinePanel;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		quantityField.setText(Integer.toString(quantity));
	}
	
	public void setName(String name) {
		this.name = name;
	}
}