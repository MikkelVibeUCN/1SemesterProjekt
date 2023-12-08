package tui;

import java.util.Scanner;

import controller.CustomerController;

public class CustomerMenu {
    private CustomerController customerController;
    private Scanner scanner;

    public CustomerMenu() {
        this.customerController = new CustomerController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Kunde Menu:");
        System.out.println("1. Opret Kunde");
        System.out.println("2. Find Kunde");


        System.out.print("Hvad vil du?: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                //
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
}