package com.wrox.jsp;

public class LoanCalc
{
  
  /** Creates a new instance of LoanCalc */
  public LoanCalc()
  {
  }

  public double calcPayment( double amount, double iRate, double periods )
  {
    return amount * factor(iRate, periods);
  }
  
  public double calcAmount( double payment, double iRate, double periods)
  {
    return payment/factor(iRate, periods);
  }
  
  private double factor(double iRate, double periods)
  {
    return (iRate * Math.pow((1.0 + iRate), (periods)))/(Math.pow((1.0+iRate), periods)-1);
  }

  public static final void main(String[] args)
  {
    double amount = 10000.0;
    double rate = 10.0 / 1200.0;
    double periods = 120.0;
    double payment = 100.0;
    LoanCalc calc = new LoanCalc();
    amount = calc.calcAmount(payment, rate, periods);
		java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance();
    System.out.println( "Amount="+nf.format(amount));
    System.out.println( "Payment="+nf.format(calc.calcPayment(amount, rate, periods) ));
  }
}
