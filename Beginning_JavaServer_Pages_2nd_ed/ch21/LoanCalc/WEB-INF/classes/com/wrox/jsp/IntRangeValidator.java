package com.wrox.jsp;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class IntRangeValidator implements Validator
{
  private int min;
  private int max;
  private boolean minset = false;
  private boolean maxset = false;
  
  public IntRangeValidator()
  {
    System.out.println("IntRangeValidator built");
  }
  
  public void setMin(int m)
  {
    minset = true;
    min = m;
  }
  
  public int getMin()
  {
    return min;
  }
  
  public void setMax(int m)
  {
    maxset = true;
    max = m;
  }
  
  public int getMax()
  {
    return max;
  }
  
  public void validate(FacesContext facesContext, UIComponent component, Object obj)
  throws ValidatorException
  {
    boolean valid = false;
    String value = null;
    int i;
    if (!(component instanceof UIInput) || (obj == null))
    {
      return;
    }
    value = obj.toString();
    try
    {
      i = Integer.parseInt(value);
    }
    catch( NumberFormatException nfe )
    {
      FacesMessage message = new FacesMessage("Could not convert to int.");
      throw new ValidatorException(message);
    }
    if( (minset && (i < min)) || (maxset && (i > max)) )
    {
      FacesMessage message =
      new FacesMessage("The entry must be between "+min+" and "+max);
      throw new ValidatorException(message);
    }
    return;
  }
  
}

