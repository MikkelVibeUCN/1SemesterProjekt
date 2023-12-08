import java.util.Scanner;

public class MainMenu {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            
            System.out.println("1. Ordre menu");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("0. Afslut");

   
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
                case 4:
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