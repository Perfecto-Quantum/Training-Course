package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import com.quantum.utils.moreActions;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uzie on 1/23/17.
 */
@QAFTestStepProvider
public class twoDevicesStepsDefs extends WebDriverTestCase {


    /**
     *  Send SMS from one device (perfecto) to second device (perfectodevii)
     *
     */


    @When("I Launch application on Device \"([^\"]*)\"$")
    public void launch_app_device(String device) throws Throwable {
        DriverUtils.switchToDriver(device);
        openApp();

    }
    //  @Test(description="SendSMS", groups={"@twoDevicesSMS"})
    @When("I send SMS from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void SendSMS(String firstDevice, String secondDevice) {


        //String PhoneBNum = "13392344376";
        final String msg = "Test Message";

        DriverUtils.switchToDriver(firstDevice);
        //openApp();

        DriverUtils.switchToDriver(secondDevice);
        //openApp();
        String PhoneBNum = moreActions.getDevicePhoneNumber();

        //device A (send SMS)
        DriverUtils.switchToDriver(firstDevice);


        getDriver().findElement("newMessage.buton").click();
        getDriver().findElement("recipients.editor").sendKeys(PhoneBNum);
        getDriver().findElement("editorbody.text").sendKeys(msg);
        getDriver().findElement("send.button").click();


        //deviceB
        DriverUtils.switchToDriver(secondDevice);
        DeviceUtils.assertVisualText(msg);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("context", "all");
        String result2 = getDriver().executeScript("mobile:screen:text", params2).toString();


    }


    private void openApp()
    {

      //  String appPackage = (String)getDriver().getCapabilities().getCapability("appPackage");
        try {
            DeviceUtils.closeApp("com.android.mms", "identifier");

        }catch (Exception e)
        {
            //nothing
        }
        DeviceUtils.startApp("com.android.mms", "identifier");
    }



    private void sleep(int ms)

    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
