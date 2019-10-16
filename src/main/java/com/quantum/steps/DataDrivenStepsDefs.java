package com.quantum.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
@QAFTestStepProvider
public class DataDrivenStepsDefs extends WebDriverTestBase {

    @When("I use Properties File")
    public void I_use_properties_file() throws Throwable {


        String data = ConfigurationUtils.getBaseBundle().getPropertyValue("myWebsite");
        System.out.println("Data from Properties: " + data);





    }
}