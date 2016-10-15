package com.wrox.jsp;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.PhaseId;

public class LogAction implements ActionListener
{
  public LogAction()
  {
  }
  
  public void processAction(ActionEvent event) 
  throws AbortProcessingException
  {
    String id = event.getComponent().getId();
    String phase = event.getPhaseId().toString();
    System.out.println(
      "Component:"
      +id
      +" generated action event handled in phase "
      +phase);
  }
  
}
