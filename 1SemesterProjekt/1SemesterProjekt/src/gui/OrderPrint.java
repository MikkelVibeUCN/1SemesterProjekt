package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductController;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.order.Order;
import model.order.OrderLine;
import model.product.Product;

public class OrderPrint extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel centerOfOL;
	private DecimalFormat formatter = new DecimalFormat("0.00");
	
	public OrderPrint(Order order) {
		// Frame setup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2_1 = new JPanel();
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		// Orderline setup
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2_1.add(scrollPane, BorderLayout.CENTER);
		
		centerOfOL = new JPanel();
		centerOfOL.setLayout(new BoxLayout(centerOfOL, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(centerOfOL);
		
		for(OrderLine orderLine : order.getOrderLines()) {
			createOrderLine(orderLine.getProduct().getPrice(), orderLine.getQuantity(), orderLine.getSubTotal(), orderLine.getProduct().getName());
		}
		
		// 
		JPanel panel_10 = new JPanel();
		panel_2_1.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_10.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 5));
		
		JLabel lblName = new JLabel(order.getCustomerName());
		panel.add(lblName);
		
		JLabel lblCustomerType = new JLabel(order.getCustomerType());
		panel.add(lblCustomerType);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 5));
		
		JLabel lblOrderID = new JLabel("Ordre nr: " + order.getID());
		panel_3.add(lblOrderID);
		
		JLabel lblDate = new JLabel("Dato: " + order.getOrderTime());
		panel_3.add(lblDate);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblProductNameStatic = new JLabel("Produkt navn");
		panel_11.add(lblProductNameStatic);
		
		JPanel panel_9 = new JPanel();
		panel_11.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblPriceStatic = new JLabel("Pris");
		panel_9.add(lblPriceStatic);
		
		JLabel lblQuantityStatic = new JLabel("Antal");
		panel_9.add(lblQuantityStatic);
		
		JLabel lblSubTotalStatic = new JLabel("Subtotal");
		panel_9.add(lblSubTotalStatic);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JPanel panel_12 = new JPanel();
		panel_8.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_12.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_13.getLayout();
		flowLayout.setHgap(40);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_13);
		
		JLabel lblSubTotal_2Static = new JLabel("SubTotal");
		panel_13.add(lblSubTotal_2Static);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_14.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_15.add(panel_14);
		
		JLabel lblSubTotal_2 = new JLabel(formatter.format(order.getTotalSubTotal()) + " DKK");
		panel_14.add(lblSubTotal_2);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.X_AXIS));
		
		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18);
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 5));
		
		JLabel lblDiscountPercentage = new JLabel("Rabat (" + formatter.format((1 - order.getDiscountPercentage()) * 100) + "%)");
		panel_18.add(lblDiscountPercentage);
		
		JPanel panel_19 = new JPanel();
		panel_17.add(panel_19);
		panel_19.setLayout(new FlowLayout(FlowLayout.RIGHT, 40, 5));
		
		JLabel lblDiscountAmount = new JLabel(formatter.format(order.getDiscountAmount()) + " DKK");
		panel_19.add(lblDiscountAmount);
		
		JPanel panel_20 = new JPanel();
		panel_8.add(panel_20);
		panel_20.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_21 = new JPanel();
		panel_20.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.X_AXIS));
		
		JPanel panel_22 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_22.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setHgap(40);
		panel_21.add(panel_22);
		
		JLabel lblTotalStatic = new JLabel("Total");
		panel_22.add(lblTotalStatic);
		
		JPanel panel_23 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_23.getLayout();
		flowLayout_3.setHgap(40);
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_21.add(panel_23);
		
		JLabel lblTotal = new JLabel(formatter.format(order.totalPrice()) + " DKK");
		panel_23.add(lblTotal);
		
		JPanel panel_2 = new JPanel();
		panel_7.add(panel_2);
		
		JButton btnOrderCancel = new JButton("Annuller");
		panel_2.add(btnOrderCancel);
		
		JButton btnOrderConfirm = new JButton("Bekræft");
		panel_2.add(btnOrderConfirm);
	}
	
	private void createOrderLine(double price, int quantity, double subTotal, String productName) {
		JPanel panel_5 = new JPanel();
		centerOfOL.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblProductName = new JLabel(productName);
		lblProductName.setBounds(0, 0, 211, 35);
		panel_5.add(lblProductName);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(211, 0, 211, 35);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblPrice = new JLabel(formatter.format(price));
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("" + quantity);
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblQuantity);
		
		JLabel lblSubTotal = new JLabel(formatter.format(subTotal));
		lblSubTotal.setHorizontalAlignment(SwingConstants.LEFT);
		panel_6.add(lblSubTotal);
	}
}