import java.util.Scanner;
import acc.Account1;
import acc.Account2;
import menu.*;
import authentication.AuthenticationAcc;
import adata.Data; 
public class App {
     static Scanner input = new Scanner(System.in); // im going to try a global scanner maybe if this works i can skip of do a scanner for every class 08/04  
    //the global scanner doesn't work as i expected xd 09/04
    //teacher i will leave a note in the final of the file app, is questions about some things (dont worry its gonna be on spanish)
    public static void main(String[] args) throws Exception {
        Account1 acc1 = new Account1(1234, 304611, "Jose",50000);
        Account2 acc2 = new Account2(4321, 611304, "Daniel", 50000);
        Data loggedInAccount = authenticateUser(acc1, acc2); //loggedInaccount is like TargetACC but its the account that is logged in the moment by the user 
        //idk how to do the menu 
        Menu menu = new Menu();
        boolean exit = false; //variable for the exit of the program 
        while (!exit) {
            int option = menu.ShowMenu();
            switch (option) {
                case 1: //check balance
                    loggedInAccount.Option1();
                    break;
                case 2: //withdraw
                    int newBalance = loggedInAccount.Option2();
                    System.out.println("Nuevo saldo: $" + newBalance);
                    break;
                case 3: //deposit
                    System.out.print("Ingrese el monto a depositar: $");
                    newBalance = loggedInAccount.Option3();
                    System.out.println("Nuevo saldo: $" + newBalance);
                    break;
                case 4: //transfer to one account 
                    System.out.print("Ingrese el número de cuenta destino: ");
                    int targetNumber = input.nextInt();
                    Data targetAccount = (targetNumber == acc2.getNumberCC()) ? acc2 : null;
                    
                    if (targetAccount != null) {
                        loggedInAccount.Option4(targetAccount, 0); 
                    } else {
                        System.out.println("Cuenta destino no válida.");
                    }
                    break;
                case 5:  //exit
                    loggedInAccount.Option5(); //idk how to do a rerun whitout closing the code (and i dont want to do it with IA)
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    //the menu took me like 2 days
            }
        }
    }

    // Authentication logic
    private static Data authenticateUser(Account1 acc1, Account2 acc2) {
        AuthenticationAcc auth = new AuthenticationAcc(3, 0, 0, false, false); //after try to do the authentication method in the class like 2 or more days i really don have any idea to do it 
        System.out.print("Ingrese el número de cuenta: ");                                                               //so i will do it on main app (although it's not what I want)
        int accountNumber = input.nextInt();

        Data targetAccount = null;
        if (accountNumber == acc1.getNumberCC()) { //here the user choose the account he want to login 
            targetAccount = acc1; 
        } else if (accountNumber == acc2.getNumberCC()) {
            targetAccount = acc2;
        } else {
            System.out.println("Cuenta no encontrada.");
            return null;
        }

        //validate password (in other version i will censurate it)
        int tries = 3;
        while (tries > 0) {
            System.out.print("Ingrese su PIN: ");
            int pin = input.nextInt();
            if (pin == targetAccount.getPassword()) {
                System.out.println("¡Bienvenido, " + targetAccount.getName() + "!");
                return targetAccount;
            } else {
                tries--;
                System.out.println("PIN incorrecto. Intentos restantes: " + tries);
            }
        }
        return null;
    }
}
/*profe tengo solo dos preguntas, la idea principal del programa era tener dos cuentas y que estas interactuaran entre si (se logro pero no como queria)
* como se supone que puedo hacer que el programa siga corriendose despues de que se salga de la cuenta para ver que la plata transferida se ve reflejada en la otra cuenta
* y la otra es por que no es optimo hacer una clase de autenticacion para hacer todo el proceso (almenos eso me dijeron) y yap, perdon por la emocion y gracias :p
*/