package begjsp.ch18.spring;

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
            errors.rejectValue("testForm", "form.error.novalue", null,
                "Value required.");
        }

        String testName = form.getName();
        String testComments = form.getComments();

        if ((testName == null) || (testName.length() < 1))
        {
            errors.rejectValue("name", "form.error.name.missing",
                "The name field is missing.");
        }
    }
}
