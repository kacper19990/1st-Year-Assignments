package bankProject;

import java.util.TreeMap;
import java.util.Date;

public class BankCustomer
{
    BankCustomer()
    {
        customerTransactions = new TreeMap<>();
    }

    private long accountNumber;
    private long sortCode;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private Date customerDateOfBirth;
    private double balance;
    private TreeMap<Date,Transaction> customerTransactions;

    public TreeMap<Date,Transaction> getCustomerTransactions() {
        return customerTransactions;
    }

    public void setCustomerTransactions(TreeMap<Date,Transaction> customerTransactions) {
        this.customerTransactions = customerTransactions;
    }

    public void setTransaction(Transaction transaction) {
        this.customerTransactions.put(transaction.getTransactionDate(), transaction);
    }

    public Transaction getLastTransaction() {
        return this.customerTransactions.get(customerTransactions.lastKey());
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getSortCode() {
        return sortCode;
    }

    public void setSortCode(long sortCode) {
        this.sortCode = sortCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}