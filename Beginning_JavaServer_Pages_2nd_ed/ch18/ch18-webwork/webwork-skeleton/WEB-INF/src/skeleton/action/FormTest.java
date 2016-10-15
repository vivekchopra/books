/*
 * Skeleton
 *
 */
package skeleton.action;

import webwork.action.ActionSupport;
import webwork.action.CommandDriven;

import java.util.ArrayList;


/**
 * A sample action
 *
 * @author Matt Baldree (matt@smallleap.com)
 * @version $Revision: 1.3 $
 */
public class FormTest extends ActionSupport implements CommandDriven
{
    String user = "";
    String comments = "";
    int age = 0;
    ArrayList things = new ArrayList();

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getUser()
    {
        return user;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public String getComments()
    {
        return comments;
    }

    public ArrayList getThings()
    {
        if (age < 25)
        {
            things.add("Go to College");
            things.add("Buy a car");
            things.add("Travel overseas");
        }
        else if (age < 35)
        {
            things.add("Get a job");
            things.add("Buy a house");
            things.add("Get married");
        }
        else
        {
            things.add("Do whatever you want!");
        }

        return things;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    protected void doValidation()
    {
        if (user.equals(""))
        {
            addError("user", "Missing name");
        }

        if (age < 18)
        {
            addError("age", "Age cannot be less than 18");
        }
    }

    protected String doExecute() throws Exception
    {
        // Process data
        return SUCCESS;
    }
}
