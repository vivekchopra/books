package com.wrox.begjsp.ch18.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class TestFormController extends SimpleFormController
{
    public ModelAndView onSubmit(Object object)
    {
        return new ModelAndView("success");
    }
}
