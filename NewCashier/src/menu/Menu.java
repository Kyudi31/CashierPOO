package menu;
import java.util.Scanner;
//the menu this dont have a very advanced logic 
public class Menu {
    private final Scanner scanner = new Scanner(System.in);    
    private int option;
    public int ShowMenu(){
    System.out.println("Bienvenido a NequiNicole");
    System.out.println("1. consultar chichigua");
    System.out.println("2. retirar money");
    System.out.println("3. Depositar. ");
    System.out.println("4. Transferir a otra cuenta. "); 
    System.out.println("5. Open del parche. ");
    option = scanner.nextInt();
    return option;
    }
}
