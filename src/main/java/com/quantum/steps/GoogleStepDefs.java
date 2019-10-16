package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import com.quantum.utils.QuantumCourseUtils;

import java.util.List;

@QAFTestStepProvider
public class GoogleStepDefs extends QuantumCourseUtils {
	@Given("^I am on Google Search Page$")
	public void I_am_on_Google_Search_Page() throws Throwable {
		new WebDriverTestBase().getDriver().get("http://www.google.com/");
	}
	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) throws Throwable {
		QAFExtendedWebElement searchBoxElement = new QAFExtendedWebElement("search.text.box");
		QAFExtendedWebElement searchBtnElement = new QAFExtendedWebElement("search.button");

		searchBoxElement.clear();
		searchBoxElement.sendKeys(searchKey);
        //Web & mobile are sometimes slightly different. In this case, in mobile we need to click the go button and in Desktop there is no button snd we
        // need to press the Enter key. To implement this, we created an isMobile method which uses the deviceType capability and with it we can branch our code
        if(isMobile()){
            searchBtnElement.click();

        }else {
            searchBoxElement.sendKeys(Keys.ENTER);
        }



	}
	@Then("^it should have \"([^\"]*)\" in search results$")
	public void it_should_have_in_search_results(String result) throws Throwable {
		QAFExtendedWebElement searchResultElement =
				new QAFExtendedWebElement("partialLink=" + result);
		searchResultElement.verifyPresent(result);
	}

	@Then("^it should have following search results:$")
	public void it_should_have_all_in_search_results(List<String> results) {
		QAFExtendedWebElement searchResultElement;
		for (String result : results) {
			searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
			searchResultElement.verifyPresent(result);
		}
	}
	
	

}
