package bankProject;

public class Bank
{
    public static void main(String[] args)
    {
        BankOperation bank = new BankOperation();
        bank.setCustomersFromFile("C:\\Users\\kacpe\\Desktop\\College Assignments\\College-Assignments\\Bank\\src\\bankProject\\customers.txt");
        Long[] accountNumber = bank.getAllCustomerAccountNumbers();
        for(long account: accountNumber){
            System.out.println(account);
        }
        bank.createAccount();

    }
}