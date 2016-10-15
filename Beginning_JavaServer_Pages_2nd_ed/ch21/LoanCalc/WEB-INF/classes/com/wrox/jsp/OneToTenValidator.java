package com.wrox.jsp;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class OneToTenValidator implements Validator
{
  public OneToTenValidator()
  {
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
    if( (i < 1) || (i > 10) )
    {
      FacesMessage message = new FacesMessage("The guess must be between 1 and 10");
      throw new ValidatorException(message);
    }
    return;
  }
  
}
