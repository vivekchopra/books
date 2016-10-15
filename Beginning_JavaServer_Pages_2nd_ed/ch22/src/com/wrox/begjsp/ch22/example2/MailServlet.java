package com.wrox.begjsp.ch22.example2;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MailServlet extends HttpServlet
{
    private static final String DEFAULT_PAGE    = "example2/mail.jsp";

    private static final String ACTION_TOKEN    = "ACTION";

    private static final Object SMTP_HOST = "localhost";
    private static final String SMTP_FROM = "example2-chapter22-begjsp@wrox.com";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = findAction(request);
        
        if (action != null)
        {
            String toAddress = request.getParameter("email_to");
            String subject = request.getParameter("email_subject");
            String emailMessage = request.getParameter("email_message");
            
            boolean messageSent = false;
            if (isValidString(toAddress))
            {
                messageSent = sendEmail(toAddress, subject, emailMessage);
                if (!messageSent)
                {
                    request.setAttribute("ERROR_MESSAGE", "Unable to send message : check logs for error messages");
                }
                else
                {
                    request.setAttribute("SENT_MESSAGE", "Message sent to : "+toAddress);
                }
            }
            else
            {
                request.setAttribute("ERROR_MESSAGE", "An email address is mandatory");
            }
        }
        performRedirect(DEFAULT_PAGE, request, response);
    }

    private boolean sendEmail(String toAddress, String subject, String emailMessage)
    {
        Properties props = new Properties();
        props.put("smtp.host", SMTP_HOST);
        Session session = Session.getDefaultInstance(props, null);

        Message message = new MimeMessage(session);

        InternetAddress inetToAddress = null;
        InternetAddress inetFromAddress = null;
        try
        {
            inetToAddress = new InternetAddress(toAddress);
            inetFromAddress = new InternetAddress(SMTP_FROM);
        }
        catch (AddressException addressError)
        {
            log("Cannot create email addresses : "+ addressError);
            return false;
        }
        
        try
        {
            message.addRecipients(Message.RecipientType.TO,
                    new InternetAddress[] { inetToAddress });
            message.setFrom(inetFromAddress);
            message.setSubject(subject);
            message.setContent(emailMessage, "text/plain");
        }
        catch (MessagingException headerError)
        {
            log("Cannot construct email message : "+ headerError);
            return false;
        }
        
        try
        {
            Transport.send(message);
        }
        catch (MessagingException sendError)
        {
            log("Cannot send email message : "+ sendError);
            return false;
        }        

        return true;
    }

    private boolean isValidString(String paramString)
    {
        return (paramString != null && (paramString.length() > 0));
    }

    private String findAction(HttpServletRequest request)
    {
        return request.getParameter(ACTION_TOKEN);
    }
    
    private void performRedirect(String path, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        if (path != null)
        {
            request.setAttribute("SERVLET_PATH", request.getContextPath()
                    + request.getServletPath());
            RequestDispatcher dispatch = request.getRequestDispatcher(path);
            dispatch.forward(request, response);
        }
    }
    
}