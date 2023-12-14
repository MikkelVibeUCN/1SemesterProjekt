package tui;

import java.util.Scanner;

import model.SalesAssistant;

public class MainMenu {
	private OrderMenu orderMenu;
	private ProductMenu productMenu;
	private CustomerMenu customerMenu;
	private SalesAssistantMenu salesAssistantMenu;
	private SalesAssistant salesAssistant;
	
	public MainMenu() {
		this.orderMenu = new OrderMenu();
		this.productMenu = new ProductMenu();
		this.customerMenu = new CustomerMenu();
		this.salesAssistantMenu = new SalesAssistantMenu();
	}

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            
            System.out.println("1. Ordre menu");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("666. opret test data");
            System.out.println("0. Afslut");

   
            int choice = scanner.nextInt();
          
            switch (choice) {
                case 1:
                	//
                	orderMenu.displayMenu();
                    break;
                case 2:
                	//
                	productMenu.displayMenu();
                    break;
                case 3:
                    //
                	customerMenu.displayMenu();
                    break;
                case 4:
                	//
                	salesAssistantMenu.displayMenu();
                case 666:
                	TryMe.createTestData();
                	break;
                case 5:
                    exit = true;
               
                    break;
                default:
                    System.out.println("Ugyldigt valg");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.run();
    }
    
    
}