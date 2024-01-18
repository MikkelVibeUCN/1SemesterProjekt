package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OrderLinePanel {
	private JPanel orderLinePanel;
	private JTextField quantityField;
	private String name;
	private int quantity;
	private int positionIndex;
	
	public OrderLinePanel(JPanel orderLinePanel, JTextField quantityField, String name, int quantity, int positionIndex) {
		this.orderLinePanel = orderLinePanel;
		this.quantityField = quantityField;
		this.name = name;
		this.quantity = quantity;
		this.positionIndex = positionIndex;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getPosistionIndex() {
		return positionIndex;
	}
	
	public String getName() {
		return name;
	}
	
	public JPanel getOrderLinePanel() {
		return orderLinePanel;
	}
	
	public void setPositionIndex(int index) {
		this.positionIndex = index;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		quantityField.setText(Integer.toString(quantity));
	}
	
	public void setName(String name) {
		this.name = name;
	}
}