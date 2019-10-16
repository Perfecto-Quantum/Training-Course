package com.quantum.steps;


import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.QuantumCourseUtils;
import cucumber.api.java.en.When;
import  com.qmetry.qaf.automation.core.ConfigurationManager;

@QAFTestStepProvider

public class returnValuesStepsDefs extends QuantumCourseUtils {

    @When("I check chance of rain")
    public static void checkRain() {


        String rain="High";
        ConfigurationManager.getBundle().setProperty("rainValue",rain);
    }

    @When("Do i need an umbrella")
    public static void needUmbrella() {


        String val = ConfigurationManager.getBundle().getString("rainValue");
        if (val.equalsIgnoreCase("high")) {
            System.out.println("I need an umbrella");
        }else {System.out.println("I will not take an umbrella");}




    }



}
