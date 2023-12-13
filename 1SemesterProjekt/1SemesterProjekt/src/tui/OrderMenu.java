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
                addProduct();
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
    	
    	System.out.println(orderController.addCustomerToOrder(phoneNo));
    }
    
    public void addProductByBarcode(int barcode) {
    	System.out.println("Indtast antal");
    	int quantity = getIntFromUser();
    	
    	while(quantity <= 0) {
    		System.out.println("Antallet er ugyldigt, skal være over 0");
    		quantity = getIntFromUser();
    	}
    	
    	System.out.println(orderController.stockMessage(barcode, quantity));
    	
    	if(orderController.addProductByBarcode(quantity, barcode)) {
    		System.out.println("Produkt tilføjet");
    	}
    	else {
    		System.out.println("Produkt eksisterer ikke");
    	}
    }
 
    public void addProductBySerialNo(int barcode, int serialNo) {   	
    	if(orderController.addProductBySerialNo(barcode, serialNo)) {
    		System.out.println("Produkt tilføjet");
    	}
    	else {
    		System.out.println("Produkt eksisterer ikke");
    	}     
    }
    
    public boolean confirmOrder(Order order) {
    	boolean result = orderController.confirmOrder();
    	
    	if(result) {
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
    	
    	return result;
    }
    
    public void addProduct() {
    	boolean isCompleted = false;
        
        while(!isCompleted) {
        	for(String string : currentOrder.getInfo()) {
    			System.out.println(string);
    		}
        	System.out.println(orderController.introMessage());
           	
        	int input = getIntFromUser();
        	if(input == 0) {
        		isCompleted = true;
        		
        		if(confirmOrder(currentOrder)) {
        			System.out.println("Ordre bekræftet");
        		}
        		else {
        			System.out.println("Et eller andet gik galt, prøv igen");
        		}
        	}
        	else {
        		System.out.println();
            	int barcode = input;
            	
            	System.out.println("Tast serienummer eller tryk \"0\" for at fortsætte");
            	
            	scanner.nextLine();
            	
            	input = getIntFromUser();
            	
            	if(input != 0) {
            		addProductBySerialNo(barcode, input);
            	}
            	else {
            		addProductByBarcode(barcode);
            	}           	
        	}
        }
    }
}
