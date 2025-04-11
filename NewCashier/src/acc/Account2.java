package acc;
import java.util.Scanner;

import adata.Data;
public class Account2 extends Data{
    Scanner Input = new Scanner(System.in);

    public Account2(int password, int NumberCC, String name, int Money){
        super(password, NumberCC, name, Money);
    }
    @Override
    public void Option1(){
        System.out.println("Tu saldo actual es de: "+ getMoney() + "$"); //show the actual money of the account 
    }
    @Override
    public int Option2(){
        System.out.println("Ingrese el valor a retirar en el cajero");
        int WithdrawAmount = Input.nextInt();
            if (WithdrawAmount > 0 && WithdrawAmount <= Money){
                Money -= WithdrawAmount; 
            }
            else{
                System.out.println("Inserta un valor valido y acorde a tu saldo");
            }
        return Money; //return the new value of the money
        }
    @Override
    public int Option3(){
        int Deposits = Input.nextInt();
        if (Deposits <= 0){
            System.out.println("Inserta un valor valido (> 0 y que no sea negativo)");
        }
        else{
            Deposits += Money; //adittion more money  in the account 
        }
        return Money; //new value of the money again
    } 
    @Override
    public int Option4(Data Account1, int TransactionAmount){ 
        System.out.println("Ingrese el valor a transferir: ");
        TransactionAmount = Input.nextInt(); //idk how to do this, ¿maybe with the getters or the setters? 
        if(TransactionAmount < 0 || TransactionAmount > Money){
            System.out.println("Porfavor ingresa valores validos, que no superen tu dinero actual y ademas no sean menores a 0");
        }
        else{
            this.setMoney(this.getMoney() - TransactionAmount);
        Account1.setMoney(Account1.getMoney() + TransactionAmount);
        System.out.println("Transferencia exitosa!");
        System.out.println("Tu nuevo saldo: $" + Money);
        }
        return Money;
    } 
    public void Option5(){
    
    } 
}
