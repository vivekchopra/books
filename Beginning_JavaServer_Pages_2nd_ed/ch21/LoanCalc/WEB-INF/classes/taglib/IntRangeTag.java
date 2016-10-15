package taglib;

import com.wrox.jsp.IntRangeValidator;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorTag;
import javax.servlet.jsp.JspException;

public class IntRangeTag extends ValidatorTag
{
  private int min = 0;
  private int max = 0;
  private boolean minset = false;
  private boolean maxset = false;

  public IntRangeTag()
  {
    super();
    super.setValidatorId("IntRangeValidator");
  }
  
  protected Validator createValidator()
  throws JspException
  {
    IntRangeValidator validator = null;
    validator = (IntRangeValidator) super.createValidator();
    if(validator == null)
    {
      System.out.println("null validator");
      return validator;
    }
    if( minset) 
      validator.setMin(min);
    if( maxset )
      validator.setMax(max);
    return validator;
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
}
