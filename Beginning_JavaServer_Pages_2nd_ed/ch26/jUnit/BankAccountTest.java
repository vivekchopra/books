package com.wrox.begjsp.ch26;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class BankAccountTest extends TestCase {

    private BankAccount account1;
    private BankAccount account2;

    protected void setUp ()
    {
        account1 = new BankAccount (1, BankAccount.CHECKING_ACCOUNT, 1000);
        account2 = new BankAccount (2, BankAccount.SAVINGS_ACCOUNT,  1000);
    }

    public void testDebit ()
    {
        float balance = account1.getCurrentBalance();
        account1.debit (100);
        Assert.assertEquals (balance-100, account1.getCurrentBalance(), 0);
    }

    public void testCredit ()
    {
        float balance = account1.getCurrentBalance();
        account1.credit (100);
        Assert.assertEquals (balance+100, account1.getCurrentBalance(), 0);
    }
  
    public void testTransferFrom ()
    {
        float transferAmount[] = {10, 100, 1000, 10000};

        for (int i = 0; i < transferAmount.length; i++) 
        {
            float balance1 = account1.getCurrentBalance();
            float balance2 = account2.getCurrentBalance();
            boolean transferSuccess = account1.transferFrom (account2, 
                                                             transferAmount[i]);
            if (transferSuccess)
            {
              Assert.assertEquals (balance1+transferAmount[i],
                                   account1.getCurrentBalance(), 
                                   0);
              Assert.assertEquals (balance2-transferAmount[i],
                                   account2.getCurrentBalance(), 
                                   0);
            }
            else /* transfer of money between bank accounts failed */
            {
              Assert.assertEquals (account1.getCurrentBalance(), balance1, 0);
              Assert.assertEquals (account2.getCurrentBalance(), balance2, 0);
            }
        }
    }

    public static void main (String[] args)
    {
        junit.swingui.TestRunner.run (BankAccountTest.class);
    }

}
