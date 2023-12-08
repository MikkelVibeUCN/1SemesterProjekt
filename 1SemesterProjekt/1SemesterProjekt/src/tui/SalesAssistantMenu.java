package tui;

import java.util.Scanner;

import controller.SalesAssistantController;

public class SalesAssistantMenu {
    private SalesAssistantController salesAssistantController;
    private Scanner scanner;

    public SalesAssistantMenu() {
        this.salesAssistantController = new SalesAssistantController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Produkt Menu:");
        System.out.println("1. Opret Salgs Assistent");
        System.out.println("2. Find Salgs Assistent");


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