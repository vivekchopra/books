package com.wrox.begjsp.ch18.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestDataListController implements Controller
{
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response)
                               throws Exception
    {
        HttpSession session = request.getSession(true);
        List data = (List) session.getAttribute("dataList");

        if (data == null)
        {
            data = new ArrayList();
        }

        request.setAttribute("dataList", data);

        return new ModelAndView("datalist");
    }
}
