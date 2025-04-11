package authentication;
import adata.*;
import java.util.Scanner;
public class AuthenticationAcc {
    Scanner Input = new Scanner(System.in);
    int Maxtries = 3;
    int PassOption; 
    int NumberAccU;
    boolean ValidationNumber;
    boolean ValidationPin;
    public AuthenticationAcc(int maxtries, int PassOption, int NumberAccU, boolean ValidationNumber, boolean ValidationPin) {
        Maxtries = maxtries;
        this.PassOption = PassOption;
        this.NumberAccU = NumberAccU;
        this.ValidationNumber = ValidationNumber;
        this.ValidationPin = ValidationPin;
    }
    //dont pay attention to the methods it turned out better to do it in the main file 
    public boolean Login(Data TargetACC){
        do{
        System.out.println("Ingresa el numero de la cuenta a la cual quieres ingresar: ");
        int NumberAccU = Input.nextInt();
        if (NumberAccU == TargetACC.getNumberCC()){
            System.out.println("Cuenta valida bienvenido "+ TargetACC.getName());
            return true;
        }
        else{
            System.out.println("El numero de cuenta no es valido, inserte nuevamente el numero de cuenta");
            return false;
        }
        } while(true);
    }
    
    public boolean PinValidation(Data TargetACC){
        int tries = Maxtries;
        while(tries > 0){
            System.out.println("Ingrese el pin de la cuenta: " + TargetACC.getNumberCC());
            PassOption = Input.nextInt();
            if (PassOption == TargetACC.getPassword()){
                System.out.println("¡Pin Correcto!");
                return true;
            }
            else{
                tries --;
                System.out.println("Pin incorrecto te quedan: " + tries + " intentos ");
                return false;
            }
        }
        System.out.println("Cuenta bloqueada");
        return false;
    }
}