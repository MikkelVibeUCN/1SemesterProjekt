package tui;

import java.util.Scanner;

import controller.OrderController;

public class OrderMenu {
    private OrderController orderController;
    private Scanner scanner;

    public OrderMenu() {
        this.orderController = new OrderController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
    	
        System.out.println("Ordre Menu:");
        System.out.println("1. Create Order");

        System.out.print("Hvad vil du?: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // createOrder();
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
    public void createOrder(int employeeID) {
    	//createOrder();
    }
    public void addCustomerToOrder(String phoneNo, Order order) {
    	//addCustomerToOrder();
    }
    public void addProductByBarcode(int Barcode) {
    	//addProductToOrder();
    }
    public void addProductBySerialNo(int serialNo) {
    	//addProductBySerialNo();
    }
    public void confirmOrder(Order order) {
    	//confirmOrder();
    }
}
