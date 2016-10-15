package com.wrox.jsp;

import java.text.NumberFormat;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class NumberToCashConverter implements Converter
{
  public NumberToCashConverter()
  {
  }
  
  public Object getAsObject(
    FacesContext facesContext, 
    UIComponent uIComponent, 
    String str)
  {
    Double dbl = null;
    if ( str == null )
    {
      return null;
    }
    
    try
    {
      NumberFormat format = NumberFormat.getCurrencyInstance();
      if( format.getCurrency().getSymbol().charAt(0) == (str.charAt(0)))
      {
        Number num = format.parse(str);
        dbl = new Double( num.doubleValue() );
      }
      else
      {
        dbl = new Double(Double.parseDouble(str));
      }
    }
    catch (Exception e)
    {
      FacesMessage message = 
        new FacesMessage("Conversion to Double failed! "+e.getMessage());
      throw new ConverterException(message);
    }
    return dbl;
  }
  
  public String getAsString(
    FacesContext facesContext, 
    UIComponent uIComponent, 
    Object obj)
  {
    Double inputVal = null;
    String retVal = null;
    if ( obj == null )
    {
      return "";
    }
    // value must be of the type that can be cast to a String.
    try
    {
      inputVal = (Double)obj;
      //== strip $ character off but decimal
      NumberFormat format = NumberFormat.getCurrencyInstance();
      retVal = format.format(inputVal);
    }
    catch (Exception e)
    {
      FacesMessage message = 
        new FacesMessage("Conversion to String failed! "+e.getMessage());
      throw new ConverterException(message);
    }
    return retVal;
  }
}