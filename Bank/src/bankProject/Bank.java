package bankProject;

import jdk.nashorn.api.tree.Tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bank implements Bankinterface{
    long account = 10001;

    //static BankCustomer[] customerArray = new BankCustomer[100];
    //static List<BankCustomer> customerList = new ArrayList<BankCustomer>();
    static Map<Long, BankCustomer> customerTree = new TreeMap<Long, BankCustomer>();
    public static void main(String[] args){

        Bank bank = new Bank();

        BankCustomer bankCustomer = new BankCustomer();
        bankCustomer.setAccountNumber(123456789);
        bankCustomer.setSortCode(12425);
        bankCustomer.setCustomerName("Joe");
        bankCustomer.setCustomerEmail("joe@tcd.ie");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            bankCustomer.setCustomerDateOfBirth(formatter.parse("08/02/1999"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bankCustomer.setCustomerAddress("Trinity College Dublin");
        //customerList.add(bankCustomer);
        bank.customerTree.put(new Long(45256789), bankCustomer);
        bank.findCustomer(new Long(45256789));
    }

    @Override
    public long createAccountNumber() {
        return 0;
    }

    @Override
    public BankCustomer findCustomer(long accountNumber) {
        BankCustomer customer = null;
        boolean customerFound = false;
        int counter = 0;
        /*while(!customerFound && counter <customerList.size()){
            customer = customerList.get(counter);
            if (customer.getAccountNumber() == accountNumber){
                customerFound = true;
            }
            counter++;
        }
        */
        return customerTree.get(accountNumber);
    }

    @Override
    public BankCustomer findCustomer(String name, Date dateOfBirth, String address) {
        return null;
    }

    @Override
    public boolean debitAccount(long accountNumber, double amountDebited) {
        BankCustomer customer = findCustomer(accountNumber);
        boolean accountDebited = false;
        double balance = customer.getBalance();
        if(balance >= amountDebited){
            customer.setBalance(balance - amountDebited);
            accountDebited = true;
        }
        else
            accountDebited = false;
        return accountDebited;
    }

    @Override
    public boolean creditAccount(long accountNumber, double amountCredited) {
        BankCustomer customer = findCustomer(accountNumber);
        customer.setBalance((customer.getBalance()+ amountCredited));
        return true;
    }

    @Override
    public void printBalance(long accountNumber) {

    }
}
//TODO Assignment noughts and crosses, 2D arrays