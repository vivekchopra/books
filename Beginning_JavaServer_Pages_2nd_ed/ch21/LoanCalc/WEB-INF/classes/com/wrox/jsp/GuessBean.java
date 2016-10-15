package com.wrox.jsp;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class GuessBean
{
  private int number;
  private int guess;
  
  public GuessBean()
  {
    number = (new Random()).nextInt(9)+1;
  }
  
  public int getNumber()
  {
    return number;
  }
  
  public int getGuess()
  {
    return guess;
  }
  
  public void setGuess(int i)
  {
    guess = i;
  }
  
  public String replay()
  {
    number = (new Random()).nextInt(9)+1;
    return "success";
  }
  
  public String action()
  {
    System.out.println("inside action method. guess="+guess+" number="+number);
    if( guess == number )
    {
      return "success";
    }
    else
    {
      FacesContext context = FacesContext.getCurrentInstance();
      int delta = Math.abs(guess-number);
      String message = "You missed it by "+delta+". Try again.";
      context.addMessage("GuessForm", new FacesMessage(message));
    }
    return "failure";
  }
  
  public void validate(FacesContext context, UIComponent component, Object obj)
  {
    int i;
    String value = obj.toString();
    UIInput inputText = (UIInput)component;
    try
    {
      i = Integer.parseInt(value);
      if( (i < 1) || (i > 10) )
      {
        inputText.setValid(false);
        FacesMessage message = new FacesMessage("Your guess should be between 1 and 10");
        context.addMessage(component.getClientId(context),message);
      }
    }
    catch( Exception e )
    {
      inputText.setValid(false);
      FacesMessage message = new FacesMessage("Exception:"+e.getMessage());
      context.addMessage(component.getClientId(context),message);
    }
    return;
  }
}
