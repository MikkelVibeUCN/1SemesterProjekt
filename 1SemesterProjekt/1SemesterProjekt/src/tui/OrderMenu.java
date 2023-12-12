package tui;

import java.util.Scanner;
import controller.OrderController;
import controller.ProductController;
import controller.CustomerController;
import controller.SalesAssistantController;
import model.order.Order;

public class OrderMenu {
    private OrderController orderController;
    
    private Scanner scanner;
    private Order currentOrder;

    public OrderMenu() {
        this.orderController = new OrderController();
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
    	
    	if(orderController.findCustomer(phoneNo) != null) {
    		orderController.addCustomerToOrder(phoneNo, currentOrder);
        	System.out.println("Kunde er tilføjet til ordren");
    	}
    	else {
    		System.out.println("Kunde eksisterer ikke");
    	}
    }
    
    public void addProductByBarcode() {
        boolean isCompleted = false;
        boolean hasAdded = false;
        
        while(!isCompleted) {
        	String message = "Indtast produkt barcode ";
        	if(hasAdded) {
        		message += "eller tast \"0\" for at bekræfte";
        		for(String string : currentOrder.getInfo()) {
        			System.out.println(string);
        		}
        		System.out.println();
        	} 
        	else {
        		message +=  "eller tast \"0\" for at afslutte";
        	}
           	System.out.println(message);
           	
        	int input = getIntFromUser();
        	if(input == 0) {
        		isCompleted = true;
        		
        		if(hasAdded) {
        			confirmOrder(currentOrder);
        		}
        	}
        	else {
        		System.out.println();
            	int barcode = input;
            	
            	System.out.println("Indtast antal");
            	int quantity = getIntFromUser();
            	
            	// Check quantity
    	
            	while(!orderController.isValidAmount(barcode, quantity) || quantity == 0) {
            		System.out.println("Antallet er ugyldigt, skal være over 0 og under " + orderController.getStockAmount(barcode));
            		quantity = getIntFromUser();
            	}
            	
            	orderController.removeStock(barcode, quantity);
            	
            	if(orderController.addProductByBarcode(quantity, barcode, currentOrder)) {
            		System.out.println("Produkt tilføjet");
            		hasAdded = true;
            	}
            	else {
            		System.out.println("Produkt eksisterer ikke");
            	}
        	}
        }
        
    }
 
    public void addProductBySerialNo(int serialNo) {
    	//addProductBySerialNo();
    }
    public void confirmOrder(Order order) {
    	if(orderController.confirmOrder(order)) {
    		System.out.println("Bekræfter ordre...");
    		
    		for(String s : order.getInfo()) {
        		System.out.println(s);
        	}
    		
    		System.out.println("Ordre er gemt");
    		
    	}
    	else {
    		System.out.println("Noget gik galt");
    	}
    	System.out.println();
    }
}
