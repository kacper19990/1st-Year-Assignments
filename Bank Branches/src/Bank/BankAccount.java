package Bank;

public class BankAccount {
    long accountNo;
    double balance;

    public double returnBalance(){


        return balance;
    }
    public void creditBalance(int balance){
        this.balance += balance;

    }

    public void debitBalance(int balance){
        this.balance -= balance;
    }
}
