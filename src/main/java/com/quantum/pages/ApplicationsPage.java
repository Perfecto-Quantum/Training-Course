package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.NoSuchElementException;

public class ApplicationsPage extends AbstractBasePage {
    @FindBy(locator = "applications.title")
    private QAFWebElement title;

    public ApplicationsPage(){
        super();
        validatePage();
    }
    private void validatePage(){
        title.click();
    }
    private Boolean validateApplicant(String applicant){
        try {
            new QAFExtendedWebDriver().findElementByXPath("//*[text()="+applicant+"\"]");
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    private void clearApplicant(String applicant){
        if(validateApplicant(applicant)){
            new QAFExtendedWebDriver().findElementByXPath("//*[text()="+applicant+"\"]").click();

        }


    }
    //@Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
