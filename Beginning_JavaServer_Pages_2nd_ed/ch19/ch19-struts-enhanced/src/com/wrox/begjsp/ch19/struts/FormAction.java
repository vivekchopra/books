package com.wrox.begjsp.ch19.struts;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormAction extends Action
{
    public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        request.setAttribute("sports", getSports());

        return mapping.findForward("success");
    }

    private List getSports()
    {
        List sports = new ArrayList();

        sports.add(new LabelValueBean("Tennis", "Tennis"));
        sports.add(new LabelValueBean("Hockey", "Hockey"));
        sports.add(new LabelValueBean("Football", "Football"));
        sports.add(new LabelValueBean("Baseball", "Baseball"));
        sports.add(new LabelValueBean("Soccer", "Soccer"));

        return sports;
    }
}
