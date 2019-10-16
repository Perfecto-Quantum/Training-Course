package com.quantum.utils;



import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.utils.DeviceUtils;
public class QuantumCourseUtils extends WebDriverTestBase {

     public String platform = getDriver().getCapabilities().getCapability("platformName").toString().toLowerCase();


    public boolean isAndroid () {

        return getDriver().getCapabilities().getCapability("platformName").toString().equalsIgnoreCase("Android");

    }
    public boolean isText(String text, int timeout) {

        Map<String, Object> params = new HashMap<>();
        params.put("content",text);
        params.put("timeout",timeout);
        String res = getDriver().executeScript("mobile:checkpoint:text", params).toString();

        if (res.equalsIgnoreCase("true")) {
            System.out.println("checkpoint is: " +res);
            return true;
        } else {
            System.out.println("checkpoint is: " +res);

            return false;
        }
    }
    public boolean isMobile() {
     String type =  ConfigurationUtils.getBaseBundle().getProperty("perfecto.capabilities.deviceType").toString();
      // String type = getDriver().getCapabilities().getCapability("deviceType").toString();

        if(type.equalsIgnoreCase("Mobile")) {return true;}
       return  false;

    }
    public void clickVisualText(String text, int timeout) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", text);
        params.put("timeout", timeout);
        getDriver().executeScript("mobile:button-text:click", params);
    }


}
