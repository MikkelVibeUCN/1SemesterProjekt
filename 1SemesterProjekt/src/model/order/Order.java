package model.order;

import java.util.ArrayList;

import model.Customer;
import model.SalesAssistant;

public class Order {
	private Customer customer;
	private SalesAssistant salesAssistant;
	
	private ArrayList<OrderLine> orderLines;
}
