package com.wrox.jsp;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class HelloBean
{
  private String name = null;
  public HelloBean()
  {
  }
  public String getName()
  {
    return name;
  }
  public void setName(String anyname)
  {
    name = anyname;
  }
  
  public String action()
  {
    boolean success = true;
    FacesContext context = FacesContext.getCurrentInstance();
    if(name != null)
    {
      for(int i = 0; i < name.length();i++)
      {
        if( !Character.isLetter(name.charAt(i)) )
        {
          FacesMessage message = new FacesMessage(
            "Username must be all alphabetic characters.");
          context.addMessage("helloForm", message);
          success = false;
          break;
        }
      }
    }
    else
    {
      success = false;
    }
    return (success ? "success" : "failure" );
  }
}
