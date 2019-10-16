package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.utils.DeviceUtils;

public class RentalOwnerDetailsPage extends AbstractBasePage {


    @FindBy(locator = "ownersDetails.header.text")
    private QAFWebElement formHeader;

    @FindBy(locator = "ownersDetails.pageHeader.text")
    private QAFWebElement pageHeader;

    @FindBy(locator = "base.delete.button")
    QAFWebElement delete;

    @FindBy(locator = "ownerDetails.firstName.field")
    private QAFWebElement firstName;

    @FindBy(locator = "ownerDetails.lastName.field")
    private QAFWebElement lastName;

    @FindBy(locator = "ownerDetails.companyName.field")
    private QAFWebElement companyName;

    @FindBy(locator = "base.save.btn")
    private QAFWebElement save;

    @FindBy(locator = "ownerDetails.state.dropbox")
    private QAFWebElement stateArrowBtn;

    @FindBy(locator = "ownerDetails.state.searchbox.field")
    private QAFWebElement stateSearchBox;

    @FindBy(locator = "ownerDetails.stateMatch.text")
    private QAFWebElement stateMatch;

    @FindBy(locator = "ownerDetails.email.button")
    private QAFWebElement emailBtn;

    @FindBy(locator = "ownerDetails.email.field")
    private QAFWebElement emailField;

    @FindBy(locator = "ownerDetails.phone.field")
    private QAFWebElement phoneNumber;

    @FindBy(locator = "ownerDetails.street.field")
    private QAFWebElement Street;

    @FindBy(locator = "ownerDetails.city.field")
    private QAFWebElement City;

    @FindBy(locator = "ownerDetails.zip.field")
    private QAFWebElement Zip;




    public RentalOwnerDetailsPage(){
        super();
    }

    public void validateRentalOwnerDetailsPage(){
        formHeader.waitForPresent(40000);
    }

    public RentalOwnersPage returnToRentalOwnersPage(){
        pageHeader.click();
        return new RentalOwnersPage();
    }

    public void addNewOwnerEntry(String newOwnerFirstName, String newOwnerSecondName, String company, String year, String month, String day, String email,String phone_Number, String country, String state, String city, String street, String zip){

        firstName.sendKeys(newOwnerFirstName);
        lastName.sendKeys(newOwnerSecondName);
        companyName.sendKeys(company);
        DeviceUtils.swipe("50%,85%", "50%,25%");
        this.driver.findElement("//*[text()=\"" + month + "\"]").click();
        this.driver.findElement("//*[text()=\"" + day + "\"]").click();
        this.driver.findElement("//*[text()=\"" + year + "\"]").click();
        emailBtn.click();
        emailField.sendKeys(email);
        phoneNumber.sendKeys(phone_Number);
        DeviceUtils.swipe("50%,85%", "50%,25%");
        this.driver.findElement("//*[text()=\""+country+"\"]").click();
        Street.sendKeys(street);
        City.sendKeys(city);
        stateArrowBtn.click();
        stateSearchBox.sendKeys(state);
        stateMatch.click();
        Zip.sendKeys(zip);
        DeviceUtils.swipe("50%,85%", "50%,25%");
        save.click();
    }

    //@Override
    protected void openPage(PageLocator pageLocator, Object... objects) {

    }
}
