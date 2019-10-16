package com.quantum.ios.steps;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.CommonStepsIntr.GeneralSteps;
import com.quantum.utils.DeviceUtils;

import java.util.HashMap;

public class IOSStepsLib implements GeneralSteps {

    @Override
	public void startClock() {
        try{DeviceUtils.closeApp("Clock","name");} catch (Exception e) {}
		DeviceUtils.startApp("Clock", "name");
		DeviceUtils.switchToContext("NATIVE");
	}
	@Override
	public void clickWorldClock() {
		CommonStep.click("clock.mainscreen.worldclock.btn");
		
	}
    @QAFTestStep(description="I click on the text {text}")
	public void clickText(String text) {
		HashMap<String, Object> params1 = new HashMap<>();
		params1.put("label", text);
		params1.put("timeout", "20");
		params1.put("threshold", "100");
		params1.put("ignorepunct", "punct");
		new WebDriverTestBase().getDriver().executeScript("mobile:button-text:click", params1);
	}
	

	
}
