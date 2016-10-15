package com.wrox.begjsp.ch18.spring;

import org.springframework.validation.BindException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class TestFormController extends SimpleFormController
{
    public ModelAndView onSubmit(Object object)
    {
        TestForm form = (TestForm) object;
        Map items = new HashMap();
        items.put("testForm", form);

        return new ModelAndView("success", items);
    }

    protected Map referenceData(HttpServletRequest request)
                         throws ServletException
    {
        Map refData = new HashMap();
        List ages = new ArrayList();

        for (int i = 0; i <= 100; i++)
        {
            ages.add(new Integer(i));
        }

        refData.put("ages", ages);

        return refData;
    }

    protected void onBindAndValidate(HttpServletRequest request, Object object,
                                     BindException errors)
                              throws Exception
    {
        if (!errors.hasErrors())
        {
            TestForm form = (TestForm) object;
            HttpSession session = request.getSession(true);
            List formList = (List) session.getAttribute("dataList");

            if (formList == null)
            {
                formList = new ArrayList();
            }

            formList.add(form);
            session.setAttribute("dataList", formList);
        }
    }
}
