package Model.Order;

import java.util.ArrayList;

import Model.Customer;
import Model.SalesAssistant;

public class Order {
	private Customer customer;
	private SalesAssistant salesAssistant;
	
	private ArrayList<OrderLine> orderLines;
}
