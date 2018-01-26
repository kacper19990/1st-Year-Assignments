package bankProject;

import java.util.Date;

public class BankCustomer {
    int accountNumber;
    int sortCode;
    double balance;
    String customerEmail;
    String customerDateOfBirth;
    String customerAddress;
    String customerName;



    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }
    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }
    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


}