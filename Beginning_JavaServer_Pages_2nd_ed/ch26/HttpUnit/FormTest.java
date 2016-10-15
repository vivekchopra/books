package com.wrox.begjsp.ch27;

import com.meterware.httpunit.*;
import junit.framework.*;


/**
 * An example of testing servlets using HttpUnit
 **/
public class FormTest extends TestCase {

    public static final String FORM_URL = "http://localhost:8080/webwork-skeleton/formtest!default.action";

    public static void main(String args[]) 
    {
        junit.textui.TestRunner.run (suite());
    }
    
    
    public static Test suite() 
    {
        return new TestSuite (FormTest.class);
    }


    /**
     * Verifies that the web page has exactly one form, with 
     * three parameters- user, age and comments.
     **/
    public void testForm() throws Exception 
    {
        WebConversation     conversation = new WebConversation();
        WebRequest request = new GetMethodWebRequest(FormTest.FORM_URL);
        
        WebResponse response = conversation.getResponse (request);
        WebForm forms[] = response.getForms();
        assertEquals (1, forms.length);
        assertEquals (3, forms[0].getParameterNames().length);
        assertEquals ("user", forms[0].getParameterNames()[2]);
        assertEquals ("age", forms[0].getParameterNames()[1]);
        assertEquals ("comments", forms[0].getParameterNames()[0]);
    }

    /**
     * Verifies that submitting the form with an invalid
     * age value fails with an error message.
     */
    public void testIncorrectAge() throws Exception 
    {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest (FormTest.FORM_URL);

        WebResponse response = conversation.getResponse (request);
        WebForm form = response.getForms()[0];
        request = form.getRequest();
        request.setParameter ("user", "John Doe");
        request.setParameter ("age", "17");
        response = conversation.getResponse (request);
        assertTrue ("Incorrect age does not flag error", 
             response.getText().indexOf ("Age cannot be less than 18") != -1);
    }

    /**
     * Verifies that submitting the form with an valid
     * age value works fine.
     */
    public void testCorrectAge() throws Exception 
    {
        WebConversation     conversation = new WebConversation();
        WebRequest  request = new GetMethodWebRequest (FormTest.FORM_URL);

        WebResponse response = conversation.getResponse (request);
        WebForm form = response.getForms()[0];
        request = form.getRequest();
        request.setParameter ("user", "Jane Doe");
        request.setParameter ("age", "18");
        response = conversation.getResponse (request);
        assertTrue ("Correct age limit not accepted", 
          response.getText().indexOf ("Advice") != -1);
    }

}
