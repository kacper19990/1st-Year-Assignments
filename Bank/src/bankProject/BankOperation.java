package bankProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankOperation
{
    private TreeMap<Long, BankCustomer> bankCustomers;

    BankOperation()
    {
        bankCustomers = new TreeMap<>();
    }

    void start()
    {
        setCustomersFromFile("C:\\Users\\kacpe\\Desktop\\College Assignments\\College-Assignments\\Bank\\src\\bankProject\\customers.txt");
        debitAccount(bankCustomers.firstKey(), 20);
    }

    public BankCustomer findCustomer(long accountNumber)
    {
        return bankCustomers.get(accountNumber);
    }

    public BankCustomer findCustomer(String name, Date dateOfBirth, String address)
    {
        for(long i = bankCustomers.firstKey(); i <= bankCustomers.lastKey(); i++)
            if(bankCustomers.get(i) != null && bankCustomers.get(i).getCustomerName().equals(name) && bankCustomers.get(i).getCustomerDateOfBirth().equals(dateOfBirth) && bankCustomers.get(i).getCustomerAddress().equals(address))
                return bankCustomers.get(i);
        return null;
    }

    public long createAccount()
    {
        if(bankCustomers != null)
            return bankCustomers.lastKey() + 1;
        else
            return 0;
    }

    public boolean debitAccount(long accountNumber, double debitAmount)
    {
        BankCustomer customer = findCustomer(accountNumber);
        double balance = customer.getBalance();


        if(balance >= debitAmount)
        {
            Transaction myTransaction = new Transaction(
                    Calendar.getInstance().getTime(), "Debit", debitAmount, balance - debitAmount
            );{

        }

            customer.setBalance(balance - debitAmount);
            customer.setTransaction(new Transaction(new Date(), "Debit", debitAmount, customer.getBalance()));
            return true;
        }
        return false;
    }

    public boolean creditAccount(long accountNumber, double creditAmount)
    {
        BankCustomer customer = findCustomer(accountNumber);
        customer.setBalance(customer.getBalance() + creditAmount);
        Transaction myTransaction =  new Transaction(new Date(), "Credit", creditAmount, customer.getBalance());
        return true;
    }

    public void printBalance(long accountNumber)
    {
        BankCustomer customer = findCustomer(accountNumber);
        System.out.print(customer.getBalance());
    }

    public void printStatement(long accountNumber){
        {
            TreeMap<Date, Transaction> transactionList = findCustomer(accountNumber).getCustomerTransactions();
            for (Map.Entry<Date, Transaction> entry : transactionList.entrySet()) {
                System.out.println(entry.getValue().toString());
            }
        }
    }

    public void setCustomersFromFile(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                String customerData = bufferedReader.readLine();
                if(customerData == null)
                    endOfFile = true;
                else
                {
                    String[] customerProperties = customerData.split(",");
                    for(int i = 0; i < customerProperties.length; i++)
                        customerProperties[i] = customerProperties[i].trim();
                    Date dateOfBirth = null;

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    try
                    {
                        dateOfBirth = formatter.parse(customerProperties[5]);
                    }

                    catch(ParseException e)
                    {
                        e.printStackTrace();
                    }
                    BankCustomer customer = new BankCustomer(
                            Long.parseLong(customerProperties[0]),
                            Integer.parseInt(customerProperties[1]),
                            customerProperties[2],
                            customerProperties[3],
                            customerProperties[4],
                            dateOfBirth,
                            Double.parseDouble(customerProperties[6])
                            );
                    bankCustomers.put(customer.getAccountNumber(), customer);
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public Long[] getAllCustomerAccountNumbers(){
        Long[] customerAccountNumbers = new Long[bankCustomers.keySet().size()];
        customerAccountNumbers = bankCustomers.keySet().toArray(customerAccountNumbers);
        return  customerAccountNumbers;
    }

    /*public ArrayList<Long> getCustomerAccountNumbers(){
        ArrayList<Long> customerAccountNumbers = new ArrayList<Long>();
        Set<Long> accountNumbers = bankCustomers.keySet();
        for (int count = 0; count < accountNumbers.size(); count++){
            customerAccountNumbers.add(accountNumbers);
        }
    }*/
}