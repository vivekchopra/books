package com.wrox.jsp;

public class LoanBean
{
  private double amount;
  private double payment;
  private double apr;
  private double periodic_rate;
  private double periods;
  
  public LoanBean()
  {
  }
  
  private double calcPayment( double amount, double iRate, double periods )
  {
    return amount * factor(iRate, periods);
  }
  
  private double calcAmount( double payment, double iRate, double periods)
  {
    return payment/factor(iRate, periods);
  }
  
  private double factor(double iRate, double periods)
  {
    return (iRate * Math.pow((1.0 + iRate), (periods)))/(Math.pow((1.0+iRate), periods)-1);
  }

  public String amount()
  {
    amount = this.calcAmount(payment, periodic_rate, periods );
    return "success";
  }
  
  public String payment()
  {
    payment = this.calcPayment(amount, periodic_rate, periods );
    return "success";
  }
  
  public double getAmount()
  {
    return amount;
  }
  
  public void setAmount(double amount)
  {
    this.amount = amount;
  }
  
  public double getApr()
  {
    return apr;
  }
  
  public void setApr(double apr)
  {
    this.periodic_rate = apr/1200.0;
    this.apr = apr;
  }
  
  public double getPayment()
  {
    return payment;
  }
  
  public void setPayment(double payment)
  {
    this.payment = payment;
  }
  
  public double getPeriodic_rate()
  {
    return periodic_rate;
  }
  
  protected void setPeriodic_rate(double periodic_rate)
  {
    this.periodic_rate = periodic_rate;
  }
  
  public double getPeriods()
  {
    return periods;
  }
  
  public void setPeriods(double periods)
  {
    this.periods = periods;
  }
}