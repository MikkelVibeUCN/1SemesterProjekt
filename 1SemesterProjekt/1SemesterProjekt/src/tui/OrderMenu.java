package tui;

import java.util.Scanner;
import controller.OrderController;
import controller.CustomerController;
import controller.SalesAssistantController;
import model.order.Order;

public class OrderMenu {
    private OrderController orderController;
    private CustomerController customerController;
    private SalesAssistantController salesAssistantController;
    
    private Scanner scanner;
    private Order currentOrder;

    public OrderMenu() {
        this.orderController = new OrderController();
        this.customerController = new CustomerController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
    	
        System.out.println("Ordre Menu:");
        System.out.println("1. Opret ny ordre");
        System.out.println("2. Find ordre");
        System.out.println("3. Slet ordre");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createOrder();
                addCustomerToOrder(); 
                addProductByBarcode();
                break;
            case 2:
            	//
                break;
            case 3:
            	//
                break;
            default:
                System.out.println("Ugyldigt valg");
        }
    }
        
    public int getIntFromUser() {
    	while(!scanner.hasNextInt()) {
    		System.out.println("Input skal være tal");
    		scanner.nextLine();
    	}
    	return scanner.nextInt();
    }
    
    
    public void createOrder() {
    	currentOrder = orderController.createOrder(1);
    	System.out.println("Ordre oprettet");
    }
    
    public void addCustomerToOrder() {
    	System.out.println("Indtast telefonnummer på kunde");
    	String phoneNo = scanner.next();
    	
    	if(customerController.findCustomer(phoneNo) != null) {
    		orderController.addCustomerToOrder(phoneNo, currentOrder);
        	System.out.println("Kunde er tilføjet til ordren");
    	}
    	else {
    		System.out.println("Kunde eksisterer ikke");
    	}
    }
    
    public void addProductByBarcode() {
    	System.out.println("Tilføj produkt");
    	int barcode = getIntFromUser();
    	System.out.println("Indtast antal");
    	int quantity = getIntFromUser();
    	
    	if(orderController.addProductByBarcode(quantity, barcode, currentOrder)) {
    		System.out.println("Produkt tilføjet");
    	}
    	else {
    		System.out.println("Produkt eksisterer ikke");
    	}
    	
    }
    
    public void addProductBySerialNo(int serialNo) {
    	//addProductBySerialNo();
    }
    public void confirmOrder(Order order) {
    	//confirmOrder();
    }
}
