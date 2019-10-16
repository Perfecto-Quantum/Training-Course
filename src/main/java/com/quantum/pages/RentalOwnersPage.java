package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RentalOwnersPage extends AbstractBasePage {

    private QAFWebElement firstNameElement = null;

    @FindBy(locator = "base.addNew.Btn")
    private QAFWebElement addNew;

    @FindBy(locator = "owners.title")
    public QAFWebElement title;

    RentalOwnersPage(){
        super();
        validatePage();
    }

    private void validatePage(){
       title.waitForPresent(5000);
    }
    public void clearOwnerEntry(String ownerFirstName, String ownerLastName){
        DeviceUtils.swipe("50%,85%", "50%,25%");

        QAFWebElement newEntry = validateOwnerEntryExists(ownerFirstName, ownerLastName);
        if(newEntry !=null){
            newEntry.click();
        RentalOwnerDetailsPage rentalOwnerDetailsPage = new RentalOwnerDetailsPage();
        rentalOwnerDetailsPage.validateRentalOwnerDetailsPage();
            Map<String, Object> params1 = new HashMap<>();
            params1.put("content", "Delete");
            params1.put("scrolling", "scroll");
            params1.put("next", "SWIPE_UP");
            this.driver.executeScript("mobile:text:find", params1);

            rentalOwnerDetailsPage.delete.click();
            Map<String, Object> params2 = new HashMap<>();
            params2.put("label", "OK");
            this.driver.executeScript("mobile:button-text:click", params2);
        }
    }

    public RentalOwnerDetailsPage clickAddNew(){
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        addNew.click();
        return new RentalOwnerDetailsPage();
    }

    public boolean getValidation(String ownerFirstName, String ownerLastName){
        return (validateOwnerEntryExists(ownerFirstName, ownerLastName)!=null);
    }

    private QAFWebElement validateOwnerEntryExists(String ownerFirstName, String ownerLastName){
        try {
            List<WebElement> rowList = this.driver.findElementsByTagName("tr");
            for (int i = 1; i < rowList.size()-1; i++) {
                List<WebElement> columnList = rowList.get(i).findElements(By.tagName("td"));
                if (columnList.get(1).getText().equalsIgnoreCase(ownerFirstName) && columnList.get(2).getText().equalsIgnoreCase(ownerLastName)) {
                    System.out.println(ownerFirstName + " " + ownerLastName + " was found in the list");
                    WebElement e = columnList.get(1).findElement(By.tagName("a"));
                    firstNameElement = (QAFWebElement) e;
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("There are no owner listings");
        }
            return firstNameElement;
    }

    //@Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
