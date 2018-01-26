package bankProject;
import java.util.Date;

public interface Bankinterface {
    public long createAccountNumber();
    public BankCustomer findCustomer(long accountNumber);
    public BankCustomer findCustomer(String name, Date dateOfBirth, String address);
    public boolean debitAccount(long accountNumber, double amountDebited);
    public boolean creditAccount(long accountNumber, double amountCredited);
    public void printBalance(long accountNumber);

}
