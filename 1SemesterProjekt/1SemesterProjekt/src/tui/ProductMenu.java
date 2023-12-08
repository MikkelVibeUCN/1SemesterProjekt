package tui;

import java.util.Scanner;

import controller.ProductController;

public class ProductMenu {
    private ProductController productController;
    private Scanner scanner;

    public ProductMenu() {
        this.productController = new ProductController();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Produkt Menu:");
        System.out.println("1. Opret Produkt");
        System.out.println("2. Find Produkt");
        System.out.println("3. Opdater Produkt");
        System.out.println("4. Fjern Produkt");

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