package Bank;

import java.util.Date;

public class Transaction
{
    private Date transactionDate;
    private String transactionType;
    private double transactionAmount;
    private double closingBalance;

    public Transaction(){

    }

    public Transaction(Date transactionDate, String transactionType, double transactionAmount, double closingBalance){
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.closingBalance = closingBalance;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    private void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType.toLowerCase();
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    private void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getClosingBalance() {
        return closingBalance;
    }

    private void setClosingBalance(double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String toString()
    {
        return  "TransactionDate:" + transactionDate +
                ",TransactionType:" + transactionType +
                ",TransactionAmount:" + transactionAmount +
                ",ClosingBalance:" + closingBalance;
    }
}