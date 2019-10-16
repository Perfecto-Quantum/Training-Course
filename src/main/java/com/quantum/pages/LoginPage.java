package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import static com.quantum.listeners.QuantumReportiumListener.logStepStart;

public class LoginPage extends AbstractBasePage{

    @FindBy(locator = "signIn.username.field")
    private QAFWebElement usernameField;
    @FindBy(locator = "signIn.password.field")
    private QAFWebElement passwordField;
    @FindBy(locator = "signIn.signIn.button")
    private QAFWebElement signInButton;
    @FindBy(locator = "login.title")
    private QAFWebElement title;

    public LoginPage(){
        super();

    }

    public void validateLoginPage(){
        title.waitForPresent(10000);
    }

    public HomePage login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
        return new HomePage();
    }
    //@Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto-generated method stub
    }
}
