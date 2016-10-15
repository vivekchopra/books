package com.wrox.begjsp.ch26;

public class BankAccount {

    public static final int   CHECKING_ACCOUNT        = 0;
    public static final int   SAVINGS_ACCOUNT         = 1;

    /* Unique ID for bank account */
    private long  accountID;
    /* Type of account- CHECKING_ACCOUNT or SAVINGS_ACCOUNT */
    private int   accountType;
    /* Account balance */
    private float currentBalance;

    public BankAccount (long accountID, int accountType, float currentBalance) 
    {
        this.accountID      = accountID;
        this.accountType    = accountType;
        this.currentBalance = currentBalance;
    }

    public boolean debit (float debitAmount)
    {
        /* No overdraft allowed */
        if (debitAmount > currentBalance)
             return false;

        currentBalance -= debitAmount;
        return true;
    }

    public boolean credit (float creditAmount)
    {
        currentBalance += creditAmount;
        return true;
    }
  
    public boolean transferFrom (BankAccount account, float amount)
    {
        /*
        account.debit (amount);
        this.credit (amount);
        return true;
        */
        if (account.debit (amount))
            return this.credit (amount);

        return false;
    }

    public float getCurrentBalance ()
    {
        return currentBalance;
    } 
}
