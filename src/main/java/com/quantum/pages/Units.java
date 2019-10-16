package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.NoSuchElementException;

public class Units extends AbstractBasePage {
    private QAFExtendedWebDriver driver = new QAFExtendedWebDriver();

    @FindBy(locator = "units.title")
    private QAFWebElement title;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "units.delete.btn")
     private QAFWebElement delete;

    @FindBy(locator="units.unlisted.radioBtn")
    private QAFWebElement unlisted;

    @FindBy(locator = "units.ESB.selection")
    private QAFWebElement EBS;

    @FindBy(locator = "units.unit.field")
    private QAFWebElement unitField;



    @FindBy(locator = "units.properytDropbox.arrow.button")
    private QAFWebElement propertyArrowBtn;

    public Units(){
        super();
        validateUnitsPage();
    }

    public Boolean validateUnit(String unit){
        try {
            driver.findElementByXPath("//*[text()=\"" + unit + "\"]");
        } catch (NoSuchElementException e) {
            System.out.println(unit+" unit was not found");
            return false;
        }
        return true;
    }
    public void clearUnit(String unit){
        boolean exists;
        if(validateUnit(unit)){
            exists=true;
            while(exists) {
                driver.findElementByXPath("//*[text()=\"" + unit + "\"]").click();
                delete.waitForPresent(3000);
                delete.click();
                driver.switchTo().alert().accept();
                exists = validateUnit(unit);
            }
        }
    }
    public void addNewUnit(String newUnit, String month){
        addNew.click();
        propertyArrowBtn.click();
        EBS.click();
        unitField.sendKeys(newUnit);
        unlisted.click();
        save.click();
    }
    private void validateUnitsPage(){title.click();}

    //@Override
    protected void openPage(PageLocator locator, Object... args) {
        // TODO Auto
    }
}
