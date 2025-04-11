package adata;
public abstract class Data {
    //all the variables
    protected int Password;
    protected int NumberCC;
    protected String Name;
    protected int Money;
    protected int WithdrawAmount;
    protected int TransactionAmount;
    protected int Deposits; 
    // im gonna declarate all of this bc in the subclases i want to do a interaction between the accounts 
    public Data(int password, int numberCC, String name, int Money) {
        this.Password = password;
        this.NumberCC = numberCC;
        this.Name = name;
        this.Money = Money; 
    } 
    //(all the getters) i will agregate a method for the info of account, and censure the password too 
    public int getPassword() {
        return Password;
    }
    public int getNumberCC() {
        return NumberCC;
    }
    public String getName() {
        return Name;
    }
    public int getMoney() {
        return Money;
    }
    public void setMoney(int Money){this.Money = Money;} //i will work with only 50000$ COP this will do the program more easy to understand (at least for me lol)
    public abstract void Option1(); 
    public abstract int Option2(); //Withdraw in a real cashier
    public abstract int Option3(); //Deposit in the account 
    public abstract int Option4(Data TargetACC, int TransactionAmount); //Im gonna think about the change of password maybe this gonna be the transffers in the accounts   
    public abstract void Option5(); //Goodbye 
}