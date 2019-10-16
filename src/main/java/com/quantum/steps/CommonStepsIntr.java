package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.android.steps.*;
import cucumber.api.java.en.When;


@QAFTestStepProvider
public interface CommonStepsIntr {

	public interface GeneralSteps {

        @QAFTestStep(description = "I click the world clock tab")
        public void clickWorldClock();

        @QAFTestStep(description="I start the Clock Application")
        public void startClock();

    }
}
