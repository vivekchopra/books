package com.wrox.jsp;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class LogChange implements ValueChangeListener
{
  public LogChange()
  {
  }
  
  public void processValueChange(ValueChangeEvent event ) 
  throws AbortProcessingException
  {
    String id = event.getComponent().getId();
    String oldVal = event.getOldValue().toString();
    String newVal = event.getNewValue().toString();
    System.out.println("Component:"
      +id
      +" value changed from "
      +oldVal
      +" to "
      +newVal);
  }
  
}
