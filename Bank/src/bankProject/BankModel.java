package bankProject;

import java.util.Date;

public interface BankModel
{
    long createAccount();
    BankCustomer findCustomer(long accountNumber);
    BankCustomer findCustomer(String name, Date dateOfBirth, String address);
    boolean debitAccount(long accountNumber, double debitAmount);
    boolean creditAccount(long accountNumber, double creditAmount);
    void printBalance(long accountNumber);
}