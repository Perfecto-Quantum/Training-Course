package com.quantum.android.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.CommonStepsIntr.GeneralSteps;
import com.quantum.utils.DeviceUtils;

import java.util.HashMap;

public class AndoridStepsLib implements GeneralSteps {


	@Override
	public void startClock() {
		DeviceUtils.startApp("Clock", "name");
		DeviceUtils.switchToContext("NATIVE");
	}
	@Override
	public void clickWorldClock() {
		CommonStep.click("clock.mainscreen.worldclock.btn");
	}


	
}
