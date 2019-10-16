package com.quantum.utils;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by uzie on 2/27/17.
 */
public class moreActions {

    public static void type(String t) {
        HashMap params = new HashMap();
        params.put("text", String.valueOf(t));

        getQAFDriver().executeScript("mobile:typetext", new Object[]{params});
    }

    public static void closeKeyboard() {
        HashMap params = new HashMap();

         params.put("mode", "off");

        getQAFDriver().executeScript("mobile:keyboard:display", new Object[]{params});

    }
    public static void callMe(String n) {
        HashMap params = new HashMap();
        params.put("to.handset", String.valueOf(n));

        getQAFDriver().executeScript("mobile:gateway:call", new Object[]{params});
    }

    public static void gpsOn( ) {
        sendADB("settings put secure location_providers_allowed +gps");
    }
    public static void gpsOff( ) {
        sendADB("settings put secure location_providers_allowed -gps");
    }



    public static void sendADB(String cmd) {
        HashMap params = new HashMap();
        params.put("command", cmd);

        getQAFDriver().executeScript("mobile:handset:shell", new Object[]{params});
    }


    public static void visualClick(String tx) {

        getQAFDriver().findElement(By.linkText(tx));
    }

    public static QAFExtendedWebDriver getQAFDriver() {
        return (new WebDriverTestBase()).getDriver();
    }



    //Audioo
    public static String  startRecord() {
        HashMap params = new HashMap();

       return getQAFDriver().executeScript("mobile:audio.recording:start", new Object[]{params}).toString();
    }

       public static void  stopRecord() {
        HashMap params = new HashMap();

          getQAFDriver().executeScript("mobile:audio.recording:stop", new Object[]{params});
    }

    public static String  speech2Text(String link) {
        HashMap params = new HashMap();
        params.put("AudioLink", link);

        return  getQAFDriver().executeScript("mobile:Audio:speech2text", new Object[]{params}).toString();
    }

    public static String getDevicePhoneNumber(){

        Map<String, Object> params1 = new HashMap<>();
        params1.put("property", "phoneNumber");
        return (String) getQAFDriver().executeScript("mobile:handset:info", params1);

    }


}


