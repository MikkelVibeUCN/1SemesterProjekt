package tui;

import java.util.Scanner;

import controller.OrderController;
import controller.CustomerController;
import model.order.Order;

public class OrderMenu {
    private OrderController orderController;
    private CustomerController customerController;
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

        System.out.print("Hvad vil du?: ");
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
    	}
    	return scanner.nextInt();
    }
    
    
    public void createOrder() {
    	System.out.println("Indtast medarbejder ID");
    	int employeeID = getIntFromUser();
    	currentOrder = orderController.createOrder(employeeID);
    	System.out.println("Ordre oprettet");
    }
    
    public void addCustomerToOrder() {
    	if(currentOrder == null) {
    		System.out.println("Der er ingen igangværende ordre");
    	}
    	System.out.println("Indtast telefonnummer på kunde");
    	String phoneNo = scanner.nextLine();
    	customerController.findCustomer(phoneNo);
    	
    	if(orderController.addCustomerToOrder(phoneNo, currentOrder)){
    		System.out.println("Kunde er tilføjet til ordren");
    	
    	} 
    	else {
    		System.out.println("Kunde eksisterer ikke");
    	}
    }
    
    public void addProductByBarcode() {
    	System.out.println("Tilføj produkt");
    	int barcode = scanner.nextInt(getIntFromUser());
    	System.out.println("Indtast antal");
    	int quantity = scanner.nextInt(getIntFromUser());
    	
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
