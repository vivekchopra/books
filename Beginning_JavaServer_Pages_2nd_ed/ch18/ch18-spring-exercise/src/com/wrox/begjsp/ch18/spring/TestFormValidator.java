package com.wrox.begjsp.ch18.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class TestFormValidator implements Validator
{
    public boolean supports(Class checkMe)
    {
        return checkMe.equals(TestForm.class);
    }

    public void validate(Object object, Errors errors)
    {
        TestForm form = (TestForm) object;

        if (form == null)
        {
            errors.rejectValue("testForm", "form.error.novalue",
                               "Value required.");
        }

        String testName = form.getName();
        String testComments = form.getComments();
        int testAge = form.getAge();

        if ((testName == null) || (testName.length() < 1))
        {
            errors.rejectValue("name", "form.error.name.missing",
                               "Name is missing.");
        }

        if ((testComments == null) || (testComments.length() < 1))
        {
            errors.rejectValue("comments", "form.error.comments.missing",
                               "Comments is missing.");
        }

        if (testAge < 18)
        {
            errors.rejectValue("age", "form.error.age.value",
                               "Age cannot be less than 18.");
        }
    }
}
