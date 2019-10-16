package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.pages.*;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.quantum.listeners.QuantumReportiumListener.logStepStart;
@QAFTestStepProvider
public class POMStepDefs extends WebDriverTestCase {
    private final String USERNAME = getBundle().getPropertyValue("username");
    private final String PASSWORD = getBundle().getPropertyValue("password");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Given("^I launch real estate site$")
    public void beforeTest() {
        logStepStart("Open browser");
        getDriver().get(getBundle().getPropertyValue("env.baseurl"));

    }
    @Given("^I login to real estate site$")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.validateLoginPage();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        homePage.validateUserLoggedIn(USERNAME);
    }


}
